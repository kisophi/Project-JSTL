package br.com.akira.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.model.User;
import br.com.akira.model.UserDAO;

@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Destroy session
		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		response.sendRedirect("login.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
		
		User user = new User();
		user.setLogin(login);
		user.setPass(pass);

		UserDAO dao = new UserDAO();
		User u = dao.userAutentication(user);

		if (u != null) {
			// Create Session
			HttpSession session = request.getSession();

			// set user
			session.setAttribute("userSessionLogin", u);

			// max time of session
			session.setMaxInactiveInterval(60 * 2);

			response.sendRedirect("userController");
		}

		else {
			//send msg invalid login
			request.setAttribute("invalidLogin", "Invalid user or password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
