package SinhVien.DAO.IMPL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import SinhVien.DAO.IGenericDAO;
import SinhVien.mapper.IRowMapper;

public class AbstractDAO<T> implements IGenericDAO<T>{
	
	private Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/db_student?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "root";
		String password = "012003";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<T> results = new ArrayList<T>();
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			SetParameters(statement, parameters);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				results.add(rowMapper.rowMapper(resultSet));
			}
			return results;
		} catch(Exception e) {
			return null;
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch(Exception e) {
				return null;
			}
		}
	}

	private void SetParameters(PreparedStatement statement, Object... parameters) {
		for(int i = 0; i < parameters.length; i++) {
			int index = i + 1;
			Object parameter = parameters[i];
			if(parameter instanceof String) {
				try {
					statement.setString(index, (String)parameter);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public int insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			statement = connection.prepareStatement(sql);
			connection.setAutoCommit(false);
			SetParameters(statement, parameters);
			int res = statement.executeUpdate();
			connection.commit();
			return res;
		} catch (Exception e) {
			try {
				connection.rollback();
				return -1;
			} catch(Exception ex) {
				return -1;
			}
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch(Exception e) {
				return -1;
			}
		}
	}

	@Override
	public int update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			SetParameters(statement, parameters);
			int res = statement.executeUpdate();
			connection.commit();
			return res;
		} catch (Exception e) {
			try {
				connection.rollback();
				return -1;
			} catch(SQLException ex) {
				
			}
			return -1;
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			} catch(Exception e) {
				return -1;
			}
		}
	}

}
