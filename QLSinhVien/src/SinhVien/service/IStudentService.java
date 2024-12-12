package SinhVien.service;

import java.util.List;

import SinhVien.model.Student;

public interface IStudentService {
	List<Student> sellectAll();
	Student sellectById(String id);
	Student sellectById(Student student);
	List<Student> sellectByCondition(String condition);
	int update(Student student);
	int delete(Student student);
	int save(Student student);
}
