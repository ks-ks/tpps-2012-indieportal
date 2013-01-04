package services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import org.apache.commons.collections.CollectionUtils;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import services.IGenericService;
import domain.DomainObject;

public abstract class GenericServiceImpl<T extends DomainObject> implements IGenericService<T>{
	
	protected static final String QUERY_SELECT_ALL = "SELECT x FROM %s x"; //$NON-NLS-1$
	protected static final String QUERY_COUNT_ALL = "SELECT COUNT(x) FROM %s x"; //$NON-NLS-1$
	
	/** Spring's jpa template that is used to access db */
	protected JpaTemplate jpaTemplate;
	
	/** Persistent class that this dao works with */
	protected Class<T> persistentClass;
	
	/**
	 * Constructor with fields
	 * 
	 * @param persistentClass
	 *            Class that this dao will work with
	 */
	public GenericServiceImpl(Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}
	
	/**
	 * @return the jpaTemplate
	 */
	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}

	/**
	 * @param jpaTemplate the jpaTemplate to set
	 */
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}
	
	/**
	 * <p>
	 * This template method executes query with performing all needed
	 * operations, like creating EntityManager, creating transaction,
	 * committing, or rolling it back.
	 * </p>
	 * <p>
	 * Methods sets parameters for the query as they appear in the parameters
	 * list, by number starting from 1. So, the first parameter in your named
	 * query should be referenced as <code>?1</code>, second as <code>?2</code>
	 * and so on.
	 * </p>
	 * <p>
	 * If <code>singleResult = true</code> and no result is found, then
	 * <code>null</code> is returned.
	 * </p>
	 * <p>
	 * Be aware, that when multiple results are returned, they are being
	 * dynamically casted to <code>REZ</code> class. It should be able to cast
	 * to {@link java.util.List}. When returning single result, <code>REZ</code>
	 * should be a single persistent entity class.
	 * </p>
	 * 
	 * @param <REZ>
	 *            Class of the result
	 * @param queryOrQueryName
	 *            Query string or NamedQuery name
	 * @param namedQuery
	 *            Specifies, whether query is named query
	 * @param singleResult
	 *            Specifies, whether single result should be returned
	 * @param initializeObjects
	 *            If true, then function will iterate through all object to
	 *            initialize them
	 * @param parameters
	 *            Parameters. You can specify multiple parameters separated by
	 *            comma
	 * @return Result of the query
	 * @throws PersistenceException
	 *             If error occurs
	 */
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	protected <REZ> REZ executeQuery(String queryOrQueryName,
			boolean namedQuery, boolean singleResult, Object... parameters) {

		REZ result;
		List<?> list;

		// Executing either named or simple query
		if (namedQuery) {
			list = jpaTemplate.findByNamedQuery(queryOrQueryName, parameters);
		} else {
			list = jpaTemplate.find(queryOrQueryName, parameters);
		}

		// Returning needed result
		if (singleResult) {
			if (! CollectionUtils.isEmpty(list)) {
				result = (REZ) list.get(0);
			} else {
				result = null;
			}
		} else {
			result = (REZ) list;
		}
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public T save(T entity) {
		
		T savedEntity = null;
		if (entity.getId() == null){
			jpaTemplate.persist(entity);
			savedEntity = entity;
		} else {
			savedEntity = jpaTemplate.merge(entity);
		}
		
		return savedEntity;
		 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delEntity(Long id) {
		
		// Getting entity by id
				T savedEntity = getById(id);

				if (savedEntity != null) {
					// Deleting entity
					delEntity(savedEntity);
				}
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delEntity(T entity) {
		// Deleting entity object
				if (!jpaTemplate.contains(entity)) {
					T attachedEntity = jpaTemplate.merge(entity);
					jpaTemplate.remove(attachedEntity);
				} else {
					jpaTemplate.remove(entity);
				}	
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public T getById(Long id) {		
		// Getting entity by id
		if (id == null) {
			return null;
		}
		T savedEntity = jpaTemplate.find(persistentClass, id);

		// Checking if we got the entity that is not NULL
		if ((savedEntity == null) || (savedEntity.getId() == null)) {						
			return null;
		}
		return savedEntity;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean exists(Long id) {
		T savedEntity = jpaTemplate.find(persistentClass, id);

		// Checking if we got the entity that is not NULL
		if ((savedEntity == null) || (savedEntity.getId() == null)) {						
			return false;
		}
		return true;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getAllEntitiesCount() {
		return executeQuery(String.format(QUERY_COUNT_ALL, persistentClass
				.getSimpleName()), false, true);
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Collection<T> getAllEntites() {		
		// Getting all entities
					List<T> list = executeQuery(String.format(QUERY_SELECT_ALL, persistentClass
							.getSimpleName()), false, false);
					if (list != null)
						return list;
					else
						return new ArrayList<T>();
	}
	
}
