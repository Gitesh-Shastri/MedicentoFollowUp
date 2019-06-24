package com.medicento.medicentofollowup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Feedbacks implements Serializable {

    private Problems problems = new Problems();
    private Integer lateDeliveryCount;
    private List<String> listOfMedicineNotAvailable = new ArrayList<>();
    private List<String> otherReasonsList = new ArrayList<>();
    private Onboarded onboarded;


    public Problems getProblems() {
        return problems;
    }

    public void setProblems(Problems problems) {
        this.problems = problems;
    }

    public Integer getLateDeliveryCount() {
        return lateDeliveryCount;
    }

    public void setLateDeliveryCount(Integer lateDeliveryCount) {
        this.lateDeliveryCount = lateDeliveryCount;
    }

    public List<String> getListOfMedicineNotAvailable() {
        return listOfMedicineNotAvailable;
    }

    public void setListOfMedicineNotAvailable(List<String> listOfMedicineNotAvailable) {
        this.listOfMedicineNotAvailable = listOfMedicineNotAvailable;
    }

    public List<String> getOtherReasonsList() {
        return otherReasonsList;
    }

    public void setOtherReasonsList(List<String> otherReasonsList) {
        this.otherReasonsList = otherReasonsList;
    }

    public Onboarded getOnboarded() {
        return onboarded;
    }

    public void setOnboarded(Onboarded onboarded) {
        this.onboarded = onboarded;
    }
}
