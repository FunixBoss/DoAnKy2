package dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dao.VocabularyContributionDAO;
import database.ConnectDBFromProperties;
import entity.Bookmark;
import entity.VocabularyContribution;

public class VocabularyContributionDAOImpl extends AbstractDAO<VocabularyContribution>
		implements VocabularyContributionDAO {

	@Override
	public VocabularyContribution select(Integer id) {
		VocabularyContribution vc = null;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selVocabContri(?)}");
		) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();

			if (rs.next()) {
				Integer vcId = rs.getInt(1);
				String word = rs.getString(2);
				String meaning = rs.getString(3);
				Integer userId = rs.getInt(4);
				vc = new VocabularyContribution(vcId, word, meaning, userId);
			}
		} catch (Exception e) {
			 e.printStackTrace();
			System.err.println("Select A Vocab Contri Failed!");
		}
		return vc;
	}

	@Override
	public List<VocabularyContribution> selectAll() {
		List<VocabularyContribution> list = new ArrayList<>();
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllVocabContri}");
			var rs = cs.executeQuery();
		) {
			while (rs.next()) {
				Integer vcId = rs.getInt(1);
				String word = rs.getString(2);
				String meaning = rs.getString(3);
				Integer userId = rs.getInt(4);
				list.add(new VocabularyContribution(vcId, word, meaning, userId));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Select all Vocab Contri failed!");
		}
		return list;	}

	@Override
	public Integer insert(VocabularyContribution vc) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call insertVocabContri(?, ?, ?)}")
		) {
			
			if(vc.getWord() != null) {
				cs.setString(1, vc.getWord());
			} else {
				cs.setNull(1, Types.NVARCHAR);
			}
			if(vc.getMeaning() != null) {
				cs.setString(2, vc.getMeaning());
			} else {
				cs.setNull(2, Types.NVARCHAR);
			}
			cs.setInt(3, vc.getUserId());
			result = cs.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Insert Vocab Contri failed!");
		}
		return result;
	}
	public static void main(String[] args) {
		VocabularyContribution x = new VocabularyContribution("xx", "yy", 4);
		new VocabularyContributionDAOImpl().insert(x);
	}

	@Override
	public Integer update(VocabularyContribution vc) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call updateVocabContri(?, ?, ?, ?)}");
		) {
			cs.setInt(1, vc.getId());
			cs.setString(2, vc.getWord());
			cs.setString(3, vc.getMeaning());
			cs.setInt(4, vc.getUserId());
			result = cs.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Update Vocab Contri failed");
		}
		return result;
	}

	@Override
	public Integer delete(VocabularyContribution vc) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteVocabContri(?)}");
		) {
			cs.setInt(1, vc.getId());
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Delete a Vocab Contri failed");
		}
		return result;
	}

}
