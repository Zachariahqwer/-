package com.itzyh.bean;

public class Job {

    private Integer jno;
    private String jname;
    private String jtype;
    private Integer jnum;

    public Integer getJno() {
        return jno;
    }

    public void setJno(Integer jno) {
        this.jno = jno;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getJtype() {
        return jtype;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype;
    }

    public Integer getJnum() {
        return jnum;
    }

    public void setJnum(Integer jnum) {
        this.jnum = jnum;
    }

    public Job(Integer jno, String jname, String jtype, Integer jnum) {
        this.jno = jno;
        this.jname = jname;
        this.jtype = jtype;
        this.jnum = jnum;
    }

    public Job(Integer jno, String jname, String jtype) {
        this.jno = jno;
        this.jname = jname;
        this.jtype = jtype;
    }

    public Job() {
    }

    @Override
    public String toString() {
        return "Job{" +
                "jno=" + jno +
                ", jname='" + jname + '\'' +
                ", jtype='" + jtype + '\'' +
                ", jnum=" + jnum +
                '}';
    }
}
