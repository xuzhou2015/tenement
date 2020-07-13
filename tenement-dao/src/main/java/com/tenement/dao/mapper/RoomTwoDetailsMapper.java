package com.tenement.dao.mapper;

import com.tenement.domain.dto.ListTwoRoomReq;
import com.tenement.domain.dto.RoomTwoReq;
import com.tenement.domain.po.RoomTwoDetails;

import java.util.List;

public interface RoomTwoDetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RoomTwoDetails record);

    int insertSelective(RoomTwoDetails record);

    RoomTwoDetails selectByPrimaryKey(Integer id);

    List<RoomTwoDetails> selectRoomTwolist(ListTwoRoomReq req);

    int updateByPrimaryKeySelective(RoomTwoDetails record);

    int updateByPrimaryKey(RoomTwoDetails record);
}