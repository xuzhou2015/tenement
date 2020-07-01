package com.tenement.service.api;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.dto.RoomTwoReq;
import com.tenement.domain.dto.RoomTwoResp;

/**
 * @author 徐周
 * @date ：Created in 2020-05-21 17:44
 * @description：1
 * @version: 1
 */
public interface RoomTwoDetailsService {

    int addTwoRoom(RoomTwoReq req);

    PageInfo<RoomTwoResp> listTwoRoom(RoomTwoReq req);

    RoomTwoResp getTwoRoom(RoomTwoReq req);

    int updateTwoRoom(RoomTwoReq req);

    int deleteTwoRoom(RoomTwoReq req);

}
