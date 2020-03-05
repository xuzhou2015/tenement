package com.tenement.service.impl;

import com.tenement.dao.mapper.RoomAreaMapper;
import com.tenement.domain.po.RoomArea;
import com.tenement.service.api.RoomAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAreaServiceimpl implements RoomAreaService {

    @Autowired
    private RoomAreaMapper roomAreaMapper;
    @Override
    public List<RoomArea> selectByPrimaryKey(Long areaId) {
        return roomAreaMapper.selectByPrimaryKey(areaId);
    }
}
