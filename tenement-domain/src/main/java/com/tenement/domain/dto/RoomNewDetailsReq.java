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

    @NotBlank
    private String title;

    @NotBlank
    private String img;

    @NotNull
    private Byte managementTypmanagementtyp;

    @NotBlank
    private String address;

    @NotNull
    private Integer buildArea;

    @NotNull
    private Byte status;

    @NotNull
    private Byte metroYn;

    @NotNull
    private Byte schoolYn;

    @NotNull
    private Byte elevatorYn;

    @NotNull
    private Byte safetyYn;

    @NotNull
    private Byte trafficYn;

    @NotNull
    private Byte businessYn;

    @NotBlank
    private String huxing;

    @NotNull
    private Integer roomTime;

    @NotNull
    private Date kaipanTime;

    @NotNull
    private Date jiaofangTime;

    @NotNull
    private Byte housestyleType;

    @NotNull
    private Byte finishType;

    @NotNull
    private Byte districtid;

    @NotNull
    private Byte heatingTyte;

    @NotNull
    private Integer housePrice;

    @NotNull
    private Integer equityTime;

    @NotNull
    private Integer priceTotal;

    private Integer userid;

}
