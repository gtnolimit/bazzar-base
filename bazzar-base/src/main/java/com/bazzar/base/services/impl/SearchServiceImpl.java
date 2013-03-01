package com.bazzar.base.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.SearchDao;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.menu.Product;
import com.bazzar.base.services.SearchService;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchDao searchDao;
	
	public List<Item> findItemsByName(String itemName) {
		return searchDao.findItemsByName(itemName);
	}

	public List<Item> findItemsByManufactureNumber(String manufactureNumber) {
		return searchDao.findItemsByManufactureNumber(manufactureNumber);
	}

	public List<Item> findItemsByManufacture(String manufacture) {
		return searchDao.findItemsByManufacture(manufacture);
	}

	public List<Item> findItemsByDescription(String description) {
		return searchDao.findItemsByDescription(description);
	}

	public List<Item> findItemsByBarCode(String barCode) {
		return searchDao.findItemsByBarCode(barCode);
	}

	public List<Product> findProdactByName(String name) {
		return searchDao.findProductByName(name);
	}

}
