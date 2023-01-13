package DAO;

import bean.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RequestDaoImpl extends DAOBase implements RequestDao {
    @Override
    public void insertRequest(Request request) {
        try {
            Connection conn = getConnection();
            String sql = "insert into request values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, request.getSno());
            ps.setString(2, request.getCno());
            ps.setString(3, request.getAgree());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getRequestNumBySno(String sno) {
        try {
            Connection conn = getConnection();
            String sql = "select count(*) from request where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public List<Request> getAgrees(String sno) {
        try {
            Connection conn = getConnection();
            String sql = "select * from request where sno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ResultSet rs = ps.executeQuery();
            List<Request> agreeList = new ArrayList<>();
            while (rs.next()){
                Request agree =new Request(sno,rs.getString("cno"),rs.getString("agree"));
                agreeList.add(agree);
            }
            return agreeList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean requestExisted(String sno, String cno) {
        try {
            Connection conn = getConnection();
            String sql = "select * from request where sno = ? and cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ps.setString(2, cno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public int getRequestNumByCno(String cno) {
        try {
            Connection conn = getConnection();
            String sql = "select count(*) from request where cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    @Override
    public void deleteRequest(String sno,String cno){
        try {
            Connection conn = getConnection();
            String sql = "delete from request where sno=? and cno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ps.setString(2, cno);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Request> getRequestsByTno(String tno) {
        try {
            Connection conn = getConnection();
            String sql = "select sno,request.cno from request join course on request.cno=course.cno collate Chinese_PRC_CI_AS where agree='0' and cteacher=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tno);
            ResultSet rs = ps.executeQuery();
            List<Request> requestList = new ArrayList<>();
            while (rs.next()){
                Request request =new Request(rs.getString("sno"),rs.getString("cno"),null);
                requestList.add(request);
            }
            return requestList;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void setAgreeBySnoCno(String sno, String cno) {
        try {
            Connection conn = getConnection();
            String sql = "update request set agree='1' where sno=? and cno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sno);
            ps.setString(2, cno);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getagree(String cno){
        try {
            Connection conn = getConnection();
            String sql = "select agree from request where cno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}
