package com.portal;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		// get employee info from webpage
		//String first, String last, String dept, String address, String phone, String city, String state, String zip, Date dob, Date hire, String pw
		String first = request.getParameter("firstName");
		String last = request.getParameter("lastName");
		String dept = request.getParameter("department");
		String address = request.getParameter("address");
		String phone = request.getParameter("phoneNumber");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String dobMonth = request.getParameter("dobMonth");
		String dobDay = request.getParameter("dobDay");
		String dobYear = request.getParameter("dobYear");
		
		// convert dob
		String dobS = dobYear + "-" + dobMonth + "-" + dobDay;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dobUtil = null;
		try {
			dobUtil = formatter.parse(dobS);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dobSql = new java.sql.Date(dobUtil.getTime());
		
		// create hire date
		java.util.Date hireUtil = new java.util.Date();
	    java.sql.Date hireSql = new java.sql.Date(hireUtil.getTime());
		
		DBConnector conn = new DBConnector();
		conn.insertEmployee(first,last,dept,address,phone,city,state,zip,dobSql,hireSql,"password");
		
		response.sendRedirect("/themepark/Portal/");
	}

}
