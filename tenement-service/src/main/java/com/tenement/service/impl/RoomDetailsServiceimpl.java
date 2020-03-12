package com.tenement.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tenement.dao.mapper.*;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.dto.*;
import com.tenement.domain.po.*;
import com.tenement.domain.vo.RoomDetailsInfo;
import com.tenement.service.api.RoomDetailsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
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
    public int insertSelective(RoomNewDetailsReq record) {

        Broker broker=new Broker();

        RoomNewDetails roomNewDetails=new RoomNewDetails();

        BeanUtils.copyProperties(record,roomNewDetails);

        roomNewDetails.setCreatime(new Date());


        roomNewDetailsMapper.insertSelective(roomNewDetails);

        return 1;

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
    public  PageInfo<RoomNewDetails> listRoom(ListRoomDetailsReq req){

        if(req.getRoomPriceId() !=null){

            req=checkRoomPrice(req);
        }
        if(req.getRoomAreaId() !=null){

            req=checkRoomArea(req);
        }
        if(req.getRoomMarketTimeType() !=null){

            req=checkRoomMarketTimeType(req);
        }
        if(req.getPageNum()==null || req.getPageSize()==null){
            throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
        }
        if(req.getOrderByType() ==null){
            req.setOrderByType(1);
        }

        PageHelper.startPage(req.getPageNum(),req.getPageSize());


       List<RoomNewDetails> roomNewDetailsList=roomNewDetailsMapper.selectByPrimaryList(req);

        PageInfo<RoomNewDetails> pageInfo=new PageInfo<>(roomNewDetailsList);


        return pageInfo;
    }

    /**
     * 搜索房型
     * @param req
     * @return
     */
    @Override
    public PageInfo<RoomDetailsInfo> listGrabbleRoom(ListGrabbleRoomReq req){

         if(req.getDistrictid()==null){
             throw new BusinessException(CommonResultCode.ILLEGAL_REQ_PARAMETER);
         }
         if(!StringUtils.isEmpty(req.getSearchKey())){
             req.setOwnerarea(req.getSearchKey());
             req.setRoomName(req.getSearchKey());
         }

        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        List<RoomDetailsInfo> roomDetailsList=roomDetailsMapper.listGrabbleRoom(req);

        PageInfo<RoomDetailsInfo> pageInfo=new PageInfo<>(roomDetailsList);

        return pageInfo;
    }

    /**
     * 获取房型详情
     * @param roomId
     * @return
     */
    @Override
    public GetRoomDetailsResp getRoomDetails(Long roomId){

        GetRoomDetailsResp getRoomDetailsResp=new GetRoomDetailsResp();

        RoomDetails roomDetails=roomDetailsMapper.selectByPrimaryKey(roomId);
        if(roomDetails==null){

            return getRoomDetailsResp;
        }
        getRoomDetailsResp.setRoomDetails(roomDetails);

        List<RoomFile> roomFileList = roomFileMapper.selectByPrimaryList(roomDetails.getRoomId());

        if(roomFileList ==null || roomFileList.size()< 1){
            return getRoomDetailsResp;
        }
        getRoomDetailsResp.setRoomFileList(roomFileList);

        return getRoomDetailsResp;
    }

    /**
     * 判断价格
     * @param listRoomDetailsReq
     * @return
     */
    private ListRoomDetailsReq checkRoomPrice(ListRoomDetailsReq listRoomDetailsReq){

        int price=10000;

        switch (listRoomDetailsReq.getRoomPriceId()){
            case 1:
                listRoomDetailsReq.setRoomPriceMin(0);
                listRoomDetailsReq.setRoomPriceMax(100*price);
                break;
            case 2:
                listRoomDetailsReq.setRoomPriceMin(100*price);
                listRoomDetailsReq.setRoomPriceMax(150*price);
                break;
            case 3:
                listRoomDetailsReq.setRoomPriceMin(150*price);
                listRoomDetailsReq.setRoomPriceMax(200*price);
                break;
            case 4:
                listRoomDetailsReq.setRoomPriceMin(200*price);
                listRoomDetailsReq.setRoomPriceMax(300*price);
                break;
            case 5:
                listRoomDetailsReq.setRoomPriceMin(300*price);
                listRoomDetailsReq.setRoomPriceMax(500*price);
                break;
            case 6:
                listRoomDetailsReq.setRoomPriceMin(500*price);
                listRoomDetailsReq.setRoomPriceMax(1000*price);
                break;
            case 7:
                listRoomDetailsReq.setRoomPriceMin(1000*price);
                listRoomDetailsReq.setRoomPriceMax(100000*price);
                break;
            case 8:
                listRoomDetailsReq.setRoomPriceMin(0);
                listRoomDetailsReq.setRoomPriceMax(10000);
                break;
            case 9:
                listRoomDetailsReq.setRoomPriceMin(price);
                listRoomDetailsReq.setRoomPriceMax(price*2);
                break;
            case 10:
                listRoomDetailsReq.setRoomPriceMin(2*price);
                listRoomDetailsReq.setRoomPriceMax(3*price);
                break;
            case 11:
                listRoomDetailsReq.setRoomPriceMin(3*price);
                listRoomDetailsReq.setRoomPriceMax(4*price);
                break;
            case 12:
                listRoomDetailsReq.setRoomPriceMin(4*price);
                listRoomDetailsReq.setRoomPriceMax(5*price);
                break;
            case 13:
                listRoomDetailsReq.setRoomPriceMin(5*price);
                listRoomDetailsReq.setRoomPriceMax(6*price);
                break;
            default:
                break;
        }
        return listRoomDetailsReq;
    }

    /**
     * 判断面积
     * @param listRoomDetailsReq
     * @return
     */
    private ListRoomDetailsReq checkRoomArea(ListRoomDetailsReq listRoomDetailsReq){

        switch (listRoomDetailsReq.getRoomAreaId()){
            case 1:
                listRoomDetailsReq.setRoomAreaMin(0);
                listRoomDetailsReq.setRoomAreaMax(60);
                break;
            case 2:
                listRoomDetailsReq.setRoomAreaMin(60);
                listRoomDetailsReq.setRoomAreaMax(80);
                break;
            case 3:
                listRoomDetailsReq.setRoomAreaMin(80);
                listRoomDetailsReq.setRoomAreaMax(100);
                break;
            case 4:
                listRoomDetailsReq.setRoomAreaMin(100);
                listRoomDetailsReq.setRoomAreaMax(120);
                break;
            case 5:
                listRoomDetailsReq.setRoomAreaMin(120);
                listRoomDetailsReq.setRoomAreaMax(150);
                break;
            case 6:
                listRoomDetailsReq.setRoomAreaMin(150);
                listRoomDetailsReq.setRoomAreaMax(200);
                break;
            case 7:
                listRoomDetailsReq.setRoomAreaMin(200);
                listRoomDetailsReq.setRoomAreaMax(20000);
                break;
            default:
                break;
        }
        return listRoomDetailsReq;

    }

    /**
     * 判断开盘时间
     * @param listRoomDetailsReq
     * @return
     */
    private ListRoomDetailsReq checkRoomMarketTimeType(ListRoomDetailsReq listRoomDetailsReq){
        LocalDate today = LocalDate.now();
        switch (listRoomDetailsReq.getRoomMarketTimeType()){
            case 1:
                listRoomDetailsReq.setRoomMarketTimeMin(today.with(TemporalAdjusters.firstDayOfMonth()));
                listRoomDetailsReq.setRoomMarketTimeMax(today.with(TemporalAdjusters.lastDayOfMonth()));
                break;
            case 2:
                listRoomDetailsReq.setRoomMarketTimeMin(today);
                listRoomDetailsReq.setRoomMarketTimeMax(today.plusMonths(1));
                break;
            case 3:
                listRoomDetailsReq.setRoomMarketTimeMin(today);
                listRoomDetailsReq.setRoomMarketTimeMax(today.plusMonths(3));
                break;
            case 4:
                listRoomDetailsReq.setRoomMarketTimeMin(today);
                listRoomDetailsReq.setRoomMarketTimeMax(today.plusMonths(6));
                break;
            case 5:
                listRoomDetailsReq.setRoomMarketTimeMin(today.minusMonths(1));
                listRoomDetailsReq.setRoomMarketTimeMax(today);
                break;
            case 6:
                listRoomDetailsReq.setRoomMarketTimeMin(today.minusMonths(3));
                listRoomDetailsReq.setRoomMarketTimeMax(today);
                break;
            default:
                break;
        }
        return listRoomDetailsReq;
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
