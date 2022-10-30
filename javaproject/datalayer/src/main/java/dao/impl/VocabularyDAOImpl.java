package dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDBFromProperties;
import entity.Vocabulary;
import dao.VocabularyDAO;

public class VocabularyDAOImpl implements VocabularyDAO {
	private List<Vocabulary> list;

	public VocabularyDAOImpl() {
		if (list == null) {
			list = selectAll();
		}
	}

	public List<Vocabulary> getList() {
		return list;
	}

	
	@Override
	/**
	 * @return null if it doesn't exist
	 */
	public Vocabulary select(Integer id) {
		Vocabulary vocab = null;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selVocab(?)}");
		){
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			
			if(rs.next()) {
				Integer vocab_id = rs.getInt(1);
				String word = rs.getString(2);
				String image = rs.getString(3);
				String pronunciation = rs.getString(4);
				Integer exampleId = rs.getInt(5);
				Integer categoryId = rs.getInt(6);
				Integer wordTypeId = rs.getInt(7);
				vocab = new Vocabulary(vocab_id, word, pronunciation, image, exampleId, categoryId, wordTypeId);
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println("Select A Vocabulary Failed!");
		}
		return vocab;
	}

	@Override
	/**
	 *  @return null if doesn't have any
	 */
	public List<Vocabulary> selectAll() {
		List<Vocabulary> list = new ArrayList<>();
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllVocab}");
			var rs = cs.executeQuery();
		){
			while(rs.next()) {
				Integer vocab_id = rs.getInt(1);
				String word = rs.getString(2);
				String image = rs.getString(3);
				String pronunciation = rs.getString(4);
				Integer exampleId = rs.getInt(5);
				Integer categoryId = rs.getInt(6);
				Integer wordTypeId = rs.getInt(7);
				
				list.add(
					new Vocabulary(vocab_id, word, pronunciation, image, exampleId, categoryId, wordTypeId));
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Select all vocabulary failed!");
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	/**
	 * @return 0 for insert failed
	 * @return 1 for insert successfully
	 */
	public Integer insert(Vocabulary vocab) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call insertVocab(?, ?, ?, ?, ?, ?)}")
		){
			cs.setString(1, vocab.getWord());
			cs.setString(2, vocab.getImage());
			cs.setString(3, vocab.getPronunciation());
			if(vocab.getExampleId() != null) {
				cs.setInt(4, vocab.getExampleId());
			}  else {
				cs.setNull(4, Types.INTEGER);
			}
			if(vocab.getCategoryId() != null) {
				cs.setInt(5, vocab.getCategoryId());
			} else {
				cs.setNull(5, Types.INTEGER);
			}
			if(vocab.getWordTypeId() != null) {
				cs.setInt(6, vocab.getWordTypeId());
			} else {
				cs.setNull(6, Types.INTEGER);
			}
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.err.println("Insert vocabulary failed!");
		}
		return result;
	}
	
	@Override
	/**
	 * @return 0 for update failed
	 * @return 1 for update successfully
	 */
	public Integer update(Vocabulary vocab) {
		Integer result = 0;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call updateVocab(?, ?, ?, ?, ?, ?, ?)}");
		){
			cs.setInt(1, vocab.getId());
			cs.setString(2, vocab.getWord());
			cs.setString(3, vocab.getImage());
			cs.setString(4, vocab.getPronunciation());
			
			if(vocab.getExampleId() != null) {
				cs.setInt(5, vocab.getExampleId());				
			} else {
				cs.setNull(5, Types.INTEGER);
			}
			if(vocab.getCategoryId() != null) {
				cs.setInt(6, vocab.getCategoryId());
			} else {
				cs.setNull(6, Types.INTEGER);
			}
			if(vocab.getWordTypeId() != null) {
				cs.setInt(7, vocab.getWordTypeId());
			} else {
				cs.setNull(7, Types.INTEGER);
			}
			result = cs.executeUpdate();
		} catch(Exception e) {
//			e.printStackTrace();
			System.out.println("Update vocab failed");
		}
		return result;
	}

	@Override
	/**
	 * @return 0 for delete failed
	 * @return 1 for delete successfully
	 */
	public Integer delete(Vocabulary vocab) {
		Integer result = 0;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteVocab(?)}");
		){
			cs.setInt(1, vocab.getId());
			result = cs.executeUpdate();
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Delete a vocabulary failed");
		}
		return result;
	}
}
