package com.bazzar.base.domain.order;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bazzar.base.domain.DBBase;

@Entity
@Table(name = "PAYMENT")
public class Payment extends DBBase implements Serializable{

	//TODO create payment
	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
}
