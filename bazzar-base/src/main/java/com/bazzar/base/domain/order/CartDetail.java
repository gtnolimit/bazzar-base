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
@Table(name = "CART_DETAIL")
public class CartDetail extends DBBase implements Serializable{

	private static final long serialVersionUID = -5527566248002296042L;
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		@Column(name="ITEM_ID")
		private Long itemId;
		@Column(name="PRICE")
		private double price;
		@Column(name="QTY")
		private int qty;
		@Column(name="SUBJECT")
		private String subject;
		@Column(name="PICTURE_LOCATION")
		private String pictureLocation;
		
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getPictureLocation() {
			return pictureLocation;
		}
		public void setPictureLocation(String pictureLocation) {
			this.pictureLocation = pictureLocation;
		}
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
		@Override
        public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result
	                + ((subject == null) ? 0 : subject.hashCode());
	        return result;
        }
		@Override
        public boolean equals(Object obj) {
	        if (this == obj)
		        return true;
	        if (obj == null)
		        return false;
	        if (getClass() != obj.getClass())
		        return false;
	        CartDetail other = (CartDetail) obj;
	        if (subject == null) {
		        if (other.subject != null)
			        return false;
	        } else if (!subject.equals(other.subject))
		        return false;
	        return true;
        }
		
		
}
