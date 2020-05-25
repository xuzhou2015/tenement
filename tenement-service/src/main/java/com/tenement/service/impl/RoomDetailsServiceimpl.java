package com.tenement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenement.dao.mapper.*;
import com.tenement.domain.common.BeanUtils;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.dto.*;
import com.tenement.domain.po.*;
import com.tenement.domain.vo.RoomDetailsInfo;
import com.tenement.service.api.RoomDetailsService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RoomDetailsServiceimpl implements RoomDetailsService {


    @Autowired
    private RoomDetailsMapper roomDetailsMapper;

    @Autowired
    private RoomFileMapper roomFileMapper;

    @Autowired
    private RoomTenementTypeMapper roomTenementTypeMapper;

    @Autowired
    private RoomHouseTypeMapper roomHouseTypeMapper;

    @Autowired
    private RoomMarketMapper roomMarketMapper;

    @Autowired
    private RoomAreaMapper roomAreaMapper;

    @Autowired
    private RoomPriceMapper roomPriceMapper;

    @Autowired
    private RoomMarketTimeMapper roomMarketTimeMapper;

    @Autowired
    private RoomDecorationTypeMapper roomDecorationTypeMapper;

    @Autowired
    private RoomOtherMapper roomOtherMapper;

    @Autowired
    private RoomOrientationMapper roomOrientationMapper;

    @Autowired
    private RoomNewDetailsMapper roomNewDetailsMapper;



    @Override
    public RespId insertSelective(RoomNewDetailsReq record) {

        RespId respId=new RespId();

        RoomNewDetails roomNewDetails= BeanUtils.convert(record,RoomNewDetails.class);

        roomNewDetails.setCreatime(new Date());

        roomNewDetailsMapper.insertSelective(roomNewDetails);

        if(roomNewDetails.getId() !=null){
            respId.setId(roomNewDetails.getId());
        }
        return respId;

    }

    @Override
    public RoomBasicsTypeResp getRoomBasicsType() {

        RoomBasicsTypeResp roomBasicsTypeResp=new RoomBasicsTypeResp();

        //房型
        List<RoomHouseType> roomHouseTypeList = roomHouseTypeMapper.selectByPrimaryList();

        roomBasicsTypeResp.setRoomHouseTypeList(roomHouseTypeList);

        //面积
        List<RoomArea> roomAreaList = roomAreaMapper.selectByPrimaryKey(null);

        roomBasicsTypeResp.setRoomAreaList(roomAreaList);

        //价格
        List<RoomPrice> roomPriceList = roomPriceMapper.selectByPrimaryList();

        roomBasicsTypeResp.setRoomPriceList(roomPriceList);

        //销售状态
        List<RoomMarket> roomMarketList = roomMarketMapper.selectByPrimaryKey(null);

        roomBasicsTypeResp.setRoomMarketList(roomMarketList);

        //物业类型表
        List<RoomTenementType> roomTenementTypeList = roomTenementTypeMapper.selectByPrimaryKey(null);

        roomBasicsTypeResp.setRoomTenementTypeList(roomTenementTypeList);

       //开盘时间
       List<RoomMarketTime> roomMarketTimeList=roomMarketTimeMapper.selectByPrimaryList();

       roomBasicsTypeResp.setRoomMarketTimeList(roomMarketTimeList);
       //装修改类型
        List<RoomDecorationType> roomDecorationTypeList= roomDecorationTypeMapper.selectByPrimaryList();
        roomBasicsTypeResp.setRoomDecorationTypeList(roomDecorationTypeList);
        //房型其实
        List<RoomOther> roomOtherList=roomOtherMapper.selectByPrimaryList();
        roomBasicsTypeResp.setRoomOtherList(roomOtherList);

       List<RoomOrientation> roomOrientations=roomOrientationMapper.selectByPrimaryList();
        roomBasicsTypeResp.setRoomOrientations(roomOrientations);
        return roomBasicsTypeResp;


    }

    /**
     * 房屋列表
     * @param req
     * @return
     */
    @Override
    public  PageInfo<RoomNewDetailsResp> listRoom(ListRoomDetailsReq req){

        if(req.getPageNum()==null || req.getPageSize()==null){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }



        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<RoomNewDetails> roomNewDetailsList=roomNewDetailsMapper.selectByPrimaryList(req);
        if(roomNewDetailsList !=null && roomNewDetailsList.size()>0){
            PageInfo<RoomNewDetails> pageInfos=new PageInfo<RoomNewDetails>(roomNewDetailsList);
            long total=pageInfos.getTotal();
            int pagenum=pageInfos.getPageNum();
            int pagesize=pageInfos.getPageSize();


            List<RoomNewDetailsResp> roomNewDetailsRespList=BeanUtils.convertList(roomNewDetailsList,RoomNewDetailsResp.class);
            PageInfo<RoomNewDetailsResp> pageInfo=new PageInfo<>(roomNewDetailsRespList);
            pageInfo.setTotal(total);
            pageInfo.setPageNum(pagenum);
            pageInfo.setPageSize(pagesize);



            return pageInfo;
        }
        return null;

    }
    /**
     * 修改新房信息
     * @param req
     * @return
     */
    @Override
    public boolean updateRoomNewDetails(RoomNewDetailsReq req){

        RoomNewDetails roomNewDetails=BeanUtils.convert(req,RoomNewDetails.class);

        if(roomNewDetailsMapper.updateByPrimaryKeySelective(roomNewDetails) >0 ){

            return true;
        }
        return false;

    }

    /**
     * 通过id删除新房
     * @param id
     * @return
     */
    @Override
    public boolean deleteRoomNewDetails(Long id){

      int returid=roomNewDetailsMapper.deleteByPrimaryKey(id);
      if(returid >0){
          return true;
      }else{
          return false;
      }
    }

    /**
     * 搜索房型
     * @param req
     * @return
     */
    @Override
    public PageInfo<RoomNewDetailsResp> listGrabbleRoom(ListGrabbleRoomReq req){

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


        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<RoomNewDetails> roomNewDetailsList=roomNewDetailsMapper.listGrabbleRoom(req);
        if(roomNewDetailsList !=null && roomNewDetailsList.size()>0){
            PageInfo<RoomNewDetails> pageInfos=new PageInfo<RoomNewDetails>(roomNewDetailsList);
            long total=pageInfos.getTotal();
            int pagenum=pageInfos.getPageNum();
            int pagesize=pageInfos.getPageSize();


            List<RoomNewDetailsResp> roomNewDetailsRespList=BeanUtils.convertList(roomNewDetailsList,RoomNewDetailsResp.class);
            PageInfo<RoomNewDetailsResp> pageInfo=new PageInfo<>(roomNewDetailsRespList);
            pageInfo.setTotal(total);
            pageInfo.setPageNum(pagenum);
            pageInfo.setPageSize(pagesize);

            return pageInfo;
        }
        return null;
    }

    /**
     * 获取房型详情
     * @param roomId
     * @return
     */
    @Override
    public RoomNewDetailsResp getRoomDetails(Long roomId){


       RoomNewDetails roomNewDetails=roomNewDetailsMapper.selectByPrimaryKey(roomId);

       if(roomNewDetails !=null){
           RoomNewDetailsResp resp=BeanUtils.convert(roomNewDetails,RoomNewDetailsResp.class);
           return resp;
       }

       return null;

    }






    private RoomDetails createRomDatails(RoomDetailsReq record) {

        RoomDetails roomDetails = new RoomDetails();
        roomDetails.setName(record.getName());
        roomDetails.setDistrictId(record.getDistrictId());
        roomDetails.setOwnerarea(record.getOwnerarea());
        roomDetails.setHousearea(record.getHousearea());
        roomDetails.setBuildarea(record.getBuildarea());
        roomDetails.setBuilddate(record.getBuilddate());
        roomDetails.setCp(record.getCp());
        roomDetails.setFloor(record.getFloor());
        roomDetails.setHousestyle(record.getHousestyle());
        roomDetails.setHousestyleType(record.getHousestyleType());
        roomDetails.setHousearea(record.getHousearea());
        roomDetails.setHouseprice(record.getHouseprice());
        roomDetails.setGn(record.getGn());
        roomDetails.setCqnx(record.getCqnx());
        roomDetails.setDt(record.getDt());
        roomDetails.setHousedirection(record.getHousedirection());
        roomDetails.setFinishType(record.getFinishType());
        roomDetails.setOnsaleType(record.getOnsaleType());
        roomDetails.setMarketType(record.getMarketType());
        roomDetails.setTenementType(record.getTenementType());
        roomDetails.setBrokerId(record.getBrokerId());

        return roomDetails;

    }
}
