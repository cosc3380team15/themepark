package com.general;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.portal.Employee;
import com.sun.xml.internal.ws.client.SenderException;

public class DBConnector {
	String url = "jdbc:mysql://cosc3380team15.ddns.net:3306/themeparkdb";
    String user = "dbadmin";
    String password = "Computerscience1";

	private List<Object[]> sendReadQuery(String query) {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
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
	
	private List<Map<String, Object>> sendReadQueryGetMap(String query) {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
        
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
            	Map<String, Object> row = new HashMap<String, Object>();
            	
            	for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            		row.put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
            	}
            	
            	records.add(row);
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
	
	private int sendUpdateQuery(String query) {
		Connection con = null;
        Statement st = null;
        int resultInt = 0;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException err) {
        	System.out.println("Class not found error: " + err.getMessage());
        }
        
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            
            resultInt = st.executeUpdate(query); // Returns 0 for fail, 1 or more for success and rows affected.
                        
            
        } catch (SQLException err) {
        	System.out.println("Connection error: " + err.getMessage());

        } finally {
            try {
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
        
        return resultInt;
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
	
	public List<Map<String, Object>> getAllEmployeeInfo() {
		return sendReadQueryGetMap(String.format("CALL getAllEmployeeInfo();"));
	}
	
	public int addNewEmployee(String deptName, String fName, String lName, String address, String phone, String city, String state, String zip, String dobMonth, String dobDay, String dobYear) {
		// (1) get today's date
		java.util.Date today = Calendar.getInstance().getTime();
	 
	    // (2) create a date "formatter" (the date format we want)
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String query = String.format("CALL insertEmployee('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
				deptName,
				fName,
				lName,
				address,
				phone.replaceAll("-", ""), // Remove dashes from string.
				city,
				state,
				zip,
				dobYear + "-" + dobMonth + "-" + dobDay,
				formatter.format(today), // Today's date.
				"password" // Default password for every new hire.
		);
		
		int resultInt = sendUpdateQuery(query);
		
		return resultInt;
	}
	
}
