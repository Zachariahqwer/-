package com.itzyh.bean;

/**
 * 部门调动报表实体类
 */
public class DeptBao {

    private Integer bdeptno;
    private String bdept;
    private Integer bpno;
    private String bpname;
    private String bpsex;
    private Integer nowDeptno;
    private String nowDept;
    private String bpyongg;
    private String bpshiyong;
    private String bdtype;

    public String getBdtype() {
        return bdtype;
    }

    public void setBdtype(String bdtype) {
        this.bdtype = bdtype;
    }

    public Integer getBdeptno() {
        return bdeptno;
    }

    public void setBdeptno(Integer bdeptno) {
        this.bdeptno = bdeptno;
    }

    public String getBdept() {
        return bdept;
    }

    public void setBdept(String bdept) {
        this.bdept = bdept;
    }

    public Integer getBpno() {
        return bpno;
    }

    public void setBpno(Integer bpno) {
        this.bpno = bpno;
    }

    public String getBpname() {
        return bpname;
    }

    public void setBpname(String bpname) {
        this.bpname = bpname;
    }

    public String getBpsex() {
        return bpsex;
    }

    public void setBpsex(String bpsex) {
        this.bpsex = bpsex;
    }

    public Integer getNowDeptno() {
        return nowDeptno;
    }

    public void setNowDeptno(Integer nowDeptno) {
        this.nowDeptno = nowDeptno;
    }

    public String getNowDept() {
        return nowDept;
    }

    public void setNowDept(String nowDept) {
        this.nowDept = nowDept;
    }

    public String getBpyongg() {
        return bpyongg;
    }

    public void setBpyongg(String bpyongg) {
        this.bpyongg = bpyongg;
    }

    public String getBpshiyong() {
        return bpshiyong;
    }

    public void setBpshiyong(String bpshiyong) {
        this.bpshiyong = bpshiyong;
    }

    public DeptBao(Integer bdeptno, String bdept, Integer bpno, String bpname, String bpsex, Integer nowDeptno, String nowDept, String bpyongg, String bpshiyong, String bdtype) {
        this.bdeptno = bdeptno;
        this.bdept = bdept;
        this.bpno = bpno;
        this.bpname = bpname;
        this.bpsex = bpsex;
        this.nowDeptno = nowDeptno;
        this.nowDept = nowDept;
        this.bpyongg = bpyongg;
        this.bpshiyong = bpshiyong;
        this.bdtype = bdtype;
    }

    public DeptBao() {
    }

    @Override
    public String toString() {
        return "DeptBao{" +
                "bdeptno=" + bdeptno +
                ", bdept='" + bdept + '\'' +
                ", bpno=" + bpno +
                ", bpname='" + bpname + '\'' +
                ", bpsex='" + bpsex + '\'' +
                ", nowDeptno=" + nowDeptno +
                ", nowDept='" + nowDept + '\'' +
                ", bpyongg='" + bpyongg + '\'' +
                ", bpshiyong='" + bpshiyong + '\'' +
                ", bdtype='" + bdtype + '\'' +
                '}';
    }
}
