package test.impl;

import test.dao.DAOBase;
import test.dao.ReportDao;
import test.entity.Paper;
import test.entity.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReportDaoImpl extends DAOBase implements ReportDao {
	private static final String REPORT_INSERT_SQL = "INSERT INTO report(report_id,report_name,report_type,report_company,report_time,report_contribution,report_proof) VALUES(?,?,?,?,?,?) ";
	private static final String REPORT_SELECT_SQL = "SELECT * FROM report where report_id = (?)";
	private static final String REPORT_COUNT_SQL = "SELECT count(*) FROM report";
	@Override
	public void addReport(Report report) {
		// TODO 自动生成的方法存根
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement psmt = con.prepareStatement(REPORT_INSERT_SQL);
			psmt.setInt(1,report.getReport_id());
			psmt.setString(2, report.getReport_name());
			psmt.setString(3, report.getReport_type());
			psmt.setString(4, report.getReport_company());
			psmt.setDate(5, report.getReport_time());
			psmt.setInt(6, report.getReport_contribution());
			psmt.setString(7, report.getReport_proof());

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
	public void upReport(Report report) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteReport(int report_id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Report getReport(int report_id) {
		// TODO 自动生成的方法存根
		Connection con = null;
		Report report = new Report();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(REPORT_SELECT_SQL);
			psmt.setInt(1, report_id);
			rs=psmt.executeQuery();
			while (rs.next()){
				report.setReport_id(rs.getInt("report_id"));
				report.setReport_name(rs.getString("report_name"));
				report.setReport_type(rs.getString("report_type"));
				report.setReport_company(rs.getString("report_company"));
				report.setReport_time(rs.getDate("report_time"));
				report.setReport_contribution(rs.getInt("report_contribution"));
				report.setReport_proof(rs.getString("report_proof"));

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
		return report;
	}

	@Override
	public int getReportId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(REPORT_COUNT_SQL);
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
