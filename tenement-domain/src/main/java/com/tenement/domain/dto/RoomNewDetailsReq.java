package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class RoomNewDetailsReq implements Serializable {

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

    private Byte districtid;

    private Byte heatingTyte;

    private Integer housePrice;

    private Integer equityTime;

    private Integer priceTotal;

    private Integer userid;

    private Date creatime;

    private Integer houseArea;


}
