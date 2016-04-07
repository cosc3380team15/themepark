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
}
