package com.tenement.service.api;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.dto.*;
import com.tenement.domain.po.RoomDetails;
import com.tenement.domain.po.RoomNewDetails;
import com.tenement.domain.vo.RoomDetailsInfo;


public interface RoomDetailsService {

    int insertSelective(RoomNewDetailsReq record);

    RoomBasicsTypeResp getRoomBasicsType();

    PageInfo<RoomNewDetails> listRoom(ListRoomDetailsReq req);

    PageInfo<RoomDetailsInfo> listGrabbleRoom(ListGrabbleRoomReq req);

    GetRoomDetailsResp getRoomDetails(Long roomId);
}
