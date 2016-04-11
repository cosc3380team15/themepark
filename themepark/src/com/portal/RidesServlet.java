package com.portal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		RideDAO conn = new RideDAO();
		List<Ride> rides = conn.rideLog30days();
		request.setAttribute("rides", rides);
		
		List<Ride> ride = (List<Ride>)request.getAttribute("rides");

		request.getRequestDispatcher("/WEB-INF/portal-pages/rides.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
