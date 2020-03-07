package com.tenement.service.impl;

import com.tenement.dao.mapper.RoomFileMapper;
import com.tenement.dao.mapper.RoomTenementTypeMapper;
import com.tenement.domain.po.RoomFile;
import com.tenement.domain.po.RoomTenementType;
import com.tenement.service.api.RoomTenementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class RoomTenementTypeServiceimpl implements RoomTenementTypeService {

    @Autowired
    private RoomTenementTypeMapper roomTenementTypeMapper;

    @Autowired
    private RoomFileMapper roomFileMapper;
    @Override
    public List<RoomTenementType> selectByPrimaryKey(Integer tenementTypeId) {
        return roomTenementTypeMapper.selectByPrimaryKey(tenementTypeId);
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @Override
    public String  uploadFile(MultipartFile file) {
        //获取上传文件名,包含后缀
        String originalFilename = file.getOriginalFilename();
        //获取后缀
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //保存的文件名
        Long filename= System.currentTimeMillis();
        String dFileName =filename+substring;
        //保存路径
        //springboot 默认情况下只能加载 resource文件夹下静态资源文件
        String path = "/file/image/";

        //生成保存文件
        File uploadFile = new File(path+dFileName);
        System.out.println(uploadFile);
        //将上传文件保存到路径
        try {
            file.transferTo(uploadFile);

            return dFileName;
//            RoomFile roomFile=new RoomFile();
//            roomFile.setFileUrl(path+dFileName);
//            roomFile.setFileType(1);
//            roomFile.setCreateTime(new Date());
//            roomFileMapper.insertSelective(roomFile);
//
//            return roomFile.getId();

        } catch (IOException e) {
            e.printStackTrace();

            return "";
        }


    }
}
