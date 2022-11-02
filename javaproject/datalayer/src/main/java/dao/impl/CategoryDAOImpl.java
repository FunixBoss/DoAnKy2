package dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDBFromProperties;
import entity.Category;
import entity.Vocabulary;
import dao.CategoryDAO;

public class CategoryDAOImpl implements CategoryDAO {
	private List<Category> list;

	public CategoryDAOImpl() {
		if (list == null) {
			list = selectAll();
		}
	}

	public List<Category> getList() {
		return list;
	}

	@Override
	/**
	 * @return null if it doesn't exist  
	 */
	public Category select(Integer id) {
		Category cate = null;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selCate(?)}");
		){
			cs.setInt(1, id);
			var rs = cs.executeQuery();
			if(rs.next()) {
				Integer cateId = rs.getInt(1);
				String name = rs.getString(2);
				String imageIcon = rs.getString(3);
				cate = new Category(cateId, name, imageIcon);
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.out.println("Select a Category failed");
		}
		return cate;
	}

	@Override
	/**
	 * @return null if don't have any
	 */
	public List<Category> selectAll() {
		List<Category> list = new ArrayList<>();
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllCate}");
			var rs = cs.executeQuery();
		){
			while(rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				String imageIcon = rs.getString(3);
				list.add(new Category(id, name, imageIcon));
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.out.println("Select all Categories failed");
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	/**
	 * @return 0 if failed
	 * @return 0 if success
	 */
	public Integer insert(Category cate) {
		Integer result = 0;
		try (
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call insertCate(?,?)}");
		){
			cs.setString(1, cate.getName());
			cs.setString(2, cate.getImageIcon());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Insert a cate failed");
		}
		return result;
	}
	
	@Override
	/**
	 * @return 0 if failed
	 * @return 0 if success
	 */
	public Integer update(Category cate) {
		Integer result = 0;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call updateCate(?,?,?)}");	
		) {
			cs.setInt(1, cate.getId());
			cs.setString(2, cate.getName());
			cs.setString(3, cate.getImageIcon());
			result = cs.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("Update Category Failed");
		}
		return result;
	}

	@Override
	/**
	 * @return 0 if failed
	 * @return 0 if success
	 */
	public Integer delete(Category cate) {
		Integer result = 0;
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call deleteCate(?)}");
		){
			cs.setInt(1, cate.getId());
			result = cs.executeUpdate();
		} catch(Exception e) {
//			e.printStackTrace();
			System.err.println("Delete a cate failed");
		}
		return result;
	}


	@Override
	/**
	 * @return null if don't have any
	 */
	public List<Vocabulary> selectAllVocabByCategoryId(Integer cateId) {
		List<Vocabulary> list = new ArrayList<>();
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllVocabInCateById(?)}");
		){
			cs.setInt(1, cateId);
			var rs = cs.executeQuery();
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
			System.out.println("Select All Vocab In Category failed");
		}
		return list.isEmpty() ? null : list;
	}

}
