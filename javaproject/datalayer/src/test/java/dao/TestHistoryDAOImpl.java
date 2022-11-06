package dao;

import java.util.List;
import java.util.regex.Pattern;

import dao.HistoryDAO;
import dao.impl.HistoryDAOImpl;
import entity.History;
import entity.Vocabulary;

public class TestHistoryDAOImpl implements HistoryDAO{
	public static void main(String[] args) {
		TestHistoryDAOImpl test = new TestHistoryDAOImpl();
		History bm = new History(1, 5);
		History bm2 = new History(3, 1, 10);
//		System.out.println(test.select(3));
//		System.out.println(test.insert(bm));
//		System.out.println(test.update(bm2));
//		System.out.println(test.delete(test.select(3)));
//		test.selectAll().forEach(System.out::println);
//		test.selectAllVocabByUserId(1).forEach(System.out::println);
		System.out.println(test.delByUserId(3));
	}

	@Override
	public History select(Integer id) {
		return new HistoryDAOImpl().select(id);
	}

	@Override
	public List<History> selectAll() {
		return new HistoryDAOImpl().selectAll();
	}

	@Override
	public Integer insert(History t) {
		return new HistoryDAOImpl().insert(t);
	}

	@Override
	public Integer update(History t) {
		return new HistoryDAOImpl().update(t);
	}

	@Override
	public Integer delete(History t) {
		return new HistoryDAOImpl().delete(t);
	}

	@Override
	public List<Vocabulary> selectAllVocabByUserId(Integer userId) {
		return new HistoryDAOImpl().selectAllVocabByUserId(userId);
	}

	@Override
	public Integer delByUserId(Integer userId) {
		return new HistoryDAOImpl().delByUserId(userId);
	}

	@Override
	public List<History> selHistoryByVocabId(Integer vocabId) {
		// TODO Auto-generated method stub
		return null;
	}
}
