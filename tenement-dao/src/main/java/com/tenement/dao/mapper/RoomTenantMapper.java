package com.tenement.dao.mapper;

import com.tenement.domain.exmple.TenantRoomExmple;
import com.tenement.domain.po.RoomTenant;

import java.util.List;

public interface RoomTenantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomTenant record);

    int insertSelective(RoomTenant record);

    RoomTenant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RoomTenant record);

    int updateByPrimaryKey(RoomTenant record);

   List<RoomTenant> selectByList(TenantRoomExmple exmple);
}