package com.bazzar.base.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

import com.bazzar.base.domain.lookup.PhoneTypeLookup;

@Entity
@Table(name="PHONE")
@Where(clause="STATUS=1")
public class Phone  extends DBBase {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
    private long id;
	@ManyToOne
    @JoinColumn(name="Type")
	private PhoneTypeLookup phoneType;
	@Column(name="COUNTRY_CODE")
	private String countryCode;
	@Column(name="AREA_CODE")
	private String areaCode;
	@Column(name="PHONE")
	private String phone;
	@Column(name="EXT")
	private String ext;
	@Column(name="STATUS")
	private boolean isActive;

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}	
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	public PhoneTypeLookup getPhoneType() {
		return phoneType;
	}
	public void setPhoneType(PhoneTypeLookup phoneType) {
		this.phoneType = phoneType;
	}
}
