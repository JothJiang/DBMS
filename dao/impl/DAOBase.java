package edu.dao.impl;

import edu.dao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAOBase implements DAO {
    @Override
    public Connection getConnection() {
        String URL="jdbc:sqlserver://localhost;"
                + "integratedSecurity=true;"
                + "databaseName=education;";
        Connection con = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(URL);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return con;
    }
}
