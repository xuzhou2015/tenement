package com.tenement.domain.exmple;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserExmple implements Serializable {


    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
}
