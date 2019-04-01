package com.topcheer.spdbybt.entity;

import java.io.Serializable;

public class YbtModuleElems implements Serializable {

    private static final long serialVersionUID = 1L;
    private String atomtypeid;

    private String atomtypename;

    private String operatorbankcode;

    private String operatorcode;

    private String updatedate;

    private String updatetime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public String getAtomtypeid() {
        return atomtypeid;
    }

    public void setAtomtypeid(String atomtypeid) {
        this.atomtypeid = atomtypeid == null ? null : atomtypeid.trim();
    }

    public String getAtomtypename() {
        return atomtypename;
    }

    public void setAtomtypename(String atomtypename) {
        this.atomtypename = atomtypename == null ? null : atomtypename.trim();
    }

    public String getOperatorbankcode() {
        return operatorbankcode;
    }

    public void setOperatorbankcode(String operatorbankcode) {
        this.operatorbankcode = operatorbankcode == null ? null : operatorbankcode.trim();
    }

    public String getOperatorcode() {
        return operatorcode;
    }

    public void setOperatorcode(String operatorcode) {
        this.operatorcode = operatorcode == null ? null : operatorcode.trim();
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate == null ? null : updatedate.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getRemark4() {
        return remark4;
    }

    public void setRemark4(String remark4) {
        this.remark4 = remark4 == null ? null : remark4.trim();
    }

    public String getRemark5() {
        return remark5;
    }

    public void setRemark5(String remark5) {
        this.remark5 = remark5 == null ? null : remark5.trim();
    }
}