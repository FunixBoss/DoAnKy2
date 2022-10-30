package test;

import java.util.List;

import dao.MeaningDAOImpl;
import entity.Meaning;
import iservice.DAO;
import iservice.MeaningDAO;

public class TestMeaningImpl implements MeaningDAO {
	public static void main(String[] args) {
		TestMeaningImpl test = new TestMeaningImpl();
		Meaning mn = new Meaning("LoL", 1);
//		System.out.println(test.select(1)); // done
//		test.insert(mn);
//		test.delete(test.select(1));
//		test.update(new Meaning(10, "updated", 1));
//		test.selectAll().forEach(System.out::println);
	}
	@Override
	public Meaning select(Integer id) {
		return new MeaningDAOImpl().select(id);
	}

	@Override
	public List<Meaning> selectAll() {
		return new MeaningDAOImpl().selectAll() ;
	}

	@Override
	public Integer insert(Meaning t) {
		return new MeaningDAOImpl().insert(t);
	}

	@Override
	public Integer update(Meaning t) {
		return new MeaningDAOImpl().update(t);
	}

	@Override
	public Integer delete(Meaning t) {
		return new MeaningDAOImpl().delete(t);
	}

}
