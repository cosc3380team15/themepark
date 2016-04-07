package com.portal;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.general.DBConnector;

/**
 * Servlet implementation class NewEmployeeServlet
 */
@WebServlet("/Portal/HumanResources/NewEmployee")
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		List<String> results = conn.getAllDepartmentNames();
		
		if (results.size() > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("departmentNamesList", results);
			//session.setMaxInactiveInterval(30 * 60); // Set session expiration time to 30 minutes.
			
			//Cookie cookieUsername = new Cookie("user", user); // Cookie for the name of the user.
			//cookieUsername.setMaxAge(30 * 60);
			//response.addCookie(cookieUsername);
			
			//response.sendRedirect("/themepark/Portal");
		}
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/new-employee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
