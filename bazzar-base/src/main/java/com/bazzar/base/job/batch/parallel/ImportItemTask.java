package com.bazzar.base.job.batch.parallel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.RecursiveTask;

import com.bazzar.base.dao.ItemBatchDao;
import com.bazzar.base.dao.MenuDao;
import com.bazzar.base.domain.item.Item;
import com.bazzar.base.job.batch.file.Document;

public class ImportItemTask extends RecursiveTask<Map<String, List<Item>>> {
	private final Map<String, List<Item>> items = new HashMap<>();
	private final Document document;
	private final ItemBatchDao itemBatchDao;
	private final MenuDao menuDao;

	public ImportItemTask(Document document, ItemBatchDao itemBatchDao,
	        MenuDao menuDao) {
		super();
		this.document = document;
		this.itemBatchDao = itemBatchDao;
		this.menuDao = menuDao;
	}

	@Override
	protected Map<String, List<Item>> compute() {
		List<RecursiveTask<Map<String, List<Item>>>> forks = new LinkedList<>();
		int itemSize = document.getLines().size();
		for (int startIndex = 1, offset = 51000; startIndex < itemSize; startIndex += offset) {
			SplitItemTask task = new SplitItemTask(
			        new CsvToItem(
			                document.getLines()
			                        .subList(
			                                startIndex,
			                                (startIndex + offset) <= itemSize ? (startIndex + offset)
			                                        : itemSize)), itemBatchDao,
			        menuDao);
			forks.add(task);
			task.fork();
		}
		for (RecursiveTask<Map<String, List<Item>>> task : forks) {
			for (Entry<String, List<Item>> entry : task.join().entrySet()) {
				if (items.containsKey(entry.getKey())) {
					items.get(entry.getKey()).addAll(entry.getValue());
				} else {
					items.put(entry.getKey(), entry.getValue());
				}
			}
		}
		return items;
	}
}
