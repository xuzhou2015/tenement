package com.tenement.service.api;

import com.github.pagehelper.PageInfo;
import com.tenement.domain.dto.TenantRoomResp;
import com.tenement.domain.exmple.TenantRoomExmple;
import com.tenement.domain.po.RoomTenant;

import java.util.List;

/**
 * @author 徐周
 * @date ：Created in 2020-10-13 15:49
 * @description：1
 * @version: 1
 */
public interface RoomTenantService {

    int insertSelective(RoomTenant record);

    PageInfo<TenantRoomResp> selectByList(TenantRoomExmple exmple);

    int updateByPrimaryKeySelective(RoomTenant record);

    int deleteByPrimaryKey(TenantRoomExmple exmple);

}
