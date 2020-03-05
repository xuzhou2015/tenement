package com.tenement.service.api;

import com.tenement.domain.po.RoomArea;

import java.util.List;

public interface RoomAreaService {

    List<RoomArea> selectByPrimaryKey(Long areaId);
}
