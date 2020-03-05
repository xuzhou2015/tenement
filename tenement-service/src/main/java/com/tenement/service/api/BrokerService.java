package com.tenement.service.api;

import com.tenement.domain.dto.BrokerExmple;
import com.tenement.domain.dto.BrokerReq;
import com.tenement.domain.po.Broker;

import java.util.List;

public interface BrokerService {

    int addBroker(BrokerReq record);

    List<Broker> listBroker(BrokerExmple brokerExmple);
}
