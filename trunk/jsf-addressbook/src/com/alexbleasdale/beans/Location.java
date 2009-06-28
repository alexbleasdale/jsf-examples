package com.alexbleasdale.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Standard Location Bean
 * 
 * @author alexbleasdale
 * 
 */

@Entity
public class Location {

	private Long id;

	private double latitude;
	private double longitude;
	private String gMapsServiceMetadata;

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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double d) {
		this.longitude = d;
	}

	@Lob
	public String getgMapsServiceMetadata() {
		return gMapsServiceMetadata;
	}

	public void setgMapsServiceMetadata(String gMapsServiceMetadata) {
		this.gMapsServiceMetadata = gMapsServiceMetadata;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((gMapsServiceMetadata == null) ? 0 : gMapsServiceMetadata
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Location other = (Location) obj;
		if (gMapsServiceMetadata == null) {
			if (other.gMapsServiceMetadata != null)
				return false;
		} else if (!gMapsServiceMetadata.equals(other.gMapsServiceMetadata))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double
				.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Location [gMapsServiceMetadata=" + gMapsServiceMetadata
				+ ", id=" + id + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}