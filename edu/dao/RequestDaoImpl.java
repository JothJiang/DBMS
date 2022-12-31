package edu.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import edu.bean.Request;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RequestDaoImpl implements RequestDao {
    @Override
    public void insertRequest(Request request) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "insert into request values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, request.getSno());
            ps.setString(2, request.getCno());
            ps.setString(3, request.getAgree());
            ps.executeUpdate();
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getRequestNumBySno(String sno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select count(*) from request where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Request> getAgrees(String sno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from request where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();
            List<Request> agreeList = new ArrayList<>();
            while (rs.next()){
                Request agree =new Request(sno,rs.getString("cno"),rs.getString("agree"));
                agreeList.add(agree);
            }
            if (is != null) {
                is.close();
            }
            return agreeList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean requestExisted(String sno, String cno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select * from request where sno = ? and cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ps.setString(2, cno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int getRequestNumByCno(String cno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select count(*) from request where cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public void deleteRequest(String sno,String cno){
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "delete from request where sno=? and cno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ps.setString(2, cno);
            ps.executeUpdate();
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Request> getRequestsByTno(String tno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select sno,request.cno from request join course on request.cno=course.cno collate Chinese_PRC_CI_AS where agree='0' and cteacher=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tno);
            ResultSet rs = ps.executeQuery();
            List<Request> requestList = new ArrayList<>();
            while (rs.next()){
                Request request =new Request(rs.getString("sno"),rs.getString("cno"),null);
                requestList.add(request);
            }
            if (is != null) {
                is.close();
            }
            return requestList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void setAgreeBySnoCno(String sno, String cno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "update request set agree='1' where sno=? and cno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ps.setString(2, cno);
            ps.executeUpdate();
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getagree(String cno){
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select agree from request where cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}
