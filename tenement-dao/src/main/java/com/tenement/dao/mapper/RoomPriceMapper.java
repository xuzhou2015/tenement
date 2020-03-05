package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomPrice;

import java.util.List;

public interface RoomPriceMapper {
    int deleteByPrimaryKey(Long priceId);

    int insert(RoomPrice record);

    int insertSelective(RoomPrice record);

    RoomPrice selectByPrimaryKey(Long priceId);

    List<RoomPrice> selectByPrimaryList();

    int updateByPrimaryKeySelective(RoomPrice record);

    int updateByPrimaryKey(RoomPrice record);
}