package dao;

import java.util.List;

import entity.Meaning;
import entity.Relatives;
import entity.Vocabulary;

public interface VocabularyDAO extends DAO<Vocabulary> {
	List<Meaning> selectAllMeaningByVocabId(Integer vocabId);
	List<Relatives> selectAllRelativesByVocabId(Integer vocabId);
	List<Vocabulary> selectByPages(int pageNumber, int rowOfPages);
	Integer countNumberOfVocab();
	Integer insertGetId(Vocabulary vocab);
}
