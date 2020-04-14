package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomOther;

import java.util.List;

public interface RoomOtherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoomOther record);

    int insertSelective(RoomOther record);

    RoomOther selectByPrimaryKey(Long id);

    List<RoomOther> selectByPrimaryList();

    int updateByPrimaryKeySelective(RoomOther record);

    int updateByPrimaryKey(RoomOther record);
}