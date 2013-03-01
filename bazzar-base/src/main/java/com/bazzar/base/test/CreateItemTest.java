package com.bazzar.base.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bazzar.base.domain.Picture;
import com.bazzar.base.domain.Review;
import com.bazzar.base.domain.item.Accessories;
import com.bazzar.base.domain.item.Color;
import com.bazzar.base.domain.item.Demensions;
import com.bazzar.base.domain.item.Detail;
import com.bazzar.base.domain.item.Features;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.item.Manufacture;
import com.bazzar.base.domain.item.QuickSpecs;
import com.bazzar.base.domain.item.Rating;
import com.bazzar.base.domain.item.ShippingDemensions;
import com.bazzar.base.domain.item.Specification;
import com.bazzar.base.domain.item.SpecificationDetails;
import com.bazzar.base.domain.item.Warranty;
import com.bazzar.base.domain.item.Weight;
import com.bazzar.base.domain.qa.Answer;
import com.bazzar.base.domain.qa.Question;

public class CreateItemTest {
	
	public CreateItemTest (){}
	public Item setIPodShuff(){
		Item item = this.setItem("Apple 2GB Pink iPod Shuffle", 
				"Crafted From A Single Piece Of Aluminum/ VoiceOver Speaks 29 Different Languages/ Up To 15 Hours Of Audio Playback/ Shuffle Switch/ Earphones Included/ Charges Via USB To Computer/ 2GB Storage Capacity/ Pink Finish", 
				49.00, 
				new Date(), 
				new Date(), 
				false, 
				49.00, 
				69.00, 
				-1, 
				false, 
				true, 
				"MD773LLA", 
				"MD773LL/A", 
				null);
		// set Color
		String [] col = {"Black","White","Dark Grey","Almond","Steal","Pink"};
		item.setColor(this.setColor(col));
		// set Review
		String [] rev = {"Small and great sound"};
		item.setReview(this.setReviews(rev));
		// set Manufacture
		String [][] man = 	{{"Apple", "MD773LL/A", "/images/items/xlarge0-64033.jpg"}};
		item.setManufacture(this.setManufactures(man));
		// set Rating
		int [] rating = {1,1,1,1};
		item.setRating(setRatings(rating));
		// set Weight
		String [][] wet = {{"Unit","0.03 lbs"},{"Shipping","2 lbs"}};
		item.setWieght(this.setWeights(wet));
		// set Warranty
		String [][]warranty = {{"Manufacturer Warranty (authorized online retailer)",null},
				{"Parts Warranty","Limited 1-year entire appliance"},
				{"Labor Warranty","Limited 1-year entire appliance"}};
		item.setWarranty(this.setWaranties(warranty));
		// set Demensions
		String [][] dem = {{"Depth"," 0.34\""},{"Height","1.14\""},{"Width","1.24\""}};
		item.setDemensions(this.setDemensions(dem));
		// set Shipping Demensions
		String [][] shipDem = {{"Depth","14\""},{"Height","9-1/4\""},{"Width","18-13/16\""}};
		item.setShippingDemensions(this.setShippingDemensions(shipDem));
		// set Specifications
		Set <Specification> spec = new HashSet <Specification> ();
		String [] spec1 = {"2GB flash drive"};
		spec.add(this.setSpecification("Capacity", spec1));
		String [] spec2 = {"Control pad","Play in order","Turn off","Shuffle","3.5mm stereo headphone minijack","VoiceOver button"};
		spec.add(this.setSpecification("External Buttons and Controls", spec2));
		String [] spec3 = {"Control pad","Play in order","Turn off","Shuffle","3.5mm stereo headphone minijack","VoiceOver button"};
		spec.add(this.setSpecification("Audio Playback", spec3));
		item.setSpecification(spec);
		// set Features
		String [][]features = {{"Sleek, anodized aluminum. Eight gorgeous colors","Its main body is crafted from a single piece of aluminum, so iPod shuffle feels solid, sleek, and durable. And the color palette makes it the perfect fashion accessory."},
				{"Hundreds of songs to go.","Never leave a favorite tune behind. Along with up to 15 hours of battery life1, iPod shuffle gives you 2GB of storage capacity, good for hundreds of songs2. That’s plenty of room for the essential songs of your workout or commute. And for multiple playlists, Genius Mixes, podcasts, and audiobooks, too."},
				{"Goes anywhere. And with anything.","iPod shuffle isn’t just portable. It’s wearable, too. Clip it to your shirt, jacket, workout gear, backpack, or purse strap, and it stays put — whether you’re running an errand or running around the track."},
				{"Control your music with just a click.","The big, clickable control pad on the front of iPod shuffle makes it easy to see and use the music controls. Press the center button to play and pause. Press the outer buttons to skip forward or back and adjust volume. Click, click, click. It’s music to your fingers."},
				{"Play it your way.","Maybe you’re the spontaneous type. Or maybe you prefer a little order. Just flip the shuffle switch to suit your listening style. Flip it to the left, and you’ll hear your music in a refreshingly random way. Flip it to the middle, and your songs play in order. Or flip to the right to turn iPod shuffle off."},
				{"Give your songs a voice.","Say you’re listening to a song and want to know the title or the artist. Just press the VoiceOver button on top of your iPod shuffle, and it tells you3. You can even use VoiceOver to hear the names of playlists and switch between them. And if your battery needs charging, VoiceOver tells you that, too."},
				{"It speaks your language.","A French love song. A Spanish bolero. An Italian cantata. Your music library has songs from all over the world. That’s why VoiceOver speaks 29 different languages. So it can tell you song titles and artists in their native tongues or any language you choose."},
				{"Sync to your heart's content.","iTunes on your Mac or PC makes it easy to load up your iPod shuffle. Just choose the playlists, audiobooks, podcasts, and other audio files you want, then sync"},
				{"When one playlist isn't enough.","You probably have multiple playlists in iTunes on your computer. One for your commute. One for the gym. Sync those playlists to iPod shuffle, and you can play the perfect mix for whatever mood strikes you. VoiceOver tells you the name of each playlist, so it’s easy to switch between them and find the one you want without looking."},
				{"Have Genius call the tunes.","There’s another way to get a good mix of music on iPod shuffle: Let Genius do the work. Activate Genius in iTunes on your computer, and it automatically finds songs that sound great together. Then it creates Genius Mixes, which you can easily sync to your iPod shuffle. It’s the perfect way to rediscover songs you haven’t listened to in forever."}};
		item.setFeatures(this.setFeatures(features));
		// set Quick Specifications
		String [][]qiuick = {{"iPod Type","Shuffle"},
				{"Average Battery Life","15 Hours"},
				{"Recharge Time","3 Hours"},
				{"Power Source","Built-in Rechargeable Li-ion Battery, USB"},
				{"Storage Capacity","2GB"},
				{"Storage Type","Flash Drive"},
				{"Song Capacity","2GB"},
				{"Supported Audio Formats","AAC, Protected AAC, MP3, MP3 VBR, Audible, Apple Lossless, AIFF, WAV"},
				{"Headphone Output","3.5-mm Stereo Headphone Jack"},
				{"Headphone Type","Apple Earphones"},
				{"Supported Languages","Chinese (Cantonese, Mandarin), Czech, Danish, Dutch, English (Australia, UK, and U.S.), Finnish, French (Canada, France), German, Greek, Hungarian, Italian, Japanese, Korean, Norwegian, Polish, Portuguese (Brazil, Portugal), Romanian, Russian, Slovak, Spanish (Mexico, Spain), Swedish, Thai, Turkish"}};
		item.setQuickSpecs(this.setQuickSpecs(qiuick));
		// set Details
		String [][]detail = {{"Apple 2GB Pink iPod Shuffle, Model MD773LLA",null}};
		item.setDetail(this.setDetails(detail));
		// set Pictures
		String [] pics = {"/images/items/xlarge0-27716.jpg","/images/items/LaundryAccessories.jpg"};
		item.setPictureLocation(this.setPictures(pics));
		// set Accessories
		return item;
	}
	public Item setMicrovave (){
		Item item = this.setItem("GE Spacemaker Over-The-Range White Microwave Oven", 
				"1.5 Cu. Ft. Capacity/ 950 Watts/ Convenience Controls/ Auto And Time Defrost/ Two-Speed 300-CFM Venting System/ Removable Oven Rack/ White Finish", 
				170.00, 
				new Date(), 
				new Date(), 
				false, 
				188.00, 
				209.00, 
				-1, 
				false, 
				true, 
				"JVM1540DNWW", 
				"JVM1540DNWW", 
				null);
		// set Color
		String [] col = {"Black","White","Dark Grey","Almond","Steal"};
		item.setColor(this.setColor(col));
		// set Review
		String [] rev = {"EASY TO USE...JUST USE FOR VEGGIES, DEFROSTING, POPCORN, SOME TO WARM UP DISHES.",
				"VERY HELPFUL OVER THE PHONE...MAN WHO INSTALLED WAS GREAT...VWRY GOOD SERVICE."};
		item.setReview(this.setReviews(rev));
		// set Manufacture
		String [][] man = 	{{"GE", "JVM1540WH", "/images/items/xlarge0-27716.jpg"},
							{"General Electric",  "JVM1540WH", "/images/items/xlarge0-27716.jpg"}};
		item.setManufacture(this.setManufactures(man));
		// set Rating
		int [] rating = {1,1,1,1,1,1};
		item.setRating(setRatings(rating));
		// set Weight
		String [][] wet = {{"Unit","51 lbs"},{"Shipping","57 lbs"}};
		item.setWieght(this.setWeights(wet));
		// set Warranty
		String [][]warranty = {{"Manufacturer Warranty (authorized online retailer)",null},
				{"Parts Warranty","Limited 1-year entire appliance"},
				{"Labor Warranty","Limited 1-year entire appliance"}};
		item.setWarranty(this.setWaranties(warranty));
		// set Demensions
		String [][] dem = {{"Depth","15-1/4\""},{"Height","16-3/4\""},{"Width","29-7/8\""}};
		item.setDemensions(this.setDemensions(dem));
		// set Shipping Demensions
		String [][] shipDem = {{"Depth","14\""},{"Height","9-1/4\""},{"Width","18-13/16\""}};
		item.setShippingDemensions(this.setShippingDemensions(shipDem));
		// set Features
		String [][]features = {{"1.5 cu. ft. capacity","950 watts (IEC-705 test procedure)"},
				{"Convenience Controls","Allow cooking and reheating at the touch of a button"},
				{"Auto and Time Defrost","Automatically defrosts for a specified amount of time"},
				{"Turntable On/Off","Ideal for oversized, oblong-shaped dishes"},
				{"Two-Speed, 300-CFM Venting System","Quickly removes smoke and steam from the cooktop"},
				{"Removable Oven Rack","Makes multi-dish cooking possible"}};
		item.setFeatures(this.setFeatures(features));
		// set Specifications
		Set <Specification> spec = new HashSet <Specification> ();
		String [] spec1 = {"2GB flash drive"};
		spec.add(this.setSpecification("Capacity", spec1));
		String [] spec2 = {"Control pad","Play in order","Turn off","Shuffle","3.5mm stereo headphone minijack","VoiceOver button"};
		spec.add(this.setSpecification("External Buttons and Controls", spec2));
		String [] spec3 = {"Control pad","Play in order","Turn off","Shuffle","3.5mm stereo headphone minijack","VoiceOver button"};
		spec.add(this.setSpecification("Audio Playback", spec3));
		item.setSpecification(spec);
		// set Quick Specifications
		String [][]quick = {{"Type","Under Cabinet"},
				{"CFM","300"},
				{"Venting Type","Ducked"},
				{"Fan Speeds","2"},
				{"Halogen Lighting","Yes"},
				{"Type","Over-the-Range"},
				{"Capacity","1.5 Cu. Ft."},
				{"Cooking Power","950 W"},
				{"Height","16.75\""},
				{"Width","30\""},
				{"Number of Power Levels","10"},
				{"Convection","No"},
				{"Sensor Cooking","No"},
				{"Interior Light","Yes"},
				{"Quick Minute","Yes"},
				{"Timer","Yes"}};
		item.setQuickSpecs(this.setQuickSpecs(quick));
		// set Details
		String [][]detail = {{"GE Spacemaker JVM1540DNWW Over-The-Range White Microwave Oven, Model JVM1540WH",null}};
		item.setDetail(this.setDetails(detail));
		// set Pictures
		String [] pics = {"/images/items/xlarge0-27716.jpg","/images/items/LaundryAccessories.jpg"};
		item.setPictureLocation(this.setPictures(pics));
		// set Accessories
		return item;
	}
	private Set <Color> setColor ( String [] colors){
		Set <Color> color = new HashSet <Color> ();
		for ( int i = 0; i < colors.length; i++){
			Color col = new Color ();
			col.setColor(colors[i]);
			col.setCPD(new Date ());
			col.setUPD(new Date ());
			color.add(col);
		}
		return color;
	}
	private Item setItem (String subgect, String description, double specialOfferPrice, 
			Date specialPriceStart, Date specialPriceEnd, boolean spesialPriceActive, 
			double salePrice, double listedPrice, int quantity,  boolean rebate, 
			boolean inStock, String manufactureModelNumber, String barCode, String pageLocator ){
		Item it = new Item ();
		it.setUPD(new Date());
		it.setCPD(new Date());
		it.setActive(true);
		it.setSubgect(subgect);
		it.setDescription(description);
		it.setSpecialOfferPrice(specialOfferPrice);
		it.setSpecialPriceStart(specialPriceStart);
		it.setSpecialPriceEnd(specialPriceEnd);
		it.setSpesialPriceActive(spesialPriceActive);
		it.setSalePrice(salePrice);
		it.setListedPrice(listedPrice);
		it.setQuantity(quantity);
		it.setRebate(rebate);
		it.setInStock(inStock);
		it.setManufactureModelNumber(manufactureModelNumber);
		it.setBarCode(barCode);
		it.setPageLocator(pageLocator);
		return it;
	}
	@SuppressWarnings("unused")
	private Answer setAnswer (String answer, Long customerId){
		Answer an = new Answer();
		an.setActive(true);
		an.setCustomerId(customerId);
		an.setAnswer(answer);
		an.setCPD(new Date());
		an.setUPD(new Date());
		return an;
	}
	@SuppressWarnings("unused")
	private Question setQuestion (String question, Long customerId){
		Question qa = new Question ();
		qa.setActive(true);
		qa.setCustomerId(customerId);
		qa.setQa(question);
		qa.setCPD(new Date());
		qa.setUPD(new Date());
		return qa;
	}
 	@SuppressWarnings({ "unchecked" })
	private Set <Review> setReviews (String [] reviews){
 		@SuppressWarnings("rawtypes")
		Set <Review> rev = new HashSet ();
 		for ( int i=0; i < reviews.length; i++){
 			rev.add(setReview ( reviews[i], new Date()));
 		}
 		return rev;
 	}
	private Review setReview (String review, Date setDate){
		Review rev = new Review();
		rev.setActive(true);
		rev.setCPD(new Date());
		rev.setReview(review);
		rev.setReviewDate(setDate);
		rev.setUPD(new Date ());
		return rev;
	}
	@SuppressWarnings("unchecked")
	private Set <Manufacture> setManufactures ( String [] [] man){
		@SuppressWarnings("rawtypes")
		Set <Manufacture> manuf = new HashSet ();
		for ( int rowIndex = 0; rowIndex < man.length; rowIndex++){
			String [] row = man[rowIndex];
			String name = null;
			String number = null;
			String pic = null;
			for ( int i=0; i< row.length; i++){
				if ( i == 0 )
					name = row[i];
				else if ( i ==1 )
					number = row[i];
				else
					pic = row[i];
			}
			manuf.add(setManufacture(name,number,pic));	
		}
		return manuf;
	}
	private Manufacture setManufacture (String name, String number, String pic ){
		Manufacture man = new Manufacture ();
		man.setActive(true);
		man.setAuthorizePicture(true);
		man.setCPD(new Date());
		man.setUPD(new Date());
		man.setName(name);
		man.setNumber(number);
		man.setPicture(setPicture(pic));
		return man;
	}
	@SuppressWarnings("unchecked")
	private Set<Rating> setRatings ( int [] rat){
		@SuppressWarnings("rawtypes")
		Set <Rating> rating = new HashSet ();
		for ( int i=0; i < rat.length; i++){
			rating.add(setRating(rat[i]));
		}
		return rating;
	}
	private Rating setRating ( int rating){
		Rating rat = new Rating ();
		rat.setActive(true);
		rat.setRating(rating);
		rat.setCPD(new Date());
		rat.setUPD(new Date());
		return rat;
	}
 	private Set <Weight> setWeights ( String [][] weig){
 		Set <Weight> weights = new HashSet <Weight> ();
 		for ( int index=0; index < weig.length; index ++){
 			String [] row = weig[index];
 			String att = null;
 			String value = null;
 			for ( int i=0; i<row.length; i++){
 				att = row[i];
 				value = row[i];
 			}
			weights.add(this.setWeight(att,value));
 		}
 		return weights;
 	}
	private Weight setWeight ( String att, String value){
		Weight dem = new Weight ();
		dem.setActive(true);
		dem.setAttribute(att);
		dem.setValue(value);
		dem.setCPD(new Date());
		dem.setUPD(new Date());
		return dem;
	}
	private Set <Warranty> setWaranties ( String [][] object){
		Set <Warranty> setObj = new HashSet <Warranty> ();
 		for ( int index=0; index < object.length; index ++){
 			String [] row = object[index];
 			String att = null;
 			String value = null;
 			for ( int i=0; i<row.length; i++){
 				if (i==0)
 					att = row[i];
 				else
 					value = row[i];
 			}
 			setObj.add(this.setWarranty(att,value));
 		}
 		return setObj;
 	
	}
	private Warranty setWarranty ( String att, String value){
		Warranty dem = new Warranty ();
		dem.setActive(true);
		dem.setAttribute(att);
		dem.setValue(value);
		dem.setCPD(new Date());
		dem.setUPD(new Date());
		return dem;
	}
	private Set <QuickSpecs> setQuickSpecs ( String [][] object){
		Set <QuickSpecs> setObj = new HashSet <QuickSpecs> ();
 		for ( int index=0; index < object.length; index ++){
 			String [] row = object[index];
 			String att = null;
 			String value = null;
 			for ( int i=0; i<row.length; i++){
 				if ( i==0 )
 					att = row[i];
 				else
 					value = row[i];
 			}
 			setObj.add(this.setQuickSpecs(att,value));
 		}
 		return setObj;
	}
	private QuickSpecs setQuickSpecs ( String att, String value){
		QuickSpecs dem = new QuickSpecs ();
		dem.setActive(true);
		dem.setAttribute(att);
		dem.setValue(value);
		dem.setCPD(new Date());
		dem.setUPD(new Date());
		return dem;
	}
	private Set <Features> setFeatures ( String [][] object){
		Set <Features> setObj = new HashSet <Features> ();
 		for ( int index=0; index < object.length; index ++){
 			String [] row = object[index];
 			String att = null;
 			String value = null;
 			for ( int i=0; i<row.length; i++){
 				if ( i==0 )
 	 				att = row[i];
 				else
 					value = row[i];
 			}
 			setObj.add(this.setFeatures(att,value));
 		}
 		return setObj;
	}
	private Features setFeatures ( String att,  String value){
		Features dem = new Features ();
		dem.setActive(true);
		dem.setAttribute(att);
		dem.setValue(value);
		dem.setCPD(new Date());
		dem.setUPD(new Date());
		return dem;
	}
	private Set <Detail> setDetails ( String [][] object){
		Set <Detail> setObj = new HashSet <Detail> ();
 		for ( int index=0; index < object.length; index ++){
 			String [] row = object[index];
 			String att = null;
 			String value = null;
 			for ( int i=0; i<row.length; i++){
 				if ( i==0 )
 	 				att = row[i];
 				else
 					value = row[i];
 			}
 			setObj.add(this.setDetail(att,value));
 		}
 		return setObj;
 	
	}
	private Detail setDetail ( String att,  String value){
		Detail dem = new Detail ();
		dem.setActive(true);
		dem.setAttribute(att);
		dem.setValue(value);
		dem.setCPD(new Date());
		dem.setUPD(new Date());
		return dem;
	}
	private Set <Demensions> setDemensions ( String [][] object){
		Set <Demensions> setObj = new HashSet <Demensions> ();
 		for ( int index=0; index < object.length; index ++){
 			String [] row = object[index];
 			String att = null;
 			String value = null;
 			for ( int i=0; i<row.length; i++){
 				if ( i==0 )
 	 				att = row[i];
 				else
 					value = row[i];
 			}
 			setObj.add(this.setDemensions(att,value));
 		}
 		return setObj;
 	
	}
	private Demensions setDemensions ( String att, String value){
		Demensions dem = new Demensions ();
		dem.setActive(true);
		dem.setAttribute(att);
		dem.setValue(value);
		dem.setCPD(new Date());
		dem.setUPD(new Date());
		return dem;
	}
	private Set <ShippingDemensions> setShippingDemensions ( String [][] object){
		Set <ShippingDemensions> setObj = new HashSet <ShippingDemensions> ();
 		for ( int index=0; index < object.length; index ++){
 			String [] row = object[index];
 			String att = null;
 			String value = null;
 			for ( int i=0; i<row.length; i++){
 				if ( i==0 )
 	 				att = row[i];
 				else
 					value = row[i];
 			}
 			setObj.add(this.setShippingDemensions(att,value));
 		}
 		return setObj;
	}
	private ShippingDemensions setShippingDemensions ( String att, String value){
		ShippingDemensions dem = new ShippingDemensions ();
		dem.setActive(true);
		dem.setAttribute(att);
		dem.setValue(value);
		dem.setCPD(new Date());
		dem.setUPD(new Date());
		return dem;
	}
	private Set <Picture> setPictures ( String [] pics){
		Set <Picture> pic = new HashSet <Picture> ();
		for ( int row=0; row < pics.length; row++){
			pic.add(this.setPicture(pics[row]));
		}
		return pic;
	}
	private Picture setPicture ( String location ){
		Picture pic = new Picture ();
		pic.setPictureLocation(location);
		pic.setDescription(location);
		pic.setActive(true);
		pic.setCPD(new Date ());
		pic.setUPD(new Date ());
		return pic;
	}
	private Specification setSpecification ( String att, String [] value){
		Specification spec = new Specification ();
		spec.setAttribute(att);
		spec.setActive(true);
		spec.setCPD(new Date ());
		spec.setUPD(new Date ());
 		spec.setSpecDetails(this.setSpecificationDetails(value));
 		return spec;
	}
	private Set<SpecificationDetails> setSpecificationDetails ( String []value ){
		Set <SpecificationDetails> specSet = new HashSet <SpecificationDetails> ();
		for ( int i=0; i<value.length; i++){
			SpecificationDetails pic = new SpecificationDetails ();
			pic.setValue(value[i]);
			pic.setActive(true);
			pic.setCPD(new Date ());
			pic.setUPD(new Date ());
			specSet.add(pic);
		}
		return specSet;
	}
	@SuppressWarnings("unused")
	private Set <Accessories> setAccessories ( Long [] ids){
		Set <Accessories> acc = new HashSet <Accessories> ();
		for ( int i=0; i< ids.length; i++){
			acc.add(setAccessories(ids[i]));
		}
		return acc;
	}
	private Accessories setAccessories (Long itemId){
		Accessories acce = new Accessories ();
		acce.setActive(true);
		acce.setCPD(new Date());
		acce.setUPD(new Date ());
		acce.setItem(itemId);
		return acce;
	}
}
