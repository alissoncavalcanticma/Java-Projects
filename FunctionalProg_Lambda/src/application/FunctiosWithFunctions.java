package application;

import entities.Product;
import model.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctiosWithFunctions {
    public static void main(String[] args) {

        //TIP Predicates

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //TIP Calcular soma dos preços dos produtos que começar com a letra T

        ProductService ps = new ProductService();

        double sum = ps.filtereSum(list, p->p.getName().charAt(0) == 'T');


        System.out.println("\n==================== List  =======================\n" );
        list.forEach(System.out::println);

        System.out.println("\n==================== Sum List based in Criteria  =======================\n" );
        System.out.println("Sum : " + String.format("%.2f", sum));
    }
}