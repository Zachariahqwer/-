package com.itzyh.bean;

public class Per {

    private Integer pno;
    private Integer pdeptno;
    private String pname;
    private String psex;
    private String pbirthday;
    private String pidnum;
    private String pdep;
    private Integer pjobno;
    private String pjob;
    private String pjoindate;
    private String pjobdate;
    private String pyongg;
    private String prlaiyuan;
    private String pzhenzhi;
    private String pnspace;
    private String ptel;
    private String pemail;
    private String pmar;
    private String phighl;
    private String phighd;
    private String plearnp;
    private String pgdate;
    private String pshiyong;
    private String pbshidate;
    private String poshidate;

    public Integer getPdeptno() {
        return pdeptno;
    }

    public void setPdeptno(Integer pdeptno) {
        this.pdeptno = pdeptno;
    }

    public Integer getPjobno() {
        return pjobno;
    }

    public void setPjobno(Integer pjobno) {
        this.pjobno = pjobno;
    }

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPsex() {
        return psex;
    }

    public void setPsex(String psex) {
        this.psex = psex;
    }

    public String getPbirthday() {
        return pbirthday;
    }

    public void setPbirthday(String pbirthday) {
        this.pbirthday = pbirthday;
    }

    public String getPidnum() {
        return pidnum;
    }

    public void setPidnum(String pidnum) {
        this.pidnum = pidnum;
    }

    public String getPdep() {
        return pdep;
    }

    public void setPdep(String pdep) {
        this.pdep = pdep;
    }

    public String getPjob() {
        return pjob;
    }

    public void setPjob(String pjob) {
        this.pjob = pjob;
    }

    public String getPjoindate() {
        return pjoindate;
    }

    public void setPjoindate(String pjoindate) {
        this.pjoindate = pjoindate;
    }

    public String getPjobdate() {
        return pjobdate;
    }

    public void setPjobdate(String pjobdate) {
        this.pjobdate = pjobdate;
    }

    public String getPyongg() {
        return pyongg;
    }

    public void setPyongg(String pyongg) {
        this.pyongg = pyongg;
    }

    public String getPrlaiyuan() {
        return prlaiyuan;
    }

    public void setPrlaiyuan(String prlaiyuan) {
        this.prlaiyuan = prlaiyuan;
    }

    public String getPzhenzhi() {
        return pzhenzhi;
    }

    public void setPzhenzhi(String pzhenzhi) {
        this.pzhenzhi = pzhenzhi;
    }

    public String getPnspace() {
        return pnspace;
    }

    public void setPnspace(String pnspace) {
        this.pnspace = pnspace;
    }

    public String getPtel() {
        return ptel;
    }

    public void setPtel(String ptel) {
        this.ptel = ptel;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public String getPmar() {
        return pmar;
    }

    public void setPmar(String pmar) {
        this.pmar = pmar;
    }

    public String getPhighl() {
        return phighl;
    }

    public void setPhighl(String phighl) {
        this.phighl = phighl;
    }

    public String getPhighd() {
        return phighd;
    }

    public void setPhighd(String phighd) {
        this.phighd = phighd;
    }

    public String getPlearnp() {
        return plearnp;
    }

    public void setPlearnp(String plearnp) {
        this.plearnp = plearnp;
    }

    public String getPgdate() {
        return pgdate;
    }

    public void setPgdate(String pgdate) {
        this.pgdate = pgdate;
    }

    public String getPshiyong() {
        return pshiyong;
    }

    public void setPshiyong(String pshiyong) {
        this.pshiyong = pshiyong;
    }

    public String getPbshidate() {
        return pbshidate;
    }

    public void setPbshidate(String pbshidate) {
        this.pbshidate = pbshidate;
    }

    public String getPoshidate() {
        return poshidate;
    }

    public void setPoshidate(String poshidate) {
        this.poshidate = poshidate;
    }

    // 不带部门编号
//    public Per(Integer pno, String pname, String psex, String pbirthday, String pidnum, String pdep, Integer pjobno, String pjob, String pjoindate, String pjobdate, String pyongg, String prlaiyuan, String pzhenzhi, String pnspace, String ptel, String pemail, String pmar, String phighl, String phighd, String plearnp, String pgdate, String pshiyong, String pbshidate, String poshidate) {
//        this.pno = pno;
//        this.pname = pname;
//        this.psex = psex;
//        this.pbirthday = pbirthday;
//        this.pidnum = pidnum;
//        this.pdep = pdep;
//        this.pjobno = pjobno;
//        this.pjob = pjob;
//        this.pjoindate = pjoindate;
//        this.pjobdate = pjobdate;
//        this.pyongg = pyongg;
//        this.prlaiyuan = prlaiyuan;
//        this.pzhenzhi = pzhenzhi;
//        this.pnspace = pnspace;
//        this.ptel = ptel;
//        this.pemail = pemail;
//        this.pmar = pmar;
//        this.phighl = phighl;
//        this.phighd = phighd;
//        this.plearnp = plearnp;
//        this.pgdate = pgdate;
//        this.pshiyong = pshiyong;
//        this.pbshidate = pbshidate;
//        this.poshidate = poshidate;
//    }

    // 带部门编号
    public Per(Integer pno, Integer pdeptno, String pname, String psex, String pbirthday, String pidnum, String pdep, Integer pjobno, String pjob, String pjoindate, String pjobdate, String pyongg, String prlaiyuan, String pzhenzhi, String pnspace, String ptel, String pemail, String pmar, String phighl, String phighd, String plearnp, String pgdate, String pshiyong, String pbshidate, String poshidate) {
        this.pno = pno;
        this.pdeptno = pdeptno;
        this.pname = pname;
        this.psex = psex;
        this.pbirthday = pbirthday;
        this.pidnum = pidnum;
        this.pdep = pdep;
        this.pjobno = pjobno;
        this.pjob = pjob;
        this.pjoindate = pjoindate;
        this.pjobdate = pjobdate;
        this.pyongg = pyongg;
        this.prlaiyuan = prlaiyuan;
        this.pzhenzhi = pzhenzhi;
        this.pnspace = pnspace;
        this.ptel = ptel;
        this.pemail = pemail;
        this.pmar = pmar;
        this.phighl = phighl;
        this.phighd = phighd;
        this.plearnp = plearnp;
        this.pgdate = pgdate;
        this.pshiyong = pshiyong;
        this.pbshidate = pbshidate;
        this.poshidate = poshidate;
    }

    // 试用的
    public Per(Integer pdeptno, Integer pno, String pname, String psex, String pyongg, String pshiyong) {
        this.pno = pno;
        this.pdeptno = pdeptno;
        this.pname = pname;
        this.psex = psex;
        this.pyongg = pyongg;
        this.pshiyong = pshiyong;
    }


    public Per(Integer pno, String pname, String psex, Integer pjobno, String pjob, String pyongg, String pshiyong) {
        this.pno = pno;
        this.pname = pname;
        this.psex = psex;
        this.pjobno = pjobno;
        this.pjob = pjob;
        this.pyongg = pyongg;
        this.pshiyong = pshiyong;
    }

    public Per() {
    }

    @Override
    public String toString() {
        return "Per{" +
                "pno=" + pno +
                ", pdeptno=" + pdeptno +
                ", pname='" + pname + '\'' +
                ", psex='" + psex + '\'' +
                ", pbirthday='" + pbirthday + '\'' +
                ", pidnum='" + pidnum + '\'' +
                ", pdep='" + pdep + '\'' +
                ", pjobno=" + pjobno +
                ", pjob='" + pjob + '\'' +
                ", pjoindate='" + pjoindate + '\'' +
                ", pjobdate='" + pjobdate + '\'' +
                ", pyongg='" + pyongg + '\'' +
                ", prlaiyuan='" + prlaiyuan + '\'' +
                ", pzhenzhi='" + pzhenzhi + '\'' +
                ", pnspace='" + pnspace + '\'' +
                ", ptel='" + ptel + '\'' +
                ", pemail='" + pemail + '\'' +
                ", pmar='" + pmar + '\'' +
                ", phighl='" + phighl + '\'' +
                ", phighd='" + phighd + '\'' +
                ", plearnp='" + plearnp + '\'' +
                ", pgdate='" + pgdate + '\'' +
                ", pshiyong='" + pshiyong + '\'' +
                ", pbshidate='" + pbshidate + '\'' +
                ", poshidate='" + poshidate + '\'' +
                '}';
    }

}
