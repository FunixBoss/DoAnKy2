package service;

import java.io.File;
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
//		System.out.println(name + "\n" + image);
//		
//		System.out.println(image);
	
		if(formatName(name).equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Không được để trống tên chủ đề";
			return false;
		} else if(!Validation.checkLength(formatName(name), 1, 50)) {
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
		
//		get url from loaded file: C:\Users\ADMIN\OneDrive\Documents\admin.png
//		null if didnot choose
		String image = data.get("image");
		
		
		Category originalCate = dao.select(cateId);
//		validate
		if(formatName(name).equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Không được để trống tên chủ đề";
			return false;
		} else if(!Validation.checkLength(formatName(name), 1, 50)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài chủ đề tối đa 50 ký tự";
			return false;
		} else if(
			formatName(name).equals(originalCate.getName()) &&
			image == null
		) {
			ErrorMessage.ERROR_MESSAGES = "Bạn phải thay đổi thông tin mới có thể cập nhật";
			return false;
		}
		
		
//		Logic Update
//		neu thay doi ca hình và tên -- done -- use it
		if(
			 !formatName(name).equals(originalCate.getName()) &&
			 image != null
		) {
//			 xoa file cu
			try {
				Path fileToDeletePath = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\category\\" + originalCate.getName() + ".png");
				Files.delete(fileToDeletePath);
			} catch (Exception e) {

			}
			
//			them file moi
			try {
				Path newDir = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\category\\" + formatName(name) + ".png");
				Files.copy(Paths.get(image), newDir, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e2) {
//				e2.printStackTrace();
			}
			
			dao.update(new Category(cateId, formatName(name), formatName(name) + ".png"));
			return true;
		 }
		
//		neu thay doi ten  -- done
		if(!formatName(name).equals(originalCate.getName()) ) {
			if(originalCate.getImageIcon() != null) {
				File oldImageFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\category\\" + originalCate.getName() + ".png");
				File newImageFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\category\\" + formatName(name) + ".png");
				oldImageFile.renameTo(newImageFile);
				dao.update(new Category(cateId, formatName(name), formatName(name) + ".png"));
				return true;
			} else {
				dao.update(new Category(cateId, formatName(name), null));
				return true;
			}
		}
		
//		neu thay doi hinh -- have not been done (bug)
		if(image != null) {
			try {
				Path newDir = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\category\\" + formatName(name) + ".png");
				Files.copy(Paths.get(image), newDir, StandardCopyOption.REPLACE_EXISTING);
				
				dao.update(new Category(cateId, formatName(name), formatName(name) + ".png"));
				return true;
			} catch (Exception e2) {
//				e2.printStackTrace();
				return false;
			}
		}
		
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
	
	private String formatName(String name) {
		return name.trim().replaceAll("\\s+", "_").toLowerCase();
	}
}
