package com.direction.demo.pojo.google;

public class DepartureTime {
	private String text;
	private String time_zone;
	private int value;
	public DepartureTime() {
		
	}
	public DepartureTime(String text, String time_zone, int value) {
		super();
		this.text = text;
		this.time_zone = time_zone;
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime_zone() {
		return time_zone;
	}
	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	

}
