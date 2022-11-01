package dao;

import java.util.List;

import dao.impl.CategoryDAOImpl;
import entity.Category;
import entity.Vocabulary;
import dao.CategoryDAO;

public class TestCateDAOImpl implements CategoryDAO{
	public static void main(String[] args) {
		TestCateDAOImpl test = new TestCateDAOImpl();
		Category cate = new Category("Shit", null, null);
		Category cate2 = new Category(5, "updated", "updated", null);
//		System.out.println(test.select(11)); // done // print 0 if parent id = null
//		test.selectAll().forEach(System.out::println); done
//		System.out.println(test.insert(cate)); // done
//		System.out.println(test.update(cate2));
//		System.out.println(test.delete(cate2));
//		test.selectAllCateByParentId(1).forEach(System.out::println); 
		test.selectAllVocabByCategoryId(1).forEach(System.out::println); 

	}
	
	@Override
	public Category select(Integer id) {
		return new CategoryDAOImpl().select(id);
	}

	@Override
	public List<Category> selectAll() {
		return new CategoryDAOImpl().selectAll();
	}

	@Override
	public Integer insert(Category t) {
		return new CategoryDAOImpl().insert(t);
	}

	@Override
	public Integer update(Category t) {
		return new CategoryDAOImpl().update(t);
	}

	@Override
	public Integer delete(Category t) {
		return new CategoryDAOImpl().delete(t);
	}

	@Override
	public List<Category> selectAllCateByParentId(Integer parentId) {
		return new CategoryDAOImpl().selectAllCateByParentId(parentId);
	}

	@Override
	public List<Vocabulary> selectAllVocabByCategoryId(Integer cateId) {
		return new CategoryDAOImpl().selectAllVocabByCategoryId(cateId);
	}

}
