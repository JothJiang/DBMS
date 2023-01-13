package DAO;

import bean.Project;

import java.util.List;

public interface ProjectDAO {
    void addProject(Project project);
    void updateProject(Project project);
    void deleteProject(String Sno);
    Project getProject(String Sno);
    void update_confirm(int confirm_num);
    List<Project> findProjects(String ptype);
    List<Project> confirmProjects();
    List<Project> showProjects();
    List<Project> teacher_Project(String tno);
    List<Project> student_Project(String sno);
}