package com.direction.demo.pojo.google;

public class Distance {

	private String text;
	private int value;
	public Distance() {
		
	}
	public Distance(String text, int value) {
		super();
		this.text = text;
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	

}
