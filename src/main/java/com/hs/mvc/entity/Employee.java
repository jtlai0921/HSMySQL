package com.hs.mvc.entity;

import java.util.Date;

public class Employee {
    private Integer empId;
    private String empNo;
    private String empName;
    private Boolean empActive;
    private Date empCt;
    private String empRfid;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Boolean getEmpActive() {
        return empActive;
    }

    public void setEmpActive(Boolean empActive) {
        this.empActive = empActive;
    }

    public Date getEmpCt() {
        return empCt;
    }

    public void setEmpCt(Date empCt) {
        this.empCt = empCt;
    }

    public String getEmpRfid() {
        return empRfid;
    }

    public void setEmpRfid(String empRfid) {
        this.empRfid = empRfid;
    }
    
}
