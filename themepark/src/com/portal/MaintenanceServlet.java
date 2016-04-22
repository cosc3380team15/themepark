package com.portal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.DBConnector;

@WebServlet("/Portal/Statistics/Maintenance")
public class MaintenanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MaintenanceServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		request.setAttribute("avgMaintenance", conn.getAvgMaintenance());
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/maintenance.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
