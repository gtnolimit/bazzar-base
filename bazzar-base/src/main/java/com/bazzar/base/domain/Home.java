package com.bazzar.base.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="HOME")
public class Home extends DBBase {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="SMTP_USER")
	private String smtpUser;
	@Column(name="COMPANY_NAME")
	private String companyName;
	@Column(name="HOME_STATE")
	private String homeState;
	@Column(name="SMTP_PASS")
	private String smtpPass;
	@Column(name="INFO_EMAIL")
	private String infoEmail;
	@Column(name="SMTP_HOST")
	private String smtpHost;
	@Column(name="SMTP_PORT")
	private String smtpPort;
	@Column(name="STATE_TAX")
	private double stateTax;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
	     name="COMPANY_ADDRESS",
	     joinColumns = @JoinColumn( name="COMPANY_ID"),
	     inverseJoinColumns = @JoinColumn( name="ADDRESS_ID")
	)
	private Set <Address> address = new HashSet <Address> ();
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
	     name="COMPANY_EMAIL",
	     joinColumns = @JoinColumn( name="COMPANY_ID"),
	     inverseJoinColumns = @JoinColumn( name="EMAIL_ID")
	)
	private Set <Email> email = new HashSet <Email> ();
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
	     name="COMPANY_PHONE",
	     joinColumns = @JoinColumn( name="COMPANY_ID"),
	     inverseJoinColumns = @JoinColumn( name="PHONE_ID")
	)
	private Set <Phone> phone = new HashSet <Phone> ();
	 	
	public Set<Address> getAddress() {
		return address;
	}
	public void setAddress(Set<Address> address) {
		this.address = address;
	}
	public Set<Email> getEmail() {
		return email;
	}
	public void setEmail(Set<Email> email) {
		this.email = email;
	}
	public Set<Phone> getPhone() {
		return phone;
	}
	public void setPhone(Set<Phone> phone) {
		this.phone = phone;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getHomeState() {
		return homeState;
	}
	public void setHomeState(String homeState) {
		this.homeState = homeState;
	}
	public double getStateTax() {
		return stateTax;
	}
	public void setStateTax(double stateTax) {
		this.stateTax = stateTax;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSmtpUser() {
		return smtpUser;
	}
	public void setSmtpUser(String smtpUser) {
		this.smtpUser = smtpUser;
	}
	public String getSmtpPass() {
		return smtpPass;
	}
	public void setSmtpPass(String smtpPass) {
		this.smtpPass = smtpPass;
	}
	public String getInfoEmail() {
		return infoEmail;
	}
	public void setInfoEmail(String infoEmail) {
		this.infoEmail = infoEmail;
	}
	public String getSmtpHost() {
		return smtpHost;
	}
	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}
	public String getSmtpPort() {
		return smtpPort;
	}
	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

}
