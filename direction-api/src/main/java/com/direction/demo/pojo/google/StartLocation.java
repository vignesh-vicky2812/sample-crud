package com.direction.demo.pojo.google;

public class StartLocation {

	private double lat;
	private double lng;

	public StartLocation() {

	}

	public StartLocation(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

}
