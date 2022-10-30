package iservice;

import java.util.List;

public interface DAO<T> {
	/**
	 * @return null if it doesn't exists 
	 */
	T select(Integer id);
	
	/**
	 *  @return null if doesn't have any
	 */
	List<T> selectAll();
	
	/**
	 * @return 0 for insert failed
	 * @return 1 for insert successfully
	 */
	Integer insert(T t);
	
	/**
	 * @return 0 for update failed
	 * @return 1 for update successfully
	 */
	Integer update(T t);
	
	/**
	 * @return 0 for delete failed
	 * @return 1 for delete successfully
	 */
	Integer delete(T t);
}
