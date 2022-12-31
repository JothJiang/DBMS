package edu.dao;

public interface ManagerDao {
    String getPwdByMno(String mno);
    String getDepartByMno(String mno); //根据g管理人员号获取所在学科
}
