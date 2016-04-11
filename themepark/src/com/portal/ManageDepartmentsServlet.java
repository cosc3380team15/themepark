package com.portal;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.DBConnector;

/**
 * Servlet implementation class ManageDepartmentsServlet
 */
@WebServlet("/Portal/ManageDepartments")
public class ManageDepartmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageDepartmentsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		
		String departmentId = request.getParameter("deptid");
		
		if (departmentId != null) {
			int deptId = Integer.parseInt(departmentId);
			Map<String, Object> row = conn.getDepartmentManagerByDeptId(deptId);
			
			request.setAttribute("deptId", deptId);
			request.setAttribute("departmentEmployees", conn.getDepartmentEmployeesById(deptId));
			request.setAttribute("deptMgrId", row.get("emp_id"));
			
			request.getRequestDispatcher("/WEB-INF/portal-pages/view-department.jsp").forward(request, response);
		} else {
			request.setAttribute("departmentsInfo", conn.getAllDepartmentsInfo());
			
			request.getRequestDispatcher("/WEB-INF/portal-pages/manage-departments.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		
		int prevDeptMgrId = Integer.parseInt(request.getParameter("prevdeptmgrid"));
		int deptId = Integer.parseInt(request.getParameter("deptid"));
		int newDeptMgrId = Integer.parseInt(request.getParameter("departmentManager"));
		
		if (prevDeptMgrId != newDeptMgrId) {
			int resInt = conn.changeDepartmentManager(deptId, newDeptMgrId);
			
			if (resInt > 0) {
				request.setAttribute("viewDepartmentPageMsg", "Changes saved.");
			} else {
				request.setAttribute("viewDepartmentPageMsg", "Update failed.");
			}
		} else {
			request.setAttribute("viewDepartmentPageMsg", "No changes mades.");
		}
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/view-department.jsp").forward(request, response);
	}

}
