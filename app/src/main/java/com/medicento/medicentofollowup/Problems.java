package com.medicento.medicentofollowup;

import java.io.Serializable;

public class Problems implements Serializable {

    private boolean productQuality;
    private boolean productMismatch;
    private boolean lateDelivery;
    private boolean creditPeriod;
    private boolean issueWithDistributor;
    private boolean medicineNotAvailable;
    private boolean issueWithDeliveryBoy;


    public boolean isProductQuality() {
        return productQuality;
    }

    public void setProductQuality(boolean productQuality) {
        this.productQuality = productQuality;
    }

    public boolean isProductMismatch() {
        return productMismatch;
    }

    public void setProductMismatch(boolean productMismatch) {
        this.productMismatch = productMismatch;
    }

    public boolean isLateDelivery() {
        return lateDelivery;
    }

    public void setLateDelivery(boolean lateDelivery) {
        this.lateDelivery = lateDelivery;
    }

    public boolean isCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(boolean creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public boolean isIssueWithDistributor() {
        return issueWithDistributor;
    }

    public void setIssueWithDistributor(boolean issueWithDistributor) {
        this.issueWithDistributor = issueWithDistributor;
    }

    public boolean isMedicineNotAvailable() {
        return medicineNotAvailable;
    }

    public void setMedicineNotAvailable(boolean medicineNotAvailable) {
        this.medicineNotAvailable = medicineNotAvailable;
    }

    public boolean isIssueWithDeliveryBoy() {
        return issueWithDeliveryBoy;
    }

    public void setIssueWithDeliveryBoy(boolean issueWithDeliveryBoy) {
        this.issueWithDeliveryBoy = issueWithDeliveryBoy;
    }
}
