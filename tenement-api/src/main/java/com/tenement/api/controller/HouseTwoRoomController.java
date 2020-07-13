package com.tenement.api.controller;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.common.Response;
import com.tenement.domain.dto.ListTwoRoomReq;
import com.tenement.domain.dto.RoomTwoReq;
import com.tenement.domain.dto.RoomTwoResp;
import com.tenement.domain.util.ResponseUtils;
import com.tenement.domain.vo.SysUserVo;
import com.tenement.service.api.RoomTwoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * @author 徐周
 * @date ：Created in 2020-05-21 17:29
 * @description：1
 * @version: 1
 */
@RestController
@RequestMapping("/house/twoRoom")
public class HouseTwoRoomController {

    @Autowired
    private RoomTwoDetailsService roomTwoDetailsService;

    /**
     * 新增二手房
     * @param request
     * @param req
     * @return
     * @throws BusinessException
     */
    @RequestMapping("/addTwoRoomDetails")
    public Response addTwoRoom(HttpServletRequest request, @RequestBody RoomTwoReq req)throws BusinessException{
        HttpSession session = request.getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
            throw new BusinessException(CommonResultCode.LONING);
        }
        req.setCreateUserid(sysUserVo.getId());
        roomTwoDetailsService.addTwoRoom(req);
        return ResponseUtils.createSuccess();
    }

    /**
     * 二手房列表
     * @param req
     * @return
     */
    @RequestMapping("/listTwoRoom")
    public Response<PageInfo<RoomTwoResp>> listTwoRoom(@RequestBody ListTwoRoomReq req){

      PageInfo<RoomTwoResp> pageInfo=roomTwoDetailsService.listTwoRoom(req);

        return ResponseUtils.createSuccess(pageInfo);
    }

    /**
     * 二手房详情
     * @param req
     * @return
     */
    @RequestMapping("/getTwoRoom")
    public Response<RoomTwoResp> getTwoRoom(@RequestBody RoomTwoReq req){

        RoomTwoResp roomTwoResp=roomTwoDetailsService.getTwoRoom(req);

        return ResponseUtils.createSuccess(roomTwoResp);
    }


    /**
     * 更新二手房信息
     * @param req
     * @return
     */
    @RequestMapping("/updateTwoRoom")
    public Response updateTwoRoom(@RequestBody RoomTwoReq req){

        if(roomTwoDetailsService.updateTwoRoom(req) > 0){

            return ResponseUtils.createSuccess();
        }
        return ResponseUtils.createFailure();
    }

    /**
     * 删除二手房信息
     * @param req
     * @return
     */
    @RequestMapping("/deleteTwoRoom")
    public Response deleteTwoRoom(@RequestBody RoomTwoReq req){

        roomTwoDetailsService.deleteTwoRoom(req);

        return ResponseUtils.createSuccess();
    }


}
