package com.scalefocus.edu.db.model;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Entity implementation class for Entity: Client
 *
 */

@Entity
@Table(name="client")
public class Client implements Serializable {

	@Id 
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "client_id", unique = true)
	private String clientId;

	@Column(name = "email")
	private String email;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(mappedBy="client", fetch = FetchType.EAGER )
	@Cascade(CascadeType.ALL)
	private List<Address> addresses;
	
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}

	public Client(String email, String firstName, String lastName, List<Address> addresses) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresses = addresses;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		if(addresses != null){
			addresses.forEach(a -> a.setClient(this));
		}
		this.addresses = addresses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
}
