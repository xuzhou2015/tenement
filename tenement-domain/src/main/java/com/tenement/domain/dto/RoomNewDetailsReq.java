package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class RoomNewDetailsReq implements Serializable {

    //@Max(value = 20,message = "最大长度为20")
    private Integer id;

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

    private Date saleDate;

    private Date finishedDate;

    private Byte housestyleStyle;

    private Byte finishType;

    private Integer districtid;

    private Byte heatingTyte;

    private Integer housePrice;

    private Integer equityTime;

    private Integer priceTotal;

    private Integer userid;

    private Date creatime;

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
