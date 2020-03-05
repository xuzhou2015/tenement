package com.tenement.domain.dto;

import com.tenement.domain.po.RoomDetails;
import com.tenement.domain.po.RoomFile;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class GetRoomDetailsResp implements Serializable {

    private RoomDetails roomDetails;

    private List<RoomFile> roomFileList;
}
