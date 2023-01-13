package DAO;
import bean.Student;
import java.util.List;
public interface StudentDAO {
    int login_search(String sno, String pwd);//研究生登录的账号密码验证
    String getPwdBySno(String sno);      //根据学号获取该研究生密码
    List<Student> getStudents();
    String getDepartBySno(String sno); //根据学号获取该研究生所在学科
    String checkSnoAndPwd(String no, String pwd);
    String checkIdentity(String sno);//判断是博士或硕士
    String findMentor(String sno);//找到学生对应的导师
}
