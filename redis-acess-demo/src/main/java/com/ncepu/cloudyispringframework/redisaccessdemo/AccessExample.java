package com.ncepu.cloudyispringframework.redisaccessdemo;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.ncepu.cloudyispringframworkdemo.common.entity.User;

import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.params.SetParams;

public class AccessExample {
    @Autowired
    private RedisTemplate redisTemplate;

    public void addLink(String userId, URL url) {
        redisTemplate.opsForList().leftPush(userId, url.toExternalForm());
    }

    public void getDistributedLock() {
        redisTemplate.execute(new RedisCallback<String>() {
            public String doInRedis(RedisConnection connection) {
                // 使用spring提供的api
                connection.set("".getBytes(), "".getBytes());
                // 直接使用jedis的连接对象
                JedisCommands jedisCommands = (JedisCommands)connection.getNativeConnection();
                jedisCommands.set("", "", SetParams.setParams().ex(1).nx());
                return "";
            }
        });
    }


    public void testOpHash() {
        User user = new User("李白", "libai", "诗仙");
        HashOperations<String, String, User> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("key1", "value1", user);
//        hashOperations.put("key1", "value2", new Integer(1));
        User user1 = hashOperations.get("key1", "value1");
    }


}
