package com.bazzar.base.domain.qa;

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

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Where;

import com.bazzar.base.domain.DBBase;

@Entity
@Table(name = "QUESTION")
@Where(clause="STATUS=1")
public class Question  extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	@Column(name="QA")
	private String qa;
	@Column(name="STATUS")
	private boolean isActive;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
 	@JoinTable(
	     name="QUESTION_ANSWER",
	     joinColumns = @JoinColumn( name="QUESTION_ID"),
	     inverseJoinColumns = @JoinColumn( name="ANSWER_ID")
	)
	@LazyCollection(LazyCollectionOption.TRUE)
	private Set <Answer> answer = new HashSet <Answer> ();
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Set<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
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
	public String getQa() {
		return qa;
	}
	public void setQa(String qa) {
		this.qa = qa;
	}
}
