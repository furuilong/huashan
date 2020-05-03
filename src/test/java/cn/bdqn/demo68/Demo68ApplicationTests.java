package cn.bdqn.demo68;

import cn.bdqn.demo68.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Demo68ApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;  //操作k-v都是字符串的

    @Autowired
    RedisTemplate redisTemplate;//k-v都是对象的



  RedisTemplate<Object, User> userredisTemplate;


    @Test
    void contextLoads() {
//        stringRedisTemplate.opsForValue() ;//字符串
//        stringRedisTemplate.opsForList(); //list列表
//        stringRedisTemplate.opsForSet();//Set集合
//        stringRedisTemplate.opsForHash(); //Hash(散列)
//        stringRedisTemplate.opsForZSet(); //有序集合

//    stringRedisTemplate.opsForValue().append("msg","hello");
//   String msg= stringRedisTemplate.opsForValue().get("msg");
//    System.out.println(msg);
//       stringRedisTemplate.opsForList().leftPush("mylist","1");
//       stringRedisTemplate.opsForList().leftPush("mylist","2");

      //  userredisTemplate.opsForValue().set("emp-01","创建的id");

    }

}
