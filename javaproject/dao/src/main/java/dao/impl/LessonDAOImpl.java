package dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dao.LessonDAO;
import database.ConnectDBFromProperties;
import entity.Bookmark;
import entity.Lesson;

public class LessonDAOImpl extends AbstractDAO<Lesson> implements LessonDAO {

	@Override
	public Lesson select(Integer id) {
		Lesson ls = null;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selLesson(?)}");
		) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();

			if (rs.next()) {
				Integer lsId = rs.getInt(1);
				String title = rs.getString(2);
				String image = rs.getString(3);
				ls = new Lesson(lsId, title, image);
			}
		} catch (Exception e) {
			 e.printStackTrace();
			System.err.println("Select A Lesson Failed!");
		}
		return ls;
	}

	@Override
	public List<Lesson> selectAll() {
		List<Lesson> list = new ArrayList<>();
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllLesson}");
			var rs = cs.executeQuery();
		) {
			while (rs.next()) {
				Integer lsId = rs.getInt(1);
				String title = rs.getString(2);
				String image = rs.getString(3);
				list.add(new Lesson(lsId, title, image));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Select all Lessons failed!");
		}
		return list;
	}

	@Override
	public Integer insert(Lesson ls) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call insertLesson(?, ?)}")
		) {
			cs.setString(1, ls.getTitle());
			if(ls.getImage() != null) {
				cs.setString(2, ls.getImage());				
			} else{
				cs.setNull(2, Types.NVARCHAR);
			}
			result = cs.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Insert Lesson failed!");
		}
		return result;
	}

	@Override
	public Integer update(Lesson ls) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call updateLesson(?, ?, ?)}");
		) {
			cs.setInt(1, ls.getId());
			cs.setString(2, ls.getTitle());
			if(ls.getImage() != null) {
				cs.setString(3, ls.getImage());				
			} else{
				cs.setNull(3, Types.NVARCHAR);
			}
			result = cs.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Update Lesson failed");
		}
		return result;
	}

	@Override
	public Integer delete(Lesson ls) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteLesson(?)}");
		) {
			cs.setInt(1, ls.getId());
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Delete a Lesson failed");
		}
		return result;
	}

}
