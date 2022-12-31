package edu.dao;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import edu.bean.Course;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CourseDaoImpl  implements CourseDao {
    @Override
    public List<Course> getCourses() {
        try {
            setNum();
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            Statement st = conn.createStatement();
            String sql = "select * from course order by ctime desc, stunum desc, cteacher";
            ResultSet rs = st.executeQuery(sql);

            List<Course> courseList = new ArrayList<>();
            while (rs.next()){
                Course course =new Course();
                course.setCno(rs.getString("cno"));
                course.setCname(rs.getString("cname"));
                course.setCtype(rs.getString("ctype"));
                course.setCstu(rs.getString("cstu"));
                course.setCteacher(rs.getString("cteacher"));
                course.setCtime(rs.getInt("ctime"));
                course.setCnum(rs.getInt("cnum"));
                course.setStunum(rs.getInt("stunum"));
                courseList.add(course);
            }
            if (is != null) {
                is.close();
            }
            return courseList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCourse(Course course) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "insert into course values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getCno());
            ps.setString(2, course.getCname());
            ps.setString(3, course.getCtype());
            ps.setString(4, course.getCstu());
            ps.setString(5, course.getCteacher());
            ps.setInt(6, course.getCtime());
            ps.setInt(7, course.getCnum());
            ps.setInt(8, course.getStunum());
            ps.executeUpdate();
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setNum() {      //更新数据表中的选课人数
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            Statement st = conn.createStatement();
            String sql = "select cno from course";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                String cno = rs.getString("cno");
                int cnum = DAOFactory.getRequestDao().getRequestNumByCno(cno);
                String sql1 = "update course set cnum = ? where cno = ?";
                PreparedStatement ps = conn.prepareStatement(sql1);
                ps.setInt(1, cnum);
                ps.setString(2, cno);
                ps.executeUpdate();
            }
            if (is != null) {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getcnames(String cno){
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select cname from course where cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cno);
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
    public int getNum() {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select count(*) from course";
            PreparedStatement ps = conn.prepareStatement(sql);
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
    public String getCoursesByTno(String tno) {
        try {
            Properties properties = new Properties();
            InputStream is = CourseDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            Connection conn = dataSource.getConnection();
            String sql = "select cname from course where cteacher = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tno);
            ResultSet rs = ps.executeQuery();

            String courses = "";
            while (rs.next()){
                String course = rs.getString("cname");
                courses += course+" ";
            }
            if (is != null) {
                is.close();
            }
            return courses;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
