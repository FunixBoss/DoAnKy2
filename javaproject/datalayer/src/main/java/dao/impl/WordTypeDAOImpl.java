package dao.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import dao.WordTypeDAO;
import database.ConnectDBFromProperties;
import entity.Category;
import entity.WordType;

public class WordTypeDAOImpl implements WordTypeDAO{
	private List<WordType> list;

	public WordTypeDAOImpl() {
		if (list == null) {
			list = selectAll();
		}
	}

	public List<WordType> getList() {
		return list;
	}

	/**
	 * @return null if don't have any
	 */
	public List<WordType> selectAll() {
		List<WordType> list = new ArrayList<>();
		try(
			var con = ConnectDBFromProperties.getConnectionFromClassPath();
			var cs = con.prepareCall("{call selAllWordType}");
			var rs = cs.executeQuery();
		){
			while(rs.next()) {
				var type = new WordType();
				type.setType(rs.getString("type"));
				list.add(type);
			}
		} catch(Exception e) {
//			e.printStackTrace();
			System.out.println("Select all WordType failed");
		}
		return list.isEmpty() ? null : list;
	}

	@Override
	public WordType select(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insert(WordType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer update(WordType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer delete(WordType t) {
		// TODO Auto-generated method stub
		return null;
	}
}