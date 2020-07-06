package mx.com.vrm.viai.configuration.crudmngImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import mx.com.vrm.viai.configuration.CrudDataManager;

// TODO: Auto-generated Javadoc
/**
 * The Class CrudDataManagerImpl.
 *
 * @param <T>
 *            the generic type
 * @param <PK>
 *            the generic type
 */
public class CrudDataManagerImpl<T, PK extends Serializable> implements CrudDataManager<T, PK> {

	/** The entity class. */
	protected Class<T> entityClass;

	/** The manager. */
	@PersistenceContext
	protected EntityManager manager;

	/**
	 * Instantiates a new crud data manager impl.
	 */
	@SuppressWarnings("unchecked")
	public CrudDataManagerImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.vrm.viai.configuration.CrudDataManager#create(java.lang.Object)
	 */
	public T create(T t) {
		this.manager.persist(t);
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.vrm.viai.configuration.CrudDataManager#read(java.io.Serializable)
	 */
	public T read(PK id) {
		return this.manager.find(entityClass, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.vrm.viai.configuration.CrudDataManager#update(java.lang.Object)
	 */
	public T update(T t) {
		return this.manager.merge(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.com.vrm.viai.configuration.CrudDataManager#delete(java.lang.Object)
	 */
	public void delete(T t) {
		t = this.manager.merge(t);
		this.manager.remove(t);
	}

}
