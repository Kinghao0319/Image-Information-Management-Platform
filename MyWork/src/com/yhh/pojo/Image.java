package com.yhh.pojo;

public class Image {
	private int id;
	private String name;
	private String country;
	private String position;
	private String resolution;
	private String longitude;
	private String latitude;
	private String acquisition_time;
	private String scale;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getAcquisition_time() {
		return acquisition_time;
	}
	public void setAcquisition_time(String acquisition_time) {
		this.acquisition_time = acquisition_time;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", image_path=" + name + ", country="
				+ country + ", position=" + position + ", resolution="
				+ resolution + ", longtitude=" + longitude + ", latitude="
				+ latitude + ", acquisition_time=" + acquisition_time
				+ ", scale=" + scale + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((acquisition_time == null) ? 0 : acquisition_time.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result
				+ ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result
				+ ((resolution == null) ? 0 : resolution.hashCode());
		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
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
		Image other = (Image) obj;
		if (acquisition_time == null) {
			if (other.acquisition_time != null)
				return false;
		} else if (!acquisition_time.equals(other.acquisition_time))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (resolution == null) {
			if (other.resolution != null)
				return false;
		} else if (!resolution.equals(other.resolution))
			return false;
		if (scale == null) {
			if (other.scale != null)
				return false;
		} else if (!scale.equals(other.scale))
			return false;
		return true;
	}
	public Image(int id, String name, String country, String position,
			String resolution, String longitude, String latitude,
			String acquisition_time, String scale) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.position = position;
		this.resolution = resolution;
		this.longitude = longitude;
		this.latitude = latitude;
		this.acquisition_time = acquisition_time;
		this.scale = scale;
	}
	public Image() {
		
	}
	
	
	
	
	
	
}
