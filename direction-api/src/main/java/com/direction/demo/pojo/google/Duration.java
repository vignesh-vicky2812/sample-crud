package com.direction.demo.pojo.google;

public class Duration {
	
	private String text;
    private int value;
    public Duration() {
    	
    }
	public Duration(String text, int value) {
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
