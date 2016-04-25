package com.portal;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.DBConnector;

/**
 * Servlet implementation class NewEmployeeServlet
 */
@WebServlet("/Portal/NewEmployee")
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
			request.setAttribute("departmentNamesList", results);
		}
		response.getWriter().println(results.size());
		request.getRequestDispatcher("/WEB-INF/portal-pages/new-employee.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DBConnector conn = new DBConnector();
		int resultInt =
				conn.addNewEmployee(
						request.getParameter("department"),
						request.getParameter("firstName"),
						request.getParameter("lastName"),
						request.getParameter("address"),
						request.getParameter("phoneNumber"),
						request.getParameter("city"),
						request.getParameter("state"),
						request.getParameter("zip"),
						request.getParameter("dobMonth"),
						request.getParameter("dobDay"),
						request.getParameter("dobYear")
				);
		
		if (resultInt >= 1) {
			String empFullName = String.format("%s %s", request.getParameter("firstName"), request.getParameter("lastName"));
			request.setAttribute("newEmployeePageMsg", String.format("Successfully added employee, %s!", empFullName));
		} else {
			request.setAttribute("newEmployeePageMsg", "Failed to add employee. Employee may already exist. Please check your records.");
		}
		
		doGet(request, response);
		//request.getRequestDispatcher("/WEB-INF/portal-pages/new-employee.jsp").forward(request, response);
	}

}
