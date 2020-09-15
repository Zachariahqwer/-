package com.itzyh.bean;


/**
 * 部门表
 */
public class Dept {

    private Integer deptno;
    private String dname;
    private String dtype;
    private String dtel;
    private String demail;
    private String dmiaoshu;
    private String ddescribe;
    private String ddate;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getDtel() {
        return dtel;
    }

    public void setDtel(String dtel) {
        this.dtel = dtel;
    }

    public String getDemail() {
        return demail;
    }

    public void setDemail(String demail) {
        this.demail = demail;
    }

    public String getDmiaoshu() {
        return dmiaoshu;
    }

    public void setDmiaoshu(String dmiaoshu) {
        this.dmiaoshu = dmiaoshu;
    }

    public String getDdescribe() {
        return ddescribe;
    }

    public void setDdescribe(String ddescribe) {
        this.ddescribe = ddescribe;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    public Dept(Integer deptno, String dname, String dtype, String dtel, String demail, String dmiaoshu, String ddescribe, String ddate) {
        this.deptno = deptno;
        this.dname = dname;
        this.dtype = dtype;
        this.dtel = dtel;
        this.demail = demail;
        this.dmiaoshu = dmiaoshu;
        this.ddescribe = ddescribe;
        this.ddate = ddate;
    }

    public Dept() {
    }

    public Dept(Integer deptno, String dname, String dtype, String dtel, String ddate) {
        this.deptno = deptno;
        this.dname = dname;
        this.dtype = dtype;
        this.dtel = dtel;
        this.ddate = ddate;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", dtype='" + dtype + '\'' +
                ", dtel='" + dtel + '\'' +
                ", demail='" + demail + '\'' +
                ", dmiaoshu='" + dmiaoshu + '\'' +
                ", ddescribe=" + ddescribe +
                ", ddate='" + ddate + '\'' +
                '}';
    }
}
