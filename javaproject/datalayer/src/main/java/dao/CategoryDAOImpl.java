package dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDBFromProperties;
import entity.Category;
import iservice.CategoryDAO;

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
				Integer parentId = (Integer) rs.getInt(4) != null ? rs.getInt(4) : null;
				cate = new Category(cateId, name, imageIcon, parentId);
			}
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Select a cate failed");
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
				Integer parentId = rs.getInt(4); 
				list.add(new Category(id, name, imageIcon, parentId));
			}
		} catch(Exception e) {
			e.printStackTrace();
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
			var cs = con.prepareCall("{call insertCate(?,?,?)}");
		){
			cs.setString(1, cate.getName());
			cs.setString(2, cate.getImageIcon());
			if(cate.getParentId() != null) {
				cs.setInt(3, cate.getParentId());				
			} else {
				cs.setNull(3, Types.INTEGER);
			}
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
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
			var cs = con.prepareCall("{call updateCate(?,?,?,?)}");	
		) {
			cs.setInt(1, cate.getId());
			cs.setString(2, cate.getName());
			cs.setString(3, cate.getImageIcon());
			if(cate.getParentId() != null) {
				cs.setInt(4, cate.getParentId());				
			} else {
				cs.setNull(4, Types.INTEGER);
			}
			result = cs.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
			System.err.println("Delete a cate failed");
		}
		return result;
	}

}
