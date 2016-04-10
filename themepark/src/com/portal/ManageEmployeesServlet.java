package com.portal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.general.CustomUtils;
import com.general.DBConnector;

/**
 * Servlet implementation class ManageEmployeesServlet
 */
@WebServlet("/Portal/ManageEmployees")
public class ManageEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageEmployeesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		
		String employeeId = request.getParameter("empid");
		
		if (employeeId != null) {
			CustomUtils customUtils = new CustomUtils();
			Map<String, Object> empRecord = conn.getSingleEmployeeInfo(Integer.parseInt(employeeId));
			List<String> deptNamesList = conn.getAllDepartmentNames();
			request.setAttribute("empRecord", empRecord);
			String[] dobSplit = empRecord.get("birth_date").toString().split("-");
			request.setAttribute("empRecDobYear", dobSplit[0]);
			request.setAttribute("empRecDobMonth", dobSplit[1]);
			request.setAttribute("empRecDobDay", dobSplit[2]);
			request.setAttribute("monthList", customUtils.monthList);
			request.setAttribute("deptNamesList", deptNamesList);
			request.setAttribute("empRecPhoneFormatted",
					customUtils.phoneUnformattedToFormatted(empRecord.get("phone").toString()));
			
			request.getRequestDispatcher("/WEB-INF/portal-pages/view-employee.jsp").forward(request, response);
		} else {
			List<Map<String, Object>> results = conn.getAllEmployeeInfo();
			
			if (results.size() > 0) {
				request.setAttribute("employeeInfoList", results);
			}
			
			request.getRequestDispatcher("/WEB-INF/portal-pages/manage-employees.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		CustomUtils customUtils = new CustomUtils();
		int resultInt =
				conn.updateEmployee(
						Integer.parseInt(request.getParameter("empid")),
						request.getParameter("department"),
						request.getParameter("firstName"),
						request.getParameter("lastName"),
						request.getParameter("address"),
						request.getParameter("phoneNumber"),
						request.getParameter("city"),
						request.getParameter("state"),
						request.getParameter("zip"),
						String.format("%d", customUtils.monthToInt(request.getParameter("dobMonth"))),
						request.getParameter("dobDay"),
						request.getParameter("dobYear")
				);
		
		if (resultInt >= 1) {
			request.setAttribute("viewEmployeePageMsg", "Employee successfully updated.");
		} else {
			request.setAttribute("viewEmployeePageMsg", "Failed to save employee information.");
		}
		
		doGet(request, response);
		//request.getRequestDispatcher("/WEB-INF/portal-pages/view-employee.jsp").include(request, response);
	}

}
