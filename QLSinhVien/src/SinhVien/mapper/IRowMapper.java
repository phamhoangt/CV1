package SinhVien.mapper;

import java.sql.ResultSet;

public interface IRowMapper<T> {
	T rowMapper(ResultSet resultSet);
}
