package com.itzyh.bean;

public class JobBao {

    private Integer bJobno;
    private String bJob;
    private Integer nowJobno;
    private String nowJob;
    private Integer bpno;
    private String bpname;
    private String bpsex;
    private String bpyongg;
    private String bpshiyong;
    private String btype;

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public Integer getbJobno() {
        return bJobno;
    }

    public void setbJobno(Integer bJobno) {
        this.bJobno = bJobno;
    }

    public String getbJob() {
        return bJob;
    }

    public void setbJob(String bJob) {
        this.bJob = bJob;
    }

    public Integer getNowJobno() {
        return nowJobno;
    }

    public void setNowJobno(Integer nowJobno) {
        this.nowJobno = nowJobno;
    }

    public String getNowJob() {
        return nowJob;
    }

    public void setNowJob(String nowJob) {
        this.nowJob = nowJob;
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

    public JobBao(Integer bJobno, String bJob, Integer nowJobno, String nowJob, Integer bpno, String bpname, String bpsex, String bpyongg, String bpshiyong, String btype) {
        this.bJobno = bJobno;
        this.bJob = bJob;
        this.nowJobno = nowJobno;
        this.nowJob = nowJob;
        this.bpno = bpno;
        this.bpname = bpname;
        this.bpsex = bpsex;
        this.bpyongg = bpyongg;
        this.bpshiyong = bpshiyong;
        this.btype = btype;
    }

    @Override
    public String toString() {
        return "JobBao{" +
                "bJobno=" + bJobno +
                ", bJob='" + bJob + '\'' +
                ", nowJobno=" + nowJobno +
                ", nowJob='" + nowJob + '\'' +
                ", bpno=" + bpno +
                ", bpname='" + bpname + '\'' +
                ", bpsex='" + bpsex + '\'' +
                ", bpyongg='" + bpyongg + '\'' +
                ", bpshiyong='" + bpshiyong + '\'' +
                ", btype='" + btype + '\'' +
                '}';
    }
}
