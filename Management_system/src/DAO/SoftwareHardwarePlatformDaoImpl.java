package DAO;

import DAO.DAOBase;
import DAO.SoftwareHardwarePlatformDao;
import bean.SoftwareHardwarePlatform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SoftwareHardwarePlatformDaoImpl extends DAOBase implements SoftwareHardwarePlatformDao {
	private static final String SOFTWARE_INSERT_SQL = "INSERT INTO SoftwareHardwarePlatform(software_id,software_name,software_company,software_time,software_contribution,software_proof) VALUES(?,?,?,?,?,?) ";
	private static final String SOFTWARE_SELECT_SQL = "SELECT * FROM SoftwareHardwarePlatform where software_id = (?)";
	private static final String SOFTWARE_COUNT_SQL = "SELECT count(*) FROM SoftwareHardwarePlatform";
	@Override
	public void addSoftwareHardwarePlatform(SoftwareHardwarePlatform softwareHardwarePlatform) {
		// TODO 自动生成的方法存根

		// TODO 自动生成的方法存根
		Connection con =null;
		try{
			con=getConnection();
			PreparedStatement ps=con.prepareStatement(SOFTWARE_INSERT_SQL);
			ps.setInt(1,softwareHardwarePlatform.getSoftware_id());
			ps.setString(2,softwareHardwarePlatform.getSoftware_name());
			ps.setString(3,softwareHardwarePlatform.getSoftware_company());
			ps.setDate(4,softwareHardwarePlatform.getSoftware_time());
			ps.setInt(5,softwareHardwarePlatform.getSoftware_contribution());
			ps.setString(6,softwareHardwarePlatform.getSoftware_proof());
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
	public void updateSoftwareHardwarePlatform(SoftwareHardwarePlatform softwareHardwarePlatform) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteSoftwareHardwarePlatform(int software_id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public SoftwareHardwarePlatform getSoftwareHardwarePlatform(int software_id) {
		// TODO 自动生成的方法存根
		Connection con = null;
		SoftwareHardwarePlatform softwareHardwarePlatform = new SoftwareHardwarePlatform();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(SOFTWARE_SELECT_SQL);
			psmt.setInt(1, software_id);
			rs=psmt.executeQuery();
			while (rs.next()){
				softwareHardwarePlatform.setSoftware_id(rs.getInt("software_id"));
				softwareHardwarePlatform.setSoftware_name(rs.getString("software_name"));
				softwareHardwarePlatform.setSoftware_company(rs.getString("software_company"));
				softwareHardwarePlatform.setSoftware_time(rs.getDate("software_time"));
				softwareHardwarePlatform.setSoftware_contribution(rs.getInt("software_contribution"));
				softwareHardwarePlatform.setSoftware_proof(rs.getString("software_proof"));

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
		return softwareHardwarePlatform;
	}

	@Override
	public int getSoftwareHardwarePlatformId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(SOFTWARE_COUNT_SQL);
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
