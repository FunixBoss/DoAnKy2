package dao;

import java.util.ArrayList;
import java.util.List;

import database.ConnectDBFromProperties;
import entity.ExampleSentences;
import iservice.ExampleDAO;

public class ExampleDAOImpl implements ExampleDAO {
	private List<ExampleSentences> list;

	public ExampleDAOImpl() {
		if (this.list == null) {
			list = selectAll();
		}
	}

	public List<ExampleSentences> getList() {
		return list;
	}

	@Override
	/**
	 * @return null if it doesn't exist
	 */
	public ExampleSentences select(Integer id) {
		ExampleSentences ex = null;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selEx(?)}");
		){
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			
			if(rs.next()) {
				Integer exId = rs.getInt(1);
				String content = rs.getString(2);
				ex = new ExampleSentences(exId, content);
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println("Select A ExampleSentences Failed!");
		}
		return ex;
	}

	/**
	 *  @return null if doesn't have any
	 */
	public List<ExampleSentences> selectAll() {
		List<ExampleSentences> list = new ArrayList<>();
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllEx}");
			var rs = cs.executeQuery();
		){
			while(rs.next()) {
				Integer id = rs.getInt(1);
				String content = rs.getString(2);
				list.add(new ExampleSentences(id, content));
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Select all Ex failed!");
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	/**
	 * @return 0 for insert failed
	 * @return 1 for insert successfully
	 */
	public Integer insert(ExampleSentences ex) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call insertEx(?)}")
		){
			cs.setString(1, ex.getContent());
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Insert Ex failed!");
		}
		return result;
	}

	@Override
	/**
	 * @return 0 for update failed
	 * @return 1 for update successfully
	 */
	public Integer update(ExampleSentences ex) {
		Integer result = 0;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call updateEx(?, ?)}");
		){
			cs.setInt(1, ex.getId());
			cs.setString(2, ex.getContent());
			result = cs.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println("Update Ex failed");
		}
		return result;
	}

	@Override
	/**
	 * @return 0 for delete failed
	 * @return 1 for delete successfully
	 */
	public Integer delete(ExampleSentences ex) {
		Integer result = 0;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteEx(?)}");
		){
			cs.setInt(1, ex.getId());
			result = cs.executeUpdate();
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Delete a Ex failed");
		}
		return result;
	}

}
