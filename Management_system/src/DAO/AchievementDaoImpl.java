package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.AchievementDao;
import DAO.DAOBase;
import bean.Achievement;
import bean.Standard;

public class AchievementDaoImpl extends DAOBase implements AchievementDao {
	private static final String ACHIEVEMENT_INSERT_SQL = "INSERT INTO achievement(id,type,detail_id) VALUES(?,?,?) ";
	private static final String ACHIEVEMENT_SELECT_SQL = "SELECT * FROM achievement where id = (?)";
	private static final String ACHIEVEMENT_COUNT_SQL = "SELECT count(*) FROM achievement";
	@Override
	public void addAchievement(Achievement achievement) {
		// TODO 自动生成的方法存根
		Connection con =null;
		try{
			con=getConnection();
			PreparedStatement ps=con.prepareStatement(ACHIEVEMENT_INSERT_SQL);
			ps.setInt(1,achievement.getId());
			ps.setString(2,achievement.getType());
			ps.setInt(3,achievement.getDetail_id());
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
	public void upAchievement(Achievement achievement) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteAchievement(int id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Achievement getAchievement(int id) {
		// TODO 自动生成的方法存根
		Connection con = null;
		Achievement achievement = new Achievement();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(ACHIEVEMENT_SELECT_SQL);
			psmt.setInt(1, id);
			rs=psmt.executeQuery();
			while (rs.next()){
				achievement.setId(rs.getInt("id"));
				achievement.setType(rs.getString("type"));
				achievement.setDetail_id(rs.getInt("detail_id"));

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
		return achievement;
	}

	@Override
	public int getAchievementId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(ACHIEVEMENT_COUNT_SQL);
            rs=psmt.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
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
		return 0;
	}
}
