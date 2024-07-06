package application;

import entities.Product;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //TIP Um objeto de uma classe sem hashCode e Equals implamentados, compara pela referência, ou seja, será true se for
        // o mesmo objeto ou 2 ponteiros apontando pro mesmo lugar.
        // Caso tenha implementado o hashCode e Equals, a comparação acontece por valor, independete da instância do objeto.

        Set<Product> set = new HashSet<>();

        set.add(new Product("Notebook", 1500.00));
        set.add(new Product("TV", 1000.00));
        set.add(new Product("Carro", 65000.00));

        Product prod = new Product("Carro", 65000.00);

        System.out.println(set.contains(prod));

    }
}