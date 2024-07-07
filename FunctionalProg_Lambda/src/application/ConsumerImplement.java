package application;

import entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ConsumerImplement {
    public static void main(String[] args) {

        //TIP Predicates

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //TIP Atualizando preços baseado em porcentagem, usando lambda
        list.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        System.out.println("\n==================== List after remove =======================\n" );
        for(Product p : list){
            System.out.println(p);
        }

        System.out.println("\n==================== List after remove with forEach  =======================\n" );
        list.forEach(System.out::println);

    }
}