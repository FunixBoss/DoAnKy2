package dao;

import java.util.List;

import entity.Meaning;
import entity.RelativeWord;
import entity.Vocabulary;

public interface VocabularyDAO extends DAO<Vocabulary> {
	List<Meaning> selectAllMeaningByVocabId(Integer vocabId);
	List<RelativeWord> selectAllRelativesByVocabId(Integer vocabId);
	List<Vocabulary> selectByPages(int pageNumber, int rowOfPages);
	Integer countNumberOfVocab();
	Integer insertGetId(Vocabulary vocab);
	List<Vocabulary> searchAll(String str);
}
