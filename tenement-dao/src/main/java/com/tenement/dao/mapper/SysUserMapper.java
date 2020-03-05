package com.tenement.dao.mapper;

import com.tenement.domain.exmple.UserExmple;
import com.tenement.domain.po.SysUser;
import com.tenement.domain.vo.SysUserVo;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    SysUserVo selectByUserName(UserExmple userExmple);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
}