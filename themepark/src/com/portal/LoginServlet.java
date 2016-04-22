package com.portal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import com.general.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/portal-pages/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get login parameters from webpage.
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
						
		DBConnector conn = new DBConnector();
		Map<String, Object> results = conn.tryLogin(user, pwd);
		
		HttpSession session = request.getSession(); // Create the session variable.
		
		if (results.size() > 0) {
			NavMenu navMenu = new NavMenu(results.get("department_name").toString()); // Create navigation menu based on department.
			session.setAttribute("userId", results.get("emp_id")); // Set from emp_id field.
			session.setAttribute("user", String.format("%s %s",	results.get("first_name"), results.get("last_name"))); // Set from first_name and last_name fields.
			session.setAttribute("dept", results.get("department_name")); // Set from department field.
			session.setAttribute("navMenu", navMenu);
			session.setMaxInactiveInterval(30 * 60); // Set session expiration time to 30 minutes.
			
			response.sendRedirect("/themepark/Portal");
		} else {
			request.setAttribute("loginPageMsg", "Incorrect username or password.");
			request.getRequestDispatcher("/WEB-INF/portal-pages/login.jsp").include(request, response);
		}
	}

}
