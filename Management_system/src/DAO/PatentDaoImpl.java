package DAO;

import DAO.*;
import bean.Patent;

import java.sql.*;

public class PatentDaoImpl extends DAOBase implements PatentDao {
	private static final String PAPER_INSERT_SQL="INSERT INTO Patent(patent_id,patent_name,patent_type,patent_number,patent_deliverytime,patent_status,patent_contribution,patent_proof) VALUES(?,?,?,?,?,?,?,?) ";
	private static final String PAPER_SELECT_SQL = "SELECT * FROM Patent where patent_id = (?)";
	private static final String PATENT_COUNT_SQL = "SELECT count(*) FROM Patent";
	@Override
	public void addPatent(Patent patent) {
		// TODO 自动生成的方法存根
		Connection con =null;
		try{
			con=getConnection();
			PreparedStatement ps=con.prepareStatement(PAPER_INSERT_SQL);
			ps.setInt(1,patent.getPatent_id());
			ps.setString(2,patent.getPatent_name());
			ps.setString(3,patent.getPatent_type());
			ps.setString(4,patent.getPatent_number());
			ps.setDate(5,patent.getPatent_deliverytime());
			ps.setString(6,patent.getPatent_status());
			ps.setInt(7,patent.getPatent_contribution());
			ps.setString(8,patent.getPatent_proof());
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
	public void updatePatent(Patent patent) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deletePatent(int patent_id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Patent getPatent(int getPatent_id) {
		Connection con = null;
		Patent patent = new Patent();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(PAPER_SELECT_SQL);
			psmt.setInt(1, getPatent_id);
			rs=psmt.executeQuery();
			while (rs.next()){
				patent.setPatent_id(rs.getInt("patent_id"));
				patent.setPatent_name(rs.getString("patent_name"));
				patent.setPatent_type(rs.getString("patent_type"));
				patent.setPatent_number(rs.getString("patent_number"));
				patent.setPatent_deliverytime(rs.getDate("patent_deliverytime"));
				patent.setPatent_status(rs.getString("patent_status"));
				patent.setPatent_contribution(rs.getInt("patent_contribution"));
				patent.setPatent_proof(rs.getString("patent_proof"));
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
		return patent;
	}

	@Override
	public int getPatentId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(PATENT_COUNT_SQL);
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
