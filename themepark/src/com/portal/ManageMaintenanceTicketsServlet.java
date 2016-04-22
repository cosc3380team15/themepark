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
		String ticketIdParam = request.getParameter("ticketId"); // If not null, then we want to show a single ticket in view-maintenance-ticket page.
		
		if (ticketIdParam == null) {
			List<Map<String, Object>> results = conn.getAllMaintenanceTickets();
			String[] filterChoices = { "All", "Open", "Closed" };
			
			request.setAttribute("maintenanceTickets", results);
			request.setAttribute("filterChoices", filterChoices);
			request.setAttribute("selectedFilter", "All"); // Default option.
			
			request.getRequestDispatcher("/WEB-INF/portal-pages/manage-maintenance-tickets.jsp").forward(request, response);
		} else {
			Map<String, Object> ticketRecord = conn.getMaintenanceTicketById(Integer.parseInt(ticketIdParam));
			
			request.setAttribute("ticketRecord", ticketRecord);
			
			request.getRequestDispatcher("/WEB-INF/portal-pages/view-maintenance-ticket.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		String updateCalled = request.getParameter("update");
		int updateCalledInt;
		
		if (updateCalled == null) {
			updateCalledInt = 0;
		} else {
			updateCalledInt = 1;
		}
		
		if (updateCalledInt == 0) { // If no update param is found, then it's a filter POST.
			List<Map<String, Object>> results = conn.getAllMaintenanceTickets();
			String[] filterChoices = { "All", "Open", "Closed" };
			
			String filterDropDownChoice = request.getParameter("filterTickets");
			
			request.setAttribute("filterChoices", filterChoices);
			request.setAttribute("selectedFilter", filterDropDownChoice); // Set to what was selected in the dropdown menu.
			
			if (filterDropDownChoice == null) {
				request.setAttribute("maintenanceTickets", results);
			} else if (filterDropDownChoice.equalsIgnoreCase("All")) {
				request.setAttribute("maintenanceTickets", results);
			} else if (filterDropDownChoice.equalsIgnoreCase("Open")) {
				List<Map<String, Object>> filteredResults = new ArrayList<Map<String, Object>>();
				for (Map<String, Object> record : results) {
					if (record.get("Status").toString().equalsIgnoreCase("Open")) {
						filteredResults.add(record);
					}
				}
				request.setAttribute("maintenanceTickets", filteredResults);
			} else if (filterDropDownChoice.equalsIgnoreCase("Closed")) {
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
		} else if (updateCalledInt == 1) { // An update to the maintenance ticket has been called in this POST.
			String ticketIdParam = request.getParameter("ticketId");
			String resolutionParam = request.getParameter("resolution");
			
			int resultInt = conn.updateMaintenanceTicket(Integer.parseInt(ticketIdParam), resolutionParam);
			
			if (resultInt > 0) {
				request.setAttribute("viewMaintTicketPageMsg", "Ticket successfully updated.");
			} else {
				request.setAttribute("viewMaintTicketPageMsg", "Failed to update ticket.");
			}
			doGet(request, response);
		}
		
		
	}

}
