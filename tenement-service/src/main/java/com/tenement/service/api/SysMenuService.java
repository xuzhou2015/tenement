package com.tenement.service.api;

import com.tenement.domain.po.SysMenu;

import java.util.List;

public interface SysMenuService {

    List<SysMenu> selectByMenuList(Integer roleId);
}
