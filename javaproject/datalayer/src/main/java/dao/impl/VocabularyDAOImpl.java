package dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import database.CallableStatementUtils;
import database.ConnectDBFromProperties;
import entity.Meaning;
import entity.Relatives;
import entity.Vocabulary;
import dao.VocabularyDAO;

public class VocabularyDAOImpl implements VocabularyDAO {
	private List<Vocabulary> list;

	public VocabularyDAOImpl() {
		if(list == null) {
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
				Integer categoryId = rs.getInt(6);
				Integer wordTypeId = rs.getInt(7);
				vocab = new Vocabulary(vocab_id, word, image, pronunciation, categoryId, wordTypeId);
			}
		} catch(Exception e) {
//			e.printStackTrace();
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
				Integer categoryId = rs.getInt(5);
				Integer wordTypeId = rs.getInt(6);
				
				list.add(
					new Vocabulary(vocab_id, word, image, pronunciation, categoryId, wordTypeId));
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
			if(vocab.getCategoryId() != null) {
				cs.setInt(4, vocab.getCategoryId());
			} else {
				cs.setNull(4, Types.INTEGER);
			}
			if(vocab.getWordTypeId() != null) {
				cs.setInt(5, vocab.getWordTypeId());
			} else {
				cs.setNull(5, Types.INTEGER);
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
	
	@Override
	/**
	 *  @return null if doesn't have any
	 */
	public List<Meaning> selectAllMeaningByVocabId(Integer vocabId) {
		List<Meaning> list = new ArrayList<>();
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selMeaningsByVocabId(?)}");
		){
			cs.setInt(1, vocabId);
			var rs = cs.executeQuery();
			while(rs.next()) {
				Integer meaningId = rs.getInt(1);
				String content = rs.getString(2);
				Integer vocabIdRs = rs.getInt(3);
				list.add(new Meaning(meaningId, content, vocabIdRs));
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Select all Meaning By Vocabulary Id failed!");
		}
		return list.isEmpty() ? null : list;
	}

	

	@Override
	public List<Relatives> selectAllRelativesByVocabId(Integer vocabId) {
		List<Relatives> list = new ArrayList<>();
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selRelativesByVocabId(?)}");
		){
			cs.setInt(1, vocabId);
			var rs = cs.executeQuery();
			while(rs.next()) {
				Integer relId = rs.getInt(1);
				String word = rs.getString(2);
				Integer vocabIdRs = rs.getInt(3);
				list.add(new Relatives(relId, word, vocabIdRs));
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Select all Relatives By Vocabulary Id failed!");
		}
		return list.isEmpty() ? null : list;
	}
	
	@Override
	
	public List<Vocabulary> selectByPages(int pageNumber, int rowOfPages) {
		List<Vocabulary> list = new ArrayList<>();
		
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = CallableStatementUtils.createCS(con, "{call selVocabByPages(?, ?)}", pageNumber, rowOfPages);
			var rs = cs.executeQuery();
		){
			while(rs.next()) {
				Integer vocab_id = rs.getInt(1);
				String word = rs.getString(2);
				String image = rs.getString(3);
				String pronunciation = rs.getString(4);
				Integer categoryId = rs.getInt(5);
				Integer wordTypeId = rs.getInt(6);
				list.add(
					new Vocabulary(vocab_id, word, image, pronunciation, categoryId, wordTypeId));
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Select Vocab By Pages Failed");
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	public Integer countNumberOfVocab() {
		int count = 0;
		
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call countVocab}");
			var rs = cs.executeQuery();
		){
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}
