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

/**
 * Servlet implementation class VendorStatsServlet
 */
@WebServlet("/Portal/Statistics/VendorStats")
public class VendorStatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorStatsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		CustomUtils cu = new CustomUtils();
		
		List<String> vendors = new ArrayList<String>();
		for (Map<String, Object> m : conn.getVendorNames()) {
			vendors.add(m.get("name").toString());
		}
		
		List<String> distinctYears = getDistinctYears(conn.getDistinctYearsVendorRevenueDaily());
		
		String filterYear = request.getParameter("selFilterYear");
		
		if (filterYear == null) {
			filterYear = distinctYears.get(0);
		}
		
		List<Map<String, Object>> vendorRevYearly = conn.viewVendorRevenueYearly(filterYear);
		
		request.setAttribute("filterYear", filterYear);
		request.setAttribute("dropDownYears", distinctYears);
		request.setAttribute("monthList", cu.monthList);
		request.setAttribute("vendors", vendors);
		request.setAttribute("viewVendorRevenueMonthly", conn.viewVendorRevenueMonthly(filterYear));
		request.setAttribute("highestRevVendor", vendorRevYearly.get(0).get("Name"));
		request.setAttribute("lowestRevVendor", vendorRevYearly.get(vendorRevYearly.size() - 1).get("Name"));
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/vendor-stats.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
