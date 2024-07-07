package application;

import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class Predicates {
    public static void main(String[] args) {

        //TIP Predicates

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        list.removeIf(p -> p.getPrice() >= 100);

        System.out.println("\n==================== List after remove =======================\n" );
        for(Product p : list){
            System.out.println(p);
        }

        System.out.println("\n==================== List after remove with forEach  =======================\n" );
        list.forEach(System.out::println);

    }
}