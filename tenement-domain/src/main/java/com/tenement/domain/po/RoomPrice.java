package com.tenement.domain.po;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomPrice {
    private Long priceId;

    private String priceName;

    private Integer priceType;

    private Integer priceMin;

    private Integer priceMax;



}