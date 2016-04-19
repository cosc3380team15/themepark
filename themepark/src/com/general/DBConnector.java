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
		return sendReadQueryGetMap("CALL getAllEmployeeInfo();");
	}
	
	public List<Map<String, Object>> getAllDepartmentsInfo() {
		return sendReadQueryGetMap("SELECT * FROM viewAllDepartmentsInfo;");
	}
	
	public List<Map<String, Object>> getAttendance() {
		return sendReadQueryGetMap("SELECT * FROM attendance;");
	}
	
	public List<Map<String, Object>> getMaintenance() {
		return sendReadQueryGetMap("SELECT * FROM maintenanceLog;");
	}
	
	public Map<String, Object> getSingleEmployeeInfo(int empId) {
		List<Map<String, Object>> res = sendReadQueryGetMap(String.format("CALL getSingleEmployeeInfo(%d);", empId));
		
		return res.get(0);
	}
	
	public Map<String, Object> getDepartmentManagerByDeptId(int deptId) {
		List<Map<String, Object>> res = sendReadQueryGetMap(String.format("CALL getDepartmentManagerByDeptId(%d);", deptId));
		
		return res.get(0);
	}
	
	public List<Map<String, Object>> getDepartmentEmployeesById(int deptId) {
		return sendReadQueryGetMap(String.format("CALL getDepartmentEmployeesById(%d);", deptId));
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
	
	public int updateEmployee(int empId, String deptName, String fName, String lName, String address, String phone, String city, String state, String zip, String dobMonth, String dobDay, String dobYear) {
		String query = String.format("CALL updateEmployeeInfo(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
				empId,
				deptName,
				fName,
				lName,
				address,
				phone.replaceAll("-", ""), // Remove dashes from string.
				city,
				state,
				zip,
				dobYear + "-" + dobMonth + "-" + dobDay
		);
		
		int resultInt = sendUpdateQuery(query);
		
		return resultInt;
	}
	
	public int changeDepartmentManager(int deptId, int empId) {
		return sendUpdateQuery(String.format("CALL changeDepartmentManager(%d, %d);", deptId, empId));
	}
	
	public int insertOnlineSale(String typeId, String first, String last, String email, String phone, String totalPurchased) {
		java.util.Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String query = String.format("CALL insertOnlineSale(%d, '%s', '%s', '%s', '%s', '%s', %d);",
				Integer.parseInt(typeId),
				formatter.format(today),
				first,
				last,
				email,
				phone.replaceAll("-", ""),
				Integer.parseInt(totalPurchased)
				);
		
		int resultInt = sendUpdateQuery(query);
		return resultInt;
	}
	
	public List<Object[]> getTicketPriceAndTypeInfo() {
		return sendReadQuery("SELECT * FROM ticket_price;");
	}
	
	public List<Map<String, Object>> getOnlinePurchaseHistory(String email, String phone) {
		return sendReadQueryGetMap(String.format("CALL getOnlinePurchaseHistory('%s', '%s');",
				email,
				phone.replaceAll("-", ""))
				);
	}
	
	public List<Map<String, Object>> getAllMaintenanceTypes() {
		return sendReadQueryGetMap("CALL getAllMaintenanceTypes();");
	}
	
	public List<Map<String, Object>> getAllRideNames() {
		return sendReadQueryGetMap("CALL getAllRideNames();");
	}
	
	public int insertRideMaintenanceTicket(int rideId, int rideMaintTypeId, int empId, String probDesc, String resDesc) {
		String query;
		
		if (resDesc == null) {
			query = String.format("CALL insertMaintenanceTicket(%d, %d, %d, '%s');",
					rideId,
					rideMaintTypeId,
					empId,
					probDesc);
		} else if (resDesc.replaceAll(" ", "") == "") {
			query = String.format("CALL insertMaintenanceTicket(%d, %d, %d, '%s');",
					rideId,
					rideMaintTypeId,
					empId,
					probDesc);
		} else {
			query = String.format("CALL insertMaintenanceTicketWithResolution(%d, %d, %d, '%s', '%s');",
					rideId,
					rideMaintTypeId,
					empId,
					probDesc,
					resDesc);
		}
		
		return sendUpdateQuery(query);
	}
	
	public List<Map<String, Object>> getAllMaintenanceTickets() {
		return sendReadQueryGetMap("SELECT * FROM viewMaintenanceTickets;");
	}
	
	/*
	
	public void insertDailyRideLog(String name, Date day, int count) {
		sendReadQuery("CALL insertDailyRideLog(name,day,count);");
	}
	
	public void insertDept(String name) {
		sendReadQuery("CALL insertDept(name);");
	}
	
	public void insertDeptManager(int id) {
		sendReadQuery("CALL insertDeptManager(id);");
	}
	
	public void insertMaintenanceLog(String name, String type, java.sql.Timestamp start, java.sql.Timestamp end, String problem, String resolution) {
		sendReadQuery("CALL insertMaintenanceLog(name,type,start,end,problem,resolution);");
	}
	
	public void insertMaintenanceType(String type) {
		sendReadQuery("CALL insertMaintenanceType(type);");
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
	*/

}
