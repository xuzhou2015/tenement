package com.tenement.dao.mapper;

import com.tenement.domain.po.RoomTenementType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomTenementTypeMapper {
    int deleteByPrimaryKey(Integer tenementTypeId);

    int insert(RoomTenementType record);

    int insertSelective(RoomTenementType record);

    List<RoomTenementType> selectByPrimaryKey(@Param("tenementTypeId") Integer tenementTypeId);

    int updateByPrimaryKeySelective(RoomTenementType record);

    int updateByPrimaryKey(RoomTenementType record);
}