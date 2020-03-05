package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomArea;

import java.util.List;

public interface RoomAreaMapper {
    int deleteByPrimaryKey(Long areaId);

    int insert(RoomArea record);

    int insertSelective(RoomArea record);

    List<RoomArea> selectByPrimaryKey(Long areaId);

    int updateByPrimaryKeySelective(RoomArea record);

    int updateByPrimaryKey(RoomArea record);
}