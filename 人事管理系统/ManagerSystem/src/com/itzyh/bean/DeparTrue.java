package com.itzyh.bean;

public class DeparTrue {

    private Integer ldeptno;
    private String ldept;
    private Integer ljobno;
    private String ljob;
    private Integer lpno;
    private String lpname;
    private String lpsex;
    private String lpyongg;
    private String lpshiyong;
    private String lizhi;
    private String ldate;
    private String ltype;

    public Integer getLdeptno() {
        return ldeptno;
    }

    public void setLdeptno(Integer ldeptno) {
        this.ldeptno = ldeptno;
    }

    public String getLdept() {
        return ldept;
    }

    public void setLdept(String ldept) {
        this.ldept = ldept;
    }

    public Integer getLjobno() {
        return ljobno;
    }

    public void setLjobno(Integer ljobno) {
        this.ljobno = ljobno;
    }

    public String getLjob() {
        return ljob;
    }

    public void setLjob(String ljob) {
        this.ljob = ljob;
    }

    public Integer getLpno() {
        return lpno;
    }

    public void setLpno(Integer lpno) {
        this.lpno = lpno;
    }

    public String getLpname() {
        return lpname;
    }

    public void setLpname(String lpname) {
        this.lpname = lpname;
    }

    public String getLpsex() {
        return lpsex;
    }

    public void setLpsex(String lpsex) {
        this.lpsex = lpsex;
    }

    public String getLpyongg() {
        return lpyongg;
    }

    public void setLpyongg(String lpyongg) {
        this.lpyongg = lpyongg;
    }

    public String getLpshiyong() {
        return lpshiyong;
    }

    public void setLpshiyong(String lpshiyong) {
        this.lpshiyong = lpshiyong;
    }

    public String getLizhi() {
        return lizhi;
    }

    public void setLizhi(String lizhi) {
        this.lizhi = lizhi;
    }

    public String getLdate() {
        return ldate;
    }

    public void setLdate(String ldate) {
        this.ldate = ldate;
    }

    public String getLtype() {
        return ltype;
    }

    public void setLtype(String ltype) {
        this.ltype = ltype;
    }

    public DeparTrue(Integer ldeptno, String ldept, Integer ljobno, String ljob, Integer lpno, String lpname, String lpsex, String lpyongg, String lpshiyong, String lizhi, String ldate, String ltype) {
        this.ldeptno = ldeptno;
        this.ldept = ldept;
        this.ljobno = ljobno;
        this.ljob = ljob;
        this.lpno = lpno;
        this.lpname = lpname;
        this.lpsex = lpsex;
        this.lpyongg = lpyongg;
        this.lpshiyong = lpshiyong;
        this.lizhi = lizhi;
        this.ldate = ldate;
        this.ltype = ltype;
    }

    public DeparTrue() {
    }

    @Override
    public String toString() {
        return "deparBao{" +
                "ldeptno=" + ldeptno +
                ", ldept='" + ldept + '\'' +
                ", ljobno=" + ljobno +
                ", ljob='" + ljob + '\'' +
                ", lpno=" + lpno +
                ", lpname='" + lpname + '\'' +
                ", lpsex='" + lpsex + '\'' +
                ", lpyongg='" + lpyongg + '\'' +
                ", lpshiyong='" + lpshiyong + '\'' +
                ", lizhi='" + lizhi + '\'' +
                ", ldate='" + ldate + '\'' +
                ", ltype='" + ltype + '\'' +
                '}';
    }
}
