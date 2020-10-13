package com.tenement.api.controller;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.common.Response;
import com.tenement.domain.dto.ListTwoRoomReq;
import com.tenement.domain.dto.RoomTwoReq;
import com.tenement.domain.dto.RoomTwoResp;
import com.tenement.domain.dto.TenantRoomResp;
import com.tenement.domain.exmple.TenantRoomExmple;
import com.tenement.domain.po.RoomTenant;
import com.tenement.domain.util.ResponseUtils;
import com.tenement.domain.vo.SysUserVo;
import com.tenement.service.api.RoomTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 徐周
 * @date ：Created in 2020-10-13 15:42
 * @description：1
 * @version: 1
 */
@RestController
@RequestMapping("/house/tenantRoom")
public class RoomTenantController {


    @Autowired
    private RoomTenantService roomTenantService;

    /**
     * 新增租房信息
     * @param request
     * @param req
     * @return
     * @throws BusinessException
     */
    @RequestMapping("/addTenantRoom")
    public Response addTenantRoom(HttpServletRequest request, @RequestBody RoomTenant req)throws BusinessException{
        HttpSession session = request.getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
            throw new BusinessException(CommonResultCode.LONING);
        }
        req.setUserid(sysUserVo.getId());
        roomTenantService.insertSelective(req);
        return ResponseUtils.createSuccess();
    }
    /**
     * 租房信息列表
     * @param req
     * @return
     */
    @RequestMapping("/listTenantRoom")
    public Response<PageInfo<TenantRoomResp>> listTenantRoom(@RequestBody TenantRoomExmple req){

        PageInfo<TenantRoomResp> pageInfo=roomTenantService.selectByList(req);

        return ResponseUtils.createSuccess(pageInfo);
    }
    /**
     * 更新租房信息
     * @param req
     * @return
     */
    @RequestMapping("/updateTenantRoom")
    public Response updateTenantRoom(@RequestBody RoomTenant req){

        if(roomTenantService.updateByPrimaryKeySelective(req) > 0){

            return ResponseUtils.createSuccess();
        }
        return ResponseUtils.createFailure();
    }
    /**
     * 删除二手房信息
     * @param req
     * @return
     */
    @RequestMapping("/deleteTenantRoom")
    public Response deleteTenantRoom(@RequestBody TenantRoomExmple req){

        roomTenantService.deleteByPrimaryKey(req);

        return ResponseUtils.createSuccess();
    }
}
