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
 * Servlet implementation class OnlinePurchaseHistoryServlet
 */
@WebServlet("/OnlinePurchaseHistory")
public class OnlinePurchaseHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OnlinePurchaseHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("phEmail");
		String phone = request.getParameter("phPhone");
		
		DBConnector conn = new DBConnector();
		
		List<Map<String, Object>> resultSet = conn.getOnlinePurchaseHistory(email, phone);
		
		if (resultSet != null) {
			request.setAttribute("historyResults", resultSet);
		} else {
			request.setAttribute("purchaseHistoryMsg", "No purchases found.");
		}
		
		request.getRequestDispatcher("/WEB-INF/pages/purchase-history.jsp").forward(request, response);
	}

}
