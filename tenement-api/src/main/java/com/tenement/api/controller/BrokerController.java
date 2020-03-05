package com.tenement.api.controller;

import com.tenement.domain.common.Response;
import com.tenement.domain.dto.BrokerExmple;
import com.tenement.domain.dto.BrokerReq;
import com.tenement.domain.po.Broker;
import com.tenement.domain.util.ResponseUtils;
import com.tenement.service.api.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/broker")
@RestController
public class BrokerController {

    @Autowired
    private BrokerService brokerService;

    /**
     * 新增经济人
     * @param req
     * @return
     */
    @RequestMapping("/addBroker")
    public Response addBroker(@RequestBody @Valid BrokerReq req){

        brokerService.addBroker(req);

        return ResponseUtils.createSuccess();
    }

    /**
     * 查询经济人列表
     * @param brokerExmple
     * @return
     */
    @RequestMapping("/listBroker")
    public Response<List<Broker>> listBroker(@RequestBody BrokerExmple brokerExmple){

        List<Broker> brokerList=brokerService.listBroker(brokerExmple);

        return ResponseUtils.createSuccess(brokerList);
    }


}
