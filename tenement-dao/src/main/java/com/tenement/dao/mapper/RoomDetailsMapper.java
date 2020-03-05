package com.tenement.dao.mapper;

import com.tenement.domain.dto.ListGrabbleRoomReq;
import com.tenement.domain.dto.ListRoomDetailsReq;
import com.tenement.domain.po.RoomDetails;
import com.tenement.domain.vo.RoomDetailsInfo;

import java.util.List;

public interface RoomDetailsMapper {
    int deleteByPrimaryKey(Long roomId);

    int insert(RoomDetails record);

    int insertSelective(RoomDetails record);

    RoomDetails selectByPrimaryKey(Long roomId);

    List<RoomDetailsInfo> selectByPrimaryList(ListRoomDetailsReq req);

    List<RoomDetailsInfo> listGrabbleRoom(ListGrabbleRoomReq req);

    int updateByPrimaryKeySelective(RoomDetails record);

    int updateByPrimaryKey(RoomDetails record);
}