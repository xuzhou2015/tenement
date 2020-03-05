package com.tenement.domain.po;

import java.util.Date;

public class RoomFile {
    private Integer id;

    private Long roomDetailsId;

    private Integer fileType;

    private String fileUrl;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getRoomDetailsId() {
        return roomDetailsId;
    }

    public void setRoomDetailsId(Long roomDetailsId) {
        this.roomDetailsId = roomDetailsId;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}