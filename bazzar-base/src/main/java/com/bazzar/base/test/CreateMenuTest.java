package com.bazzar.base.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;

import com.bazzar.base.domain.Picture;
import com.bazzar.base.domain.menu.Category;
import com.bazzar.base.domain.menu.Product;
import com.bazzar.base.domain.menu.SubCategory;

@Controller
public class CreateMenuTest {
	

	public CreateMenuTest (){
	}
	
	public Category setPortableElectronics(){
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Set <SubCategory> subPortableElectronics = new HashSet ();

		String [] musicPlayers={"iPods & MP3 Players","Portable DVD Player","Boomboxes","Portable Satellite Radio","Clock Radios","Radios"};
		Set <Product> prodMusicPlayers = setProducts (musicPlayers);
		SubCategory subMusicPlayers = setSubCategory("Music Players", prodMusicPlayers);
		subPortableElectronics.add(subMusicPlayers);
			
		String [] portableSpeakers={"Other Portables","Clock Radios","Voice Recorders","E-Readers"};
		Set <Product> prodPortableSpeakers = setProducts (portableSpeakers);
		SubCategory subPortableSpeakers = setSubCategory("Portable Speakers", prodPortableSpeakers);
		subPortableElectronics.add(subPortableSpeakers);

		String [] videoPlayers={"Portable DVD Player"};
		Set <Product> prodVideoPlayers = setProducts (videoPlayers);
		SubCategory subVideoPlayers = setSubCategory("Video Players", prodVideoPlayers);
		subPortableElectronics.add(subVideoPlayers);

		String [] portableAccessories={"Headphones","iPod Accessories (by type)","iPod Audio Stations","Portable DVD Accessories","Rechargeable Batteries","Power Adapters/ Chargers"};
		Set <Product> prodPortableAccessories = setProducts (portableAccessories);
		SubCategory subPortableAccessories = setSubCategory("Portable Accessories", prodPortableAccessories);
		subPortableElectronics.add(subPortableAccessories);

		Category catPortableElectronics = setCategory ("Portable Electronics", subPortableElectronics);
		return catPortableElectronics;
	}
	@SuppressWarnings("rawtypes")
	public Category setComputers(){
		@SuppressWarnings("unchecked")
		Set <SubCategory> subComputers = new HashSet ();
		String [] computers={"iPad & Tablets","Laptop / Notebook Computers","Desktop Computers","E-Readers"};
		Set <Product> prodComputers = setProducts (computers);
		SubCategory subComputer = setSubCategory("Computers", prodComputers);
		subComputers.add(subComputer);

		String [] printersScanners={"Printers & Scanners","Cables & Connections","Printer Ink & Toner","Digital Photo Paper"};
		Set <Product> prodPrintersScanners = setProducts (printersScanners);
		SubCategory subPrintersScanners = setSubCategory("Printers & Scanners", prodPrintersScanners);
		subComputers.add(subPrintersScanners);

		String [] computerAccessories={"iPad Accessories","Mouse & Keyboards","Computer Monitors","External Hard Drives","Networking & Wireless","Cables & Connections","Laptop Accessories","Computer Hardware","Printers & Scanners","Software"};
		Set <Product> prodComputerAccessories = setProducts (computerAccessories);
		SubCategory subComputerAccessories = setSubCategory("Computer Accessories", prodComputerAccessories);
		subComputers.add(subComputerAccessories);

		Category catComputers = setCategory ("Computers", subComputers);
		return catComputers;
	}
	@SuppressWarnings("rawtypes")
	public Category setCamerasCamcorders (){
		@SuppressWarnings("unchecked")
		Set <SubCategory> subCamerasCamcorders = new HashSet ();

		String [] cameras={"Digital Cameras"};
		Set <Product> prodCameras = setProducts (cameras);
		SubCategory subCameras = setSubCategory("Cameras", prodCameras);
		subCamerasCamcorders.add(subCameras);

		String [] cameraAccessories={"Digital Camera & Camcorder Lenses","Digital Camera Batteries and Chargers","Camera Cases","USB Flash Drives & Memory Cards","Digital Photo Frames","Photo Printers","Digital Photo Paper"};
		Set <Product> prodCameraAccessories = setProducts (cameraAccessories);
		SubCategory subCameraAccessories = setSubCategory("Camera Accessories", prodCameraAccessories);
		subCamerasCamcorders.add(subCameraAccessories);

		String [] camcorders={"Camcorders"};
		Set <Product> prodCamcorders = setProducts (camcorders);
		SubCategory subCamcorders = setSubCategory("Camcorders", prodCamcorders);
		subCamerasCamcorders.add(subCamcorders);

		String [] camcorderAccessories={"Video Lights","Camcorder Microphones","Camcorder Batteries","Camcorder Bags"};
		Set <Product> prodCamcorderAccessories = setProducts (camcorderAccessories);
		SubCategory subCamcorderAccessories = setSubCategory("Camcorder Accessories", prodCamcorderAccessories);
		subCamerasCamcorders.add(subCamcorderAccessories);

		Category catCamerasCamcorders = setCategory ("Cameras & Camcorders", subCamerasCamcorders);
		return catCamerasCamcorders;
	}
	@SuppressWarnings("unchecked")
	public Category setAudio (){
		@SuppressWarnings("rawtypes")
		Set <SubCategory> subAudio = new HashSet ();

		String [] speakers={"Bookshelf Speakers","Center Channel Speakers","Floor Standing Speakers","Home Theater Speaker Packages","In Wall Speakers","In Ceiling Speakers","Outdoor Speakers","Soundbars","Subwoofer Speakers","Portable Speakers","Satellite Speakers","Stereo Speaker Packages"};
		Set <Product> prodSpeakers = setProducts (speakers);
		SubCategory subSpeakers = setSubCategory("Speakers", prodSpeakers);
		subAudio.add(subSpeakers);

		String [] homeTheater={"Amplifiers","Home Theater Systems","Preamplifiers","Audio Receivers","Tuners"};
		Set <Product> prodHomeTheater = setProducts (homeTheater);
		SubCategory subHomeTheater = setSubCategory("Home Theater", prodHomeTheater);
		subAudio.add(subHomeTheater);

		String [] audioPlayers={"iPods & MP3 Players","Mini Systems","Turntables","Boomboxes","Portable Satellite Radio","Clock Radios","CD Players and Recorders","Radios"};
		Set <Product> prodAudioPlayers = setProducts (audioPlayers);
		SubCategory subAudioPlayers = setSubCategory("Audio Players", prodAudioPlayers);
		subAudio.add(subAudioPlayers);

		String [] audioAaccessories={"Audio Racks & Video Racks","Remote Controls","Speaker Stands","Audio Cables","Audio Carrying Cases","Subwoofer Cables","Digital Audio Cables"};
		Set <Product> prodAudioAaccessories = setProducts (audioAaccessories);
		SubCategory subAudioAaccessories = setSubCategory("Audio Accessories", prodAudioAaccessories);
		subAudio.add(subAudioAaccessories);

		Category catAudio = setCategory ("Audio", subAudio);
		return catAudio;

	}
	@SuppressWarnings("rawtypes")
	public Category setAppliances (){
		@SuppressWarnings("unchecked")
		Set <SubCategory> subAppliances = new HashSet ();
		String [] kitchen = {"Appliance Packages","Cooking Products","Dishwashers","Garbage Disposals","Hoods","Ice Makers","Microwaves & Microwave Ovens","Refrigerators & Freezers","Small Appliances","Trash Compactors"};
		Set <Product> prodKitchen = setProducts (kitchen);
		SubCategory subKitchen = setSubCategory("Kitchen", prodKitchen);
		subAppliances.add(subKitchen);
		
		String [] laundry = {"Laundry Packages","Washers","Dryers","Stack Washers and Dryers","Washer and Dryer Combo Units","Commercial Dryers","Commercial Washers","Laundry Accessories"};
		Set <Product> prodLaundry = setProducts (laundry);
		SubCategory subLaundry = setSubCategory("Laundry", prodLaundry);
		subAppliances.add(subLaundry);
		
		String [] homeComfort = {"Air Conditioners","Air Purifiers","Dehumidifiers","Fans And Space Heaters","Humidifiers","Central Cooling and Heating","Vacuums","Water Dispensers","Water Heaters","Power Generators"};
		Set <Product> prodHomeComfort = setProducts (homeComfort);
		SubCategory subHomeComfort = setSubCategory("HomeComfort", prodHomeComfort);
		subAppliances.add(subHomeComfort);
		
		String [] outdoor = {"Outdoor Grills /BBQs","Mosquito Repellant","Outdoor Heaters"};
		Set <Product> prodOutdoor = setProducts (outdoor);
		SubCategory subOutdoor = setSubCategory("Outdoor", prodOutdoor);
		subAppliances.add(subOutdoor);
		
		Category catAppliances = setCategory ("Appliances", subAppliances);
		
		return catAppliances;
	}
	@SuppressWarnings("rawtypes")
	private Set <Product> setProducts ( String [] products){
		@SuppressWarnings("unchecked")
		Set <Product> product = new HashSet ();
		for ( int i = 0; i < products.length; i++){
			Product prod;
			if (products[i].equals("Laundry Packages"))
				prod = setProduct(products[i], "/images/items/LaundryPackages.jpg");
			else if (products[i].equals("Washers"))
				prod = setProduct(products[i], "/images/items/washer.jpg");
			else if (products[i].equals("Dryers"))
				prod = setProduct(products[i], "/images/items/dryers.jpg");
			else if (products[i].equals("Stack Washers and Dryers"))
				prod = setProduct(products[i], "/images/items/StackWasherAndDryers.jpg");
			else if (products[i].equals("Washer and Dryer Combo Units"))
				prod = setProduct(products[i], "/images/items/WasherAndDryerComboUnits.jpg");
			else if (products[i].equals("Commercial Dryers"))
				prod = setProduct(products[i], "/images/CommercialDryers.jpg");
			else if (products[i].equals("Commercial Washers"))
				prod = setProduct(products[i], "/images/items/CommercialWashers.jpg");
			else if (products[i].equals("Laundry Accessories"))
				prod = setProduct(products[i], "/images/items/LaundryAccessories.jpg");
			else
				prod = setProduct(products[i], null);
			product.add(prod);
		}
		return product;
	}
	private Product setProduct ( String attribute, String pictureLocation ){
		Product product = new Product ();
		product.setAttribute(attribute);
		product.setActive(true);
		product.setCPD( new Date () );
		product.setUPD( new Date () );
		
		if ( pictureLocation != null ){
			product.setPicture( setPicture (pictureLocation)) ;
			System.out.println ("setting picture : " + pictureLocation);
		}
		return product;
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
	private SubCategory setSubCategory (String attribute, Set <Product> products){
		SubCategory subCategory = new SubCategory ();
		subCategory.setAttribute(attribute);
		subCategory.setProduct(products);
		subCategory.setActive(true);
		subCategory.setCPD( new Date () );
		subCategory.setUPD( new Date () );
		return subCategory;
	}	
	private Category setCategory (String attribute, Set <SubCategory> subCategories) {
		Category category = new Category ();
		category.setAttribute(attribute);
		category.setSubCategory(subCategories);
		category.setActive(true);
		category.setCPD( new Date () );
		category.setUPD( new Date () );
		return category;
	}

}
