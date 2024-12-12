package SinhVien.mapper;

import java.sql.ResultSet;

import SinhVien.model.Student;

public class StudentMapper implements IRowMapper<Student> {

	@Override
	public Student rowMapper(ResultSet resultSet) {
		try {
			String id = resultSet.getString("id");
			String firstName = resultSet.getString("firstName");
			String secondName = resultSet.getString("secondName");
			String address = resultSet.getString("address");
			return new Student(id, firstName, secondName, address);
		} catch(Exception ex) {
			return null;
		}
	}

}
