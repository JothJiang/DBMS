package edu.dao;

import edu.bean.GC;

import java.util.List;

public interface GCDao {
    void insertGC(GC gc);
    int getGCNumBySno(String sno);      //根据学号获取该研究生成为助教的课程数量
    List<GC> getGCs(String sno);     //根据学号获取该研究生评价
    void insertpj(String sno,String cno,String gstate);
    void insertpj1(String sno,String cno,String tevaluate);
    boolean courseOccupied(String cno);     //判断某课程是否已有助教老师
    List<GC> getGCsByTno(String tno);       //根据教师号获取选课记录
    String getCoursesBySno(String sno); //根据学号获取拼接成一个字符串的所有课程
}
