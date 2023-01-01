package edu.dao.impl;

import edu.dao.ManagerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ManagerDaoImpl extends DAOBase implements ManagerDao {
    @Override
    public String checkMnoAndPwd(String no, String pwd) {
        Connection con = null;
        try {
            con = getConnection();
            String QUERY_PWD_SQL = "select dname from dbo.manager join dbo.depart on dno=mdepart where mno=? and pwd=?";
            PreparedStatement pst = con.prepareStatement(QUERY_PWD_SQL);
            pst.setString(1, no);
            pst.setString(2, pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("mdepart");
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
