package edu.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import edu.bean.GC;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GCDaoImpl implements GCDao {
    @Override
    public void insertGC(GC gc) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "insert into gc values (?,?,null,null)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gc.getSno());
            ps.setString(2, gc.getCno());
            ps.executeUpdate();
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getGCNumBySno(String sno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select count(*) from gc where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
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
    public List<GC> getGCs(String sno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from gc where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();
            List<GC> gcList = new ArrayList<>();
            while (rs.next()){
                GC gc=new GC(sno,rs.getString("cno"),rs.getString("gstate"),rs.getString("tevaluate"));
                gcList.add(gc);
            }
            if (is != null) {
                is.close();
            }
            return gcList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void insertpj(String sno,String cno,String gstate){
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "update gc set gstate=? where sno=? and cno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gstate);
            ps.setString(2, sno);
            ps.setString(3, cno);
            ps.executeUpdate();
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void insertpj1(String sno, String cno, String tevaluate) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "update gc set tevaluate=? where sno=? and cno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tevaluate);
            ps.setString(2, sno);
            ps.setString(3, cno);
            ps.executeUpdate();
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean courseOccupied(String cno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select sno from gc where cno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
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
    public List<GC> getGCsByTno(String tno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select sno,gc.cno,gstate,tevaluate from gc join course on gc.cno=course.cno collate Chinese_PRC_CI_AS where cteacher=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tno);
            ResultSet rs = ps.executeQuery();
            List<GC> gcList = new ArrayList<>();
            while (rs.next()){
                GC gc=new GC(rs.getString("sno"),rs.getString("cno"),rs.getString("gstate"),rs.getString("tevaluate"));
                gcList.add(gc);
            }
            if (is != null) {
                is.close();
            }
            return gcList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getCoursesBySno(String sno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select cname from gc join course on gc.cno=course.cno collate Chinese_PRC_CI_AS where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();

            StringBuilder courses = new StringBuilder();
            while (rs.next()){
                String course = rs.getString("cname");
                courses.append(course).append(" ");
            }
            if (is != null) {
                is.close();
            }
            return courses.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
