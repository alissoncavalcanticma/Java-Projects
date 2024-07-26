package db;

import com.mysql.cj.conf.PropertySet;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    //TIP Objeto de conexão
    private static Connection conn = null;

    //TIP Método para realizar conexão
    public static Connection getConnection(){
        if(conn == null){
            try{
                Properties props = loadProperties();

                String url = props.getProperty("dburl");

                //TIP Instanciando objeto de conexão em conn
                conn = DriverManager.getConnection(url, props);

            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    //TIP Método para encerrar a conexão
    public static void closeConnection(){
        if(conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }




    //TIP Método para carregar properties
    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch(IOException e){
            throw new DbException(e.getMessage());
        }
    }

    //TIP Método para encerrar o Statement
    public static void closeStatement(Statement st){
        if(st != null){
            try{
                st.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    //TIP Método para encerrar o ResultSet
    public static void closeResultSet(ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }





}
