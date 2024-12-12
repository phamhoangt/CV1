package SinhVien.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SinhVien.DAO.IMPL.StudentDAO;
import SinhVien.model.Student;
import SinhVien.service.IMPL.StudentService;

@WebServlet(urlPatterns = {"/searchStudent"})
public class searchStudent extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id").trim();
		String fullName = req.getParameter("name").trim();
		String address = req.getParameter("address").trim();
		StringBuilder condition = new StringBuilder();
		if(!id.equals("")) {
			condition.append(" id = '" + id + "'");
		}
		if(!address.equals("")) {
			if(condition.length() != 0) condition.append("and "); 
			condition.append("address LIKE '%" + address + "%'");
		}
		if(fullName.equals("") == false) {
			if(condition.length() > 0) condition.append("and ");
			condition.append("LCASE(CONCAT_WS(' ', firstName, secondName)) LIKE '%" + fullName.toLowerCase() + "%'");
		}
		List<Student> students = (ArrayList<Student>)(new StudentService(new StudentDAO())).sellectByCondition(condition.toString());
		req.setAttribute("listStudent", students);
		req.setAttribute("ID", id);
		req.setAttribute("fullname", fullName);
		req.setAttribute("address", address);
		req.getRequestDispatcher("view_student.jsp").forward(req, resp);
	}

}
