package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomMarketTime;

import java.util.List;

public interface RoomMarketTimeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomMarketTime record);

    int insertSelective(RoomMarketTime record);

    RoomMarketTime selectByPrimaryKey(Integer id);

    List<RoomMarketTime>  selectByPrimaryList();

    int updateByPrimaryKeySelective(RoomMarketTime record);

    int updateByPrimaryKey(RoomMarketTime record);
}