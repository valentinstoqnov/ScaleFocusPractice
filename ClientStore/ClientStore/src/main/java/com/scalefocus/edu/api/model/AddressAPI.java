package com.scalefocus.edu.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AddressAPI {
	
	private String addressId;
	@JsonProperty("country") private String country;
	@JsonProperty("city") private String city;
	@JsonProperty("zipcode") private String zipcode;
	@JsonProperty("addressline") private String addressline;

	public AddressAPI() {
		super();
	}

	public AddressAPI(String country, String city, String zipcode, String addressline) {
		super();
		this.country = country;
		this.city = city;
		this.zipcode = zipcode;
		this.addressline = addressline;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddressline() {
		return addressline;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}
}
