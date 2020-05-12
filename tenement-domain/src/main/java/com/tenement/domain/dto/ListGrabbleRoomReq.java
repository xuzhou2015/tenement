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
    private Integer pageNum=1;

    /**
     * 每页显示条数
     */
    private Integer pageSize=10;

    /**
     * 地区ID
     */
    private Integer districtid;

    /**
     * 小区名称
     */
    private String name;


    /**
     *总价
     */
    private String priceTotal;


    private Integer priceMin;

    private Integer priceMax;

    /**
     *面积
     */
    private String houseArea;

    private Integer houseAreaMin;

    private Integer houseAreaMax;

    /**
     *房型
     */
    private String houseStyles;

    /**
     * 是否近地铁
     */
    private Integer metroYn;

    /**
     * 近学校
     */
    private Integer schoolYn;

    /**
     * 是否有电梯
     */
    private Integer elevatorYn;

    /**
     * 安选验真
     */
    private Integer  safetyYn;

    /**
     * 物业类型
     */
    private Integer managementType;

    /**
     * 楼盘状态
     */
    private Integer status;

    /**
     * 产权年限
     */
    private Integer equityTime;
}
