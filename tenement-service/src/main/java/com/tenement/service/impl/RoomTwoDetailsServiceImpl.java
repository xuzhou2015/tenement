package com.tenement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenement.dao.mapper.RoomTwoDetailsMapper;
import com.tenement.domain.common.BeanUtils;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.dto.RoomNewDetailsResp;
import com.tenement.domain.dto.RoomTwoReq;
import com.tenement.domain.dto.RoomTwoResp;
import com.tenement.domain.po.RoomNewDetails;
import com.tenement.domain.po.RoomTwoDetails;
import com.tenement.service.api.RoomTwoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 徐周
 * @date ：Created in 2020-05-21 18:14
 * @description：1
 * @version: 1
 */
@Service
public class RoomTwoDetailsServiceImpl implements RoomTwoDetailsService {

    @Autowired
    private RoomTwoDetailsMapper roomTwoDetailsMapper;


    @Override
    public int addTwoRoom(RoomTwoReq req) {
        RoomTwoDetails roomTwoDetails= BeanUtils.convert(req,RoomTwoDetails.class);
        return roomTwoDetailsMapper.insertSelective(roomTwoDetails);
    }

    @Override
    public PageInfo<RoomTwoResp> listTwoRoom(RoomTwoReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());

        List<RoomTwoDetails> roomNewDetailsList=roomTwoDetailsMapper.selectRoomTwolist(req);
        if(roomNewDetailsList !=null  && roomNewDetailsList.size()>0){
            PageInfo<RoomTwoDetails> pageInfos=new PageInfo<RoomTwoDetails>(roomNewDetailsList);
            long total=pageInfos.getTotal();
            int pagenum=pageInfos.getPageNum();
            int pagesize=pageInfos.getPageSize();

            List<RoomTwoResp> roomTwoRespList=BeanUtils.convertList(roomNewDetailsList,RoomTwoResp.class);
            PageInfo<RoomTwoResp> pageInfo=new PageInfo<>(roomTwoRespList);
            pageInfo.setTotal(total);
            pageInfo.setPageNum(pagenum);
            pageInfo.setPageSize(pagesize);

            return pageInfo;

        }

        return null;
    }

    @Override
    public int updateTwoRoom(RoomTwoReq req) {

        RoomTwoDetails roomTwoDetails= BeanUtils.convert(req,RoomTwoDetails.class);
        if(roomTwoDetails.getId() ==null){

             throw new BusinessException(CommonResultCode.ID_ERROR);
        }

      return   roomTwoDetailsMapper.updateByPrimaryKeySelective(roomTwoDetails);

    }

    @Override
    public int deleteTwoRoom(RoomTwoReq req) {
        if(req.getId() ==null){
            throw new BusinessException(CommonResultCode.ID_ERROR);
        }
        return  roomTwoDetailsMapper.deleteByPrimaryKey(req.getId());

    }

    @Override
    public RoomTwoResp getTwoRoom(RoomTwoReq req) {
        if(req.getId() ==null){
            throw new BusinessException(CommonResultCode.ID_ERROR);
        }
       RoomTwoDetails roomTwoDetails=roomTwoDetailsMapper.selectByPrimaryKey(req.getId());
        if(roomTwoDetails !=null){

            RoomTwoResp roomTwoResp=BeanUtils.convert(roomTwoDetails,RoomTwoResp.class);

            return roomTwoResp;
        }
        return null;
    }
}
