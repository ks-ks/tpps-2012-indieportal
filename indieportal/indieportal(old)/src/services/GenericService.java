package services;

import java.util.Collection;
import java.util.HashMap;

import domain.DomainObject;


public class GenericService<T extends DomainObject> implements IGenericService<T> {

	protected HashMap<Long, T> map = new HashMap<Long,T>();
	private Long lastId = -100000l; 
	@Override
	public T save(T entity) {
		if (entity.getId() == null){
			entity.setId(lastId++);
		}
		return  map.put(entity.getId(), entity);
		 
	}

	@Override
	public void delEntity(Long id) {
		map.remove(id);
		
	}

	@Override
	public void delEntity(T entity) {
		map.remove(entity.getId());	
	}

	@Override
	public T getById(Long id) {
		
		return map.get(id);
	}

	@Override
	public boolean exists(Long id) {
		return map.containsKey(id);
	}

	@Override
	public long getAllEntitiesCount() {
		return map.size(); 
	}

	@Override
	public Collection<T> getAllEntites() {		
		return map.values();
	}
	
	
}
