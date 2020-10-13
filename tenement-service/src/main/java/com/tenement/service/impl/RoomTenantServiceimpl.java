package com.tenement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenement.dao.mapper.RoomTenantMapper;
import com.tenement.domain.common.BeanUtils;
import com.tenement.domain.dto.RoomTwoResp;
import com.tenement.domain.dto.TenantRoomResp;
import com.tenement.domain.exmple.TenantRoomExmple;
import com.tenement.domain.po.RoomTenant;
import com.tenement.domain.po.RoomTwoDetails;
import com.tenement.service.api.RoomTenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 徐周
 * @date ：Created in 2020-10-13 15:50
 * @description：1
 * @version: 1
 */
@Service
public class RoomTenantServiceimpl implements RoomTenantService {

    @Autowired
    private RoomTenantMapper roomTenantMapper;
    @Override
    public int insertSelective(RoomTenant record) {

        record.setCreatime(new Date());
        return roomTenantMapper.insertSelective(record);
    }

    @Override
    public PageInfo<TenantRoomResp> selectByList(TenantRoomExmple exmple) {

        exmple.setDeleteYn(0);
        PageHelper.startPage(exmple.getPageNum(),exmple.getPageSize());


        List<RoomTenant> roomTenantList=roomTenantMapper.selectByList(exmple);
        if(roomTenantList !=null  && roomTenantList.size()>0){
            PageInfo<RoomTenant> pageInfos=new PageInfo<RoomTenant>(roomTenantList);
            long total=pageInfos.getTotal();
            int pagenum=pageInfos.getPageNum();
            int pagesize=pageInfos.getPageSize();

            List<TenantRoomResp> roomTwoRespList= BeanUtils.convertList(roomTenantList,TenantRoomResp.class);
            PageInfo<TenantRoomResp> pageInfo=new PageInfo<>(roomTwoRespList);
            pageInfo.setTotal(total);
            pageInfo.setPageNum(pagenum);
            pageInfo.setPageSize(pagesize);

            return pageInfo;

        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(RoomTenant record) {
        return roomTenantMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(TenantRoomExmple exmple) {
        return roomTenantMapper.deleteByPrimaryKey(exmple.getId());
    }
}
