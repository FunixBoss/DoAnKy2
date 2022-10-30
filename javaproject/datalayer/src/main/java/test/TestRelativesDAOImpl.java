package test;

import java.util.List;

import dao.RelativesDAOImpl;
import entity.Relatives;
import iservice.RelativesDAO;

public class TestRelativesDAOImpl implements RelativesDAO {
	public static void main(String[] args) {
		TestRelativesDAOImpl test = new TestRelativesDAOImpl();
		Relatives rel = new Relatives(null, "Collector", 1);
		Relatives rel2 = new Relatives(2, "Updated", 3);
//		System.out.println(test.select(1));
//		test.insert(rel);
//		test.update(rel2);
		test.delete(test.select(12));
		test.selectAll().forEach(System.out::println);
	}

	@Override
	public Relatives select(Integer id) {
		return new RelativesDAOImpl().select(id);
	}

	@Override
	public List<Relatives> selectAll() {
		return new RelativesDAOImpl().selectAll();
	}

	@Override
	public Integer insert(Relatives t) {
		return new RelativesDAOImpl().insert(t);
	}

	@Override
	public Integer update(Relatives t) {
		return new RelativesDAOImpl().update(t);
	}

	@Override
	public Integer delete(Relatives t) {
		return new RelativesDAOImpl().delete(t);
	}

}
