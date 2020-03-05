package com.tenement.service.impl;

import com.tenement.dao.mapper.DistrictMapper;
import com.tenement.domain.po.District;
import com.tenement.service.api.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceimpl implements DistrictService {

    @Autowired
    private DistrictMapper districtMapper;
    @Override
    public List<District> selectByPrimaryList(Integer parentid) {
        return districtMapper.selectByPrimaryList(parentid);
    }


}
