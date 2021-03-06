package com.portal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.general.CustomUtils;
import com.general.DBConnector;
import com.general.RideDAO;

import models.Ride;

@WebServlet("/Portal/Statistics/Rides")
public class RidesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RidesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		CustomUtils cu = new CustomUtils();
		
		List<String> rides = new ArrayList<String>();
		for (Map<String, Object> m : conn.getAllRideNames()) {
			rides.add(m.get("name").toString());
		}
		
		String filterYear = request.getParameter("selFilterYear");
		
		if (filterYear == null) {
			filterYear = "2016";
		}
		
		request.setAttribute("filterYear", filterYear);
		request.setAttribute("dropDownYears", getDistinctYears(conn.viewRideActivityYearlyAll()));
		request.setAttribute("monthList", cu.monthList);
		request.setAttribute("ridesList", rides);
		request.setAttribute("viewRideActivity", conn.viewRideActivity(filterYear));
		request.setAttribute("viewRideActivityYearly", conn.viewRideActivityYearly(filterYear));
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/rides.jsp").forward(request, response);
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
}
