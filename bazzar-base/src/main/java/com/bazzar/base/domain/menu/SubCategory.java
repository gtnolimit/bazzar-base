package com.bazzar.base.domain.menu;

import java.io.Serializable;
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
@Table(name = "SUBCATEGORY")
@Where(clause="STATUS=1")
public class SubCategory  extends DBBase implements Serializable{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 

	@Column(name="ATTRIBUTE") 
 	private String attribute;
	@Column(name="STATUS")
	private boolean isActive;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="SUBCATEGORY_PRODUCT",
	     joinColumns = @JoinColumn( name="SUBCATEGORY_ID"),
	     inverseJoinColumns = @JoinColumn( name="PRODUCT_ID")
	)
	private Set<Product> product = new HashSet <Product> ();

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}

}
