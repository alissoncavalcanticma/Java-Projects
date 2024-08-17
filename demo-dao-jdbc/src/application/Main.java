package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /**
         * TESTE DE INSTANCIAÇÃO DE OBJ
        Department dp = new Department(1, "TI");
        Seller seller = new Seller(11, "Alisson", "alisson@als.com.br", new Date(), 5800.00, dp);
         **/

        //USANDO PADRÃO FACTORY PARA INSTANCIAR CONNECTION
        SellerDao sellerDao = DaoFactory.createSellerDao();


        //Teste seller findById
        Seller seller = sellerDao.findById(3);
        System.out.println("=== Teste findById ===");
        System.out.println(seller);

        //Teste seller findByDepartment
        System.out.println("\n=== Teste findByDepartment ===");
        Department department = new Department(1, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj : list){
            System.out.println(obj);
        }

        //Teste seller findAll
        System.out.println("\n=== Teste findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        //Teste seller insert
        System.out.println("\n=== Teste insert ===");
        Seller newSeller = new Seller(null, "TestInsert", "test.insert@gmail.com", new Date(), 7018.85, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

    }
}