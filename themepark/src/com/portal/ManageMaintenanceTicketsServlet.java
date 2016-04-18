package com.portal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.DBConnector;

/**
 * Servlet implementation class ManageMaintenanceTicketsServlet
 */
@WebServlet("/Portal/ManageMaintenanceTickets")
public class ManageMaintenanceTicketsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageMaintenanceTicketsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		
		List<Map<String, Object>> results = conn.getAllMaintenanceTickets();
		Object filter = request.getAttribute("filterTickets");
		
		if (filter == null) {
			request.setAttribute("maintenanceTickets", results);
		} else if (filter.toString().equalsIgnoreCase("all")) {
			request.setAttribute("maintenanceTickets", results);
		} else if (filter.toString().equalsIgnoreCase("open")) {
			List<Map<String, Object>> filteredResults = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> record : results) {
				if (record.get("Status").toString().equalsIgnoreCase("open")) {
					filteredResults.add(record);
				}
			}
			request.setAttribute("maintenanceTickets", filteredResults);
		} else if (filter.toString().equalsIgnoreCase("closed")) {
			List<Map<String, Object>> filteredResults = new ArrayList<Map<String, Object>>();
			for (Map<String, Object> record : results) {
				if (record.get("Status").toString().equalsIgnoreCase("closed")) {
					filteredResults.add(record);
				}
			}
			request.setAttribute("maintenanceTickets", filteredResults);
		} else {
			request.setAttribute("maintenanceTickets", results);
		}
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/manage-maintenance-tickets.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
