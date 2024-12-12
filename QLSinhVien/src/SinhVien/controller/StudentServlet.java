package SinhVien.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SinhVien.DAO.IMPL.StudentDAO;
import SinhVien.model.Student;
import SinhVien.service.IMPL.StudentService;

@WebServlet(urlPatterns = {"/trang-chu"})
public class StudentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Student> list = new StudentService(new StudentDAO()).sellectAll();
		req.setAttribute("listStudent", list);
		req.getRequestDispatcher("view_student.jsp").forward(req, resp);
	}

}
