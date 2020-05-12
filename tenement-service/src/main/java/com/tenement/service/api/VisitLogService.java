package com.tenement.service.api;

import com.tenement.dao.mapper.VisitLogMapper;
import com.tenement.domain.po.VisitLog;

/**
 * @author 徐周
 * @date ：Created in 2020-04-19 16:17
 * @description：1
 * @version: 1
 */
public interface VisitLogService {

    int insertSelective(VisitLog record);
}
