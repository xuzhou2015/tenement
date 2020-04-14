package com.tenement.domain.dto;

import com.tenement.domain.common.CustomConverting;
import com.tenement.domain.common.DateConverter;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BrokerResp implements Serializable {

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

    private String userphoto;

    private String wx;

    private String companyCode;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private String creationTime;

    private Integer creationUserid;

    private String creationName;
}
