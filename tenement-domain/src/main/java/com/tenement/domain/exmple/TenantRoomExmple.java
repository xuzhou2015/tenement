package com.tenement.domain.exmple;

import com.tenement.domain.dto.Page;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 徐周
 * @date ：Created in 2020-10-13 16:15
 * @description：1
 * @version: 1
 */
@Getter
@Setter
public class TenantRoomExmple extends Page implements Serializable {

    private Integer id;

    private String name;

    private Integer deleteYn;


}
