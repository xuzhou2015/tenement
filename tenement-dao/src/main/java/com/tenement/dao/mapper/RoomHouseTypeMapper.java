package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomHouseType;

import java.util.List;

public interface RoomHouseTypeMapper {
    int deleteByPrimaryKey(Long houseTypeId);

    int insert(RoomHouseType record);

    int insertSelective(RoomHouseType record);

    RoomHouseType selectByPrimaryKey(Long houseTypeId);

   List<RoomHouseType> selectByPrimaryList();

    int updateByPrimaryKeySelective(RoomHouseType record);

    int updateByPrimaryKey(RoomHouseType record);
}