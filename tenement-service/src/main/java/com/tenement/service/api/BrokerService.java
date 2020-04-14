package com.tenement.service.api;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.dto.BrokerExmple;
import com.tenement.domain.dto.BrokerReq;
import com.tenement.domain.dto.BrokerResp;
import com.tenement.domain.dto.RespId;
import com.tenement.domain.po.Broker;

import java.util.List;

public interface BrokerService {

    RespId addBroker(BrokerReq record);

    PageInfo<BrokerResp> listBroker(BrokerExmple brokerExmple);

    BrokerResp getBroker(BrokerExmple brokerExmple);

     boolean updateBroker(Broker req);

    boolean deleteBroker(Integer brokerId);
}
