package SinhVien.DAO.IMPL;

import java.util.List;

import SinhVien.DAO.IStudentDAO;
import SinhVien.mapper.StudentMapper;
import SinhVien.model.Student;

public class StudentDAO extends AbstractDAO<Student> implements IStudentDAO {

	@Override
	public List<Student> sellectAll() {
		String sql = "SELECT * FROM Students";
		return query(sql, new StudentMapper());
	}

	@Override
	public List<Student> sellectById(Student student) {
		String sql = "SELECT * FROM Students WHERE id = ?";
		return query(sql, new StudentMapper(), student.getId());
	}

	@Override
	public List<Student> sellectById(String id) {
		String sql = "SELECT * FROM Students WHERE id = ?";
		return query(sql, new StudentMapper(), id);
	}

	@Override
	public List<Student> sellectByConditions(String conditions) {
		String sql = "SELECT * FROM Students WHERE " + conditions;
		return query(sql, new StudentMapper());
	}

	@Override
	public int save(Student student) {
		String sql = "INSERT INTO Students(id, firstName, secondName, address) VALUES (?, ?, ?, ?);";
		return insert(sql, student.getId(), student.getFirstName(), student.getSecondName(), student.getAddress());
	}

	@Override
	public int delete(Student student) {
		String sql = "DELETE FROM Students WHERE id = ?";
		return update(sql, student.getId());
	}

	@Override
	public int update(Student student) {
		String sql = "UPDATE Students SET firstName = ?, secondName = ?, address = ? WHERE id = ?";
		return update(sql, student.getFirstName(), student.getSecondName(), student.getAddress(), student.getId());
	}
	
}
