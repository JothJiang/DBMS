package edu.dao;

import edu.bean.Request;

import java.util.List;

public interface RequestDao {
    void insertRequest(Request request);        //插入一条选课请求
    int getRequestNumBySno(String sno);          //根据学号获取该研究生请求成为助教的课程数量
    List<Request> getAgrees(String sno);           //根据学号获取该研究生请求成为助教的课程列表
    boolean requestExisted(String sno,String cno);  //判断某次请求是否已存在
    int getRequestNumByCno(String cno);             //根据课程编号获取该课程的选课人数
    void deleteRequest(String sno,String cno);      //删除选课请求
    List<Request> getRequestsByTno(String tno);     //根据教师号获取选课请求
    void setAgreeBySnoCno(String sno,String cno);   //根据学号和课程号设置选课请求的agree字段值为1(同意)
    int getagree(String cno);                       //根据课程号获取agree值
}
