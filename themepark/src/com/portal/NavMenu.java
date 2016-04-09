package com.portal;

import java.util.ArrayList;
import java.util.List;

public class NavMenu {
	private String sectionName;
	private String sectionLink;
	public List<NavMenuLink> links = new ArrayList<NavMenuLink>();

	public NavMenu(String department) {
		sectionName = department.toUpperCase();
		
		if (department.equalsIgnoreCase("HUMAN RESOURCES")) {
			sectionLink = "/Portal/HumanResources";
			links.add(new NavMenuLink("NEW EMPLOYEE", "/Portal/NewEmployee"));
			links.add(new NavMenuLink("MANAGE EMPLOYEES", "/Portal/ManageEmployees"));
		} else if (department.equalsIgnoreCase("OPERATIONS")) {
			sectionLink = "/Portal/Operations";
			links.add(new NavMenuLink("NEW MAINTENANCE TICKET", "/Portal/Operations/NewMaintenanceTicket"));
			links.add(new NavMenuLink("EXISTING MAINTENANCE TICKETS", "/Portal/Operations/ExistingMaintenanceTickets"));
			links.add(new NavMenuLink("COMPLETED MAINTENANCE TICKETS", "/Portal/Operations/CompletedMaintenanceTickets"));
		} else if (department.equalsIgnoreCase("STATISTICS")) {
			sectionLink = "/Portal/Statistics";
			links.add(new NavMenuLink("RIDES", "/Portal/Statistics/Rides"));
			links.add(new NavMenuLink("ATTENDANCE", "/Portal/Statistics/Attendance"));
			links.add(new NavMenuLink("MAINTENANCE", "/Portal/Statistics/Maintenance"));
		}
	}

	public String getSectionName() {
		return sectionName;
	}

	public String getSectionLink() {
		return sectionLink;
	}

	public List<NavMenuLink> getLinks() {
		return links;
	}
}
