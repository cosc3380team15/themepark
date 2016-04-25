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

@WebServlet("/Portal/Vendors/ManageVendors")
public class ManageVendorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ManageVendorsServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnector conn = new DBConnector();
		
		List<Map<String, Object>> vendorList = conn.viewVendorList();
		List<String> distinctVendType = getDistinctVendTypes(conn.getVendTypes());
		
		String typeFilter = request.getParameter("concessionFilter");
		
		if (typeFilter == null) {
			typeFilter = distinctVendType.get(0);
		}
		
		request.setAttribute("concessTypeFilter", typeFilter);
		request.setAttribute("vendList", vendorList);
		request.setAttribute("vendType", distinctVendType);
		request.setAttribute("vendFilter", conn.viewVendTypes(typeFilter));
		
		request.getRequestDispatcher("/WEB-INF/portal-pages/manage-vendors.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("concessionFilter");
		
		String typeFilter = request.getParameter("concessionFilter");
		
		request.setAttribute("concessTypeFilter", typeFilter);
		doGet(request, response);
	}
	
	private List<String> getDistinctVendTypes(List<Map<String, Object>> values) {
		List<String> results = new ArrayList<String>();
		
		for (Map<String, Object> item : values) {
			if (!results.contains(item.get("type").toString())) {
				results.add(item.get("type").toString());
			}
		}
		
		return results;
	}
	
}
