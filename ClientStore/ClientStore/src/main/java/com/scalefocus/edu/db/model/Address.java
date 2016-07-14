package com.scalefocus.edu.db.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Entity implementation class for Entity: Address
 *
 */

@Entity
@Table(name = "address")
public class Address implements Serializable {
	
	@Id 
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "address_id", unique = true, nullable = false)
	private String addressId;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "addressline")
	private String addressline;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client_id", nullable=false)
	@Cascade(CascadeType.ALL)
	private Client client;

	private static final long serialVersionUID = 1L;

	public Address() {
		super();
	}   
	
	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}   
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}   
	
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}   
	
	public String getAddressline() {
		return this.addressline;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	} 
}