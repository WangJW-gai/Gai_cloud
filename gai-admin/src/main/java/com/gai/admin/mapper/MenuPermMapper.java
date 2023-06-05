package com.gai.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gai.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuPermMapper extends BaseMapper<User> {

    List<String> selectListByUserId(Long userId);
}