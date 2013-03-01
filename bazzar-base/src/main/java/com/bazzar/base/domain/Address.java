package com.bazzar.base.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.base.domain.lookup.AddressTypeLookup;
import com.bazzar.base.domain.lookup.StateTypeLookup;

@Entity
@Table(name="ADDRESS")
@Where(clause="STATUS=1")
public class Address extends DBBase {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne
	@JoinColumn (name="type")
	private AddressTypeLookup addressType;
	@Column(name="ADDRESS_1")
	private String addressLine1;
	@Column(name="ADDRESS_2")
	private String addressLine2;
	@Column(name="ADDRESS_3")
	private String addressLine3;
	@Column(name="CITY")
	private String city;
	@ManyToOne
    @JoinColumn(name = "STATE")
	private StateTypeLookup state;
	@Column(name="ZIP")
	private String zip;
	@Column(name="ZIP4")
	private String zip4;
	@Column(name="STATUS")
	private Boolean isActive;
	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public AddressTypeLookup getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressTypeLookup addressType) {
		this.addressType = addressType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}	
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}	
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public StateTypeLookup getState() {
		return state;
	}
	public void setState(StateTypeLookup stateTypeLookup) {
		this.state = stateTypeLookup;
	}	
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}	
	public String getZip4() {
		return zip4;
	}
	public void setZip4(String zip4) {
		this.zip4 = zip4;
	}

}
