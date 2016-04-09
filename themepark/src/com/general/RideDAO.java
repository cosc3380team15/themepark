package com.general;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Ride;

public class RideDAO {

	private List<Ride> sendReadQuery(String query) {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://cosc3380team15.ddns.net:3306/themeparkdb";
        String user = "dbadmin";
        String password = "Computerscience1";
        
        List<Ride> rides = new ArrayList<Ride>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException err) {
        	System.out.println("Class not found error: " + err.getMessage());
        }
        
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery(query);
                        
            while (rs.next()) {
            	Ride ride = new Ride();
            	ride.setActivityID(rs.getInt("activityID"));
            	ride.setRideName(rs.getString("rideName"));
            	ride.setRideID(rs.getInt("rideID"));
            	ride.setDate(rs.getDate("date"));
            	ride.setRideCount(rs.getInt("rideCount"));
            	rides.add(ride);
            }
        } catch (SQLException err) {
        	System.out.println("Connection error: " + err.getMessage());

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException err) {
            	System.out.println("Closing error: " + err.getMessage());
            }
        }
        
        return rides;
	}
	
	public List<Ride> rideLog30days(){
		return sendReadQuery(String.format("SELECT * FROM rideLog30days;"));
	}
}