package com.topcheer.spdbybt.entity;

import java.io.Serializable;
import java.util.Date;

public class SysElem implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String transactionModelCode;

    private String transactionModelName;

    private String operatorPerson;

    private Date crtTime;

    private Date updTime;

    private Integer isDelete;

    public String getCrtTimeStr() {
        return crtTimeStr;
    }

    public void setCrtTimeStr(String crtTimeStr) {
        this.crtTimeStr = crtTimeStr;
    }

    private String crtTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTransactionModelCode() {
        return transactionModelCode;
    }

    public void setTransactionModelCode(String transactionModelCode) {
        this.transactionModelCode = transactionModelCode;
    }

    public String getTransactionModelName() {
        return transactionModelName;
    }

    public void setTransactionModelName(String transactionModelName) {
        this.transactionModelName = transactionModelName;
    }

    public String getOperatorPerson() {
        return operatorPerson;
    }

    public void setOperatorPerson(String operatorPerson) {
        this.operatorPerson = operatorPerson;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}