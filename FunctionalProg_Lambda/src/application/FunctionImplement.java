package application;

import entities.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionImplement {
    public static void main(String[] args) {

        //TIP Predicates

        List<Product> list = new ArrayList<>();
        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        //TIP Atualizando nomes baseado em regra de função, usando lambda
        //List<String> strings =

        //TIP Function map cria nova lista e executa function para esse nova lista.
        //Functin map só funciona em tipo stream, por isso a necessidade de converter a list em stream.

        List<String> namesProducts = list.stream()
                .map(p -> p.getName().toUpperCase())
                .collect(Collectors.toList());



        // list.forEach(p -> p.setName(p.getName().toUpperCase());

        System.out.println("\n==================== List after remove =======================\n" );
        for(String p : namesProducts){
            System.out.println(p);
        }

        System.out.println("\n==================== List after remove with forEach  =======================\n" );
        namesProducts.forEach(System.out::println);

    }
}