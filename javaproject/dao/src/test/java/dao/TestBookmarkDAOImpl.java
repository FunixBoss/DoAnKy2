
package dao;

import java.util.List;

import dao.impl.BookmarkDAOImpl;
import entity.Bookmark;
import entity.User;
import entity.Vocabulary;

public class TestBookmarkDAOImpl implements BookmarkDAO {
	public static void main(String[] args) {
		TestBookmarkDAOImpl test = new TestBookmarkDAOImpl();
		Bookmark bm = new Bookmark(1, 3);
		Bookmark bm2 = new Bookmark(3, 1, 10);
//		System.out.println(test.select(3));
//		System.out.println(test.insert(bm));
//		System.out.println(test.update(bm2));
//		System.out.println(test.delete(test.select(3)));
//		test.selectAll().forEach(System.out::println);
		
//		System.out.println(test.selectByUserId(2));
//		test.selectAllVocabByUserId(1).forEach(System.out::println);;
//		System.out.println(test.delByUserId(2));
//		test.selBookmarkByVocabId(3).forEach(System.out::println);
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


	@Override
	public List<Vocabulary> selectAllVocabByUserId(Integer userId) {
		return new BookmarkDAOImpl().selectAllVocabByUserId(userId);
	}

	@Override
	public Integer delByUserId(Integer userId) {
		return new BookmarkDAOImpl().delByUserId(userId);
	}

	@Override
	public List<Bookmark> selBookmarkByVocabId(Integer vocabId) {
		return new BookmarkDAOImpl().selBookmarkByVocabId(vocabId);
	}

	@Override
	public Integer deleteAll(Bookmark bm) {
		return new BookmarkDAOImpl().deleteAll(bm);
	}

	@Override
	public List<Bookmark> checkExistBookmark(Integer userId, Integer vocabId) {
		return new BookmarkDAOImpl().checkExistBookmark(userId, vocabId);
	}

	@Override
	public Bookmark checkExistBookmarkInDb(Integer userId, Integer vocabId) {
		return new BookmarkDAOImpl().checkExistBookmarkInDb(userId, vocabId);
	}

	

}
