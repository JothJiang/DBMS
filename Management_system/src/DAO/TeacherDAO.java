package DAO;
import bean.Teacher;
import java.util.List;
public interface TeacherDAO {
    int login_search(String sno, String pwd);
    String getPwdByTno(String tno);
    List<Teacher> getTeachers();
    String getDepartByTno(String tno); //根据教师号获取教师部门
    String checkTnoAndPwd(String no, String pwd);
}
