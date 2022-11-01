package com.direction.demo.pojo.here;

public class Agency {
	private String id;
    private String name;
    private String website;
    public Agency() {
    	
    }
	public Agency(String id, String name, String website) {
		super();
		this.id = id;
		this.name = name;
		this.website = website;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
}
