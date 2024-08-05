package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        /**
         * TESTE DE INSTANCIAÇÃO DE OBJ
        Department dp = new Department(1, "TI");
        Seller seller = new Seller(11, "Alisson", "alisson@als.com.br", new Date(), 5800.00, dp);
         **/

        //USANDO PADRÃO FACTORY PARA INSTANCIAR CONNECTION
        SellerDao sellerDao = DaoFactory.createSellerDao();


        //Teste findById
        Seller seller = sellerDao.findById(3);
        System.out.println("=== Teste findById ===");
        System.out.println(seller);

    }
}