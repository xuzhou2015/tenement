package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ListGrabbleRoomReq implements Serializable {


    /**
     * 当时查询页数
     */
    private Integer pageNum;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    private Integer districtid;

    private String searchKey;

    private String roomName;

    private String ownerarea;
}
