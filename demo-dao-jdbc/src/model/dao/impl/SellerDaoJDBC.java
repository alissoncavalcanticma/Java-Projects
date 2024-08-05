package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {

    private Connection conn;

    public SellerDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void insert(Seller dp) {

    }

    @Override
    public void update(Seller dp) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {

        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
                    "SELECT " +
                            "seller.*, department.Name as DepName " +
                            "FROM " +
                            "seller " +
                            "INNER JOIN " +
                            "department " +
                            "ON seller.DepartmentId = department.Id " +
                            "WHERE seller.Id = ?;"
                    );
            st.setInt(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                //Função de instanciar Departamento
                Department dep = instantiateDepartment(rs);

                //Função de instanciar Seller
                Seller seller = instantiateSeller(rs, dep);

                return seller;

            }
            return null;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }


    }


    //Função para instanciar Seller
    //Exceção foi propagada, pois já tratada no método origem
    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {

        Seller seller = new Seller();
        seller.setId(rs.getInt("Id"));
        seller.setName(rs.getString("Name"));
        seller.setEmail(rs.getString("Email"));
        seller.setBirthDate(rs.getDate("BirthDate"));
        seller.setBaseSalary(rs.getDouble("BaseSalary"));
        seller.setDepartment(dep);

        return seller;

    }

    //Função para instanciar Department
    //Exceção foi propagada, pois já é tratada no método origem
    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dp = new Department();
        dp.setId(rs.getInt("DepartmentId"));
        dp.setName(rs.getString("DepName"));

        return dp;
    }
;
    @Override
    public List<Seller> findAll() {
        return List.of();
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try{
            st = conn.prepareStatement(
              "SELECT " +
                      "seller.*, department.Name as DepName " +
                  "FROM " +
                      "seller " +
                  "INNER JOIN " +
                      "department " +
                            "ON " +
                                "seller.DepartmentId = department.Id " +
                  "WHERE DepartmentId = ? " +
                  "ORDER BY Name;"
            );
            st.setInt(1, department.getId());

            rs = st.executeQuery();

            //List de Seller's
            List<Seller> list = new ArrayList<>();

            //Map para salvar o Department único
            Map<Integer, Department> map = new HashMap<>();

            while(rs.next()){

                Department dep = map.get(rs.getInt("DepartmentId"));

                if(dep == null){
                    dep = instantiateDepartment(rs);
                }

                Seller seller = instantiateSeller(rs, dep);

                list.add(seller);

            }
            return list;
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
