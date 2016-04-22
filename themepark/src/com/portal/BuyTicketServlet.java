package com.portal;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.DBConnector;

/**
 * Servlet implementation class BuyTicketServlet
 */
@WebServlet("/BuyTicket")
public class BuyTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		List<Map<String, Object>> ticketPriceInfo = conn.getTicketPriceAndTypeInfo();
		
		request.setAttribute("ticketPriceInfo", ticketPriceInfo);
		
		request.getRequestDispatcher("/WEB-INF/pages/BuyTicket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		int resultInt = conn.insertOnlineSale(
				request.getParameter("ticketTypeId"),
				request.getParameter("first"),
				request.getParameter("last"),
				request.getParameter("email"),
				request.getParameter("phone"),
				request.getParameter("ticketCount")
				);
		
		if (resultInt >= 1) {
			request.setAttribute("buyTicketMsg", "Successfully purchased tickets.");
		} else {
			request.setAttribute("buyTicketMsg", "Failed to buy tickets.");
		}
		request.getRequestDispatcher("/WEB-INF/pages/BuyTicket.jsp").forward(request, response);

	}

}
