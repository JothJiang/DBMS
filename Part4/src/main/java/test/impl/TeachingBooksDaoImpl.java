package test.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dao.DAOBase;
import test.dao.TeachingBooksDao;
import test.entity.Paper;
import test.entity.TeachingBooks;

public class TeachingBooksDaoImpl extends DAOBase implements TeachingBooksDao {
	private static final String TEACH_INSERT_SQL = "INSERT INTO TeachingBooks(tb_id,tb_name,tb_publisher,tb_publicationtime,tb_contribution,tb_proof) VALUES(?,?,?,?,?) ";
	private static final String TEACH_SELECT_SQL = "SELECT * FROM TeachingBooks where paper_id = (?)";
	private static final String TEACH_COUNT_SQL = "SELECT count(*) FROM TeachingBooks";
	@Override
	public void addTeachingBooks(TeachingBooks teachingBooks) {
		// TODO 自动生成的方法存根
		Connection con = null;
		try{
			con = getConnection();
			PreparedStatement psmt = con.prepareStatement(TEACH_INSERT_SQL);
			psmt.setInt(1, teachingBooks.getTb_id());
			psmt.setString(2, teachingBooks.getTb_name());
			psmt.setString(3, teachingBooks.getTb_publisher());
			psmt.setDate(4, teachingBooks.getTb_publicationtime());
			psmt.setInt(5, teachingBooks.getTb_contribution());
			psmt.setString(6, teachingBooks.getTb_proof());

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
	public void upTeachingBooks(TeachingBooks teachingBooks) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void deleteTeachingBooks(int teachingBooks_id) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public TeachingBooks getTeachingBooks(int TeachingBooks_id) {
		// TODO 自动生成的方法存根
		Connection con = null;
		TeachingBooks teachingBooks = new TeachingBooks();
		try{
			con = getConnection();
			ResultSet rs=null;
			PreparedStatement psmt = con.prepareStatement(TEACH_SELECT_SQL);
			psmt.setInt(1, TeachingBooks_id);
			rs=psmt.executeQuery();
			while (rs.next()){
				teachingBooks.setTb_id(rs.getInt("tb_id"));
				teachingBooks.setTb_name(rs.getString("tb_name"));
				teachingBooks.setTb_publisher(rs.getString("tb_publisher"));
				teachingBooks.setTb_publicationtime(rs.getDate("tb_publicationtime"));
				teachingBooks.setTb_contribution(rs.getInt("tb_contribution"));
				teachingBooks.setTb_proof(rs.getString("tb_proof"));

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
		return teachingBooks;
	}

	@Override
	public int getTeachingBooksId() {
		// TODO 自动生成的方法存根
        Connection con = null;
        try{
            con = getConnection();
            ResultSet rs=null;
            PreparedStatement psmt = con.prepareStatement(TEACH_COUNT_SQL);
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
