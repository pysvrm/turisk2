package mx.com.vrm.viai.configuration;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Interface CrudDataManager.
 *
 * @param <T>
 *            the generic type
 * @param <PK>
 *            the generic type
 */
public interface CrudDataManager<T, PK extends Serializable> {

	/**
	 * Creates the.
	 *
	 * @param t
	 *            the t
	 * @return the t
	 */
	T create(T t);

	/**
	 * Read.
	 *
	 * @param id
	 *            the id
	 * @return the t
	 */
	T read(PK id);

	/**
	 * Update.
	 *
	 * @param t
	 *            the t
	 * @return the t
	 */
	T update(T t);

	/**
	 * Delete.
	 *
	 * @param t
	 *            the t
	 */
	void delete(T t);
}
