
package dao;

import java.util.List;

import dao.impl.BookmarkDAOImpl;
import entity.Bookmark;

public class TestBookmarkDAOImpl implements BookmarkDAO {
	public static void main(String[] args) {
		TestBookmarkDAOImpl test = new TestBookmarkDAOImpl();
		Bookmark bm = new Bookmark(1, 5);
		Bookmark bm2 = new Bookmark(3, 1, 10);
//		System.out.println(test.select(3));
//		System.out.println(test.insert(bm));
//		System.out.println(test.update(bm2));
		System.out.println(test.delete(test.select(3)));
		test.selectAll().forEach(System.out::println);
	}

	@Override
	public Bookmark select(Integer id) {
		return new BookmarkDAOImpl().select(id);
	}

	@Override
	public List<Bookmark> selectAll() {
		return new BookmarkDAOImpl().selectAll();
	}

	@Override
	public Integer insert(Bookmark t) {
		return new BookmarkDAOImpl().insert(t);
	}

	@Override
	public Integer update(Bookmark t) {
		return new BookmarkDAOImpl().update(t);
	}

	@Override
	public Integer delete(Bookmark t) {
		return new BookmarkDAOImpl().delete(t);
	}

}
