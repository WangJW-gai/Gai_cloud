package com.gai.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gai.security.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuPermMapper extends BaseMapper<SysUser> {

    List<String> selectListByUserId(Long userId);
}