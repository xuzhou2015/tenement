package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BrokerExmple implements Serializable {

    private Integer brokerId;

    private String brokerName;
}
