package com.bazzar.base.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.base.domain.item.Color;

@Entity
@Table(name = "PICTURES")
@Where(clause="STATUS=1")
public class Picture  extends DBBase {

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Long id; 
	@Column(name = "PICTURE_LOCATION")
	private String pictureLocation;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ALT")
	private String alt;
	@Column(name="STATUS")
	private boolean isActive;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="picture")
	private Color color;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPictureLocation() {
		return pictureLocation;
	}
	public void setPictureLocation(String pictureLocation) {
		this.pictureLocation = pictureLocation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAlt() {
		return alt;
	}
	public void setAlt(String alt) {
		this.alt = alt;
	}
		
}
