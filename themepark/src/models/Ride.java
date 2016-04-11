package models;

import java.io.Serializable;
import java.util.Date;

public class Ride implements Serializable{
	private int activityID;
	private String rideName;
	private int rideID;
	private Date date;
	private int rideCount;
	
	public void setActivityID(int id) {
        this.activityID = id;
    }
	public void setRideName(String name) {
        this.rideName = name;
    }
	public void setRideID(int id) {
        this.rideID = id;
    }
	public void setDate(Date dt) {
        this.date = dt;
    }
	public void setRideCount(int count) {
        this.rideCount = count;
    }
	public int getActivityID(){
		return activityID;
	}
	public String getRideName(){
		return rideName;
	}
	public int getRideID(){
		return rideID;
	}
	public Date getDate(){
		return date;
	}
	public int getRideCount(){
		return rideCount;
	}
}
