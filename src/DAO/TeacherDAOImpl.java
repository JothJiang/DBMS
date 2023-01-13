package DAO;

import bean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDAOImpl extends DAOBase implements TeacherDAO {
    private static final String PROJECT_SELECT_SQL = "select pwd from teacher where tno=?";

    @Override
    public int login_search(String tno, String pwd) {
        Connection con = null;
        Teacher teacher_ = new Teacher();
        int flag=0;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_SQL);
            psmt.setString(1, tno);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                /*student_.setsno(rs.getString("pid"));
                student_.setsname(rs.getString("sname"));
                student_.setsdepart(rs.getString("sdepart"));
                student_.setstype(rs.getString("stype"));*/
                if(rs.getString("pwd").equals(pwd)){
                    flag=1;
                }
            }
            psmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(flag==1){
            return 2;
        }
        else {
            return 1;
        }
    }
}
