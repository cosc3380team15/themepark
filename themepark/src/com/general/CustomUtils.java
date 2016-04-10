package com.general;

public class CustomUtils {
	
	public String[] monthList = {
			"January",
			"February",
			"March",
			"April",
			"May",
			"June",
			"July",
			"August",
			"September",
			"October",
			"November",
			"December"
		};

	public int monthToInt(String month) {
		switch (month) {
			case "January":
				return 1;
			case "February":
				return 2;
			case "March":
				return 3;
			case "April":
				return 4;
			case "May":
				return 5;
			case "June":
				return 6;
			case "July":
				return 7;
			case "August":
				return 8;
			case "September":
				return 9;
			case "October":
				return 10;
			case "November":
				return 11;
			case "December":
				return 12;
			default:
				return -1;
		}
	}
	
	public String intToMonth(int monthDigit) {
		switch (monthDigit) {
			case 1:
				return "January";
			case 2:
				return "February";
			case 3:
				return "March";
			case 4:
				return "April";
			case 5:
				return "May";
			case 6:
				return "June";
			case 7:
				return "July";
			case 8:
				return "August";
			case 9:
				return "September";
			case 10:
				return "October";
			case 11:
				return "November";
			case 12:
				return "December";
			default:
				return "";
		}
	}
	
	public String phoneUnformattedToFormatted(String unformatted) {
		return String.format("%s-%s-%s",
				unformatted.substring(0, 3),
				unformatted.substring(3, 6),
				unformatted.substring(6, 10)
			);
	}
	
	public String phoneFormattedToUnformatted(String formatted) {
		return formatted.replaceAll("-", "");
	}
}
