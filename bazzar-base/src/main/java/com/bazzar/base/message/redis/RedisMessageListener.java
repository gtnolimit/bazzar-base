package com.bazzar.base.message.redis;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import com.bazzar.base.dao.redis.ItemRepository;
import com.bazzar.base.job.batch.Job;

public class RedisMessageListener implements MessageListener {

	private ItemRepository itemRepository;
	private Job importItemJob;

	public RedisMessageListener(ItemRepository itemRepository, Job importItemJob) {
		this.itemRepository = itemRepository;
		this.importItemJob = importItemJob;
	}

	@Override
	public void onMessage(Message jobId, byte[] pattern) {
		importItemJob.execute(itemRepository.getJob(Long.valueOf(jobId
		        .toString())));
	}

}