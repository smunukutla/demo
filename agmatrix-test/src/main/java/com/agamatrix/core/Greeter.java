package com.agamatrix.core;

public class Greeter {
 
	private Long uniqueID;
	private String name;
	
	public Greeter(Long uniqueID, String name) {
		setUniqueID(uniqueID);
		setName(name);
	}
	
	
	public Long getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(Long uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	
}
