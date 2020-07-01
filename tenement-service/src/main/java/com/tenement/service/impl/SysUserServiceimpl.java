package com.tenement.service.impl;

import com.tenement.dao.mapper.SysUserMapper;
import com.tenement.dao.mapper.SysUserRoleMapper;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.dto.UserLogin;
import com.tenement.domain.exmple.UserExmple;
import com.tenement.domain.po.SysUser;
import com.tenement.domain.po.SysUserRole;
import com.tenement.domain.vo.SysUserVo;
import com.tenement.service.api.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class SysUserServiceimpl implements SysUserService {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;


    /**
     * 登陆
     * @param req
     * @return
     */
    @Override
  //  @Cacheable(value = "SysUserVo",key="'usrid'+#req.userName",unless="#result == null")
    public SysUserVo login(UserLogin req) {

        UserExmple userExmple=new UserExmple();
        userExmple.setUserName(req.getUserName());
        userExmple.setPassword(req.getPassword());

        SysUserVo sysUserVo=sysUserMapper.selectByUserName(userExmple);
        return sysUserVo;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(UserLogin userLogin) {
        if(StringUtils.isEmpty(userLogin.getTrueName())){

            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }
        if(StringUtils.isEmpty(userLogin.getUserName())){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }
        if(StringUtils.isEmpty(userLogin.getPassword())){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }
        if(userLogin.getRoleType()==null || (userLogin.getRoleType() !=1 && userLogin.getRoleType() != 2)){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }

        UserExmple userExmple=new UserExmple();

        userExmple.setUserName(userLogin.getUserName());
        SysUserVo sysUserVo=sysUserMapper.selectByUserName(userExmple);
        if(sysUserVo !=null){
            throw new BusinessException(CommonResultCode.USER_REPETITION);
        }
        SysUser sysUser=new SysUser();
        sysUser.setTrueName(userLogin.getTrueName());
        sysUser.setPassword(userLogin.getPassword());
        sysUser.setUserName(userLogin.getUserName());
        sysUser.setCreateTime(new Date());
        sysUser.setUpdateTime(new Date());
        if(!StringUtils.isEmpty(userLogin.getPhone())){
            sysUser.setPhone(userLogin.getPhone());
        }

        sysUserMapper.insertSelective(sysUser);

        SysUserRole sysUserRole=new SysUserRole();
        if(userLogin.getRoleType()==1){
            sysUserRole.setRoleId(2);
        }else{
            sysUserRole.setRoleId(3);
        }
        sysUserRole.setUserId(sysUser.getId());
        sysUserRoleMapper.insertSelective(sysUserRole);

        return true;
    }
}
