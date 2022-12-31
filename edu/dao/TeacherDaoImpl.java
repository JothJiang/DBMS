package edu.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import edu.bean.Teacher;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TeacherDaoImpl implements TeacherDao{
    @Override
    public String getPwdByTno(String tno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select pwd from teacher where tno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tno);
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
    public List<Teacher> getTeachers() {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            Statement st = conn.createStatement();
            String sql = "select tno,tname from teacher";
            ResultSet rs = st.executeQuery(sql);

            List<Teacher> teacherList = new ArrayList<>();
            while (rs.next()){
                String tno = rs.getString("tno");
                String tname = rs.getString("tname");

                Teacher teacher = new Teacher();
                teacher.setTno(tno);
                teacher.setTname(tname);
                teacherList.add(teacher);
            }
            if (is != null) {
                is.close();
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
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select tdeaprt from teacher where tno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tno);
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
}
