package dao;

import java.util.List;

import dao.impl.ExampleDAOImpl;
import entity.Example;
import dao.ExampleDAO;

public class TestExampleDAOImpl implements ExampleDAO {
	public static void main(String[] args) {
		TestExampleDAOImpl test = new TestExampleDAOImpl();
		Example ex = new Example(null, "How Are You ấy?", "Bạn thế nào z?", 2);
//		System.out.println(test.select(4));
//		System.out.println(test.insert(ex));
//		System.out.println(test.update(new Example(4, "Updated", "Updated", 10)));
//		System.out.println(test.delete(test.select(7)));
//		test.selectAll().forEach(System.out::println);
	}
	@Override
	public Example select(Integer id) {
		return new ExampleDAOImpl().select(id);
	}

	@Override
	public List<Example> selectAll() {
		return new ExampleDAOImpl().selectAll();
	}

	@Override
	public Integer insert(Example t) {
		return new ExampleDAOImpl().insert(t);
	}

	@Override
	public Integer update(Example t) {
		return new ExampleDAOImpl().update(t);
	}

	@Override
	public Integer delete(Example t) {
		return new ExampleDAOImpl().delete(t);
	}
	

}
