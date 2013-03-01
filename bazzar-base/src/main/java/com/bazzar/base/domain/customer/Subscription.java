package com.bazzar.base.domain.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bazzar.base.domain.DBBase;

@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription   extends DBBase {

	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "PROMOTIONAL")
	private boolean promotional;
	@Column(name = "NEWLATTER")
	private boolean newsLatter;
	@Column(name = "COUPONS")
	private boolean coupons;
	// TODO add subscription fields
}
