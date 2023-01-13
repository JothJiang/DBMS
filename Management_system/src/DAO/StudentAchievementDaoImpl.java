package DAO;

import DAO.DAOBase;
import DAO.StudentAchievementDao;
import bean.Student_Achievement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentAchievementDaoImpl extends DAOBase implements StudentAchievementDao {
	private static final String STUACHIEVEMENT_INSERT_SQL = "INSERT INTO student_achievement(sid,achievement_id) VALUES(?,?) ";
	private static final String STUACHIEVEMENT_SELECT_SQL = "SELECT * FROM student_achievement where sid = (?)";
	private static final String STUACHIEVEMENT_SELECTALL_SQL = "SELECT * FROM student_achievement";
	private static final String STUACHIEVEMENT_UPDATE_SQL = "UPDATE student_achievement SET teacher_result=(?),manager_result=(?) where id = (?)";
	public void addStudentAchievement(Student_Achievement stu_achievement) {
		// TODO 自动生成的方法存根
		Connection con =null;
		try{
			con=getConnection();
			PreparedStatement ps=con.prepareStatement(STUACHIEVEMENT_INSERT_SQL);
			ps.setString(1,stu_achievement.getSid());
			ps.setInt(2,stu_achievement.getAchievement_id());
            ps.executeUpdate();
            ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try{
				con.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void upStudentAchievement(Student_Achievement stu_achievement) {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(STUACHIEVEMENT_UPDATE_SQL);
            psmt.setString(1, stu_achievement.getTeacher_result());
            psmt.setString(2, stu_achievement.getManager_result());
            psmt.setInt(3, stu_achievement.getId());
            psmt.executeUpdate();
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
	}

	@Override
	public void deleteStudentAchievement(int id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public List<Student_Achievement> getStudentAchievement(String sid) {
		// TODO 自动生成的方法存根
		Connection con = null;
		List<Student_Achievement> list = new ArrayList<Student_Achievement>();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(STUACHIEVEMENT_SELECT_SQL);
			psmt.setString(1, sid);
			rs=psmt.executeQuery();
			while (rs.next()){
				Student_Achievement stu_achievement = new Student_Achievement();
				stu_achievement.setId(rs.getInt("id"));
				stu_achievement.setSid(rs.getString("sid"));
				stu_achievement.setAchievement_id(rs.getInt("achievement_id"));
				stu_achievement.setTeacher_result(rs.getString("teacher_result"));
				stu_achievement.setManager_result(rs.getString("manager_result"));
				list.add(stu_achievement);
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
		return list;
	}

	@Override
	public List<Student_Achievement> getAllStudentAchievement() {
		// TODO 自动生成的方法存根
		Connection con = null;
		List<Student_Achievement> list = new ArrayList<Student_Achievement>();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(STUACHIEVEMENT_SELECTALL_SQL);
			rs=psmt.executeQuery();
			while (rs.next()){
				Student_Achievement stu_achievement = new Student_Achievement();
				stu_achievement.setId(rs.getInt("id"));
				stu_achievement.setSid(rs.getString("sid"));
				stu_achievement.setAchievement_id(rs.getInt("achievement_id"));
				stu_achievement.setTeacher_result(rs.getString("teacher_result"));
				stu_achievement.setManager_result(rs.getString("manager_result"));
				list.add(stu_achievement);
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
		return list;
	}

}
