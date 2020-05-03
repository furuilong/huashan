package cn.bdqn.demo68.config;

import cn.bdqn.demo68.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

@Configuration
public class MyRedisConfig {



//    @Bean
//    public  RedisTemplate<Object,User> userRedisTemplate(
//            RedisConnectionFactory redisConnectionFactory
//    )throws UnknownHostException {
//          RedisTemplate<Object, User> template=new RedisTemplate<>();
//          template.setConnectionFactory(redisConnectionFactory);
//        Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<User>(User.class);
//        template.setDefaultSerializer(serializer);
//          return  template;
//    }

//    @Bean
//    @Primary  //默认缓存管理器  必须得有默认
//    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, User> empRedisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(empRedisTemplate);
//        //key多了一个前缀
//
//        //使用前缀，默认把cacheName作为前缀
//        cacheManager.setUsePrefix(true);
//        return cacheManager;
//    }



}
