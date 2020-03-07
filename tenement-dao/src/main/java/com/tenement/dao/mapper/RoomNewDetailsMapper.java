package com.tenement.dao.mapper;

import com.tenement.domain.dto.ListRoomDetailsReq;
import com.tenement.domain.po.RoomNewDetails;

import java.util.List;

public interface RoomNewDetailsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoomNewDetails record);

    int insertSelective(RoomNewDetails record);

    RoomNewDetails selectByPrimaryKey(Long id);

    List<RoomNewDetails> selectByPrimaryList(ListRoomDetailsReq req);

    int updateByPrimaryKeySelective(RoomNewDetails record);

    int updateByPrimaryKey(RoomNewDetails record);
}