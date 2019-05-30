package com.medicento.medicentofollowup;

public class PendingJobListElement {

    String pharmacyName;
    String mobileNumber;
    String actionTakenTime;
    String actionMoto;

    public PendingJobListElement(String pharmacyName, String mobileNumber, String actionTakenTime, String actionMoto) {
        this.pharmacyName = pharmacyName;
        this.mobileNumber = mobileNumber;
        this.actionTakenTime = actionTakenTime;
        this.actionMoto = actionMoto;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getActionTakenTime() {
        return actionTakenTime;
    }

    public String getActionMoto() {
        return actionMoto;
    }
}
