package br.unip.minicurso.model.dao;

public interface DAO<T, K> {

	public T add(T entity);

	public T find(Class<T> clazz, K key);
	
	public void remove(T entity);

	public void update(T entity);

}