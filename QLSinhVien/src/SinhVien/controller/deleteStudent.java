package SinhVien.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SinhVien.DAO.IMPL.StudentDAO;
import SinhVien.model.Student;
import SinhVien.service.IStudentService;
import SinhVien.service.IMPL.StudentService;

@WebServlet(urlPatterns = {"/deleteStudent"})
public class deleteStudent extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private IStudentService studentService = new StudentService(new StudentDAO());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Student student = studentService.sellectById(id);
		int res = studentService.delete(student);
		if(res < 0) {
			resp.sendRedirect("error.jsp");
		} else {
			resp.sendRedirect("trang-chu");
		}
	}
}
