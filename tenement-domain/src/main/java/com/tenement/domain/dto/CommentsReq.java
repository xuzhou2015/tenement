package com.tenement.domain.dto;

import com.tenement.domain.common.CustomConverting;
import com.tenement.domain.common.DateConverter;
import lombok.Getter;
import lombok.Setter;


/**
 * @author 徐周
 * @date ：Created in 2020-04-07 13:06
 * @description：2
 * @version: 1
 */
@Getter
@Setter
public class CommentsReq {

    private Integer id;

    private Integer uid;

    private Integer newhouseid;

    private Integer usedhouseid;

    private Integer rentinghouseid;

    private String content;



    private Integer top;

    private Integer answeruid;



    private String answercontent;

    private Integer down;

    private Integer type=0;


    private String answername;

    private String username;




    /**
     * 当时查询页数
     */
    private Integer pageNum=1;

    /**
     * 每页显示条数
     */
    private Integer pageSize=10;

}
