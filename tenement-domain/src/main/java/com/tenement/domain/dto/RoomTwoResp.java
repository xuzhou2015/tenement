package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 徐周
 * @date ：Created in 2020-05-23 14:12
 * @description：1
 * @version: 1
 */
@Getter
@Setter
public class RoomTwoResp implements Serializable {
    private Integer id;

    private String name;

    private Integer districtid;

    private String houseStyle;

    private Integer priceTotal;

    private Integer housePrice;

    private String address;

    private Integer houseArea;

    private Integer referencePay;

    private Integer buildDate;

    private String housePosition;

    private Integer referenceMonthPay;

    private String houseType;

    private Integer houseFloor;

    private Integer fitmentStatus;

    private Integer elevatorYn;

    private String bookLimit;

    private String equityType;

    private String heatingType;

    private String projectAdvantage;

    private String roomPhoto;

    private String houseStructural;

    private String listPhoto;

    private Integer brokerid;

    private Integer homePage;

    private Integer hotRecommend;

    private Integer guessLike;

    private String createDate;

    private Integer createUserid;

    private String telephone;


}
