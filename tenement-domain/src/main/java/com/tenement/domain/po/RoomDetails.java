package com.tenement.domain.po;

import java.time.LocalDate;
import java.util.Date;

public class RoomDetails {
    private Long roomId;

    private String name;

    private Integer districtId;

    private String ownerarea;

    private Integer housearea;

    private String builddate;

    private String cp;

    private Integer floor;

    private String housestyle;

    private Byte housestyleType;

    private Double buildarea;

    private Integer houseprice;

    private Byte gn;

    private Integer cqnx;

    private Byte dt;

    private Byte housedirection;

    private Byte finishType;

    private Byte onsaleType;

    private Byte marketType;

    private Byte tenementType;

    private LocalDate marketTime;

    private Integer brokerId;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getOwnerarea() {
        return ownerarea;
    }

    public void setOwnerarea(String ownerarea) {
        this.ownerarea = ownerarea;
    }

    public Integer getHousearea() {
        return housearea;
    }

    public void setHousearea(Integer housearea) {
        this.housearea = housearea;
    }

    public String getBuilddate() {
        return builddate;
    }

    public void setBuilddate(String builddate) {
        this.builddate = builddate;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getHousestyle() {
        return housestyle;
    }

    public void setHousestyle(String housestyle) {
        this.housestyle = housestyle;
    }

    public Byte getHousestyleType() {
        return housestyleType;
    }

    public void setHousestyleType(Byte housestyleType) {
        this.housestyleType = housestyleType;
    }

    public Double getBuildarea() {
        return buildarea;
    }

    public void setBuildarea(Double buildarea) {
        this.buildarea = buildarea;
    }

    public Integer getHouseprice() {
        return houseprice;
    }

    public void setHouseprice(Integer houseprice) {
        this.houseprice = houseprice;
    }

    public Byte getGn() {
        return gn;
    }

    public void setGn(Byte gn) {
        this.gn = gn;
    }

    public Integer getCqnx() {
        return cqnx;
    }

    public void setCqnx(Integer cqnx) {
        this.cqnx = cqnx;
    }

    public Byte getDt() {
        return dt;
    }

    public void setDt(Byte dt) {
        this.dt = dt;
    }

    public Byte getHousedirection() {
        return housedirection;
    }

    public void setHousedirection(Byte housedirection) {
        this.housedirection = housedirection;
    }

    public Byte getFinishType() {
        return finishType;
    }

    public void setFinishType(Byte finishType) {
        this.finishType = finishType;
    }

    public Byte getOnsaleType() {
        return onsaleType;
    }

    public void setOnsaleType(Byte onsaleType) {
        this.onsaleType = onsaleType;
    }

    public Byte getMarketType() {
        return marketType;
    }

    public void setMarketType(Byte marketType) {
        this.marketType = marketType;
    }

    public Byte getTenementType() {
        return tenementType;
    }

    public void setTenementType(Byte tenementType) {
        this.tenementType = tenementType;
    }

    public LocalDate getMarketTime() {
        return marketTime;
    }

    public void setMarketTime(LocalDate marketTime) {
        this.marketTime = marketTime;
    }

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
    }
}