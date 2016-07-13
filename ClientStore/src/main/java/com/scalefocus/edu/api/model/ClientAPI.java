package com.scalefocus.edu.api.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ClientAPI {
	
	private String clientId;
	@JsonProperty("email") private String email;
	@JsonProperty("firstName") private String firstName;
	@JsonProperty("lastName") private String lastName;
	@JsonProperty("addresses") private List<AddressAPI> addresses;
	
	public ClientAPI(String email, String firstName, String lastName, List<AddressAPI> addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.addresses = addresses;
	}

	public ClientAPI() {
		super();
	}

	public String getClientId() {
		return clientId;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<AddressAPI> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressAPI> addresses) {
		this.addresses = addresses;
	}
}
