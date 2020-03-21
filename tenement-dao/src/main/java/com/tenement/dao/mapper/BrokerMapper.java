package com.tenement.dao.mapper;

import com.tenement.domain.dto.BrokerExmple;
import com.tenement.domain.po.Broker;

import java.util.List;

public interface BrokerMapper {
    int deleteByPrimaryKey(Integer brokerId);

    int insert(Broker record);

    int insertSelective(Broker record);

    Broker selectByPrimaryKey(BrokerExmple exmple);

    List<Broker> selectByPrimaryList(BrokerExmple exmple);

    int updateByPrimaryKeySelective(Broker record);

    int updateByPrimaryKey(Broker record);
}