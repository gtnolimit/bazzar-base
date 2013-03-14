package com.bazzar.base.services;

import java.util.List;

import net.sf.json.JSONObject;

import com.bazzar.base.domain.item.Item;

public interface ItemService {

	public List <Item> getAllItems ( );
	public Item getItemQuestions ( Long id );
	public Item getItemReviews ( Long id );
	public Item getItemAccessories ( Long id );
	public Item getItem ( Long id );
	
	public void editItem ( Item item );
	public Long addItem ( Item item );
	public void delete ( Long id );
	public void delete ( Item item );

	public Long importItems(JSONObject json);
	public JSONObject validateImportItemRequest(String json);
}
