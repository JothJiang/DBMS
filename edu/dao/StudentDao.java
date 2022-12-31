package edu.dao;

import edu.bean.Student;

import java.util.List;

public interface StudentDao {
    String getPwdBySno(String sno);      //根据学号获取该研究生密码
    List<Student> getStudents();
    String getDepartBySno(String sno); //根据学号获取该研究生所在学科
}
