package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.BookmarkDAO;
import database.ConnectDBFromProperties;
import entity.Bookmark;

public class BookmarkDAOImpl implements BookmarkDAO {
	private List<Bookmark> list;

	public BookmarkDAOImpl() {
		if (this.list == null) {
			list = selectAll();
		}
	}

	public List<Bookmark> getList() {
		return list;
	}
	
	@Override
	/**
	 * @return null if it doesn't exist
	 */
	public Bookmark select(Integer id) {
		Bookmark bm = null;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selBookmark(?)}");) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();

			if (rs.next()) {
				Integer bmId = rs.getInt(1);
				Integer vocabId = rs.getInt(2);
				Integer userId = rs.getInt(3);
				bm = new Bookmark(bmId, vocabId, userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Select A Bookmark Failed!");
		}
		return bm;
	}
	
	@Override
	/**
	 * @return null if doesn't have any
	 */
	public List<Bookmark> selectAll() {
		List<Bookmark> list = new ArrayList<>();
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selAllBookmark}");
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				Integer bmId = rs.getInt(1);
				Integer vocabId = rs.getInt(2);
				Integer userId = rs.getInt(3);
				list.add(new Bookmark(bmId, vocabId, userId));
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Select all Bookmark failed!");
		}
		return list.isEmpty() ? null : list;
	}
	
	@Override
	/**
	 * @return 0 for insert failed
	 * @return 1 for insert successfully
	 */
	public Integer insert(Bookmark bm) {
		Integer result = 0;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call insertBookmark(?, ?)}")) {
			cs.setInt(1, bm.getVocabularyId());
			cs.setInt(2, bm.getUserId());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Insert Bookmark failed!");
		}
		return result;
	}
	
	@Override
	/**
	 * @return 0 for update failed
	 * @return 1 for update successfully
	 */
	public Integer update(Bookmark bm) {
		Integer result = 0;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call updateBookmark(?, ?, ?)}");) {
			cs.setInt(1, bm.getId());
			cs.setInt(2, bm.getVocabularyId());
			cs.setInt(3, bm.getUserId());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Update Bookmark failed");
		}
		return result;
	}
	
	@Override
	/**
	 * @return 0 for delete failed
	 * @return 1 for delete successfully
	 */
	public Integer delete(Bookmark bm) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteBookmark(?)}");
		) {
			cs.setInt(1, bm.getId());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Delete a Bookmark failed");
		}
		return result;
	}
}
