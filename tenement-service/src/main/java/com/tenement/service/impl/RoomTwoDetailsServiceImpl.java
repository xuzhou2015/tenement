package com.tenement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenement.dao.mapper.RoomTwoDetailsMapper;
import com.tenement.domain.common.BeanUtils;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.dto.ListTwoRoomReq;
import com.tenement.domain.dto.RoomNewDetailsResp;
import com.tenement.domain.dto.RoomTwoReq;
import com.tenement.domain.dto.RoomTwoResp;
import com.tenement.domain.po.RoomNewDetails;
import com.tenement.domain.po.RoomTwoDetails;
import com.tenement.service.api.RoomTwoDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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
    public PageInfo<RoomTwoResp> listTwoRoom(ListTwoRoomReq req) {

        PageHelper.startPage(req.getPageNum(),req.getPageSize());

        //总价
        if(!StringUtils.isEmpty(req.getPriceTotal())){

            String[] priceArray=req.getPriceTotal().split("\\|");
            if(priceArray.length<2){
                Integer price=Integer.valueOf(priceArray[0]);
                if(price<=100){
                    req.setPriceMin(0);
                    req.setPriceMax(price);
                }
                if(price>=2000){
                    req.setPriceMin(price);
                    req.setPriceMax(1000000);
                }
            }else{

                req.setPriceMin(Integer.valueOf(priceArray[0]));
                req.setPriceMax(Integer.valueOf(priceArray[1]));
            }
        }
        //面积
        if(!StringUtils.isEmpty(req.getHouseArea())){
            String[] houseAreaArray=req.getHouseArea().split("\\|");
            if(houseAreaArray.length<2){
                Integer houseArea=Integer.valueOf(houseAreaArray[0]);
                if(houseArea<=100){
                    req.setHouseAreaMin(0);
                    req.setHouseAreaMax(houseArea);
                }
                if(houseArea>=500){
                    req.setHouseAreaMin(houseArea);
                    req.setHouseAreaMax(1000000);
                }
            }else{
                req.setHouseAreaMin(Integer.valueOf(houseAreaArray[0]));
                req.setHouseAreaMax(Integer.valueOf(houseAreaArray[1]));
            }

        }
        if(!StringUtils.isEmpty(req.getBookLimit())){
            String[] booklimitArray=req.getBookLimit().split("\\|");
            String booklimit="";
            for(String str:booklimitArray){
                booklimit+=str+",";
            }
            booklimit=booklimit.substring(0,booklimit.length()-1);
            req.setBookLimit(booklimit);
        }
        if(req.getHotRecommend() !=null && req.getHotRecommend() >1){
            req.setHotRecommend(null);
        }


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
