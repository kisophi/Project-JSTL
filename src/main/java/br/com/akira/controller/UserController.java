package br.com.akira.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.model.User;
import br.com.akira.model.UserDAO;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");

		User u = new User();
		if (userid != null) {
			u.setUserid(Integer.parseInt(userid));}
		u.setName(name);
		u.setLogin(login);
		u.setPass(pass);

		UserDAO dao = new UserDAO();
		dao.saveUser(u);
	}

}
