package com.tenement.service.api;


import com.tenement.domain.dto.UserLogin;
import com.tenement.domain.vo.SysUserVo;

public interface SysUserService {

    SysUserVo login(UserLogin req);

    boolean addUser(UserLogin userLogin);
}
