
package dao;

import java.util.List;

import dao.impl.VocabularyDAOImpl;
import entity.Meaning;
import entity.Relatives;
import entity.Vocabulary;

public class TestVocabDAOImpl implements VocabularyDAO {
	public static void main(String[] args) {
		Vocabulary vocab = new Vocabulary("Hello Em Yeu", "/image/hello.jpg", "/pronunciation/hello.mp3", null, 2);
		Vocabulary vocab2 = new Vocabulary(1, "Fuck", "/image/abc.jpg", "/image/abc.jpg", null, 1);
		TestVocabDAOImpl test = new TestVocabDAOImpl();
		
//		System.out.println(selectAVocab(3)); // done // 0 if Integer fields = null
//		System.out.println(insertVocab(vocab)); // done
//		System.out.println(updateVocab(vocab2)); // done
//		System.out.println(deleteVocab(selectAVocab(7))); // done
//		test.selectAllMeaningByVocabId(1).forEach(System.out::println);
		test.selectAllRelativesByVocabId(1).forEach(System.out::println);

	}
	

	@Override
	public Vocabulary select(Integer id) {
		return new VocabularyDAOImpl().select(id);
	}

	@Override
	public List<Vocabulary> selectAll() {
		return new VocabularyDAOImpl().selectAll();
	}

	@Override
	public Integer insert(Vocabulary t) {
		return new VocabularyDAOImpl().insert(t);
	}

	@Override
	public Integer update(Vocabulary t) {
		return new VocabularyDAOImpl().update(t);
	}

	@Override
	public Integer delete(Vocabulary t) {
		return new VocabularyDAOImpl().delete(t);
	}

	@Override
	public List<Meaning> selectAllMeaningByVocabId(Integer vocabId) {
		return new VocabularyDAOImpl().selectAllMeaningByVocabId(vocabId) ;
	}

	@Override
	public List<Relatives> selectAllRelativesByVocabId(Integer vocabId) {
		return new VocabularyDAOImpl().selectAllRelativesByVocabId(vocabId);
	}
}
