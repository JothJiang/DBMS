package edu.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DepartDaoImpl implements DepartDao{

    @Override
    public String getdnames(String dno){
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select dname from depart where dno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dno);
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
        return "-1";
    }

    @Override
    public int getask(String dno){
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select dask from depart where dno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dno);
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
        return -1;
    }

    @Override
    public void updatesak(int dask,String dno){
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "update depart set dask=? where dno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dask);
            ps.setString(2, dno);
            ps.executeUpdate();
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
