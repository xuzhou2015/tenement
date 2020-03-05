package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ListRoomDetailsReq implements Serializable {

    /**
     * 当时查询页数
     */
    private Integer pageNum;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 排序类型(1 价格正序，1 价格倒序,3 开盘时间正序，4 开盘时间倒序)
     */
    private Integer orderByType;

    /**
     * 城市ID
     */
    private Integer districtid;

    /**
     * 价格ID
     */
    private Integer roomPriceId;

    /**
     * 价格类型（1：单价格，2：总价）
     */
    private Integer roomPriceType;

    /**
     * 价格上显
     */
    private Integer roomPriceMax;

    /**
     * 价格下显
     */
    private Integer roomPriceMin;

    /**
     * 销售状态
     */
    private Integer roomMarketStatus;

    /**
     * 物业类型
     */
    private Integer roomTenementType;

    /**
     * 开盘时间类型
     */
    private Integer roomMarketTimeType;

    private LocalDate roomMarketTimeMin;

    private LocalDate roomMarketTimeMax;

    /**
     * 装修类型
     */
    private Integer roomDecorationType;

    /**
     * 面积
     */
    private Integer roomAreaId;

    private Integer roomAreaMax;

    private Integer roomAreaMin;



}
