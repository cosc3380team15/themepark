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
    
    Connection con = null;
    ResultSet rs = null;
    
    private void openConnection() {
    	try {
            Class.forName("com.mysql.jdbc.Driver");
        } 
        catch (ClassNotFoundException err) {
        	System.out.println("Class not found error: " + err.getMessage());
        }
    	
    	try {
    		con = DriverManager.getConnection(url, user, password);
    	} catch (SQLException err) {
        	System.out.println("Connection error: " + err.getMessage());
        }
    }
    
    private List<Map<String, Object>> sendReadQuery(PreparedStatement ps) {        
        List<Map<String, Object>> records = new ArrayList<Map<String, Object>>();
        
        try {
            rs = ps.executeQuery();
                        
            while (rs.next()) {
            	Map<String, Object> row = new HashMap<String, Object>();
            	
            	for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
            		row.put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
            	}
            	
            	records.add(row);
            }
        } catch (SQLException err) {
        	System.out.println("Connection error: " + err.getMessage());
        } finally { // Close connections to DB.
        	try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
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
	
	private int sendUpdateQuery(PreparedStatement ps) {
        int resultInt = 0;
        
        try {            
            resultInt = ps.executeUpdate(); // Returns 0 for fail, 1 or more for success and rows affected.
        } catch (SQLException err) {
        	System.out.println("Connection error: " + err.getMessage());
        } finally { // Close connections to DB.
        	try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
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
	
	public Map<String, Object> tryLogin(String username, String password) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL tryLogin(?, ?);");
			ps.setString(1, username);
			ps.setString(2, password);
			
			results = sendReadQuery(ps);

			return (results.size() > 0) ? results.get(0) : new HashMap<String, Object>();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return new HashMap<String, Object>();
	}
	
	public List<String> getAllDepartmentNames() {
		List<String> results = new ArrayList<String>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getAllDepartmentNames();");
			
			for (Map<String, Object> m : sendReadQuery(ps)) {
				results.add(m.get("name").toString());
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getAllEmployeeInfo() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getAllEmployeeInfo();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getAllDepartmentsInfo() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewAllDepartmentsInfo;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getAttendance() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM avgMonthlyAttendance;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getMaintenance() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM maintenanceLog;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public Map<String, Object> getSingleEmployeeInfo(int empId) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getSingleEmployeeInfo(?);");
			ps.setInt(1, empId);
			
			results = sendReadQuery(ps);
			
			return (results.size() > 0) ? results.get(0) : new HashMap<String, Object>();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return new HashMap<String, Object>();
	}
	
	public Map<String, Object> getDepartmentManagerByDeptId(int deptId) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getDepartmentManagerByDeptId(?);");
			ps.setInt(1, deptId);
			
			results = sendReadQuery(ps);
			
			return (results.size() > 0) ? results.get(0) : new HashMap<String, Object>();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return new HashMap<String, Object>();
	}
	
	public List<Map<String, Object>> getDepartmentEmployeesById(int deptId) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getDepartmentEmployeesById(?);");
			ps.setInt(1, deptId);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public int addNewEmployee(String deptName, String fName, String lName, String address, String phone, String city, String state, String zip, String dobMonth, String dobDay, String dobYear) {
		// (1) get today's date
		java.util.Date today = Calendar.getInstance().getTime();
	 
	    // (2) create a date "formatter" (the date format we want)
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    
	    int resultInt = 0;
	    
	    try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL insertEmployee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			ps.setString(1, deptName);
			ps.setString(2, fName);
			ps.setString(3, lName);
			ps.setString(4, address);
			ps.setString(5, phone.replaceAll("-", "")); // Remove dashes from string.
			ps.setString(6, city);
			ps.setString(7, state);
			ps.setString(8, zip);
			ps.setString(9, dobYear + "-" + dobMonth + "-" + dobDay);
			ps.setString(10, formatter.format(today));
			ps.setString(11, "password");
			
			resultInt = sendUpdateQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultInt;
	}
	
	public int updateEmployee(int empId, String deptName, String fName, String lName, String address, String phone, String city, String state, String zip, String dobMonth, String dobDay, String dobYear) {
		int resultInt = 0;
	    
	    try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL updateEmployeeInfo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			ps.setInt(1, empId);
			ps.setString(2, deptName);
			ps.setString(3, fName);
			ps.setString(4, lName);
			ps.setString(5, address);
			ps.setString(6, phone.replaceAll("-", "")); // Remove dashes from string.
			ps.setString(7, city);
			ps.setString(8, state);
			ps.setString(9, zip);
			ps.setString(10, dobYear + "-" + dobMonth + "-" + dobDay);
			
			resultInt = sendUpdateQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultInt;
	}
	
	public int changeDepartmentManager(int deptId, int empId) {
		int resultInt = 0;
	    
	    try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL changeDepartmentManager(?, ?);");
			ps.setInt(1, deptId);
			ps.setInt(2, empId);
			
			resultInt = sendUpdateQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultInt;
	}
	
	public int insertOnlineSale(String typeId, String first, String last, String email, String phone, String totalPurchased) {
		java.util.Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		int resultInt = 0;
	    
	    try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL insertOnlineSale(?, ?, ?, ?, ?, ?, ?);");
			ps.setInt(1, Integer.parseInt(typeId));
			ps.setString(2, formatter.format(today));
			ps.setString(3, first);
			ps.setString(4, last);
			ps.setString(5, email);
			ps.setString(6, phone.replaceAll("-", ""));
			ps.setInt(7, Integer.parseInt(totalPurchased));
			
			resultInt = sendUpdateQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultInt;
	}
	
	public List<Map<String, Object>> getTicketPriceAndTypeInfo() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM ticket_price;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getOnlinePurchaseHistory(String email, String phone) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getOnlinePurchaseHistory(?, ?);");
			ps.setString(1, email);
			ps.setString(2, phone.replaceAll("-", ""));
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getAllMaintenanceTypes() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getAllMaintenanceTypes();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getAllRideNames() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getAllRideNames();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public int insertRideMaintenanceTicket(int rideId, int rideMaintTypeId, int empId, String probDesc, String resDesc) {
		int resultInt = 0;
	    
	    try {
			openConnection();
			
			if (resDesc == null) {
				PreparedStatement ps = con.prepareStatement("CALL insertMaintenanceTicket(?, ?, ?, ?);");
				ps.setInt(1, rideId);
				ps.setInt(2, rideMaintTypeId);
				ps.setInt(3, empId);
				ps.setString(4, probDesc);

				resultInt = sendUpdateQuery(ps);
			} else if (resDesc.replaceAll(" ", "") == "") {
				PreparedStatement ps = con.prepareStatement("CALL insertMaintenanceTicket(?, ?, ?, ?);");
				ps.setInt(1, rideId);
				ps.setInt(2, rideMaintTypeId);
				ps.setInt(3, empId);
				ps.setString(4, probDesc);

				resultInt = sendUpdateQuery(ps);
			} else {
				PreparedStatement ps = con.prepareStatement("CALL insertMaintenanceTicketWithResolution(?, ?, ?, ?, ?);");
				ps.setInt(1, rideId);
				ps.setInt(2, rideMaintTypeId);
				ps.setInt(3, empId);
				ps.setString(4, probDesc);
				ps.setString(5, resDesc);

				resultInt = sendUpdateQuery(ps);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultInt;
	}
	
	public List<Map<String, Object>> getAllMaintenanceTickets() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewMaintenanceTickets;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public Map<String, Object> getMaintenanceTicketById(int id) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewMaintenanceTickets WHERE ID = ?;");
			ps.setInt(1, id);
			
			results = sendReadQuery(ps);
			
			return (results.size() > 0) ? results.get(0) : new HashMap<String, Object>();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return new HashMap<String, Object>();
	}
	
	public int updateMaintenanceTicket(int id, String resolution) {
		int resultInt = 0;
	    
	    try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL updateMaintenanceTicket(?, ?);");
			ps.setInt(1, id);
			ps.setString(2, resolution);
			
			resultInt = sendUpdateQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultInt;
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
