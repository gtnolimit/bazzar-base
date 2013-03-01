package com.bazzar.base.domain.item;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.bazzar.base.domain.DBBase;
import com.bazzar.base.domain.Picture;
import com.bazzar.base.domain.Review;
import com.bazzar.base.domain.qa.Question;

@Entity
@Table(name = "ITEM") 
@Where(clause="STATUS=1")
public class Item extends DBBase implements Serializable{
	
	private static final long serialVersionUID = 2013406734640664822L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@Column(name = "SUBJECT", nullable = true, length = 2500)
	private String subgect;
	@Column(name = "DESCRIPTION", nullable = true, length = 2500)
	private String description;
	@Column(name = "SPECIAL_OFFER_PRICE")
	private double specialOfferPrice;
	@Column(name = "SPECIAL_PRICE_START")
	private Date specialPriceStart;
	@Column(name = "SPECIAL_PRICE_END")
	private Date specialPriceEnd;
	@Column(name = "SPECIAL_PRICE_ACTIVE")
	private boolean spesialPriceActive;
	@Column(name = "SALE_PRICE")
	private double salePrice;
	@Column(name = "LISTED_PRICE")
	private double listedPrice;
	@Column(name = "QTY")
	private int quantity; 
	@Column(name = "REBATE")
	private boolean rebate;
	@Column(name = "IN_STOCK")
	private boolean inStock;
	@Column(name = "MANUFACTURE_MODEL_NUMBER")
	private String manufactureModelNumber;
	@Column(name = "BAR_CODE")
	private String barCode;
	@Column (name= "PAGE_LOCATOR")
	private String pageLocator;
	@Column(name="STATUS")
	private boolean isActive;
		
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_MANUFACTURE",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="MANUFACTURE_ID")
	)
	private Set<Manufacture> manufacture = new HashSet <Manufacture> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_RATING",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="RATING_ID")
	)
	private Set <Rating> rating = new HashSet <Rating> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_COLOR",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="COLOR_ID")
	)
	private Set <Color> color = new HashSet <Color> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_REVIEW",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="REVIEW_ID")
	)
	private Set <Review> review = new HashSet <Review> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_PICTURES",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="PICTURES_ID")
	)
	private Set <Picture> pictureLocation = new HashSet <Picture> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_WARRANTY",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="WARRANTY_ID")
	)
	private Set <Warranty> warranty = new HashSet <Warranty> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_WEIGHT",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="WEIGHT_ID")
	)
	private Set <Weight> wieght = new HashSet <Weight> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_FEATURES",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="FEATURES_ID")
	)
	private Set <Features> features = new HashSet <Features> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_DEMENSIONS",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="DEMENSIONS_ID")
	)
	private Set <Demensions> demensions = new HashSet <Demensions> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_SHIPMENTDEMENSIONS",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="DEMENSIONS_ID")
	)
	private Set <ShippingDemensions> shippingDemensions = new HashSet <ShippingDemensions> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_ACCESSORIES",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="ACCESSORIES_ID")
	)
	private Set <Accessories> accessories = new HashSet <Accessories> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_DETAIL",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="DETAIL_ID")
	)
	private Set <Detail> detail = new HashSet <Detail> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_SPECIFICATION",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="SPECIFICATION_ID")
	)
	private Set <Specification> specification = new HashSet <Specification> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_QUICKSPECS",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="QUICKSPECS_ID")
	)
	private Set <QuickSpecs> quickSpecs = new HashSet <QuickSpecs> ();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(
	     name="ITEM_QA",
	     joinColumns = @JoinColumn( name="ITEM_ID"),
	     inverseJoinColumns = @JoinColumn( name="QA_ID")
	)
	private Set <Question> qa = new HashSet <Question> ();
	
	public Set<Color> getColor() {
		return color;
	}
	public void setColor(Set<Color> color) {
		this.color = color;
	}
	public boolean isRebate() {
		return rebate;
	}
	public void setRebate(boolean rebate) {
		this.rebate = rebate;
	}
	public String getManufactureModelNumber() {
		return manufactureModelNumber;
	}
	public void setManufactureModelNumber(String manufactureModelNumber) {
		this.manufactureModelNumber = manufactureModelNumber;
	}
	public String getBarCode() {
		return barCode;
	}
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getPageLocator() {
		return pageLocator;
	}
	public void setPageLocator(String pageLocator) {
		this.pageLocator = pageLocator;
	}
	public Set<Question> getQa() {
		return qa;
	}
	public void setQa(Set<Question> qa) {
		this.qa = qa;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSubgect() {
		return subgect;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setSubgect(String subgect) {
		this.subgect = subgect;
	}
	public double getSpecialOfferPrice() {
		return specialOfferPrice;
	}
	public void setSpecialOfferPrice(double specialOfferPrice) {
		this.specialOfferPrice = specialOfferPrice;
	}
	public Date getSpecialPriceStart() {
		return specialPriceStart;
	}
	public void setSpecialPriceStart(Date specialPriceStart) {
		this.specialPriceStart = specialPriceStart;
	}
	public Date getSpecialPriceEnd() {
		return specialPriceEnd;
	}
	public void setSpecialPriceEnd(Date specialPriceEnd) {
		this.specialPriceEnd = specialPriceEnd;
	}
	public boolean isSpesialPriceActive() {
		return spesialPriceActive;
	}
	public void setSpesialPriceActive(boolean spesialPriceActive) {
		this.spesialPriceActive = spesialPriceActive;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public double getListedPrice() {
		return listedPrice;
	}
	public void setListedPrice(double listedPrice) {
		this.listedPrice = listedPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
	public Set<Rating> getRating() {
		return rating;
	}
	public void setRating(Set<Rating> rating) {
		this.rating = rating;
	}
	public Set<Manufacture> getManufacture() {
		return manufacture;
	}
	public void setManufacture(Set<Manufacture> manufacture) {
		this.manufacture = manufacture;
	}
	public Set<Review> getReview() {
		return review;
	}
	public void setReview(Set<Review> review) {
		this.review = review;
	}
	public Set<Picture> getPictureLocation() {
		return pictureLocation;
	}
	public void setPictureLocation(Set<Picture> pictureLocation) {
		this.pictureLocation = pictureLocation;
	}
	public Set<Warranty> getWarranty() {
		return warranty;
	}
	public void setWarranty(Set<Warranty> warranty) {
		this.warranty = warranty;
	}
	public Set<Weight> getWieght() {
		return wieght;
	}
	public void setWieght(Set<Weight> wieght) {
		this.wieght = wieght;
	}
	public Set<Features> getFeatures() {
		return features;
	}
	public void setFeatures(Set<Features> features) {
		this.features = features;
	}
	public Set<Demensions> getDemensions() {
		return demensions;
	}
	public void setDemensions(Set<Demensions> demensions) {
		this.demensions = demensions;
	}
	public Set<Accessories> getAccessories() {
		return accessories;
	}
	public void setAccessories(Set<Accessories> accessories) {
		this.accessories = accessories;
	}
	public Set<Detail> getDetail() {
		return detail;
	}
	public void setDetail(Set<Detail> detail) {
		this.detail = detail;
	}
	public Set<Specification> getSpecification() {
		return specification;
	}
	public void setSpecification(Set<Specification> specification) {
		this.specification = specification;
	}
	public Set<ShippingDemensions> getShippingDemensions() {
		return shippingDemensions;
	}
	public void setShippingDemensions(Set<ShippingDemensions> shippingDemensions) {
		this.shippingDemensions = shippingDemensions;
	}
	public Set<QuickSpecs> getQuickSpecs() {
		return quickSpecs;
	}
	public void setQuickSpecs(Set<QuickSpecs> quickSpecs) {
		this.quickSpecs = quickSpecs;
	}	
}
