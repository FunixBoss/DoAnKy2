package dao;

import java.util.List;

import dao.impl.RelativeWordDAOImpl;
import entity.RelativeWord;

public class TestRelativeWordDAOImpl implements RelativeWordDAO {
	public static void main(String[] args) {
		TestRelativeWordDAOImpl test = new TestRelativeWordDAOImpl();
		RelativeWord rel = new RelativeWord(null, "Collector", 1);
		RelativeWord rel2 = new RelativeWord(2, "Updated", 3);
//		System.out.println(test.select(2));
//		test.insert(rel);
//		test.update(rel2);
//		test.delete(test.select(12));
		test.selectAll().forEach(System.out::println);
	}

	@Override
	public RelativeWord select(Integer id) {
		return new RelativeWordDAOImpl().select(id);
	}

	@Override
	public List<RelativeWord> selectAll() {
		return new RelativeWordDAOImpl().selectAll();
	}

	@Override
	public Integer insert(RelativeWord t) {
		return new RelativeWordDAOImpl().insert(t);
	}

	@Override
	public Integer update(RelativeWord t) {
		return new RelativeWordDAOImpl().update(t);
	}

	@Override
	public Integer delete(RelativeWord t) {
		return new RelativeWordDAOImpl().delete(t);
	}

}
