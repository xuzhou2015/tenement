package com.tenement.domain.dto;

import com.tenement.domain.common.CustomConverting;
import com.tenement.domain.common.DateConverter;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class RoomNewDetailsResp implements Serializable {
    private Long id;

    private String name;

    private String title;

    private String img;

    private Byte managementType;

    private String address;

    private Integer buildArea;

    private Byte status;

    private String telephone;

    private Byte metroYn;

    private Byte schoolYn;

    private Byte elevatorYn;

    private Byte safetyYn;

    private Byte trafficYn;

    private Byte businessYn;

    private String houseStyle;

    private Integer buildDate;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private String saleDate;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private String finishedDate;

    private Byte housestyleStyle;

    private Byte finishType;

    private Integer districtid;

    private Byte heatingTyte;

    private Integer housePrice;

    private Integer equityTime;

    private Integer priceTotal;

    private Integer userid;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private Date creatime;

    private Byte deleteYn;

    private Integer houseArea;

    private Integer brokerid;

    private String swiperPhoto;

    private String houseStylePhoto;

    private Integer homePage;

    private Integer hotRecommend;

    private Integer guessLike;

    private Double managementPrice;

    private String management;

    private String greenPoint;

    private Integer personNum;

    private Integer carNum;

    private String projectAdvantage;
}
