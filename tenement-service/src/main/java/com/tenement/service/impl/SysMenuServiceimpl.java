package com.tenement.service.impl;

import com.tenement.dao.mapper.SysMenuMapper;
import com.tenement.domain.po.SysMenu;
import com.tenement.service.api.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceimpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> selectByMenuList(Integer roleId) {

        return sysMenuMapper.selectByMenuList(roleId);
    }
}
