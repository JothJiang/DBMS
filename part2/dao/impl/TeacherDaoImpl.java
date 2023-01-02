package edu.dao.impl;

import edu.dao.TeacherDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TeacherDaoImpl extends DAOBase implements TeacherDao {
    @Override
    public String checkTnoAndPwd(String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection();
            String QUERY_PWD_SQL = "select tname from dbo.teacher where tno=? and pwd=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, no);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("tname");
            }else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
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
