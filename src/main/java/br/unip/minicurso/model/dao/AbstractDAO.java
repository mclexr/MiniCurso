package br.unip.minicurso.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public abstract class AbstractDAO<T, K> implements DAO<T, K> {

	
	protected EntityManager manager;
	
	public AbstractDAO(EntityManager manager) {
		this.manager = manager;
	}

	public T add(T entity) throws PersistenceException {
		manager.getTransaction().begin();
		manager.persist(entity);
		manager.getTransaction().commit();
		return entity;
	}
	
	public T find(Class<T> clazz, K key) throws NoResultException {
		return manager.find(clazz, key);
	}
	
	public void remove(T entity) throws PersistenceException {
		manager.getTransaction().begin();
		manager.remove(entity);
		manager.getTransaction().commit();
	}

	
	public void update(T entity) throws PersistenceException {
		manager.getTransaction().begin();
		manager.merge(entity);
		manager.getTransaction().commit();
	}
}