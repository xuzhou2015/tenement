package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author 徐周
 * @date ：Created in 2020-07-13 15:12
 * @description：1
 * @version: 1
 */
@Getter
@Setter
public class ListTwoRoomReq extends Page implements Serializable {

    private String name;

    private Integer districtid;

    private String priceTotal;

    private Integer priceMin;

    private Integer priceMax;

    private String houseArea;

    private Integer houseAreaMin;

    private Integer houseAreaMax;

    private String bookLimit;


    private Integer hotRecommend;

    private String projectAdvantage;
}
