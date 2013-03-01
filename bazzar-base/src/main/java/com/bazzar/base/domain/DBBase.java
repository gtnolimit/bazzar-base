package com.bazzar.base.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class DBBase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATED", updatable=true)
	protected Date UPD;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED", updatable=false)
	protected Date CPD;
	//protected String User;
	
	public Date getUPD() {
		return UPD;
	}
	public void setUPD(Date UPD) {
		this.UPD = UPD;
	}
	//public String getUser() {
	//	return User;
	//}
	//public void setUser(String User) {
	//	this.User = User;
	//}
	public Date getCPD() {
		return CPD;
	}
	public void setCPD(Date cPD) {
		CPD = cPD;
	}
    public String toString() {
        return super.toString();
    }
}