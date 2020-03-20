package com.tenement.domain.dto;

import com.tenement.domain.common.CustomConverting;
import com.tenement.domain.common.DateConverter;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RoomNewDetailsResp {
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

    private Byte districtid;

    private Byte heatingTyte;

    private Integer housePrice;

    private Integer equityTime;

    private Integer priceTotal;

    private Integer userid;

    private Date creatime;

    private Byte deleteYn;

    private Integer houseArea;
}
