package test.impl;

import test.dao.DAOBase;
import test.dao.RewardDao;
import test.entity.Reward;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RewardDaoImpl extends DAOBase implements RewardDao {
	private static final String REWARD_INSERT_SQL = "INSERT INTO reward(reward_id,reward_name,reward_level,award_level,reward_rank,reward_time,reward_proof) VALUES(?,?,?,?,?,?,?) ";
	private static final String REWARD_SELECT_SQL = "SELECT * FROM reward where reward_id = (?)";
	private static final String REWARD_COUNT_SQL = "SELECT count(*) FROM reward";
	@Override
	public void addReward(Reward reward) {
		// TODO 自动生成的方法存根
		Connection con =null;
		try{
			con=getConnection();
			PreparedStatement ps=con.prepareStatement(REWARD_INSERT_SQL);
			ps.setInt(1,reward.getReward_id());
			ps.setString(2,reward.getReward_name());
			ps.setString(3,reward.getReward_level());
			ps.setString(4,reward.getAward_level());
			ps.setString(5,reward.getReward_rank());
			ps.setDate(6,reward.getReward_time());
			ps.setString(7,reward.getReward_proof());
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
		}// TODO 自动生成的方法存根
		
	}

	@Override
	public void upReward(Reward reward) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteReward(int reward_id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Reward getReward(int reward_id) {
		Connection con = null;
		Reward reward = new Reward();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(REWARD_SELECT_SQL);
			psmt.setInt(1, reward_id);
			rs=psmt.executeQuery();
			while (rs.next()){
				reward.setReward_id(rs.getInt("reward_id"));
				reward.setReward_name(rs.getString("reward_name"));
				reward.setReward_level(rs.getString("reward_level"));
				reward.setAward_level(rs.getString("award_level"));
				reward.setReward_rank(rs.getString("reward_rank"));
				reward.setReward_time(rs.getDate("reward_time"));
				reward.setReward_proof(rs.getString("reward_proof"));

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
		return reward;
	}

	@Override
	public int getRewardId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(REWARD_COUNT_SQL);
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
	

