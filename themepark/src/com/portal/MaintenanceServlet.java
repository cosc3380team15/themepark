package com.portal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		String filterYear = request.getParameter("selFilterYear");
		List<Map<String, Object>> viewMaintTicketStats = conn.viewMaintenanceTicketStats();
		
		if (filterYear == null) {
			filterYear = "2016";
		}
		
		request.setAttribute("filterYear", filterYear);
		request.setAttribute("dropDownYears", getDistinctYears(viewMaintTicketStats));
		request.setAttribute("viewMaintTicketStats", viewMaintTicketStats);
		request.setAttribute("avgMaintTicketVals", getMaxTicketRecord(conn.viewAvgMaintBreakdownTicketsPerMonth(), filterYear));
		request.setAttribute("worstMinorRide", getMaxTicketRecord(conn.getMinorMaintTicketRankings(), filterYear).get("Ride"));
		request.setAttribute("worstMajorRide", getMaxTicketRecord(conn.getMajorMaintTicketRankings(), filterYear).get("Ride"));
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/maintenance.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	private List<String> getDistinctYears(List<Map<String, Object>> values) {
		List<String> results = new ArrayList<String>();
		
		for (Map<String, Object> item : values) {
			if (!results.contains(item.get("Year").toString())) {
				results.add(item.get("Year").toString());
			}
		}
		
		return results;
	}
	
	private Map<String, Object> getMaxTicketRecord(List<Map<String, Object>> values, String year) {
		for (Map<String, Object> m : values) {
			if (m.get("Year").toString().equals(year)) {
				return m;
			}
		}
		
		return new HashMap<String, Object>();
	}
}
