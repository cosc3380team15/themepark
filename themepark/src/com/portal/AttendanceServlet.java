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

import com.general.CustomUtils;
import com.general.DBConnector;

@WebServlet("/Portal/Statistics/Attendance")
public class AttendanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AttendanceServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		CustomUtils cu = new CustomUtils();
		
		List<String> weatherConditions = new ArrayList<String>();
		for (Map<String, Object> m : conn.getAllWeatherConditions()) {
			weatherConditions.add(m.get("name").toString());
		}
		
		String[] statHeadings = { "Attendance", "Weekly Average", "Monthly Attendance Spike", "Weekly Attendance Spike" };
		
		List<String> distinctYears = getDistinctYears(conn.getMonthlyAttenSpikes());
		
		String filterYear = request.getParameter("selFilterYear");
		
		if (filterYear == null) {
			filterYear = distinctYears.get(0);
		}
		
		List<Map<String, Object>> avgMonthlyAtt = conn.viewAvgMonthlyAttendance(filterYear);
		
		request.setAttribute("filterYear", filterYear);
		request.setAttribute("dropDownYears", distinctYears);
		request.setAttribute("monthList", cu.monthList);
		request.setAttribute("statHeadings", statHeadings);
		request.setAttribute("viewAvgMonthlyAttendance", avgMonthlyAtt);
		request.setAttribute("weeklyAttenSpikes", conn.getWeeklyAttenSpikes());
		request.setAttribute("monthlyAttenSpikes", conn.getMonthlyAttenSpikes());
		request.setAttribute("highestAttMonth", avgMonthlyAtt.get(0).get("Month"));
		request.setAttribute("lowestAttMonth", avgMonthlyAtt.get(avgMonthlyAtt.size() - 1).get("Month"));
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/attendance.jsp").forward(request, response);
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
