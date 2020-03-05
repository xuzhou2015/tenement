package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;




@Getter
@Setter
public class BrokerReq implements Serializable {



    @NotBlank
    private String brokerName;

    @NotBlank
    private String brokerPhone;

    @NotNull
    private Double rank;

    @NotNull
    private Double roomGoal;

    @NotNull
    private Double serviceGoal;

    @NotNull
    private Double evaluateGoal;

    @NotBlank
    private String companyName;

    @NotBlank
    private String shopName;

    @NotBlank
    private String cardNumber;

    @NotBlank
    private String companyCode;


}
