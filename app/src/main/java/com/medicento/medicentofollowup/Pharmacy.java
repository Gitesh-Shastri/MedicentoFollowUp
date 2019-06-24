package com.medicento.medicentofollowup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pharmacy implements Serializable {

    private String pharmacyName;
    private String mobileNumber;
    private String callingTime;
    private Moto actionMoto;
    private String address;
    private Date firstOrderDate;
    private Date firstCallDate;
    private List<Distributor> distributorList = new ArrayList<>();
    private Feedbacks feedbacks = new Feedbacks();


    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCallingTime() {
        return callingTime;
    }

    public void setCallingTime(String callingTime) {
        this.callingTime = callingTime;
    }

    public Moto getActionMoto() {
        return actionMoto;
    }

    public void setActionMoto(Moto actionMoto) {
        this.actionMoto = actionMoto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getFirstOrderDate() {
        return firstOrderDate;
    }

    public void setFirstOrderDate(Date firstOrderDate) {
        this.firstOrderDate = firstOrderDate;
    }

    public Date getFirstCallDate() {
        return firstCallDate;
    }

    public void setFirstCallDate(Date firstCallDate) {
        this.firstCallDate = firstCallDate;
    }

    public List<Distributor> getDistributorList() {
        return distributorList;
    }

    public void setDistributorList(List<Distributor> distributorList) {
        this.distributorList = distributorList;
    }

    public Feedbacks getFeedbacks() {
        return feedbacks;
    }

    public void setFeedbacks(Feedbacks feedbacks) {
        this.feedbacks = feedbacks;
    }
}

