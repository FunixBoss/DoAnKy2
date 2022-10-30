
package dao;

import java.util.List;

import dao.impl.VocabularyDAOImpl;
import entity.Vocabulary;

public class TestVocabDAOImpl {
	public static void main(String[] args) {
		Vocabulary vocab = new Vocabulary("Hello Em Yeu", "/image/hello.jpg", "/pronunciation/hello.mp3", null, null, 2);
		Vocabulary vocab2 = new Vocabulary(1, "Fuck", "/image/abc.jpg", "/image/abc.jpg", null, null, 1);
//		System.out.println(selectAVocab(3)); // done // 0 if Integer fields = null
//		System.out.println(insertVocab(vocab)); // done
//		System.out.println(updateVocab(vocab2)); // done
//		System.out.println(deleteVocab(selectAVocab(7))); // done
//		selectAllVocab().forEach(System.out::println); // done
	}
	
	public static Vocabulary selectAVocab(Integer id) {
		return new VocabularyDAOImpl().select(id); // return null
	}
	
	public static List<Vocabulary> selectAllVocab(){
		return new VocabularyDAOImpl().selectAll();
	}

	public static int insertVocab(Vocabulary vocab) {
		return new VocabularyDAOImpl().insert(vocab);
	}
	
	public static int updateVocab(Vocabulary vocab) {
		return new VocabularyDAOImpl().update(vocab);
	}
	public static int deleteVocab(Vocabulary vocab) {
		return new VocabularyDAOImpl().delete(vocab);
	}
}
