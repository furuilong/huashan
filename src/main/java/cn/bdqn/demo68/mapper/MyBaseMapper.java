package cn.bdqn.demo68.mapper;

import cn.bdqn.demo68.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<User> {

    List<User> findAll();
}
