package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;




@Getter
@Setter
public class BrokerReq implements Serializable {



    private Integer id;

    private String brokerName;


    private String brokerPhone;


    private Double rank;


    private Double roomGoal;


    private Double serviceGoal;


    private Double evaluateGoal;


    private String companyName;


    private String shopName;


    private String cardNumber;


    private String companyCode;

    private String userPhoto;

    private String wx;

    private Integer creationUserid;

    private String creationName;




}
