package com.tenement.service.impl;

import com.tenement.dao.mapper.VisitLogMapper;
import com.tenement.domain.po.VisitLog;
import com.tenement.service.api.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 徐周
 * @date ：Created in 2020-04-19 16:18
 * @description：1
 * @version: 1
 */
@Service
public class VisitLogServiceimpl implements VisitLogService {

    @Autowired
    private VisitLogMapper visitLogMapper;

    @Override
    public int insertSelective(VisitLog record) {
        return visitLogMapper.insertSelective(record);
    }
}
