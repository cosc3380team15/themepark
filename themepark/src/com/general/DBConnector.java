package com.general;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {

	private List<Object[]> sendReadQuery(String query) {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://cosc3380team15.ddns.net:3306/themeparkdb";
        String user = "dbadmin";
        String password = "Computerscience1";
        
        List<Object[]> records = new ArrayList<Object[]>();
        
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
            	Object[] record = new Object[rs.getMetaData().getColumnCount()];
            	
            	for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            		record[i - 1] = rs.getObject(i);
            	}
            	
            	records.add(record);
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
        
        return records;
	}
	
	public List<Object[]> tryLogin(String username, String password) {
		return sendReadQuery(String.format("CALL tryLogin('%s', '%s');", username, password));
	}
	
	public List<String> getAllDepartmentNames() {
		List<Object[]> results = sendReadQuery("CALL getAllDepartmentNames();");
		List<String> deptNamesList = new ArrayList<String>();
		for (Object[] row : results) {
			deptNamesList.add(row[0].toString());
		}
		
		return deptNamesList;
	}
	
	public void insertDailyRideLog(String name, Date day, int count) {
		sendReadQuery("CALL insertDailyRideLog(name,day,count);");
	}
	
	public void insertDept(String name) {
		sendReadQuery("CALL insertDept(name);");
	}
	
	public void insertDeptManager(int id) {
		sendReadQuery("CALL insertDeptManager(id);");
	}
	
	public void insertEmployee(String first, String last, String dept, String address, String phone, String city, String state, String zip, Date dob, Date hire, String pw) {
		sendReadQuery("CALL insertEmployee('Information Technology','"+first+"','"+last+"','"+address+"','"+phone+"','"+city+"','"+state+"','"+zip+"','"+dob+"','"+hire+"','"+pw+"');");
	}
	
	public void insertMaintenanceLog(String name, String type, java.sql.Timestamp start, java.sql.Timestamp end, String problem, String resolution) {
		sendReadQuery("CALL insertMaintenanceLog(name,type,start,end,problem,resolution);");
	}
	
	public void insertMaintenanceType(String type) {
		sendReadQuery("CALL insertMaintenanceType(type);");
	}
	
	public void insertOnlineSale(String type, Date buyDate, String first, String last, String email, String phone, int totalPurchased, double totalPrice) {
		sendReadQuery("CALL inserOnlineSale(type,buyDate,first,last,email,phone,totalPurchased,totalPrice);");
	}
	
	public void insertRide(String name, String descr) {
		sendReadQuery("CALL insertRide(name,descr);");
	}
	
	public void inserRideWeatherClosure(String name, String weather, Date dtClosed, Date dtOpened) {
		sendReadQuery("CALL insertRideWeatherClosure(name,weather,dtClosed,dtOpened);");
	}
	
	public void insertTicketPrice(String type, double price) {
		sendReadQuery("CALL insertTicketPrice(type,price);");
	}
	
	public void insertVendor(String type, String name, String descr, Date start, Date end) {
		sendReadQuery("CALL insertVendor(type,name,descr,start,end);");
	}
	
	public void insertVendorType(String type) {
		sendReadQuery("CALL insertVendorType(type);");
	}
	
	public void insertVendRevenue(String name, double amt) {
		sendReadQuery("CALL inserVendRevenue(name,amt);");
	}
	
	public void inseretWalkinSale(String type, Date soldDay, int amt, double total) {
		sendReadQuery("CALL insertWalkinSale(type,soldDay,amt,total);");
	}
	
	public void insertWeather(String name) {
		sendReadQuery("CALL insertWeather(name);");
	}
	
	public void updateEmployeeInfo(int id, String dept, String first, String last, String address, String phone, String cty, String st, String zp, Date dob) {
		sendReadQuery("CALL updateEmployeeInfo(id,dept,first,last,address,phone,cty,st,zp,dob);");
	}
}
