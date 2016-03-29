package com.portal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String username = "travis";	// temporary, delete later.
	private final String password = "password";	// temporary, delete later.
       
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
		
		// Temp variable to hold a list of navigation items. This will eventually need to be a list of navigation items
		// retrieved from a class based on the privileges of the user that is logging in.
		List<NavMenu> navigationItems = new ArrayList<NavMenu>();
		navigationItems.add(new NavMenu("operations"));
		navigationItems.add(new NavMenu("statistics"));
		//String navItems[] = new String[navigationItems.size()];
		//navItems = navigationItems.toArray(navItems);
		
		if (username.equals(user) && password.equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", "Travis");
			session.setAttribute("navItems", navigationItems);
			session.setMaxInactiveInterval(30 * 60); // Set session expiration time to 30 minutes.
			
			//Cookie cookieUsername = new Cookie("user", user); // Cookie for the name of the user.
			//cookieUsername.setMaxAge(30 * 60);
			//response.addCookie(cookieUsername);
			
			response.sendRedirect("/themepark/Portal");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/themepark/Login");
			response.getWriter().println("<p>Incorrect pw</p>");
			rd.include(request, response);
		}
	}

}
