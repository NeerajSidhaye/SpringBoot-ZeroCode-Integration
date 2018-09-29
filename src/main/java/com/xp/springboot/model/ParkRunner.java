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
		
		
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((club == null) ? 0 : club.hashCode());
			result = prime * result + ((gender == null) ? 0 : gender.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((parkRunId == null) ? 0 : parkRunId.hashCode());
			result = prime * result + ((totalRuns == null) ? 0 : totalRuns.hashCode());
			return result;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "ParkRunner [parkRunId=" + parkRunId + ", name=" + name + ", totalRuns=" + totalRuns + ", club="
					+ club + ", gender=" + gender + "]";
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ParkRunner other = (ParkRunner) obj;
			if (club == null) {
				if (other.club != null)
					return false;
			} else if (!club.equals(other.club))
				return false;
			if (gender == null) {
				if (other.gender != null)
					return false;
			} else if (!gender.equals(other.gender))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (parkRunId == null) {
				if (other.parkRunId != null)
					return false;
			} else if (!parkRunId.equals(other.parkRunId))
				return false;
			if (totalRuns == null) {
				if (other.totalRuns != null)
					return false;
			} else if (!totalRuns.equals(other.totalRuns))
				return false;
			return true;
		}

}
