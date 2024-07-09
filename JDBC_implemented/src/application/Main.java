package application;

import db.DB;
import db.DbException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

        //Instanciando objetos de conexão
        Connection conn = null;
        PreparedStatement ps = null;

        //Instância usada na definição de data de ps
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        /** Bloco try  **/
        try{
            conn = DB.getConnection();

            //Statement
            ps = conn.prepareStatement(
                "INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS //Usado para retornar o Id do registro criado;
            );

            //Incrementando o Statement com os dados a serem inseridos
            ps.setString(1, "Alisson");
            ps.setString(2, "alisson@alisson.com");
            ps.setDate(3, new java.sql.Date((sdf.parse("08/07/2024").getTime())));
            ps.setDouble(4, 4300.00);
            ps.setInt(5, 4);


            int rowsAffected = ps.executeUpdate();

            if(rowsAffected > 0){
                //Objeto ResultSet recebendo dados da execução
                ResultSet rs = ps.getGeneratedKeys();

                while(rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! Id= " + id);
                }
            }else{
                System.out.println("Not Rows Affected!");
            }


        }catch(SQLException e){
            e.printStackTrace();
        }catch(ParseException e){
            e.printStackTrace();
        }finally{
            DB.closeConnection();
            DB.closeStatement(ps);
        }


        //TIP Recuperando dados

        /*
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

            System.out.println(rs.getStatement());

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DB.closeConnection();
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
         */
    }
}