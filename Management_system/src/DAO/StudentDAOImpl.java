package DAO;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import bean.Student;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class StudentDAOImpl extends DAOBase implements StudentDAO {

    private static final String PROJECT_SELECT_SQL = "select pwd from student where sno=?";

    @Override
    public int login_search(String sno, String pwd) {
        Connection con = null;
        Student student_ = new Student();
        int flag=0;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_SQL);
            psmt.setString(1, sno);
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
    public String getPwdBySno(String sno) {
        try {
            Connection conn = getConnection();
            String sql = "select pwd from student where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getStudents() {
        try {
            Connection conn = getConnection();
            String sql = "select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (rs.next()){
                Student student = new Student();
                student.setsno(rs.getString("sno"));
                student.setsname(rs.getString("sname"));
                student.setsdepart(rs.getString("sdepart"));
                student.setstype(rs.getString("stype"));
                studentList.add(student);
            }
            return studentList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    @Override
    public String getDepartBySno(String sno) {
        try {
            Connection conn = getConnection();
            String sql = "select sdepart from student where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String checkSnoAndPwd(String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection();
            String QUERY_PWD_SQL = "select sname from dbo.student where sno=? and pwd=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, no);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("sname");
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

    @Override
    public String checkIdentity(String sno) {
        // TODO 自动生成的方法存根
        Connection con = null;
        try {
            con = getConnection();
            String QUERY_PWD_SQL = "select stype from dbo.student where sno=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, sno);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("stype");
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
    @Override
    public String findMentor(String sno)
    {
        // TODO 自动生成的方法存根
        Connection con = null;
        try {
            con = getConnection();
            String QUERY_PWD_SQL = "select mentor from dbo.student where sno=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, sno);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("mentor");
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
            }        }
    }
}