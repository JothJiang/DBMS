package edu.dao;

import edu.bean.Course;

import java.util.List;

public interface CourseDao {
    void addCourse(Course course);
    void setNum();
    List<Course> getCourses();  //获取可选的课程列表，分别以学时、选课人数降序排序,以授课教师升序排序
    String getcnames(String cno); //根据课程号获取课程名
    int getNum();           //获取课程总数
    String getCoursesByTno(String tno); //根据教师号获取拼接成一个字符串的所有课程
}
