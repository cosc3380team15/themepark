package com.portal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.DBConnector;

/**
 * Servlet implementation class NewMaintenanceTicketServlet
 */
@WebServlet("/Portal/NewMaintenanceTicket")
public class NewMaintenanceTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMaintenanceTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		request.setAttribute("rides", conn.getAllRideNames());
		request.setAttribute("maintenanceTypes", conn.getAllMaintenanceTypes());
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/new-maintenance-ticket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();

		int resultInt = conn.insertRideMaintenanceTicket(
				Integer.parseInt(request.getParameter("ride")),
				Integer.parseInt(request.getParameter("maintenanceType")),
				Integer.parseInt(request.getSession().getAttribute("userId").toString()),
				request.getParameter("problem").toString(),
				(request.getParameter("resolution") == null) ? null : request.getParameter("resolution").toString() 
			);
		
		if (resultInt >= 1) { // Ticket successfully added. Redirect to view all maintenance tickets.
			response.sendRedirect("/themepark/Portal/ManageMaintenanceTickets");
		} else {
			request.setAttribute("newMaintTicketMsg", "Failed to create maintenance ticket.");
			
			doGet(request, response);
		}
	}

}
