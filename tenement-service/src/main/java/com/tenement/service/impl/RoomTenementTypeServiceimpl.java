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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    public List<String>  uploadFile(MultipartFile[] file) {

        List<String> stringList = new ArrayList<>();

        for (MultipartFile multipartFile : file) {

            if (!multipartFile.isEmpty()) {

                String originalFilename = multipartFile.getOriginalFilename();
                //获取后缀
                String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
                //保存的文件名
                Random random = new Random();
                String index= String.valueOf(random.nextInt(899999));
                Long filename = System.currentTimeMillis();
                String dFileName = filename.toString()+index+ substring;
                //保存路径
                //springboot 默认情况下只能加载 resource文件夹下静态资源文件
               // String path = "/file/image/";

                String path="/users/xuzhou/file";

                //生成保存文件
                File uploadFile = new File(path + dFileName);
                System.out.println(uploadFile);
                //将上传文件保存到路径
                try {
                    multipartFile.transferTo(uploadFile);

                    stringList.add(dFileName);

                } catch (IOException e) {
                    e.printStackTrace();

                    return null;
                }
            }

        }

        return stringList;

    }
    private int nextInt(final int min, final int max)

    {

        Random rand= new Random();

        int tmp = Math.abs(rand.nextInt());

        return tmp % (max - min + 1) + min;

    }

}
