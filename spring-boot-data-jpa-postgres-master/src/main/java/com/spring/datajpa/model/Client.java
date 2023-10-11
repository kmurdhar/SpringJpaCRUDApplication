package com.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;

	@Column(name = "mobileNumber")
	private Long mobileNumber;

	@Column(name = "clientId")
	private Integer clientId;
	
	@Column(name = "physicalAddress")
	private String physicalAddress;

	public Client() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	 

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	 
	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public Client(long id, String firstName, String lastName, Long mobileNumber, int client_id,
			String physicalAddress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.clientId = client_id;
		this.physicalAddress = physicalAddress;
	}

	 
}
