package com.portal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.DBConnector;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/Portal/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/change-pw.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		
		String currentPw = request.getParameter("currentPw");
		int empId = Integer.parseInt(request.getSession().getAttribute("userId").toString());
		
		
		if (conn.tryLoginUsingId(empId, currentPw).size() > 0) {
			String newPw = request.getParameter("newPw");
			String newPwConfirm = request.getParameter("newPwConfirm");
			
			if (newPw.equals(newPwConfirm)) {
				if (conn.changeEmployeePassword(empId, currentPw, newPwConfirm) > 0) {
					request.setAttribute("changePwMsg", "Your password has been successfully changed!");
				} else {
					request.setAttribute("changePwMsg", "Failed to change password.");
				}
			} else {
				request.setAttribute("changePwMsg", "New passwords do not match.");
			}
		} else {
			request.setAttribute("changePwMsg", "Old password is not correct.");
		}
		
		doGet(request, response);
	}

}
