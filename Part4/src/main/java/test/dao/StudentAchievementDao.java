package test.dao;

import java.util.List;

import test.entity.Student_Achievement;

public interface StudentAchievementDao {
    void addStudentAchievement(Student_Achievement stu_achievement);
    void upStudentAchievement(Student_Achievement stu_achievement);
    void deleteStudentAchievement(int id);
    List<Student_Achievement> getStudentAchievement(String sid);
    List<Student_Achievement> getAllStudentAchievement();
}

