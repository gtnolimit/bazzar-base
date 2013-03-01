package com.bazzar.base.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bazzar.base.domain.lookup.OrderStatusLookup;

@Entity
@Table(name = "NOTE")
public class Note extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="NOTE")
	private String note;
	@ManyToOne
	@JoinColumn(name="TYPE")
	private OrderStatusLookup noteType;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public OrderStatusLookup getNoteType() {
		return noteType;
	}
	public void setNoteType(OrderStatusLookup noteType) {
		this.noteType = noteType;
	}	
}
