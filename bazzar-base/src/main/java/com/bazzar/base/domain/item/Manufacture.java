package com.bazzar.base.domain.item;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.base.domain.DBBase;
import com.bazzar.base.domain.Picture;


@Entity
@Table(name = "MANUFACTURE")
@Where(clause="STATUS=1")
public class Manufacture extends DBBase implements Serializable{
	
	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "NUMBER")
	private String number;
	@Column(name = "AUTHORIZE_PICTURE")
	private boolean authorizePicture;
	@Column(name="STATUS")
	private boolean isActive;
	
 	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="MANUFACTURE_PICTURE",
	     joinColumns = @JoinColumn( name="MANUFACTURE_ID"),
	     inverseJoinColumns = @JoinColumn( name="PICTURE_ID")
	)
 	private Picture picture;
 	
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
	public boolean isAuthorizePicture() {
		return authorizePicture;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public void setAuthorizePicture(boolean authorizePicture) {
		this.authorizePicture = authorizePicture;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
}
