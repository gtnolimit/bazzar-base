package com.bazzar.base.job.batch.parallel;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.io.dozer.ICsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.bazzar.base.domain.item.Item;

public class CsvToItem {

	public static final String IMPORT_ITEM_DOWNLOAD_URL = "importItemDownlaodUrl";

	final String[] partialFieldMapping = new String[] { "id", "category",
	        "subCategory", "product", "subject", "description",
	        "specialOfferPrice", "specialPriceStart", "specialPriceEnd",
	        "specialPriceActive", "salePrice", "listedPrice", "quantity",
	        "rebate", "inStock", "manufactureModelNumber", "barCode",
	        "pageLocator", "active" };

	final CellProcessor[] processors = new CellProcessor[] { new Optional(),
	        new Optional(), new Optional(), new Optional(), new Optional(),
	        new Optional(), new Optional(),
	        new Optional(new ParseDate("MM/dd/yyyy")),
	        new Optional(new ParseDate("MM/dd/yyyy")), new Optional(),
	        new Optional(), new Optional(), new Optional(), new Optional(),
	        new Optional(), new Optional(), new Optional(), new Optional(),
	        new Optional() };

	private final Map<String, List<Item>> items;
	private final List<String> linesItems;

	public CsvToItem(List<String> lineItems) {
		this.linesItems = lineItems;
		items = new HashMap<>();
	}

	public Map<String, List<Item>> getItems() {
		try (ICsvDozerBeanReader beanReader = new CsvDozerBeanReader(
		        new StringReader(StringUtils.join(linesItems, "\r")),
		        CsvPreference.STANDARD_PREFERENCE)) {

			beanReader.configureBeanMapping(Item.class, partialFieldMapping);

			Item item;
			while ((item = beanReader.read(Item.class, processors)) != null) {
				if (items.containsKey(item.getCategory() + ","
				        + item.getSubCategory() + "," + item.getProduct())) {
					items.get(
					        item.getCategory() + "," + item.getSubCategory()
					                + "," + item.getProduct()).add(item);
				} else {
					List<Item> itemList = new ArrayList<Item>();
					itemList.add(item);
					items.put(item.getCategory() + "," + item.getSubCategory()
					        + "," + item.getProduct(), itemList);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		return items;
	}

}
