package com.bazzar.base.job.batch.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.RecursiveTask;

import com.bazzar.base.dao.ItemBatchDao;
import com.bazzar.base.dao.MenuDao;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.domain.menu.Category;
import com.bazzar.base.domain.menu.Product;
import com.bazzar.base.domain.menu.SubCategory;

public class SplitItemTask extends RecursiveTask<Map<String, List<Item>>> {
	private final CsvToItem csvToItem;
	private final ItemBatchDao itemBatchDao;
	private final MenuDao menuDao;

	SplitItemTask(CsvToItem csvToItem, ItemBatchDao itemBatchDao,
	        MenuDao menuDao) {
		super();
		this.csvToItem = csvToItem;
		this.itemBatchDao = itemBatchDao;
		this.menuDao = menuDao;
	}

	@Override
	protected Map<String, List<Item>> compute() {
		Map<String, List<Item>> items = csvToItem.getItems();
		for (Entry<String, List<Item>> entry : items.entrySet()) {
			List<String> keys = Arrays.asList(entry.getKey().split(","));
			if (keys.size() > 2) {
				Product product = null;
				Category category = menuDao.getCategoryByAttribute(keys.get(0));
				if (category == null) {
					product = new Product();
					product.setAttribute(keys.get(2));
					product.setActive(true);
					SubCategory subCategory = new SubCategory();
					subCategory.setAttribute(keys.get(1));
					subCategory.setActive(true);
					subCategory.getProduct().add(product);
					category = new Category();
					category.setAttribute(keys.get(0));
					category.setActive(true);
					category.getSubCategory().add(subCategory);
					menuDao.add(category);
				} else {
					SubCategory subCategory = menuDao.findSubCategoryChild(
					        keys.get(0), keys.get(1));
					if (subCategory == null) {
						product = new Product();
						product.setAttribute(keys.get(2));
						product.setActive(true);
						subCategory = new SubCategory();
						subCategory.setAttribute(keys.get(1));
						subCategory.setActive(true);
						subCategory.getProduct().add(product);
						category.getSubCategory().add(subCategory);
						menuDao.edit(category);
					} else {
						product = menuDao.findProductChild(keys.get(0),
						        keys.get(1), keys.get(2));
						if (product == null) {
							product = new Product();
							product.setAttribute(keys.get(2));
							product.setActive(true);
							subCategory.getProduct().add(product);
							menuDao.edit(subCategory);
						}
					}
				}

				product = menuDao.findProductChild(keys.get(0), keys.get(1),
				        keys.get(2));
				itemBatchDao.batchInsert(entry.getValue(), product);
			}
		}

		return items;
	}
}
