package dao;

import java.security.spec.RSAKeyGenParameterSpec;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDBFromProperties;
import entity.Meaning;
import entity.Vocabulary;
import iservice.MeaningDAO;

public class MeaningDAOImpl implements MeaningDAO {
	private List<Meaning> list;
	
	public MeaningDAOImpl() {
		if(this.list == null) {
			list = selectAll();
		}
	}
	
	public List<Meaning> getList() {
		return list;
	}

	@Override
	/**
	 * @return null if it doesn't exist
	 */
	public Meaning select(Integer id) {
		Meaning meaning = null;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selMeaning(?)}");
		){
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			
			if(rs.next()) {
				Integer meaningId = rs.getInt(1);
				String content = rs.getString(2);
				Integer vocabId = rs.getInt(3);
				meaning = new Meaning(meaningId, content, vocabId);
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println("Select A Meaning Failed!");
		}
		return meaning;
	}
	
	
	@Override
	/**
	 *  @return null if doesn't have any
	 */
	public List<Meaning> selectAll() {
		List<Meaning> list = new ArrayList<>();
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllMeaning}");
			var rs = cs.executeQuery();
		){
			while(rs.next()) {
				Integer meaningId = rs.getInt(1);
				String content = rs.getString(2);
				Integer vocabId = rs.getInt(3);
				list.add(new Meaning(meaningId, content, vocabId));
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Select all Meaning failed!");
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	/**
	 * @return 0 for insert failed
	 * @return 1 for insert successfully
	 */
	public Integer insert(Meaning meaning) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call insertMeaning(?, ?)}")
		){
			cs.setString(1, meaning.getContent());
			cs.setInt(2, meaning.getVocabularyId());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Insert Meaning failed!");
		}
		return result;
	}

	@Override
	/**
	 * @return 0 for update failed
	 * @return 1 for update successfully
	 */
	public Integer update(Meaning meaning) {
		Integer result = 0;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call updateMeaning(?, ?, ?)}");
		){
			cs.setInt(1, meaning.getId());
			cs.setString(2, meaning.getContent());
			cs.setInt(3, meaning.getVocabularyId());
			result = cs.executeUpdate();
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Update Meaning failed");
		}
		return result;
	}

	@Override
	/**
	 * @return 0 for delete failed
	 * @return 1 for delete successfully
	 */
	public Integer delete(Meaning meaning) {
		Integer result = 0;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteMeaning(?)}");
		){
			cs.setInt(1, meaning.getId());
			result = cs.executeUpdate();
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Delete a Meaning failed");
		}
		return result;
	}

}
