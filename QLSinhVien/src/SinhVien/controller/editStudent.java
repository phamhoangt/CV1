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

@WebServlet(urlPatterns = {"/editStudent"})
public class editStudent extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IStudentService studentService = new StudentService(new StudentDAO());
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Student student = studentService.sellectById(id);
		req.setAttribute("student", student);
		req.getRequestDispatcher("editStudent.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = (String)req.getParameter("ID");
		String firstName = (String)req.getParameter("firstName");
		String secondName = (String)req.getParameter("secondName");
		String address = (String)req.getParameter("address");
		int res = studentService.update(new Student(id, firstName, secondName, address));
		if(res < 0) {
			// Thất bại
			resp.sendRedirect("error.jsp");
		} else {
			resp.sendRedirect("trang-chu");
		}
	}
}
