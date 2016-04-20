package com.portal;

import java.util.ArrayList;
import java.util.List;

public class NavMenu {
	
	public class NavSection {
		private String title;
		private String titleLink;
		private List<NavMenuLink> links;
		
		public NavSection(String sectionTitle) {
			title = sectionTitle;
			links = new ArrayList<NavMenuLink>();
		}

		public String getTitle() {
			return title;
		}

		public String getTitleLink() {
			return titleLink;
		}

		public List<NavMenuLink> getLinks() {
			return links;
		}
	}

	private List<NavSection> sections = new ArrayList<NavSection>();

	public NavMenu(String department) {
		switch (department.toUpperCase()) {
			case "HUMAN RESOURCES":
				addHumanResourcesSection();
				break;
			case "OPERATIONS":
				addOperationsSection();
				break;
			default:
				break;
		}
		
		// All departments get access to Statistics by default.
		addStatisticsSection();
	}
	
	private void addHumanResourcesSection() {
		NavSection ns = new NavSection("HUMAN RESOURCES");
		ns.links.add(new NavMenuLink("NEW EMPLOYEE", "/Portal/NewEmployee"));
		ns.links.add(new NavMenuLink("MANAGE EMPLOYEES", "/Portal/ManageEmployees"));
		ns.links.add(new NavMenuLink("MANAGE DEPARTMENTS", "/Portal/ManageDepartments"));
		sections.add(ns);
	}
	
	private void addOperationsSection() {
		NavSection ns = new NavSection("OPERATIONS");
		ns.links.add(new NavMenuLink("NEW MAINTENANCE TICKET", "/Portal/NewMaintenanceTicket"));
		ns.links.add(new NavMenuLink("MANAGE MAINTENANCE TICKETS", "/Portal/ManageMaintenanceTickets"));
		sections.add(ns);
	}
	
	private void addStatisticsSection() {
		NavSection ns = new NavSection("STATISTICS");
		ns.links.add(new NavMenuLink("RIDES", "/Portal/Statistics/Rides"));
		ns.links.add(new NavMenuLink("ATTENDANCE", "/Portal/Statistics/Attendance"));
		ns.links.add(new NavMenuLink("MAINTENANCE", "/Portal/Statistics/Maintenance"));
		sections.add(ns);
	}
	
	public List<NavSection> getSections() {
		return sections;
	}

}
