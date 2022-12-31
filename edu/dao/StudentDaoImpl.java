package edu.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import edu.bean.Student;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class StudentDaoImpl implements StudentDao{
    @Override
    public String getPwdBySno(String sno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select pwd from student where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
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
    public List<Student> getStudents() {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select * from student";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Student> studentList = new ArrayList<>();
            while (rs.next()){
                Student student = new Student();
                student.setSno(rs.getString("sno"));
                student.setSname(rs.getString("sname"));
                student.setSdepart(rs.getString("sdepart"));
                student.setStype(rs.getString("stype"));
                studentList.add(student);
            }
            if (is != null) {
                is.close();
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
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select sdepart from student where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
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
