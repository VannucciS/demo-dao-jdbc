package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;

		try {
			String sql = "INSERT INTO Department (Name) VALUES (?)";
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Error! Nothing was inserted!");
			}
		} catch (SQLException e) {
			throw new DbException("Error: " + e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;

		try {
			String sql = "UPDATE Department SET Name = ? WHERE ID = ?";
			st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			st.executeUpdate();

		} catch (SQLException e) {
			throw new DbException("Error: " + e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;

		try {
			String sql = "Delete from Department WHERE Id=?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			int affectedRows = st.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("Selected id was deleted!");
			} else {
				throw new DbException("Error: nothing was deleted");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM Department WHERE Id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = new Department(rs.getInt(1), rs.getString(2));
				return dep;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());

		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);

		}

	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		List<Department> list = new ArrayList<>();
		try {
			String sql = "SELECT * FROM department";			
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				Department dep = new Department(rs.getInt(1), rs.getString(2));
				list.add(dep);
			}
			return list;
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);			
		}
		
	}

}
