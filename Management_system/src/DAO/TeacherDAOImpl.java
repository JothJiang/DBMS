package DAO;

import bean.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
    @Override
    public String getPwdByTno(String tno) {
        try {
            Connection conn = getConnection();
            String sql = "select pwd from teacher where tno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "-1";
    }

    @Override
    public List<Teacher> getTeachers() {
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            String sql = "select tno,tname from teacher";
            ResultSet rs = st.executeQuery(sql);

            List<Teacher> teacherList = new ArrayList<>();
            while (rs.next()){
                String tno = rs.getString("tno");
                String tname = rs.getString("tname");

                Teacher teacher = new Teacher();
                teacher.settno(tno);
                teacher.settname(tname);
                teacherList.add(teacher);
            }
            return teacherList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getDepartByTno(String tno){
        try {
            Connection conn = getConnection();
            String sql = "select tdepart from teacher where tno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "-1";
    }
    @Override
    public String checkTnoAndPwd(String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection();
            String QUERY_PWD_SQL = "select tname from dbo.teacher where tno=? and pwd=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, no);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("tname");
            }else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
