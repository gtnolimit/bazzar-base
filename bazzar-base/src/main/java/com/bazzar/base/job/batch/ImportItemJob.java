package com.bazzar.base.job.batch;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

import net.sf.json.JSONObject;

import com.bazzar.base.dao.ItemBatchDao;
import com.bazzar.base.dao.MenuDao;
import com.bazzar.base.dao.redis.ItemRepository;
import com.bazzar.base.job.batch.file.Document;
import com.bazzar.base.job.batch.parallel.CsvToItem;
import com.bazzar.base.job.batch.parallel.ImportItemTask;

public class ImportItemJob extends Job {

	ItemRepository itemRepository;
	ItemBatchDao itemBatchDao;
	MenuDao menuDao;

	public ImportItemJob(ItemRepository itemRepository,
	        ItemBatchDao itemBatchDao, MenuDao menuDao) {
		this.itemRepository = itemRepository;
		this.itemBatchDao = itemBatchDao;
		this.menuDao = menuDao;
	}

	private final ForkJoinPool forkJoinPool = new ForkJoinPool();

	@Override
	public void execute(Map<Object, Object> params) {
		JSONObject jobParams = JSONObject.fromObject(params.get("params"));
		try {
			forkJoinPool.invoke(new ImportItemTask(Document.fromFile(jobParams
			        .getString(CsvToItem.IMPORT_ITEM_DOWNLOAD_URL)),
			        itemBatchDao, menuDao));
		} catch (IOException e) {
			params.put("status", "error");
			itemRepository.updateJob(params);
			return;
		} catch (URISyntaxException e) {
			params.put("status", "error");
			itemRepository.updateJob(params);
			return;
		}
		params.put("status", "successful");
		itemRepository.updateJob(params);
	}
}
