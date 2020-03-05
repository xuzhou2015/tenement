package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomDecorationType;

import java.util.List;

public interface RoomDecorationTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomDecorationType record);

    int insertSelective(RoomDecorationType record);

    RoomDecorationType selectByPrimaryKey(Integer id);

    List<RoomDecorationType> selectByPrimaryList();
    int updateByPrimaryKeySelective(RoomDecorationType record);

    int updateByPrimaryKey(RoomDecorationType record);
}