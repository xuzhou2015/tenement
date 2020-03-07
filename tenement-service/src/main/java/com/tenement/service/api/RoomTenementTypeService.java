package com.tenement.service.api;

import com.tenement.domain.po.RoomTenementType;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RoomTenementTypeService {

    List<RoomTenementType> selectByPrimaryKey(Integer tenementTypeId);

    String  uploadFile(MultipartFile file);
}
