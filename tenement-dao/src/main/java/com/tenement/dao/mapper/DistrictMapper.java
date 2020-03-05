package com.tenement.dao.mapper;

import com.tenement.domain.po.District;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer districtid);

    int insert(District record);

    int insertSelective(District record);

    District selectByPrimaryKey(Integer districtid);

   List<District> selectByPrimaryList(@Param("parentid") Integer parentid);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);
}