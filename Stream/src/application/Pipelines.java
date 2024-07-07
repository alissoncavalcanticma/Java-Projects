package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pipelines {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(2,3,4,5,7,9));

        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        // OBS: Primeiro argumento da função reduce é o elemento neutro da operação (Ex: Multiplicação = 1, soma = 0)
        int sum = list.stream().reduce(1, (x,y) -> x * y);
        System.out.println("Soma: " + sum);


        //Transformando Stream baseados em regras lambda
        List<Integer> newList = list.stream()
                .filter(x -> x % 2 == 0)
                .map(x -> x * 10)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(newList.toArray()));

    }
}