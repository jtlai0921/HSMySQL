package com.hs.mvc.entity;

import java.util.Date;

public class ClockOn {
    private Integer clockId;
    private String empNo;
    private Integer statusId;
    private Date clockOn;
    private String image;

    public Integer getClockId() {
        return clockId;
    }

    public void setClockId(Integer clockId) {
        this.clockId = clockId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Date getClockOn() {
        return clockOn;
    }

    public void setClockOn(Date clockOn) {
        this.clockOn = clockOn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ClockOn{" + "clockId=" + clockId + ", empNo=" + empNo + ", statusId=" + statusId + ", clockOn=" + clockOn + ", image=" + image + '}';
    }

    
}
