package com.tenement.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenement.dao.mapper.BrokerMapper;
import com.tenement.domain.common.BeanUtils;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.dto.*;
import com.tenement.domain.po.Broker;
import com.tenement.domain.po.RoomNewDetails;
import com.tenement.service.api.BrokerService;
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
     *
     * @param record
     * @return
     */
    @Override
    public RespId addBroker(BrokerReq record) {


        RespId respId=new RespId();
        Broker broker = BeanUtils.convert(record, Broker.class);


        BrokerExmple brokerExmple = new BrokerExmple();
        brokerExmple.setBrokerName(record.getBrokerName());

        Broker brokers = brokerMapper.selectByPrimaryKey(brokerExmple);
        if (brokers == null) {
            broker.setCreationTime(new Date());
            brokerMapper.insertSelective(broker);
            if(broker.getId() !=null){
                respId.setId(broker.getId());
            }
            return respId;
        }
        throw new BusinessException(CommonResultCode.USER_REPETITION);

    }

    /**
     * 查询经济人列表
     *
     * @param brokerExmple
     * @return
     */
    @Override
    public PageInfo<BrokerResp> listBroker(BrokerExmple brokerExmple) {


        if (brokerExmple.getPageNum() == null || brokerExmple.getPageSize() == null) {
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }

        PageHelper.startPage(brokerExmple.getPageNum(), brokerExmple.getPageSize());

        List<Broker> brokerList = brokerMapper.selectByPrimaryList(brokerExmple);

        if (brokerList != null && brokerList.size() > 0) {

            PageInfo<Broker> pageInfos=new PageInfo<Broker>(brokerList);

            long total=pageInfos.getTotal();
            int pagenum=pageInfos.getPageNum();
            int pagesize=pageInfos.getPageSize();


            List<BrokerResp> brokerResps = BeanUtils.convertList(brokerList, BrokerResp.class);
            PageInfo<BrokerResp> pageInfo = new PageInfo<>(brokerResps);
            pageInfo.setTotal(total);
            pageInfo.setPageNum(pagenum);
            pageInfo.setPageSize(pagesize);

            return pageInfo;
        }

        return null;
    }

    /**
     * 查询经济人详情
     * @param brokerExmple
     * @return
     */
    @Override
    public BrokerResp getBroker(BrokerExmple brokerExmple){

        BrokerResp brokerResp=null;

        Broker broker=brokerMapper.selectByPrimaryKey(brokerExmple);
        if(broker !=null){

             brokerResp=BeanUtils.convert(broker,BrokerResp.class);

        }
        return brokerResp;

    }
    @Override
    public boolean updateBroker(Broker req){

        if(brokerMapper.updateByPrimaryKey(req) > 0){
            return true;
        }

        return false;

    }
    @Override
    public boolean deleteBroker(Integer brokerId){

        if(brokerMapper.deleteByPrimaryKey(brokerId) >0){

            return true;
        }
        return false;
    }
}
