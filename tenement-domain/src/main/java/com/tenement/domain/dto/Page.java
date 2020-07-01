package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 徐周
 * @date ：Created in 2020-05-23 11:17
 * @description：1
 * @version: 1
 */
@Setter
@Getter
public class Page {

    /**
     * 当时查询页数
     */
    private Integer pageNum=1;

    /**
     * 每页显示条数
     */
    private Integer pageSize=10;
}
