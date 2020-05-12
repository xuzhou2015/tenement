package com.tenement.dao.mapper;

import com.tenement.domain.po.VisitLog;

public interface VisitLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VisitLog record);

    int insertSelective(VisitLog record);

    VisitLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VisitLog record);

    int updateByPrimaryKey(VisitLog record);
}