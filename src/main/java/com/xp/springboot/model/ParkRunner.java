package com.xp.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PARK_RUNNER")
public class ParkRunner {

		@Id
		@GeneratedValue
		private Long parkRunId;
		
		private String name;
		private String totalRuns;
		private String club;
		private String gender;
		
		/**
		 * @return the parkRunId
		 */
		public Long getParkRunId() {
			return parkRunId;
		}

		/**
		 * @param parkRunId the parkRunId to set
		 */
		public void setParkRunId(Long parkRunId) {
			this.parkRunId = parkRunId;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

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

		/**
		 * @return the club
		 */
		public String getClub() {
			return club;
		}

		/**
		 * @param club the club to set
		 */
		public void setClub(String club) {
			this.club = club;
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


}
