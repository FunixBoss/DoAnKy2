package dao;

import java.util.List;

import entity.History;
import entity.Vocabulary;

public interface HistoryDAO extends DAO<History>{
	List<Vocabulary> selectAllVocabByUserId(Integer userId);
	Integer delByUserId(Integer userId);
	List<History> selHistoryByVocabId(Integer vocabId);
}
