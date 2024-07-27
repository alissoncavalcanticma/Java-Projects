package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {


        /******

         ===================  Transações  =========================

         ****** */

        //Instanciando objetos de manipulação de dados
        Connection conn = null;
        Statement st = null;

        //Try Block
        try{
            conn = DB.getConnection();
            st = conn.createStatement();

            //Setando false para auto-commit
            conn.setAutoCommit(false);


            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2900 WHERE DepartmentId = 1");

            //Causando fake erro
            int x = 1;
            if(x < 2){
                throw new SQLException("Fake Error");
            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary= 3090 WHERE DepartmentId = 2");

            //Commitando a transação
            conn.commit();


            System.out.println("Rows1: " + rows1);
            System.out.println("Rows2: " + rows2);

        }catch(SQLException e){
            try{
                //Definindo RollBack em caso de erro lançado
                conn.rollback();
                throw new DbException("transaction rolled back! Caused by: " + e.getMessage());
            }catch(SQLException e1){
                throw new DbException("Eror trying to rollback! Caused by: " + e1.getMessage());
            }
        }finally{
            DB.closeConnection();
            DB.closeStatement(st);
        }





        /******

         ===================  Deletando dados  =========================

         ****** */


        /*
        //Instanciando objetos de conexão
        Connection conn = null;
        PreparedStatement ps = null;

        //Try Block

        try{
            conn = DB.getConnection();
            ps = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ?;");

            ps.setInt(1, 2);

            int rowsAffected = ps.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        }catch(SQLException e){
           //e.printStackTrace();
            throw new DbIntegrityException(e.getMessage());
        }finally{
            DB.closeConnection();
            DB.closeStatement(ps);
        }

        */



        /******

         ===================  Atualizando dados  =========================

         ****** */

        /*


        /**
        //Instanciando objetos de conexão
        Connection conn = null;
        PreparedStatement st = null;


        //Try Block
        try{
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE (DepartmentId = ?);");
            st.setDouble(1,200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);



        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            DB.closeStatement(st);
            DB.closeConnection();
        }
        **/





        /******

         ===================  Inserindo dados  =========================

         ****** */

        /*


        //Instanciando objetos de conexão
        Connection conn = null;
        PreparedStatement ps = null;

        //Instância usada na definição de data de ps
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Bloco try
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
            ps.setDate(3, new java.sql.Date((sdf.parse("25/07/2024").getTime())));
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

         */



        /******

        ===================  Recuperando dados  =========================

        ****** */

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