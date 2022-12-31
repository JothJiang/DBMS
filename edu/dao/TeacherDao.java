package edu.dao;

import edu.bean.Teacher;

import java.util.List;

public interface TeacherDao {
    String getPwdByTno(String tno);
    List<Teacher> getTeachers();
    String getDepartByTno(String tno); //根据教师号获取教师部门
}
