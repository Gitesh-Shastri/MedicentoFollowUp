package com.medicento.medicentofollowup;

public class Pharmacy {
    String areaname;
    String address;
    String phone;
    String name;

    public Pharmacy(String areaname, String address, String phone, String name) {
        this.areaname = areaname;
        this.address = address;
        this.phone = phone;
        this.name = name;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
