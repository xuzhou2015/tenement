package com.tenement.service.api;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.dto.*;
import com.tenement.domain.po.RoomNewDetails;
import com.tenement.domain.vo.RoomDetailsInfo;


public interface RoomDetailsService {

    RespId insertSelective(RoomNewDetailsReq record);

    RoomBasicsTypeResp getRoomBasicsType();

    PageInfo<RoomNewDetailsResp> listRoom(ListRoomDetailsReq req);

    PageInfo<RoomNewDetailsResp> listGrabbleRoom(ListGrabbleRoomReq req);

    RoomNewDetailsResp getRoomDetails(Long roomId);

     boolean deleteRoomNewDetails(Long id);

     boolean updateRoomNewDetails(RoomNewDetailsReq req);
}
