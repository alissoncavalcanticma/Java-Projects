package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department dp = new Department(1, "TI");

        Seller seller = new Seller(11, "Alisson", "alisson@als.com.br", new Date(), 5800.00, dp);

        System.out.println(dp);
        System.out.println(seller);

    }
}