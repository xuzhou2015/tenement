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
     * 小区名称
     */
    private String name;

    /**
     * 开盘查询开始时间
     */
    private String  beginSaleDate;


    /**
     * 开盘查询结束时间
     */
    private String endSaleDate;



    /**
     * 交房询开始时间
     */
    private String  beginFinishedDate;


    /**
     * 交房时间询结束时间
     */
    private String endFinishedDate;


    /**
     * 售楼状态
     */
    private Integer status;


    /**
     * 最小单价
     */
    private Integer minHousePrice;

    /**
     * 最大单价
     */
    private Integer maxHouserPrice;






}
