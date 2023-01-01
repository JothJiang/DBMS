package edu.domain;

public class Student {
    private String sno;
    private String sname;
    private String sdepart;
    private String stype;
    private String pwd;

    public Student() {
    }

    public Student(String sno, String sname, String sdepart, String stype, String pwd) {
        this.sno = sno;
        this.sname = sname;
        this.sdepart = sdepart;
        this.stype = stype;
        this.pwd = pwd;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSdepart() {
        return sdepart;
    }

    public void setSdepart(String sdepart) {
        this.sdepart = sdepart;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}