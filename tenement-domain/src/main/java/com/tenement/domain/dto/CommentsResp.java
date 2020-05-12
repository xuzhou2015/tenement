package com.tenement.domain.dto;

import com.tenement.domain.common.CustomConverting;
import com.tenement.domain.common.DateConverter;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 徐周
 * @date ：Created in 2020-04-07 17:48
 * @description：2
 * @version: 1
 */
@Getter
@Setter
public class CommentsResp {

    private Integer id;

    private Integer uid;

    private Integer newhouseid;

    private Integer usedhouseid;

    private Integer rentinghouseid;

    private String content;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private String createtime;

    private Integer top;

    private Integer answeruid;

    @CustomConverting(value = DateConverter.class,parameter = "yyyy.MM.dd")
    private String answertime;

    private String answercontent;

    private Integer down;

    private String answername;

    private String username;

}
