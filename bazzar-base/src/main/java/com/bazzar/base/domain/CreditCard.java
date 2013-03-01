package com.bazzar.base.domain;


import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.base.domain.lookup.CreditCardTypeLookup;
import com.bazzar.base.domain.lookup.CustomerTypeLookup;

@Entity
@Table(name="CREDITCARD")
@Where(clause="STATUS=1")
public class CreditCard  extends DBBase {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ID")
	private long id;
	@Column(name="PARENT_ID")
	private long parentId;
	@ManyToOne
	@JoinColumn(name="GLOBAL_TYPE")
	private CustomerTypeLookup globalType;
	@ManyToOne
	@JoinColumn(name="CARD_TYPE")
	private CreditCardTypeLookup cardType;
	@Column(name="NUMBER")
	private String number; 
	@Column(name="DISPLAY_NUMBER")
	private String displayNumber; 
	@Column(name="EXPARATION")
	private String expiration; 
	@Column(name="SECURITY_CODE")
	private String securityCode; 
	@Column(name="CARHOLDER_NAME")
	private String cardholderName;
	@Column(name="NICKNAME")
	private String nickname;
	@Column(name="STATUS")
	private Boolean isActive;

	
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@OneToMany(cascade = ALL,fetch=FetchType.LAZY)
	@JoinTable(name = "CREDITCARD_ADDRESS", 
		joinColumns = { @JoinColumn(name = "CREDITCARD_ID") }, 
		inverseJoinColumns = { @JoinColumn(name = "ADDRESS_ID") })
	private Set<Address> cardAddress = new HashSet<Address>();
	
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getParentId() {
			return parentId;
		}
		public void setParentId(long parentId) {
			this.parentId = parentId;
		}
		public CreditCardTypeLookup getCardType() {
			return cardType;
		}
		public void setCardType(CreditCardTypeLookup cardType) {
		this.cardType = cardType;
		}
		public String getNumber() {
			return number;
		}
		public void setNumber(String number) {
			this.number = number;
		}
		public String getDisplayNumber() {
			return displayNumber;
		}
		public void setDisplayNumber(String displayNumber) {
			this.displayNumber = displayNumber;
		}
		public String getExpiration() {
			return expiration;
		}
		public void setExpiration(String expiration) {
			this.expiration = expiration;
		}
		public String getSecurityCode() {
			return securityCode;
		}
		public void setSecurityCode(String securityCode) {
			this.securityCode = securityCode;
		}
		public String getCardholderName() {
			return cardholderName;
		}
		public void setCardholderName(String cardholderName) {
			this.cardholderName = cardholderName;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public CustomerTypeLookup getGlobalType() {
			return globalType;
		}
		public void setGlobalType(CustomerTypeLookup globalType) {
			this.globalType = globalType;
		}
	
		public Set<Address> getCardAddress() {
			return cardAddress;
		}
		public void setCardAddress(Set<Address> cardAddress) {
			this.cardAddress = cardAddress;
		}

}
