package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DAO.DAOBase;
import DAO.OtherDao;
import bean.Other;

public class OtherDaoImpl extends DAOBase implements OtherDao {
	private static final String OTHER_INSERT_SQL = "INSERT INTO Other(other_name,other_type,other_time,other_contribution,other_proof) VALUES(?,?,?,?,?) ";
	private static final String OTHER_SELECT_SQL = "SELECT * FROM Other where other_id = (?)";
	private static final String OTHER_COUNT_SQL = "SELECT count(*) FROM Other";
	@Override
	public void addOther(Other other) {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(OTHER_INSERT_SQL);
            psmt.setString(1, other.getOther_name());
            psmt.setString(2, other.getOther_type());
            psmt.setDate(3, other.getOther_time());
            psmt.setString(4, other.getOther_contribution());
            psmt.setString(5, other.getOther_proof());
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
	public void upOther(Other other) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteOther(int other_id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Other getOther(int other_id) {
		// TODO 自动生成的方法存根
        Connection con = null;
        Other other = new Other();
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(OTHER_SELECT_SQL);
            psmt.setInt(1, other_id);
            rs=psmt.executeQuery();
            while (rs.next()){
                other.setOther_id(rs.getInt("other_id"));
	            other.setOther_name(rs.getString("other_name"));
	            other.setOther_type(rs.getString("other_type"));
	            other.setOther_time(rs.getDate("other_time"));
	            other.setOther_contribution(rs.getString("other_contribution"));
	            other.setOther_proof(rs.getString("other_proof"));
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
		return other;
	}

	@Override
	public int getOtherId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(OTHER_COUNT_SQL);
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
