package test.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.dao.DAOBase;
import test.dao.StandardDao;
import test.entity.Reward;
import test.entity.Standard;

public class StandardDaoImpl extends DAOBase implements StandardDao {
	private static final String STANDARD_INSERT_SQL = "INSERT INTO standard(standard_id,standard_name,standard_level,standard_time,standard_proof) VALUES(?,?,?,?,?) ";
	private static final String STANDARD_SELECT_SQL = "SELECT * FROM standard where standard_id = (?)";
	private static final String STANDARD_COUNT_SQL = "SELECT count(*) FROM standard";
	@Override
	public void addStandard(Standard standard) {
		// TODO 自动生成的方法存根
		Connection con =null;
		try{
			con=getConnection();
			PreparedStatement ps=con.prepareStatement(STANDARD_INSERT_SQL);
			ps.setInt(1,standard.getStandard_id());
			ps.setString(2,standard.getStandard_name());
			ps.setString(3,standard.getStandard_level());
			ps.setDate(4,standard.getStandard_time());
			ps.setString(5,standard.getStandard_proof());
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
	public void upStandard(Standard standard) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteStandard(int standard_id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Standard getStandard(int standard_id) {
		// TODO 自动生成的方法存根
		Connection con = null;
		Standard standard = new Standard();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(STANDARD_SELECT_SQL);
			psmt.setInt(1, standard_id);
			rs=psmt.executeQuery();
			while (rs.next()){
				standard.setStandard_id(rs.getInt("standard_id"));
				standard.setStandard_name(rs.getString("standard_name"));
				standard.setStandard_level(rs.getString("standard_level"));
				standard.setStandard_time(rs.getDate("standard_time"));
				standard.setStandard_proof(rs.getString("standard_proof"));

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
		return standard;
	}

	@Override
	public int getStandardId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(STANDARD_COUNT_SQL);
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
