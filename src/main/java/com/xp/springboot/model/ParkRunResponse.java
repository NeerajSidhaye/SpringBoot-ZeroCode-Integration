package com.xp.springboot.model;

public class ParkRunResponse {

	private String message;
	private String location;
	
	public ParkRunResponse(String message, String location) {
		this.message = message;
		this.location=location;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
