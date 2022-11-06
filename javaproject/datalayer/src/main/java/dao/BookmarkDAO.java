package dao;

import java.util.List;

import entity.Bookmark;
import entity.Vocabulary;

public interface BookmarkDAO extends DAO<Bookmark>{
	List<Vocabulary> selectAllVocabByUserId(Integer userId);
	Integer delByUserId(Integer userId);
	List<Bookmark> selBookmarkByVocabId(Integer vocabId);
}
