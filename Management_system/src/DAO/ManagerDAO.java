package DAO;
import bean.Manager;
public interface ManagerDAO {
    int login_search(String mno, String pwd);
    String getPwdByMno(String mno);
    String getDepartByMno(String mno); //根据g管理人员号获取所在学科
    String checkMnoAndPwd(String no, String pwd);
}
