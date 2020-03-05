package com.tenement.domain.vo;

import com.tenement.domain.po.SysUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SysUserVo extends SysUser {

    private Integer roleId;
}
