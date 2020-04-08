package com.tenement.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 徐周
 * @date ：Created in 2020-04-07 17:12
 * @description：2
 * @version: 1
 */
@Getter
@Setter
public class CommentsExmple implements Serializable {

    private Integer newhouseid;

    private Integer usedhouseid;

    private Integer rentinghouseid;
}
