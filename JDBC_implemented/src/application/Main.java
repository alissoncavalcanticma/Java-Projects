package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try{
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM department");

            while(rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DB.closeConnection();
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}