package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomOrientation;

import java.util.List;

public interface RoomOrientationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoomOrientation record);

    int insertSelective(RoomOrientation record);

    RoomOrientation selectByPrimaryKey(Long id);

    List<RoomOrientation> selectByPrimaryList();

    int updateByPrimaryKeySelective(RoomOrientation record);

    int updateByPrimaryKey(RoomOrientation record);
}