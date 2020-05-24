package com.xp.springboot.model.dto;

import javax.validation.constraints.NotNull;


public class PartialUpdateDTO {
	
	@NotNull
	private String totalRuns;

	/**
	 * @return the totalRuns
	 */
	public String getTotalRuns() {
		return totalRuns;
	}

	/**
	 * @param totalRuns the totalRuns to set
	 */
	public void setTotalRuns(String totalRuns) {
		this.totalRuns = totalRuns;
	}
	
	

}
