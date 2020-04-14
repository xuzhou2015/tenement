package com.tenement.domain.dto;

import com.tenement.domain.po.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class RoomBasicsTypeResp implements Serializable {

    //房型
    List<RoomHouseType> roomHouseTypeList;

    //面积
    List<RoomArea> roomAreaList;
    //价格
    List<RoomPrice> roomPriceList;

    //销售状态
    List<RoomMarket> roomMarketList;

    //物业类型表
    List<RoomTenementType> roomTenementTypeList;
    //开盘时间
    List<RoomMarketTime> roomMarketTimeList;

    //装修改类型
    List<RoomDecorationType> roomDecorationTypeList;

    //房型其它类型
    List<RoomOther> roomOtherList;

    List<RoomOrientation> roomOrientations;

}
