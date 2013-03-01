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
@Table(name = "ORDER_DETAIL")
public class OrderDetail extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		@Column(name="ITEM_ID")
		private Long itemId;
		@Column(name="ITEM_PRICE")
		private double price;
		@Column(name="QTY")
		private int qty;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getItemId() {
			return itemId;
		}
		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		
}
