package com.medicento.medicentofollowup;

import java.io.Serializable;

public class Distributor implements Serializable {

    private String distributorName;
    private String distributorAddress;

    public Distributor(String distributorName, String distributorAddress) {
        this.distributorName = distributorName;
        this.distributorAddress = distributorAddress;
    }

    public String getDistributorName() {
        return distributorName;
    }

    public void setDistributorName(String distributorName) {
        this.distributorName = distributorName;
    }

    public String getDistributorAddress() {
        return distributorAddress;
    }

    public void setDistributorAddress(String distributorAddress) {
        this.distributorAddress = distributorAddress;
    }
}
