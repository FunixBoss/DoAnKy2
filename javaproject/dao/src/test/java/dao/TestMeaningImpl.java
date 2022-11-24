package dao;

import java.util.List;

import dao.impl.MeaningDAOImpl;
import entity.Example;
import entity.Meaning;
import dao.DAO;
import dao.MeaningDAO;

public class TestMeaningImpl implements MeaningDAO {
	public static void main(String[] args) {
		TestMeaningImpl test = new TestMeaningImpl();
		Meaning mn = new Meaning("LoL", 1);
//		System.out.println(test.select(1)); // done
//		test.insert(mn);
//		test.delete(test.select(1));
//		test.update(new Meaning(10, "updated", 1));
//		test.selectAll().forEach(System.out::println);
		System.out.println(test.insertGetId(mn));
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
	@Override
	public List<Example> selectAllExampleByMeaningId(Integer meaningId) {
		return new MeaningDAOImpl().selectAllExampleByMeaningId(meaningId);
	}
	@Override
	public Integer insertGetId(Meaning meaning) {
		return new MeaningDAOImpl().insertGetId(meaning);
	}
}
