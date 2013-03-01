package com.bazzar.base.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bazzar.base.dao.ItemDao;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;
	
	public List <Item> getAllItems ( ){
		return itemDao.getAllItems ( );
	}
	
	public Item getItemQuestions ( Long id ){
		return itemDao.getItemQuestions ( id );
	}
	
	public Item getItemReviews ( Long id ){
		return itemDao.getItemReview ( id );
	}
	
	public Item getItemAccessories ( Long id ){
		return itemDao.getItemAccessories ( id );
	}
	
	public Item getItem ( Long id ){
		return itemDao.getItem ( id );
	}

	public void editItem(Item item) {
		itemDao.editItem(item);
	}

	public Long addItem(Item item) {
		return itemDao.addItem(item);
	}

	public void delete(Long id) {
		itemDao.delete(id);
	}

	public void delete(Item item) {
		itemDao.delete(item);
	}
}
