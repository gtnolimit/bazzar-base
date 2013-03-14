package com.bazzar.base;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisShardInfo;

import com.bazzar.base.dao.ItemBatchDao;
import com.bazzar.base.dao.MenuDao;
import com.bazzar.base.dao.redis.ItemRepository;
import com.bazzar.base.job.batch.ImportItemJob;
import com.bazzar.base.job.batch.Job;
import com.bazzar.base.message.redis.RedisMessageListener;

@Configuration
// @EnableScheduling
public class AppConfig {

	@Value(value = "${redis.host}")
	private String redisHost;

	@Value(value = "${redis.port}")
	private String redisPort;

	@Value(value = "${redis.pass}")
	private String redisPassword;

	@Value(value = "${redis.pool}")
	private Boolean redisPool;

	@Value(value = "${redis.on}")
	private Boolean redisOn;

	@Autowired
	ItemBatchDao itemBatchDao;

	@Autowired
	MenuDao menuDao;

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = null;
		if (redisOn) {
			jedisConnectionFactory = new JedisConnectionFactory(
			        new JedisShardInfo(redisHost, redisPort));
			if (StringUtils.isNotBlank(redisPassword)) {
				jedisConnectionFactory.setPassword(redisPassword);
			}
			jedisConnectionFactory.setUsePool(true);
		}
		return jedisConnectionFactory;
	}

	@Bean
	RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = null;
		if (redisOn) {
			template = new RedisTemplate<String, Object>();
			template.setConnectionFactory(jedisConnectionFactory());
			template.setKeySerializer(new StringRedisSerializer());
			template.setHashValueSerializer(new GenericToStringSerializer<Object>(
			        Object.class));
			template.setValueSerializer(new GenericToStringSerializer<Object>(
			        Object.class));
		}
		return template;
	}

	@Bean
	ItemRepository itemRepository() {
		return new ItemRepository(redisTemplate());
	}

	@Bean
	Job importItemJob() {
		return new ImportItemJob(itemRepository(), itemBatchDao, menuDao);
	}

	@Bean
	MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(new RedisMessageListener(
		        itemRepository(), importItemJob()));
	}

	@Bean
	RedisMessageListenerContainer redisContainer() {
		final RedisMessageListenerContainer container = new RedisMessageListenerContainer();

		if (redisOn) {
			container.setConnectionFactory(jedisConnectionFactory());
			container.addMessageListener(messageListener(), topic());
		}

		return container;
	}

	@Bean
	ChannelTopic topic() {
		return new ChannelTopic("pubsub:queue");
	}
}