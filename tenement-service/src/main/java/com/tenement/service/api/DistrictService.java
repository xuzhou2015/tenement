package com.tenement.service.api;

import com.tenement.domain.po.District;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

public interface DistrictService {

    List<District> selectByPrimaryList(Integer parentid);


}
