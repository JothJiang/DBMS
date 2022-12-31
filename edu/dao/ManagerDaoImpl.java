package edu.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ManagerDaoImpl implements ManagerDao{
    @Override
    public String getPwdByMno(String mno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select pwd from manager where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString(1);
            }
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public String getDepartByMno(String mno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select mdepart from manager where mno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString(1);
            }
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
