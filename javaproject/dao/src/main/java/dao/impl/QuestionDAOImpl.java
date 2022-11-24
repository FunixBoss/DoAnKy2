package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.QuestionDAO;
import database.ConnectDBFromProperties;
import entity.Lesson;
import entity.Question;

public class QuestionDAOImpl extends AbstractDAO<Question> implements QuestionDAO {

	@Override
	public Question select(Integer id) {
		Question qs = null;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selQuestion(?)}");
		) {
			cs.setInt(1, id);
			var rs = cs.executeQuery();

			if (rs.next()) {
				Integer qsId = rs.getInt(1);
				String content = rs.getString(2);
				Integer lessonId = rs.getInt(3);
				qs = new Question(qsId, content, lessonId);
			}
		} catch (Exception e) {
			 e.printStackTrace();
			System.err.println("Select A Question Failed!");
		}
		return qs;
	}

	@Override
	public List<Question> selectAll() {
		List<Question> list = new ArrayList<>();
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllQuestion}");
			var rs = cs.executeQuery();
		) {
			while (rs.next()) {
				Integer qsId = rs.getInt(1);
				String content = rs.getString(2);
				Integer lessonId = rs.getInt(3);
				list.add(new Question(qsId, content, lessonId));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Select all Questions failed!");
		}
		return list;
	}

	@Override
	public Integer insert(Question qs) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call insertQuestion(?, ?)}")
		) {
			cs.setString(1, qs.getContent());
			cs.setInt(2, qs.getLessonId());
			result = cs.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Insert Question failed!");
		}
		return result;
	}

	@Override
	public Integer update(Question qs) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call updateQuestion(?, ?, ?)}");
		) {
			cs.setInt(1, qs.getId());
			cs.setString(2, qs.getContent());
			cs.setInt(3, qs.getLessonId());
			result = cs.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Update Question failed");
		}
		return result;
	}

	@Override
	public Integer delete(Question qs) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteQuestion(?)}");
		) {
			cs.setInt(1, qs.getId());
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Delete a Question failed");
		}
		return result;
	}

	@Override
	public List<Question> selAllQuestionByLessonId(Integer lessonId) {
		List<Question> list = new ArrayList<>();
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllQuestionByLessonId(?)}");
		) {
			cs.setInt(1, lessonId);
			var rs = cs.executeQuery();
			while (rs.next()) {
				Integer qsId = rs.getInt(1);
				String content = rs.getString(2);
				Integer lessonIdRs = rs.getInt(3);
				list.add(new Question(qsId, content, lessonId));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.err.println("Select all Questions By Lesson ID failed!");
		}
		return list;
	}

}
