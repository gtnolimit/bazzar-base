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
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Where;

import com.bazzar.base.domain.DBBase;
import com.bazzar.base.domain.Picture;
import com.bazzar.base.domain.item.Item;


@Entity
@Table(name = "PRODUCT")
@Where(clause="STATUS=1")
@Proxy(lazy=true)
public class Product extends DBBase  implements Serializable{

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 

	@Column(name="ATTRIBUTE") 
 	private String attribute;
	@Column(name="STATUS")
	private boolean isActive;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="PICTURE_ID")
	private Picture picture;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
 	@JoinTable(
	     name="PRODUCT_ITEM",
	     joinColumns = @JoinColumn( name="PRODUCT_ID"),
	     inverseJoinColumns = @JoinColumn( name="ITEM_ID")
	)
	private Set <Item> item = new HashSet <Item> ();
 	
	public Picture getPicture() {
		return picture;
	}
	public void setPicture(Picture picture) {
		this.picture = picture;
	}
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
	public Set<Item> getItem() {
		return item;
	}
	public void setItem(Set<Item> item) {
		this.item = item;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
