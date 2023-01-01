package edu.dao.impl;

import edu.dao.ActivityDAO;
import edu.domain.Activity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDaoImpl extends DAOBase implements ActivityDAO {

    private static final String ACTIVITY_INSERT_SQL =
            "INSERT INTO dbo.activity(name,addr,adate,report,picture,note,grad_id,state)VALUES(?,?,?,?,?,?,?,?)";

    @Override
    public void addActivity(Activity activity) {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pst = con.prepareStatement(ACTIVITY_INSERT_SQL);
            pst.setString(1, activity.getName());
            pst.setString(2, activity.getAddr());
            pst.setString(3, activity.getDate());
            pst.setString(4, activity.getReport());
            pst.setString(5, activity.getPicture());
            pst.setString(6, activity.getNote());
            pst.setString(7, activity.getGid());
            pst.setString(8, activity.getState());
            pst.executeUpdate();
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                assert con != null;
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteActivity(Integer id) throws SQLException {
        Connection conn = getConnection();
        Statement stmt = null;
        try {
            String DELETE_ACTIVITY_SQL = "delete from dbo.activity where id = " + id;
            stmt = conn.createStatement();
            stmt.executeUpdate(DELETE_ACTIVITY_SQL);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert stmt != null;
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public List<Activity> queryActivityById(String gid) {
        Connection con = null;
        ResultSet rs; //结果集
        List<Activity> activities = new ArrayList<>();
        try{
            con = getConnection();
            String ACTIVITY_SELECT_SQL = "SELECT * FROM dbo.activity WHERE grad_id=?";
            PreparedStatement pst = con.prepareStatement(ACTIVITY_SELECT_SQL);
            pst.setString(1, gid);
            rs = pst.executeQuery();
            Activity activity;
            while(rs.next()){
                activity = new Activity();
                activity.setId(rs.getString("id"));
                activity.setAddr(rs.getString("addr"));
                activity.setName(rs.getString("name"));
                activity.setReport(rs.getString("report"));
                activity.setDate(rs.getString("adate"));
                activity.setPicture(rs.getString("picture"));
                activity.setNote(rs.getString("note"));
                activity.setState(rs.getString("state"));
                activities.add(activity);
            }
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                assert con != null;
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return activities;
    }

    @Override
    public List<Activity> queryActivityByDepart(String depart) {
        Connection con = null;
        ResultSet rs; //结果集
        List<Activity> activities = new ArrayList<>();
        try{
            con = getConnection();
            String ACTIVITY_SELECT_SQL2 = "SELECT * FROM dbo.activity JOIN dbo.student ON grad_id=id WHERE sdepart=? and state='导师审核通过'";
            PreparedStatement pst = con.prepareStatement(ACTIVITY_SELECT_SQL2);
            pst.setString(1, depart);
            rs = pst.executeQuery();
            Activity activity;
            while(rs.next()){
                activity = new Activity();
                activity.setId(rs.getString("id"));
                activity.setAddr(rs.getString("addr"));
                activity.setName(rs.getString("name"));
                activity.setReport(rs.getString("report"));
                activity.setDate(rs.getString("adate"));
                activity.setPicture(rs.getString("picture"));
                activity.setNote(rs.getString("note"));
                activity.setState(rs.getString("state"));
                activities.add(activity);
            }
            pst.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                assert con != null;
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return activities;
    }

    @Override
    public void updateStateById(String id, String note) {
        Connection con = null;
        try {
            con = getConnection();
            String UPDATE_STATE_SQL = "update dbo.activity set state=? where id=?";
            PreparedStatement pst = con.prepareStatement(UPDATE_STATE_SQL);
            pst.setString(1, note);
            pst.setString(2, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert con != null;
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
