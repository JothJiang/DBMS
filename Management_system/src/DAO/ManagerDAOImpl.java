package DAO;

import bean.Administrator;
import bean.Manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class ManagerDAOImpl extends DAOBase implements ManagerDAO {
    private static final String PROJECT_SELECT_SQL = "select pwd from manager where mno=?";

    @Override
    public int login_search(String mno, String pwd) {
        Connection con = null;
        Manager manager = new Manager();
        int flag=0;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_SQL);
            psmt.setString(1, mno);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                /*student_.setsno(rs.getString("pid"));
                student_.setsname(rs.getString("sname"));
                student_.setsdepart(rs.getString("sdepart"));
                student_.setstype(rs.getString("stype"));*/
                if(rs.getString("pwd").equals(pwd)) {
                    flag=1;
                }
                manager.setpwd(rs.getString("pwd"));
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
    public String getPwdByMno(String mno) {
        try {
            Connection conn = getConnection();
            String sql = "select pwd from manager where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mno);
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
    public String getDepartByMno(String mno) {
        try {
            Connection conn = getConnection();
            String sql = "select mdepart from manager where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mno);
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
    public String checkMnoAndPwd(String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection();
            String QUERY_PWD_SQL = "select dname from dbo.manager join dbo.depart on dno=mdepart where mno=? and pwd=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, no);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("dname");
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
