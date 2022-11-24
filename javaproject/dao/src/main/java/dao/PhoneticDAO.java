package dao;

import java.util.List;

import entity.Phonetic;

public interface PhoneticDAO extends DAO<Phonetic>{
	List<Phonetic> selAllPhoneticByVocabId(Integer vocabId);
}
