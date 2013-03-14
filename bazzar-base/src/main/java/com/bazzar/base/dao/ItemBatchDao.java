package com.bazzar.base.dao;

import java.util.List;

import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.menu.Product;

public interface ItemBatchDao {

	public void batchInsert(List<Item> items, Product product);
}
