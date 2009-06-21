package com.example.jsf.beans;

public class Location {

	private double latitude;
	private double longtude;

	/**
	 * Getters and Setters
	 */
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtude() {
		return longtude;
	}

	public void setLongtude(double longtude) {
		this.longtude = longtude;
	}

	/**
	 * hashCode and equals
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longtude);
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
		if (Double.doubleToLongBits(latitude) != Double
				.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longtude) != Double
				.doubleToLongBits(other.longtude))
			return false;
		return true;
	}

}
