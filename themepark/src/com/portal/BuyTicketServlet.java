package com.portal;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.DBConnector;

/**
 * Servlet implementation class BuyTicketServlet
 */
@WebServlet("/BuyTicketServlet")
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
		
		request.getRequestDispatcher("/BuyTicket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		int resultInt = conn.insertOnlineSale(
				"One-day", // edit this later
				request.getParameter("first"),
				request.getParameter("last"),
				request.getParameter("email"),
				"", // add phone number later
				Integer.parseInt(request.getParameter("oneday")),
				35.00*(Integer.parseInt(request.getParameter("oneday")))
				);
		
		if (resultInt >= 1) {
			request.setAttribute("msg", "Successfully bought tickets.");
		} else {
			request.setAttribute("msg", "Failed to buy tickets.");
		}	
		/*
		resultInt = 
				conn.insertOnlineSale(
					"Seasonal",
					request.getParameter("first"),
					request.getParameter("last"),
					request.getParameter("email"),
					"", // add phone number later
					Integer.parseInt(request.getParameter("seasonal")),
					300.00*(Integer.parseInt(request.getParameter("seasonal")))
				);
				*/
		
		request.getRequestDispatcher("/BuyTicket.jsp").include(request, response);

		
	}

}
