package br.com.akira.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.akira.model.User;

@WebFilter(filterName =("loginFilter"), dispatcherTypes = DispatcherType.REQUEST, urlPatterns = "/*")
public class LoginFilter implements Filter {

	public LoginFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		HttpSession session = req.getSession();
//		User usuario = (User) session.getAttribute("userLoginSession");

		/**
		 * Session userSessionLogin get LoginController
		 */
		if (
				req.getRequestURI().lastIndexOf("login.jsp") != -1
				|| req.getRequestURI().lastIndexOf("loginController") != -1 
				|| session.getAttribute("userSessionLogin") != null) {
			System.out.println("filter in ...");
			chain.doFilter(request, response);
		}

		else {
			req.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
