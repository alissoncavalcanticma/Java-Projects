package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(2,3,4,5,7,9));

        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Alisson", "Fabiana", "Christian");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, x -> x+2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        //Stream inifinita implmentando sequencia de Fibonacci
        Stream<Long> st4 = Stream.iterate(new Long[]{0L, 1L}, p -> new Long[]{p[1], p[0]+p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

    }
}