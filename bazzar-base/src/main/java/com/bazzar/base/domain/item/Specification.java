package com.bazzar.base.domain.item;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.base.domain.DBBase;

@Entity
@Table(name = "SPECIFICATIONS")
@Where(clause="STATUS=1")
public class Specification extends DBBase{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "ATTRIBUTE", nullable = true, length = 1000)
	private String attribute;
	@Column(name="STATUS")
	private boolean isActive;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="SPECIFICATION_DETAILS",
	     joinColumns = @JoinColumn( name="SPECIFICATION_ID"),
	     inverseJoinColumns = @JoinColumn( name="DETAIL_ID")
	)
	private Set <SpecificationDetails> specDetails = new HashSet <SpecificationDetails> ();
	
	public Set<SpecificationDetails> getSpecDetails() {
		return specDetails;
	}
	public void setSpecDetails(Set<SpecificationDetails> specDetails) {
		this.specDetails = specDetails;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
