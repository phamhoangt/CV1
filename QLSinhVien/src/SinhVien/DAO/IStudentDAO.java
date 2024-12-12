package SinhVien.DAO;

import java.util.List;

import SinhVien.model.Student;

public interface IStudentDAO {
	List<Student> sellectAll();
	List<Student> sellectById(Student student);
	List<Student> sellectById(String id);
	List<Student> sellectByConditions(String conditions);
	int save(Student student);
	int delete(Student student);
	int update(Student student);
}
