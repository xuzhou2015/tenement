package com.tenement.domain.po;

import java.util.Date;

public class Broker {
    private Integer id;

    private String brokerName;

    private String brokerPhone;

    private Double rank;

    private Double roomGoal;

    private Double serviceGoal;

    private Double evaluateGoal;

    private String companyName;

    private String shopName;

    private String cardNumber;

    private String userphoto;

    private String wx;

    private String companyCode;

    private Date creationTime;

    private Integer creationUserid;

    private String creationName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getBrokerPhone() {
        return brokerPhone;
    }

    public void setBrokerPhone(String brokerPhone) {
        this.brokerPhone = brokerPhone;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
    }

    public Double getRoomGoal() {
        return roomGoal;
    }

    public void setRoomGoal(Double roomGoal) {
        this.roomGoal = roomGoal;
    }

    public Double getServiceGoal() {
        return serviceGoal;
    }

    public void setServiceGoal(Double serviceGoal) {
        this.serviceGoal = serviceGoal;
    }

    public Double getEvaluateGoal() {
        return evaluateGoal;
    }

    public void setEvaluateGoal(Double evaluateGoal) {
        this.evaluateGoal = evaluateGoal;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }

    public String getWx() {
        return wx;
    }

    public void setWx(String wx) {
        this.wx = wx;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getCreationUserid() {
        return creationUserid;
    }

    public void setCreationUserid(Integer creationUserid) {
        this.creationUserid = creationUserid;
    }

    public String getCreationName() {
        return creationName;
    }

    public void setCreationName(String creationName) {
        this.creationName = creationName;
    }
}