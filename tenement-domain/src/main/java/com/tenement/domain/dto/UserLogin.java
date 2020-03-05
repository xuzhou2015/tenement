package com.tenement.domain.dto;





import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;


@Getter
@Setter
public class UserLogin implements Serializable {


    /**
     * 用户登陆名
     */
    @NotBlank
    private String userName;

    /**
     * 密码
     */
    @NotBlank
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 用户名
     */
    private String trueName;

    /**
     *用户类型(1:普通用户，2：后台用户)
     */
    private Integer roleType;



}
