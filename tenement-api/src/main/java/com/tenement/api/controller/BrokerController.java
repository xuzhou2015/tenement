package com.tenement.api.controller;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.common.Response;
import com.tenement.domain.dto.BrokerExmple;
import com.tenement.domain.dto.BrokerReq;
import com.tenement.domain.dto.BrokerResp;
import com.tenement.domain.dto.RespId;
import com.tenement.domain.po.Broker;
import com.tenement.domain.util.ResponseUtils;
import com.tenement.domain.vo.SysUserVo;
import com.tenement.service.api.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequestMapping("/house/broker")
@RestController
public class BrokerController {

    @Autowired
    private BrokerService brokerService;

    /**
     * 新增经济人
     *
     * @param req
     * @return
     */
    @RequestMapping("/addBroker")
    public Response<RespId> addBroker(HttpServletRequest request,@RequestBody BrokerReq req) throws BusinessException {

        HttpSession session = request.getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
            throw new BusinessException(CommonResultCode.LONING);
        }
        req.setCreationUserid(sysUserVo.getId());
        req.setCreationName(sysUserVo.getUserName());

        RespId respId=brokerService.addBroker(req);

        return ResponseUtils.createSuccess(respId);
    }

    /**
     * 查询经济人列表
     *
     * @param brokerExmple
     * @return
     */
    @RequestMapping("/listBroker")
    public Response<PageInfo<BrokerResp>> listBroker(HttpServletRequest request,@RequestBody BrokerExmple brokerExmple) throws BusinessException {

        PageInfo<BrokerResp> brokerList = brokerService.listBroker(brokerExmple);

        return ResponseUtils.createSuccess(brokerList);
    }

    /**
     * 查询经济人详情
     *
     * @param brokerExmple
     * @return
     */
    @RequestMapping("/getBroker")
    public Response<BrokerResp> getBroker(HttpServletRequest request,@RequestBody BrokerExmple brokerExmple) throws BusinessException {

        BrokerResp brokerResp = brokerService.getBroker(brokerExmple);

        return ResponseUtils.createSuccess(brokerResp);
    }

    /**
     * 修改经济人信息
     *
     * @param req
     * @return
     */
    @RequestMapping("/updateBroker")
    public Response updateBroker(HttpServletRequest request,@RequestBody Broker req) throws BusinessException {

        boolean bool = brokerService.updateBroker(req);
        if (bool) {
            return ResponseUtils.createSuccess();
        }

        return ResponseUtils.createFailure();
    }

    /**
     * 删除经济人信息
     *
     * @param brokerExmple
     * @return
     */
    @RequestMapping("/deleteBroker")
    public Response deleteBroker(HttpServletRequest request,@RequestBody BrokerExmple brokerExmple) throws BusinessException{

        boolean bool = brokerService.deleteBroker(brokerExmple.getId());
        if (bool) {
            return ResponseUtils.createSuccess();
        }

        return ResponseUtils.createFailure();
    }


}
