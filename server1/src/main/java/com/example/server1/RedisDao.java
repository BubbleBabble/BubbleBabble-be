package com.example.server1;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisDao {

	private final RedisTemplate<String, Chat> redisTemplate;

	public RedisDao(RedisTemplate<String, Chat> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	public void setValues(String id, Chat chat) {
		ValueOperations<String, Chat> values = redisTemplate.opsForValue();
		values.set(id, chat);
	}

}