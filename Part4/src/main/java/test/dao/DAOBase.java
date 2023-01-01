package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOBase implements DAO {
    @Override
    public Connection getConnection() {
        String URL="jdbc:sqlserver://127.0.0.1:1433; DatabaseName=courseDesign";
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             con = DriverManager.getConnection(URL,"sa","123456");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}
