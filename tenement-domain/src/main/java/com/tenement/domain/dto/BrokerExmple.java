package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BrokerExmple implements Serializable {

    /**
     * 当时查询页数
     */
    private Integer pageNum=10;

    /**
     * 每页显示条数
     */
    private Integer pageSize=10;


    private Integer id;

    private String brokerName;

    private String brokerPhone;
}
