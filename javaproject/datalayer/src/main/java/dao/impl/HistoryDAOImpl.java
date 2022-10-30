package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.HistoryDAO;
import database.ConnectDBFromProperties;
import entity.History;

public class HistoryDAOImpl implements HistoryDAO {
	private List<History> list;

	public HistoryDAOImpl() {
		if (this.list == null) {
			list = selectAll();
		}
	}

	public List<History> getList() {
		return list;
	}
	
	@Override
	/**
	 * @return null if it doesn't exist
	 */
	public History select(Integer id) {
		History bm = null;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selHistory(?)}");) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();

			if (rs.next()) {
				Integer bmId = rs.getInt(1);
				Integer vocabId = rs.getInt(2);
				Integer userId = rs.getInt(3);
				bm = new History(bmId, vocabId, userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Select A History Failed!");
		}
		return bm;
	}
	
	@Override
	/**
	 * @return null if doesn't have any
	 */
	public List<History> selectAll() {
		List<History> list = new ArrayList<>();
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call selAllHistory}");
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				Integer bmId = rs.getInt(1);
				Integer vocabId = rs.getInt(2);
				Integer userId = rs.getInt(3);
				list.add(new History(bmId, vocabId, userId));
			}
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Select all History failed!");
		}
		return list.isEmpty() ? null : list;
	}
	
	@Override
	/**
	 * @return 0 for insert failed
	 * @return 1 for insert successfully
	 */
	public Integer insert(History hst) {
		Integer result = 0;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call insertHistory(?, ?)}")) {
			cs.setInt(1, hst.getVocabularyId());
			cs.setInt(2, hst.getUserId());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Insert History failed!");
		}
		return result;
	}
	
	@Override
	/**
	 * @return 0 for update failed
	 * @return 1 for update successfully
	 */
	public Integer update(History hst) {
		Integer result = 0;
		try (var con = ConnectDBFromProperties.getConnectionFromClassPath();
				var cs = con.prepareCall("{call updateHistory(?, ?, ?)}");) {
			cs.setInt(1, hst.getId());
			cs.setInt(2, hst.getVocabularyId());
			cs.setInt(3, hst.getUserId());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Update History failed");
		}
		return result;
	}
	
	@Override
	/**
	 * @return 0 for delete failed
	 * @return 1 for delete successfully
	 */
	public Integer delete(History hst) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteHistory(?)}");
		) {
			cs.setInt(1, hst.getId());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Delete a History failed");
		}
		return result;
	}
}
