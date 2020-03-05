package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomFile;

import java.util.List;

public interface RoomFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomFile record);

    int insertSelective(RoomFile record);

    RoomFile selectByPrimaryKey(Integer id);

    List<RoomFile> selectByPrimaryList(Long roomId);

    int updateByPrimaryKeySelective(RoomFile record);

    int updateByPrimaryKey(RoomFile record);
}