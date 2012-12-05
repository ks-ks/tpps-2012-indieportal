package services;

import java.util.Collection;

import domain.DomainObject;

public interface IGenericService<T extends DomainObject> {
	
	public T save(T entity);
	public void delEntity(Long id);
	public void delEntity(T entity);
	public T getById(Long id);
	public boolean exists(Long id);
	public long getAllEntitiesCount();
	public Collection<T> getAllEntites();
	
}
