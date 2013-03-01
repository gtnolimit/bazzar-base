package com.bazzar.base.services;

import java.util.List;

import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.menu.Product;

public interface SearchService {

	public List <Item> findItemsByName ( String itemName );
	public List <Item> findItemsByManufactureNumber ( String manufactureNumber );
	public List <Item> findItemsByManufacture ( String manufacture );
	public List <Item> findItemsByDescription ( String description );
	public List <Item> findItemsByBarCode ( String barCode );
	
	public List <Product> findProdactByName ( String name );
}
