package com.alexbleasdale.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ContactDetails {

	private Long id;
	private String homeTelephone;
	private String mobileTelephone;
	private String email;
	private String gMapsUrl;

	/**
	 * Getters and Setters
	 */

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHomeTelephone() {
		return homeTelephone;
	}

	public void setHomeTelephone(String homeTelephone) {
		this.homeTelephone = homeTelephone;
	}

	public String getMobileTelephone() {
		return mobileTelephone;
	}

	public void setMobileTelephone(String mobileTelephone) {
		this.mobileTelephone = mobileTelephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getgMapsUrl() {
		return gMapsUrl;
	}

	public void setgMapsUrl(String gMapsUrl) {
		this.gMapsUrl = gMapsUrl;
	}

	/**
	 * hashCode and equals
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((gMapsUrl == null) ? 0 : gMapsUrl.hashCode());
		result = prime * result
				+ ((homeTelephone == null) ? 0 : homeTelephone.hashCode());
		result = prime * result
				+ ((mobileTelephone == null) ? 0 : mobileTelephone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactDetails other = (ContactDetails) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gMapsUrl == null) {
			if (other.gMapsUrl != null)
				return false;
		} else if (!gMapsUrl.equals(other.gMapsUrl))
			return false;
		if (homeTelephone == null) {
			if (other.homeTelephone != null)
				return false;
		} else if (!homeTelephone.equals(other.homeTelephone))
			return false;
		if (mobileTelephone == null) {
			if (other.mobileTelephone != null)
				return false;
		} else if (!mobileTelephone.equals(other.mobileTelephone))
			return false;
		return true;
	}

	/**
	 * toString()
	 */

	@Override
	public String toString() {
		return "ContactDetails [email=" + email + ", gMapsUrl=" + gMapsUrl
				+ ", homeTelephone=" + homeTelephone + ", mobileTelephone="
				+ mobileTelephone + "]";
	}

}
