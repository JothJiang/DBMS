package test.impl;

import test.dao.DAOBase;
import test.entity.Paper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dao.*;

public class PaperDaoImpl extends DAOBase implements PaperDao {
	private static final String PAPER_INSERT_SQL = "INSERT INTO Paper(paper_id,paper_name,journal_name,paper_status,paper_time,index_type,paper_library,paper_proof) VALUES(?,?,?,?,?,?,?,?) ";
	private static final String PAPER_SELECT_SQL = "SELECT * FROM Paper where paper_id = (?)";
	private static final String PAPER_COUNT_SQL = "SELECT count(*) FROM Paper";
	@Override
	public void addPaper(Paper paper) {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PAPER_INSERT_SQL);
            psmt.setInt(1, paper.getPaper_id());
            psmt.setString(2, paper.getPaper_name());
            psmt.setString(3, paper.getJournal_name());
            psmt.setString(4, paper.getPaper_status());
            psmt.setDate(5, paper.getPaper_time());
            psmt.setString(6, paper.getIndex_type());
            psmt.setString(7, paper.getPaper_library());
            psmt.setString(8, paper.getPaper_proof());
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
	public void upPaper(Paper paper) {
		// TODO 自动生成的方法存根
		
	}
	
	@Override
	public void deletePaper(int paper_id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Paper getPaper(int paper_id) {
		// TODO 自动生成的方法存根
        Connection con = null;
        Paper paper = new Paper();
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(PAPER_SELECT_SQL);
            psmt.setInt(1, paper_id);
            rs=psmt.executeQuery();
            while (rs.next()){
                paper.setPaper_id(rs.getInt("paper_id"));
	            paper.setPaper_name(rs.getString("paper_name"));
	            paper.setJournal_name(rs.getString("journal_name"));
	            paper.setPaper_status(rs.getString("paper_status"));
	            paper.setPaper_time(rs.getDate("paper_time"));
	            paper.setIndex_type(rs.getString("index_type"));
	            paper.setPaper_library(rs.getString("paper_library"));
	            paper.setPaper_proof(rs.getString("paper_proof"));
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
		return paper;
	}

	@Override
	public int getPaperId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(PAPER_COUNT_SQL);
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
