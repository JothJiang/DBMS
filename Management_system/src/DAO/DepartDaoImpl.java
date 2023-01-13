package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepartDaoImpl extends DAOBase implements DepartDao{

    @Override
    public String getdnames(String dno){
        try {
            Connection conn = getConnection();
            String sql = "select dname from depart where dno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "-1";
    }

    @Override
    public int getask(String dno){
        try {
            Connection conn = getConnection();
            String sql = "select dask from depart where dno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updatesak(int dask,String dno){
        try {
            Connection conn = getConnection();
            String sql = "update depart set dask=? where dno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, dask);
            ps.setString(2, dno);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
