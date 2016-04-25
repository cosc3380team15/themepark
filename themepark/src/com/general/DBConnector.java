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
    String user = "webuser";
    String password = "tretA&etam3k";
    
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
	
	public List<Map<String, Object>> getAvgMaintenance() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM avgMonthlyMaintenance;");
			
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
	
	public List<Map<String, Object>> viewMaintenanceTicketStats() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewMaintenanceTicketStats;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getMinorMaintTicketRankings() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getMinorMaintTicketRankings();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getMajorMaintTicketRankings() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getMajorMaintTicketRankings();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewAvgMaintBreakdownTicketsPerMonth() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewAvgMaintBreakdownTicketsPerMonth;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewRideActivity(String year) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewRideActivity WHERE Year = ?;");
			ps.setString(1, year);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewRideActivityYearly(String year) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewRideActivityYearly WHERE Year = ?;");
			ps.setString(1, year);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewRideActivityYearlyAll() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewRideActivityYearly;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewRideClosuresAll() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewRideClosures;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewRideClosures(String year) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewRideClosures WHERE Year = ?;");
			ps.setString(1, year);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getAllWeatherConditions() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT name FROM weather_condition;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewRideClosuresYearlyStats(String year) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewRideClosuresYearlyStats WHERE Year = ?;");
			ps.setString(1, year);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewRideClosuresPerRide(String year) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewRideClosuresPerRide WHERE Year = ?;");
			ps.setString(1, year);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getWeeklyAttenSpikes() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getWeeklyAttenSpikes();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getMonthlyAttenSpikes() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getMonthlyAttenSpikes();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewVendorList() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		
		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM vendList;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewAvgMonthlyAttendance(String year) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewAvgMonthlyAttendance WHERE Year = ? ORDER BY Attendance desc;");
			ps.setString(1, year);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewVendorRevenueYearly(String year) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewVendorRevenueYearly WHERE Year = ?;");
			ps.setString(1, year);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewVendorRevenueMonthly(String year) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM viewVendorRevenueMonthly WHERE Year = ?;");
			ps.setString(1, year);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> viewVendTypes(String type) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM vendList WHERE type = ?;");
			ps.setString(1, type);
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getDistinctYearsVendorRevenueDaily() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getDistinctYearsVendorRevenueDaily();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getVendTypes() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("CALL getVendType();");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
	
	public List<Map<String, Object>> getVendorNames() {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();

		try {
			openConnection();
			
			PreparedStatement ps = con.prepareStatement("SELECT v.vendor_id as id, v.name as name from vendor v;");
			
			results = sendReadQuery(ps);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return results;
	}
}