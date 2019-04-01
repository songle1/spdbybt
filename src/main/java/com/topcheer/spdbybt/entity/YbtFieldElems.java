package com.topcheer.spdbybt.entity;

import java.io.Serializable;

public class YbtFieldElems implements Serializable {

    private static final long serialVersionUID = 1L;
    private String fieldid; //字段元素编号

    private String fieldcname; //字段元素名称

    private String fieldename; //字段英文名称

    private String fieldinputtype; //字段输入类型

    private String fieldinputtypename; //字段输入类型名称

    private String atomtypeid; //交易模块编号

    private String operatorbankcode; //操作机构

    private String operatorcode; //操作柜员

    private String fieldgettype; //字段取值类型

    private String fieldgettypename; //字段取值类型名称

    private String fieldtype; //字段类型

    private String fieldtypename; //字段类型名称

    private String isfixlength; //是否固定类型

    private String isfixlengthname; //是否固定类型名称

    private String fieldlength; //字段长度

    private String precisionval; //数值精度

    private String updatedate;

    private String updatetime;

    private String remark1;

    private String remark2;

    private String remark3;

    private String remark4;

    private String remark5;

    public String getAtomtypename() {
        return atomtypename;
    }

    public void setAtomtypename(String atomtypename) {
        this.atomtypename = atomtypename;
    }

    private String atomtypename; //交易模块名称;

    public String getFieldid() {
        return fieldid;
    }

    public void setFieldid(String fieldid) {
        this.fieldid = fieldid == null ? null : fieldid.trim();
    }

    public String getFieldcname() {
        return fieldcname;
    }

    public void setFieldcname(String fieldcname) {
        this.fieldcname = fieldcname == null ? null : fieldcname.trim();
    }

    public String getFieldename() {
        return fieldename;
    }

    public void setFieldename(String fieldename) {
        this.fieldename = fieldename == null ? null : fieldename.trim();
    }

    public String getFieldinputtype() {
        return fieldinputtype;
    }

    public void setFieldinputtype(String fieldinputtype) {
        this.fieldinputtype = fieldinputtype == null ? null : fieldinputtype.trim();
    }

    public String getAtomtypeid() {
        return atomtypeid;
    }

    public void setAtomtypeid(String atomtypeid) {
        this.atomtypeid = atomtypeid == null ? null : atomtypeid.trim();
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

    public String getFieldinputtypename() {
        return fieldinputtypename;
    }

    public void setFieldinputtypename(String fieldinputtypename) {
        this.fieldinputtypename = fieldinputtypename;
    }

    public String getFieldgettype() {
        return fieldgettype;
    }

    public void setFieldgettype(String fieldgettype) {
        this.fieldgettype = fieldgettype;
    }

    public String getFieldgettypename() {
        return fieldgettypename;
    }

    public void setFieldgettypename(String fieldgettypename) {
        this.fieldgettypename = fieldgettypename;
    }

    public String getFieldtype() {
        return fieldtype;
    }

    public void setFieldtype(String fieldtype) {
        this.fieldtype = fieldtype;
    }

    public String getFieldtypename() {
        return fieldtypename;
    }

    public void setFieldtypename(String fieldtypename) {
        this.fieldtypename = fieldtypename;
    }

    public String getIsfixlength() {
        return isfixlength;
    }

    public void setIsfixlength(String isfixlength) {
        this.isfixlength = isfixlength;
    }

    public String getIsfixlengthname() {
        return isfixlengthname;
    }

    public void setIsfixlengthname(String isfixlengthname) {
        this.isfixlengthname = isfixlengthname;
    }

    public String getFieldlength() {
        return fieldlength;
    }

    public void setFieldlength(String fieldlength) {
        this.fieldlength = fieldlength;
    }

    public String getPrecisionval() {
        return precisionval;
    }

    public void setPrecisionval(String precisionval) {
        this.precisionval = precisionval;
    }
}