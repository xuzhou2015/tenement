package com.tenement.domain.dto;

import com.tenement.domain.common.CustomConverting;
import com.tenement.domain.common.DateConverter;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 徐周
 * @date ：Created in 2020-10-13 15:45
 * @description：1
 * @version: 1
 */
@Getter
@Setter
public class TenantRoomResp implements Serializable {

    private Integer id;

    private String name;

    private String address;

    private Integer price;

    private Integer rentStyle;

    private Integer houseStyle;

    private Integer houseDirection;

    private String listPicture;

    private String housePicture;

    private Integer deposit;

    private Integer serviceCost;

    private Integer introductCost;

    private Integer payment;

    private Integer brokerId;

    private String telephone;

    private Integer managementType;

    private Integer fitmentStatus;

    private Integer area;

    private Integer floor;

    private Integer carNum;

    private Integer usePower;

    private Integer getHot;

    private Integer metroYn;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private Date rentStartLimit;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private Date rentEndtLimit;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private Date lookTime;

    private Integer elevator;

    private Integer useWater;

    private Integer fire;

    private String supportingFacilities;

    private String houseDescription;

    private String aboutHouse;

    private Integer mustbeLook;

    private Integer userid;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private Date creatime;

    private Integer deleteYn;
}
