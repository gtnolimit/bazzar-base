package com.bazzar.base.domain.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bazzar.base.domain.DBBase;

@Entity
@Table(name = "IPS")
public class Ip extends DBBase implements Serializable{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	@Column(name = "IP")
	private String ip;
	@Column (name = "SESSION")
	private String session;

	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIps() {
		return ip;
	}
	public void setIps(String ip) {
		this.ip = ip;
	}
}
