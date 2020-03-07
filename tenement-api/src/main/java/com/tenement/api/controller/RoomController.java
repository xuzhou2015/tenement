package com.tenement.api.controller;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.Response;
import com.tenement.domain.dto.*;
import com.tenement.domain.po.District;
import com.tenement.domain.po.RoomNewDetails;
import com.tenement.domain.po.RoomTenementType;
import com.tenement.domain.util.ResponseUtils;
import com.tenement.domain.vo.RoomDetailsInfo;
import com.tenement.domain.vo.SysUserVo;
import com.tenement.service.api.DistrictService;
import com.tenement.service.api.RoomAreaService;
import com.tenement.service.api.RoomDetailsService;
import com.tenement.service.api.RoomTenementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


/**
 * 房屋信息
 */
@RestController
@RequestMapping("/room")
public class RoomController {


    @Autowired
    private RoomDetailsService roomDetailsService;

    @Autowired
    private RoomAreaService roomAreaService;

    @Autowired
    private RoomTenementTypeService roomTenementTypeService;

    @Autowired
    private DistrictService districtService;

    /**
     *  创建房屋信息
     * @param req
     * @return
     * @throws RuntimeException
     */
    @RequestMapping("/addRoomDetails")
    public Response addRoom(@RequestBody  RoomNewDetailsReq req, HttpServletRequest request) throws BusinessException{

        HttpSession session = request.getSession();
        SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
        if (sysUserVo == null) {
            return ResponseUtils.createFailure();
        }
        req.setUserid(sysUserVo.getId());

        if(roomDetailsService.insertSelective(req)>0){
            return ResponseUtils.createSuccess();
        }
        return ResponseUtils.createFailure();
    }

    /**
     *  获取房屋基础类型
     * @return
     * @throws RuntimeException
     */
    @RequestMapping("/getRoomBasicsType")
    public Response<RoomBasicsTypeResp> getRoomBasicsType()throws BusinessException{

        RoomBasicsTypeResp roomBasicsTypeResp=roomDetailsService.getRoomBasicsType();

        return ResponseUtils.createSuccess(roomBasicsTypeResp);
    }

    /**
     *  获取房型详情
     * @return
     * @throws RuntimeException
     */
    @RequestMapping("/getRoomDetails")
    public Response<GetRoomDetailsResp> getRoomDetails(@RequestBody @Validated GetRoomDetailsReq req) throws BusinessException{


       GetRoomDetailsResp getRoomDetailsResp=roomDetailsService.getRoomDetails(req.getRoomId());

       return ResponseUtils.createSuccess(getRoomDetailsResp);
    }

    /**
     *  获取房屋列表
     * @return
     * @throws RuntimeException
     */
    @RequestMapping("/listRoom")
    public  Response<PageInfo<RoomNewDetails>> listRoom(@RequestBody ListRoomDetailsReq req){

        PageInfo<RoomNewDetails> roomDetailsList=roomDetailsService.listRoom(req);

        return ResponseUtils.createSuccess(roomDetailsList);
    }

    /**
     *   搜索房屋列表
     * @return
     * @throws RuntimeException
     */
    @RequestMapping("/listGrabbleRoom")
    public  Response<PageInfo<RoomDetailsInfo>> listGrabbleRoom(@RequestBody ListGrabbleRoomReq req){

        PageInfo<RoomDetailsInfo> roomDetailsList=roomDetailsService.listGrabbleRoom(req);

        return ResponseUtils.createSuccess(roomDetailsList);
    }


    /**
     *获取房屋物业类型
     * @param req
     * @return
     * @throws RuntimeException
     */
    @RequestMapping("/listRoomTenementType")
    public Response<List<RoomTenementType>> listRoomTenementType(@RequestBody @Valid ListRoomTenementTypeReq req) throws BusinessException{

        List<RoomTenementType> roomTenementTypeList=roomTenementTypeService.selectByPrimaryKey(req.getTenementTypeId());
        return ResponseUtils.createSuccess(roomTenementTypeList);
    }

    /**
     *获取省市区
     * @param req
     * @return
     * @throws RuntimeException
     */
    @RequestMapping("/lisDistrict")
    public Response<List<District>> lisDistrict(@RequestBody @Valid LisDistrictReq req) throws BusinessException{

        List<District> districtList=districtService.selectByPrimaryList(req.getParentid());
        return ResponseUtils.createSuccess(districtList);
    }

    /**
     * 上传图片
     * @param file
     * @return
     * @throws RuntimeException
     */
    @RequestMapping(value = "/uploadFile")
    public Response<UploadFileResp> uploadFile(@RequestParam("file") MultipartFile file) throws BusinessException {

        String iamgeStr=roomTenementTypeService.uploadFile(file);

        if(StringUtil.isNotEmpty(iamgeStr)){
            UploadFileResp uploadFileResp=new UploadFileResp();
            uploadFileResp.setImageStr(iamgeStr);
            return ResponseUtils.createSuccess(uploadFileResp);
        }else{
            return ResponseUtils.createFailure();
        }


    }


    @RequestMapping(value = "/index")
    public String index() throws RuntimeException {

        return "index";
    }

}
