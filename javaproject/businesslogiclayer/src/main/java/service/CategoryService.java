package service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;

import dao.impl.CategoryDAOImpl;
import dao.impl.VocabularyDAOImpl;
import entity.Category;
import entity.Vocabulary;
import helper.ErrorMessage;
import helper.Validation;

public class CategoryService {
	private CategoryDAOImpl dao;
	
	public CategoryService() {
		dao = new CategoryDAOImpl();
	}
	
	public boolean add(Map<String, String> data) {
		ErrorMessage.ERROR_MESSAGES = null;
		String name = data.get("category"); 
		String image = data.get("image");
		System.out.println(name + "\n" + image);
	
		if(name.equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Không được để trống tên chủ đề";
			return false;
		} else if(!Validation.checkLength(name, 1, 50)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài chủ đề tối đa 50 ký tự";
			return false;
		} else if(!image.equals("")) {
			try {
				Path newDir = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\category\\" + name.replaceAll("\\s+", "_").toLowerCase() + ".png");
				Files.copy(Paths.get(image), newDir, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e2) {
//				e2.printStackTrace();
				return false;
			}
		} 
		dao.insert(new Category(name, name + ".png"));
		return true;
	}
	
	public boolean update(Map<String, String> data) {
		ErrorMessage.ERROR_MESSAGES = null;
		Integer cateId = Integer.parseInt(data.get("id"));
		String name = data.get("category");
		String image = data.get("image") == null ? "" : data.get("image");
		
		Category originalCate = dao.select(cateId);
		
		if(name.trim().equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Không được để trống tên chủ đề";
			return false;
		} else if(!Validation.checkLength(name, 1, 50)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài chủ đề tối đa 50 ký tự";
			return false;
		} else if(!image.trim().equals("")) {
			try {
				Path newDir = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\category\\" + name.replaceAll("\\s+", "_").toLowerCase() + ".png");
				Files.copy(Paths.get(image), newDir, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e2) {
//				e2.printStackTrace();
				return false;
			}
		} 
		
		dao.update(new Category(cateId, name.replaceAll("\\s+", "_").toLowerCase(), name.replaceAll("\\s+", "_").toLowerCase() + ".png"));
		return true;
	}
	
	public boolean delete(Category category) {
		try {
			List<Vocabulary> vocabs = dao.selectAllVocabByCategoryId(category.getId());
			if(vocabs != null) {
				for(Vocabulary vocab : vocabs) {
					vocab.setCategoryId(null);
					new VocabularyDAOImpl().update(vocab);
				}
			}
			dao.delete(category);				

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
}
