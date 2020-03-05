package com.tenement.service.impl;

import com.tenement.dao.mapper.BrokerMapper;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.dto.BrokerExmple;
import com.tenement.domain.dto.BrokerReq;
import com.tenement.domain.po.Broker;
import com.tenement.service.api.BrokerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrokerServiceimpl implements BrokerService {

    @Autowired
    private BrokerMapper brokerMapper;

    /**
     * 新增经济人
     * @param record
     * @return
     */
    @Override
    public int addBroker(BrokerReq record) {


        Broker broker=new Broker();

        BeanUtils.copyProperties(record,broker);

        BrokerExmple brokerExmple=new BrokerExmple();
        brokerExmple.setBrokerName(record.getBrokerName());

        Broker brokers=brokerMapper.selectByPrimaryKey(brokerExmple);
        if(brokers==null){
            broker.setCareteTime(new Date());
            brokerMapper.insertSelective(broker);
            return 1;
        }

        throw new BusinessException(CommonResultCode.USER_REPETITION);

    }

    /**
     * 查询经济人列表
     * @param brokerExmple
     * @return
     */
    @Override
    public List<Broker> listBroker(BrokerExmple brokerExmple){

     // List<Broker> brokerList=brokerMapper.selectByPrimaryList(brokerExmple);

     // return brokerList;

        return null;
    }
}
