package service;

import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dao.impl.BookmarkDAOImpl;
import dao.impl.CategoryDAOImpl;
import dao.impl.ExampleDAOImpl;
import dao.impl.HistoryDAOImpl;
import dao.impl.MeaningDAOImpl;
import dao.impl.RelativesDAOImpl;
import dao.impl.VocabularyDAOImpl;
import entity.Bookmark;
import entity.Example;
import entity.History;
import entity.Meaning;
import entity.Relatives;
import entity.Vocabulary;
import helper.ErrorMessage;
import helper.Validation;


public class VocabularyService {
	private VocabularyDAOImpl dao;
	
	public VocabularyService() {
		dao = new VocabularyDAOImpl();
	}
	
	public boolean add(Map<String, String> data) {
		ErrorMessage.ERROR_MESSAGES = null;
		String word = data.get("word");
		String type = data.get("type");
		String category = data.get("category"); // can be null
		String pronunciation = data.get("pronunciation"); // can be null
		String image = data.get("image"); // can be null
		
		String relatives = data.get("relatives"); // can be null
		List<String> meanings = Arrays.asList(data.get("meaning1"), data.get("meaning2"), data.get("meaning3"));
		List<String> examples = Arrays.asList(data.get("example1"), data.get("example2"), data.get("example3"));
		
//		validate
		if(word.equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Ô từ vựng không được để trống!";
			return false;
		} else if(!relatives.equals("") && !Validation.checkLength(relatives, 1, 300)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài các từ liên quan tối đa 200 ký tự";
			return false;
		}  else if( 
				(!meanings.get(0).equals("") && !Validation.checkLength(meanings.get(0), 1, 50)) ||
				(!meanings.get(1).equals("") && !Validation.checkLength(meanings.get(1), 1, 50)) ||
				(!meanings.get(2).equals("") && !Validation.checkLength(meanings.get(2), 1, 50))
		){
			ErrorMessage.ERROR_MESSAGES = "Độ dài của các ô ý nghĩa tối đa 50 ký tự";
			return false;
		} else if (
				(!examples.get(0).equals("") && !Validation.checkLength(examples.get(0), 1, 200)) ||
				(!examples.get(1).equals("") && !Validation.checkLength(examples.get(1), 1, 200)) ||
				(!examples.get(2).equals("") && !Validation.checkLength(examples.get(2), 1, 200))
		) {
			if(checkExampleRowDetailMeaningIsNotNull(examples)){
				ErrorMessage.ERROR_MESSAGES = "Nghĩa của các câu ví dụ không được để trống";
				return false;
			}
			ErrorMessage.ERROR_MESSAGES = "Độ dài mỗi dòng ô ý nghĩa tối đa 200 ký tự";
			return false;
		} 
		
		
//		SAVE FILES
		if(image != null) {
			try {
				Path newDir = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\vocabulary\\" + word.replaceAll("\\s+", "_").toLowerCase() + ".png");
				Files.copy(Paths.get(image), newDir, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e2) {
//				e2.printStackTrace();
				return false;
			}
		} 
		 
		 if(pronunciation != null) {
			try {
				Path newDir = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\pronunciation\\" + word.replaceAll("\\s+", "_").toLowerCase() + ".mp3");
				Files.copy(Paths.get(pronunciation), newDir, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e2) {
				e2.printStackTrace();
				return false;
			}
		}
		

		
//		INSERT		
		Integer cateId = new CategoryDAOImpl().getIdFromCateName(category.toLowerCase()) == -1 ? null :  new CategoryDAOImpl().getIdFromCateName(category.toLowerCase());
		String imageName = null;
		if(image != null) {
			imageName = (word + ".png").replaceAll("\\s+", "_").toLowerCase();
		}
		String pronunciationName = null;
		if(pronunciation != null) {
			pronunciationName = (word + ".mp3").replaceAll("\\s+", "_").toLowerCase();
		}
		Vocabulary vocab = new Vocabulary(word, imageName, pronunciationName, cateId, Integer.parseInt(type));
//		insert into vocabulary
		Integer insertedVocabId = dao.insertGetId(vocab);
		
//		insert into relatives
		if(!relatives.trim().equals("")) {
			List<String> relativeWords = Arrays.asList(relatives.split(";"));
			RelativesDAOImpl relDao = new RelativesDAOImpl();
			relativeWords.forEach(rel -> {
				if(!rel.trim().equals("")) {
					relDao.insert(new Relatives(null, rel.trim(), insertedVocabId));
				}
			});
		}
		
//		insert into meanings and example
		int i = 0;
		for(String mn : meanings) {
			if(!mn.trim().equals("")) {
//				insert to meaning
				Integer insertedMeaningId = new MeaningDAOImpl().insertGetId(new Meaning(mn, insertedVocabId));
				
//				insert to example
				if(!examples.get(i).trim().equals("")) {
					List<String> exampleRow = Arrays.asList(examples.get(i).split("\\r?\\n"));
					for(String str : exampleRow) {
						if(!exampleRow.isEmpty()) {
							List<String> exampleRowDetail = Arrays.asList(str.split(";"));
//								have only example or meaning of example
//							System.out.println(exampleRowDetail.size());
							 if (exampleRowDetail.size() >= 2){
								new ExampleDAOImpl().insert(new Example(exampleRowDetail.get(0), exampleRowDetail.get(1), insertedMeaningId));									
							}
						}
					}
				}
			}
			i++;
		}
		return true;

	}
	
	public boolean update(Map<String, String> data) {
		ErrorMessage.ERROR_MESSAGES = null;
		Integer id = Integer.parseInt(data.get("id"));
		String word = data.get("word");
		String type = data.get("type");
		String category = data.get("category"); // can be null
		String pronunciation = data.get("pronunciation"); // can be null
		String image = data.get("image"); // can be null
		String relatives = data.get("relatives"); // can be null
		List<String> meanings = Arrays.asList(data.get("meaning1"), data.get("meaning2"), data.get("meaning3"));
		List<String> examples = Arrays.asList(data.get("example1"), data.get("example2"), data.get("example3"));
		System.out.println("id=" + id);
		System.out.println("Word=" + word + "\t" + "Type=" +type  + "\t" + "Category=" + category);
		System.out.println("Image="+ image ); // C:\Users\ADMIN\OneDrive\Documents\admin.png
		System.out.println("Pronun=" + pronunciation); // C:\Users\ADMIN\OneDrive\Desktop\4000 english words volume 6-audio\4000 english words volume 6\02.mp3
		System.out.println("Relatives=" + relatives);
		
		Integer cateId = new CategoryDAOImpl().getIdFromCateName(category.toLowerCase()) == -1 ? null :  new CategoryDAOImpl().getIdFromCateName(category.toLowerCase());
		Vocabulary originalVocab = new VocabularyDAOImpl().select(id);
		
//		Validation
		if(word.equals("")) {
			ErrorMessage.ERROR_MESSAGES = "Ô từ vựng không được để trống!";
			return false;
		} else if(!relatives.equals("") && !Validation.checkLength(relatives, 1, 300)) {
			ErrorMessage.ERROR_MESSAGES = "Độ dài các từ liên quan tối đa 200 ký tự";
			return false;
		}  else if( 
				(!meanings.get(0).equals("") && !Validation.checkLength(meanings.get(0), 1, 50)) ||
				(!meanings.get(1).equals("") && !Validation.checkLength(meanings.get(1), 1, 50)) ||
				(!meanings.get(2).equals("") && !Validation.checkLength(meanings.get(2), 1, 50))
		){
			ErrorMessage.ERROR_MESSAGES = "Độ dài của các ô ý nghĩa tối đa 50 ký tự";
			return false;
		} else if (
				(!examples.get(0).equals("") && !Validation.checkLength(examples.get(0), 1, 200)) ||
				(!examples.get(1).equals("") && !Validation.checkLength(examples.get(1), 1, 200)) ||
				(!examples.get(2).equals("") && !Validation.checkLength(examples.get(2), 1, 200))
		) {
			if(checkExampleRowDetailMeaningIsNotNull(examples)){
				ErrorMessage.ERROR_MESSAGES = "Nghĩa của các câu ví dụ không được để trống";
				return false;
			}
			ErrorMessage.ERROR_MESSAGES = "Độ dài mỗi dòng ô ý nghĩa tối đa 200 ký tự";
			return false;
		} 
		
		

		
		
//		Sửa tên từ vựng
		if(!formatName(word).equals(originalVocab.getWord())) {
//			update img 
			if(image != null) {
				try {
					Path newDir = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\vocabulary\\" + formatName(word) + ".png");
					Files.copy(Paths.get(image), newDir, StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e2) {
//					e2.printStackTrace();
					return false;
				}
			} else {
//				ko update img
				File oldImageFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\vocabulary\\" + originalVocab.getWord() + ".png");
				File newImageFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\vocabulary\\" + formatName(word) + ".png");
				oldImageFile.renameTo(newImageFile);	
			}
			image = formatName(word) + ".png";
			
//			update pronun
			if(pronunciation != null) {
				try {
					Path newDir = Paths.get(System.getProperty("user.dir") + "\\src\\main\\resources\\pronunciation\\" + formatName(word) + ".mp3");
					Path a =Files.copy(Paths.get(pronunciation), newDir, StandardCopyOption.REPLACE_EXISTING);
				} catch (Exception e2) {
					e2.printStackTrace();
					return false;
				}
			} else {
//				ko update pronun
				File oldImageFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\vocabulary\\" + originalVocab.getWord() + ".png");
				File newImageFile = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\vocabulary\\" + formatName(word) + ".png");
				oldImageFile.renameTo(newImageFile);
			}
			pronunciation = formatName(word) + ".mp3";

		} else {
//			ko sửa tên từ vựng
			image = originalVocab.getImage();
			pronunciation = originalVocab.getPronunciation();
		}
		
		Vocabulary vocab = new Vocabulary(word, image, pronunciation, cateId , Integer.parseInt(type));
		vocab.setId(id);
		dao.update(vocab);
		
		
		
		deleteOnOtherTable(originalVocab);
//		insert into relatives
		if(!relatives.trim().equals("")) {
			List<String> relativeWords = Arrays.asList(relatives.split(";"));
			RelativesDAOImpl relDao = new RelativesDAOImpl();
			relativeWords.forEach(rel -> {
				if(!rel.trim().equals("")) {
					relDao.insert(new Relatives(null, rel.trim(), id));
				}
			});
		}
//		insert into meanings and example
//		    delete old data
		
		int i = 0;
		for(String mn : meanings) {
			if(!mn.trim().equals("")) {
//				insert to meaning
				Integer insertedMeaningId = new MeaningDAOImpl().insertGetId(new Meaning(mn, id));
				
//				insert to example
				if(!examples.get(i).trim().equals("")) {
					List<String> exampleRow = Arrays.asList(examples.get(i).split("\\r?\\n"));
					for(String str : exampleRow) {
						if(!exampleRow.isEmpty()) {
							List<String> exampleRowDetail = Arrays.asList(str.split(";"));
//								have only example or meaning of example
//							System.out.println(exampleRowDetail.size());
							 if (exampleRowDetail.size() >= 2){
								new ExampleDAOImpl().insert(new Example(exampleRowDetail.get(0), exampleRowDetail.get(1), insertedMeaningId));									
							}
						}
					}
				}
			}
			i++;
		}
		return true;
	}
	
	private boolean checkExampleRowDetailMeaningIsNotNull(List<String> exampleRows) {
		for(String row : exampleRows) {
			List<String> rowDetail = Arrays.asList(row.split(";"));
			for(String item : rowDetail) {
				if(!item.trim().equals("")) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean delete(Vocabulary vocab) {
		VocabularyDAOImpl vocabDao = new VocabularyDAOImpl();
		MeaningDAOImpl meanDao = new MeaningDAOImpl();
		
		try {
			List<Meaning> meanings = vocabDao.selectAllMeaningByVocabId(vocab.getId());
			if(meanings != null) {
				//  delete meaning
				for(Meaning mean : meanings) {
					List<Example> examples = new MeaningDAOImpl().selectAllExampleByMeaningId(mean.getId());
					//	delete example
					if(examples != null) {
						ExampleDAOImpl exDao = new ExampleDAOImpl();
						for(Example ex : examples) {
							exDao.delete(ex);
						}
					}
					meanDao.delete(mean);
				}
			}
			
//			delete relatives
			RelativesDAOImpl relDao = new RelativesDAOImpl();
			List<Relatives> relatives = vocabDao.selectAllRelativesByVocabId(vocab.getId());
			if(relatives != null) {
				relatives.forEach(rel -> relDao.delete(rel));
			}
//			delete bookmark
			BookmarkDAOImpl bmDao = new BookmarkDAOImpl();
			List<Bookmark> bookmarks = bmDao.selBookmarkByVocabId(vocab.getId());
			if(bookmarks != null) {
				for(Bookmark bm : bookmarks) {
					bmDao.delete(bm);
				}
			}
			
			
//			delete history
			HistoryDAOImpl hstrDao = new HistoryDAOImpl();
			List<History> histories = hstrDao.selHistoryByVocabId(vocab.getId());
			if(histories != null) {
				for(History hstr : histories) {
					hstrDao.delete(hstr);
				}
			}
			
//			delete vocabulary
			vocabDao.delete(vocab);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	private String formatName(String name) {
		return name.trim().replaceAll("\\s+", "_").toLowerCase();
	}
	
	private void deleteOnOtherTable(Vocabulary vocab) {
		List<Relatives> originalRelatives = dao.selectAllRelativesByVocabId(vocab.getId());
		if(originalRelatives != null) {
			originalRelatives.forEach(rel -> new RelativesDAOImpl().delete(rel));
		}
		
		List<Meaning> originalMeanings = dao.selectAllMeaningByVocabId(vocab.getId());
		if(originalMeanings != null) {
			for(Meaning mn : originalMeanings) {
				List<Example> originalExamples = new MeaningDAOImpl().selectAllExampleByMeaningId(mn.getId());
				if(originalExamples != null) {
					originalExamples.forEach(ex -> new ExampleDAOImpl().delete(ex));
				}
				new MeaningDAOImpl().delete(mn);
			}
		}
	}
}
