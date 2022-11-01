package com.direction.demo.pojo.google;

public class ArrivalStop {
	private Location location;
    private String name;
    private ArrivalStop() {
    	
    }
	public ArrivalStop(Location location, String name) {
		super();
		this.location = location;
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
}
