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

import com.bazzar.base.domain.lookup.EmailTypeLookup;

@Entity
@Table(name="EMAIL")
@Where(clause="STATUS=1")
public class Email  extends DBBase {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@ManyToOne
	@JoinColumn(name="TYPE")
	private EmailTypeLookup emailType;
	@Column(name="EMAIL")
	private String email;
	@Column(name="STATUS")
	private boolean isActive;

	
		public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

		public void setEmailType(EmailTypeLookup emailType) {
			this.emailType = emailType;
		}
		public EmailTypeLookup getEmailType() {
			return emailType;
		}
}
