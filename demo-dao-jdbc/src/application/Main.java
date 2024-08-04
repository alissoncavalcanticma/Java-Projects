package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department dp = new Department(1, "TI");

        Seller seller = new Seller(11, "Alisson", "alisson@als.com.br", new Date(), 5800.00, dp);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(dp);
        System.out.println(seller);

    }
}