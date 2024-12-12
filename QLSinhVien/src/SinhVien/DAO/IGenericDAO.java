package SinhVien.DAO;

import java.util.List;

import SinhVien.mapper.IRowMapper;

public interface IGenericDAO<T> {
	List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
	int insert(String sql, Object... parameters);
	int update(String sql, Object... parameters);
}
