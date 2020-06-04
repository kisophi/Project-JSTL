package br.com.akira.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.akira.model.User;
import br.com.akira.model.UserDAO;

@WebServlet("/userController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getParameter("action");
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		
		if(action==null) {
			action = "allUsers";
		}

		/**
		 * List of Users
		 */
		if (action.equals("allUsers")) {
			UserDAO dao = new UserDAO();
			List<User> list = dao.allUsers();

			request.setAttribute("list", list);
			request.getRequestDispatcher("WEB-INF/allUsers.jsp").forward(request, response);
		}
		
		/**
		 * Add Users
		 */
		else if(action.equals("addUser")) {
			request.getRequestDispatcher("WEB-INF/addUser.jsp").forward(request, response);
		}
		
		/**
		 * Delete Users
		 */
		else if(action.equals("deleteUser")) {
			UserDAO dao = new UserDAO();
			dao.deleteUser(Integer.parseInt(userid));
			response.sendRedirect("userController");
		}
		
		/**
		 * Update Users
		 */
		else if(action.equals("updateUser")) {
			UserDAO dao = new UserDAO();
			User user = dao.findById(Integer.parseInt(userid));
			
			request.setAttribute("user", user);
			request.getRequestDispatcher("WEB-INF/updateUser.jsp").forward(request, response);
		}
		
		/**
		 * Find User by name
		 */
		if (action.equals("findByName")) {
			UserDAO dao = new UserDAO();
			List<User> list = dao.findByName(name);

			request.setAttribute("list", list);
			request.getRequestDispatcher("WEB-INF/findByName.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");

		User u = new User();
		if (userid != null) {
			u.setUserid(Integer.parseInt(userid));
		}
		u.setName(name);
		u.setLogin(login);
		u.setPass(pass);

		UserDAO dao = new UserDAO();
		dao.saveUser(u);
		
		response.sendRedirect("userController");
	}

}
