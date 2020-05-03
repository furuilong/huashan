package cn.bdqn.demo68.mapper;

import cn.bdqn.demo68.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author furuilong
 * @since 2020-02-14
 */
@Component
public interface UserMapper extends MyBaseMapper<User> {



}
