package dao;

import java.util.List;

import entity.Category;
import entity.Vocabulary;

public interface CategoryDAO extends DAO<Category> {
	List<Category> selectAllCateByParentId(Integer parentId); 
	List<Vocabulary> selectAllVocabByCategoryId(Integer cateId);
}
