package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomMarket;

import java.util.List;

public interface RoomMarketMapper {
    int deleteByPrimaryKey(Integer marketTypeId);

    int insert(RoomMarket record);

    int insertSelective(RoomMarket record);

    List<RoomMarket> selectByPrimaryKey(Integer marketTypeId);

    int updateByPrimaryKeySelective(RoomMarket record);

    int updateByPrimaryKey(RoomMarket record);
}