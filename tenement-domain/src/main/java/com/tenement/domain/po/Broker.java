package com.tenement.domain.po;

import java.util.Date;

public class Broker {
    private Integer brokerId;

    private String brokerName;

    private String brokerPhone;

    private Double rank;

    private Double roomGoal;

    private Double serviceGoal;

    private Double evaluateGoal;

    private String companyName;

    private String shopName;

    private String cardNumber;

    private String companyCode;

    private Date careteTime;

    public Integer getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Integer brokerId) {
        this.brokerId = brokerId;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Date getCareteTime() {
        return careteTime;
    }

    public void setCareteTime(Date careteTime) {
        this.careteTime = careteTime;
    }
}
