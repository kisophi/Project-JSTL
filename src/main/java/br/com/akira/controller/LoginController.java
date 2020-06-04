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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String pass  = request.getParameter("pass");
		
		UserDAO dao = new UserDAO();
		User u = dao.userAutentication(login, pass);
		
		if(u!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("userSessionLogin", u);
			
			//max time of session
			session.setMaxInactiveInterval(60*2);
			
			response.sendRedirect("userController");
//			request.getRequestDispatcher("")
		}else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	
	}

}
