package edu.bean;

public class Request {
    private String sno;
    private String cno;
    private String agree;

    public Request(String sno, String cno, String agree) {
        this.sno = sno;
        this.cno = cno;
        this.agree = agree;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }
}
