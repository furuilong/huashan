package cn.bdqn.demo68.service.impl;

import cn.bdqn.demo68.entity.User;
import cn.bdqn.demo68.mapper.UserMapper;
import cn.bdqn.demo68.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.*;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author furuilong
 * @since 2020-02-14
 */
@CacheConfig(cacheNames = "user")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;



    /**
     * @EnableCaching 第一步
     * Cacheable 第二步
     * 将方法运行结果缓存,以后要相同的数据，查询从缓存中获取，不用调用方法;
     * cacheManager管理多个Cache组件到底，对缓存的真正CRUD操作在Cache组件中，每一个的缓存组件都有自己唯一一个名字“
     * 几个属性:
     * cacheNames/value :指定缓存组件的名称;
     * key:缓存数据使用的key；可以用它来说指定;默认的使用方法参数的值 1方法的返回值 #id
     * keyGenercatot :key的生成器；可以自己指定可以的生成器的组件ID
     * key/keyGenerator: 二选一使用
     * cacheManager：指定缓存管理器;或者cacheResolver指定获取解析器
     * cobditon:指定符合条件的情况下才缓存；、
     * unless:否定缓存；当unless指定的条件为true 方法的返回就不会被缓存
     * uncess="#result ==null"
     * sync:是否使用异步模式
     */

}
