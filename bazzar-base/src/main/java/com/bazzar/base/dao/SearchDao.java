package com.bazzar.base.dao;

import java.util.List;

import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.menu.Product;

public interface SearchDao {

	public List <Item> findItemsByName ( String itemName );
	public List <Item> findItemsByManufactureNumber ( String manufactureNumber );
	public List <Item> findItemsByManufacture ( String manufacture );
	public List <Item> findItemsByDescription ( String description );
	public List <Item> findItemsByBarCode ( String barCode );
	
	public List<Product> findProductByName ( String productName );
 
}
