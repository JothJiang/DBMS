package edu.domain;

public class Activity {
    private String id;
    private String name;
    private String addr;
    private String date;
    private String report;
    private String picture;
    private String note;
    private String gid;
    private String state;

    public Activity() {
    }

    public Activity(String id, String name, String addr, String date, String report, String picture, String note, String gid, String state) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.date = date;
        this.report = report;
        this.picture = picture;
        this.note = note;
        this.gid = gid;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
