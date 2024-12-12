package SinhVien.service.IMPL;

import java.util.List;

import SinhVien.DAO.IStudentDAO;
import SinhVien.model.Student;
import SinhVien.service.IStudentService;

public class StudentService implements IStudentService{
	private IStudentDAO studentDAO;
	
	public StudentService(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	@Override
	public List<Student> sellectAll() {
		return studentDAO.sellectAll();
	}

	@Override
	public Student sellectById(Student id) {
		List<Student> result = studentDAO.sellectById(id);
		return result == null ? null : result.get(0);
	}

	@Override
	public int update(Student student) {
		System.out.println(student.toString());
		return studentDAO.update(student);
	}

	@Override
	public int delete(Student student) {
		return studentDAO.delete(student);
	}

	@Override
	public Student sellectById(String id) {
		List<Student> list = studentDAO.sellectById(id);
		return list == null ? null : list.get(0);
	}

	@Override
	public int save(Student student) {
		return studentDAO.save(student);
	}

	@Override
	public List<Student> sellectByCondition(String condition) {
		return studentDAO.sellectByConditions(condition);
	}
	
}
