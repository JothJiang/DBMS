package DAO;

import bean.Administrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdministratorDAOImpl extends DAOBase implements AdministratorDAO {
    private static final String PROJECT_SELECT_SQL = "select pwd from Train_administrator where tano=?";

    @Override
    public int login_search(String tano, String pwd) {
        Connection con = null;
        Administrator administrator = new Administrator();
        int flag=0;
        try{
            con = getConnection();
            PreparedStatement psmt = con.prepareStatement(PROJECT_SELECT_SQL);
            psmt.setString(1, tano);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                administrator.setpwd(rs.getString("pwd"));
                if(rs.getString("pwd").equals(pwd)) {
                    flag=1;
                }
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
        if(flag==1){
            return 2;
        }
        else {
            return 1;
        }
    }
}
