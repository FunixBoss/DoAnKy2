package dao;

import java.util.List;
import java.util.regex.Pattern;

import dao.HistoryDAO;
import dao.impl.HistoryDAOImpl;
import entity.History;

public class TestHistoryDAOImpl implements HistoryDAO{
	public static void main(String[] args) {
		TestHistoryDAOImpl test = new TestHistoryDAOImpl();
		History bm = new History(1, 5);
		History bm2 = new History(3, 1, 10);
//		System.out.println(test.select(3));
//		System.out.println(test.insert(bm));
//		System.out.println(test.update(bm2));
		System.out.println(test.delete(test.select(3)));
		test.selectAll().forEach(System.out::println);
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
}
