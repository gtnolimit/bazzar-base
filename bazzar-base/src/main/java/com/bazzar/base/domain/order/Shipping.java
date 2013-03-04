package com.bazzar.base.domain.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bazzar.base.domain.DBBase;

@Entity
@Table(name = "SHIPPING")
public class Shipping extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="AMOUNT")
	private double amount;
	@Column(name="TERM")
	private double term;
	@Column(name="WEIGHT")
	private double weght;
	@Column(name="SHIPPING_RATE")
	private double shippingRate;
	
	public double getTerm() {
		return term;
	}
	public void setTerm(double term) {
		this.term = term;
	}
	public double getWeght() {
		return weght;
	}
	public void setWeght(double weght) {
		this.weght = weght;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getShippingRate() {
		return shippingRate;
	}
	public void setShippingRate(double shippingRate) {
		this.shippingRate = shippingRate;
	}

	
}
