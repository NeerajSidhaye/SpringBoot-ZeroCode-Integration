package com.xp.springboot.model.dto;

import javax.validation.constraints.NotNull;


public class RegisterRunnerDTO {
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String gender;
	
	@NotNull
	private String homeRun;
	
	@NotNull
	private String runningClub;
	
	@NotNull
	private String email;
	
	@NotNull
	private String postCode;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the homeRun
	 */
	public String getHomeRun() {
		return homeRun;
	}

	/**
	 * @param homeRun the homeRun to set
	 */
	public void setHomeRun(String homeRun) {
		this.homeRun = homeRun;
	}

	/**
	 * @return the runningClub
	 */
	public String getRunningClub() {
		return runningClub;
	}

	/**
	 * @param runningClub the runningClub to set
	 */
	public void setRunningClub(String runningClub) {
		this.runningClub = runningClub;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	
}
