package test;

import java.util.List;

import dao.ExampleDAOImpl;
import entity.ExampleSentences;
import iservice.ExampleDAO;

public class TestExampleDAOImpl implements ExampleDAO {
	public static void main(String[] args) {
		TestExampleDAOImpl test = new TestExampleDAOImpl();
		ExampleSentences ex = new ExampleSentences(null, "How Are You");
//		System.out.println(test.select(4));
//		System.out.println(test.insert(ex));
//		System.out.println(test.update(new ExampleSentences(4, "Updated")));
		System.out.println(test.delete(test.select(7)));
		test.selectAll().forEach(System.out::println);
	}
	@Override
	public ExampleSentences select(Integer id) {
		return new ExampleDAOImpl().select(id);
	}

	@Override
	public List<ExampleSentences> selectAll() {
		return new ExampleDAOImpl().selectAll();
	}

	@Override
	public Integer insert(ExampleSentences t) {
		return new ExampleDAOImpl().insert(t);
	}

	@Override
	public Integer update(ExampleSentences t) {
		return new ExampleDAOImpl().update(t);
	}

	@Override
	public Integer delete(ExampleSentences t) {
		return new ExampleDAOImpl().delete(t);
	}

}
