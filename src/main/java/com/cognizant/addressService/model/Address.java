package com.cognizant.addressService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private int user_id;
	@Column(name = "perm_add")
	private String permanentAddress;
	@Column(name = "pre_add")
	private String currentAddress;
	public Address(int user_id,String permanentAddress, String currentAddress) {
		super();
		this.user_id=user_id;
		this.permanentAddress = permanentAddress;
		this.currentAddress = currentAddress;
	}
	public Address() {
		super();
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPresentAddress() {
		return currentAddress;
	}
	public void setPresentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	

}
