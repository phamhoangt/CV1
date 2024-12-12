package SinhVien.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SinhVien.DAO.IMPL.StudentDAO;
import SinhVien.model.Student;
import SinhVien.service.IMPL.StudentService;

@WebServlet(urlPatterns = {"/addStudent"})
public class addStudent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("add_student.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("ID");
		String firstName = req.getParameter("firstName");
		String secondName = req.getParameter("secondName");
		String address = req.getParameter("address");
		if(new StudentService(new StudentDAO()).save(new Student(id, firstName, secondName, address)) < 0) {
			resp.sendRedirect("error.jsp");
		} else {
			resp.sendRedirect("/QLSinhVien/trang-chu");
		}
	}
}
