package application;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) {


        //TIP TreeSet ordena, mas não é o mais rápido.
        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(0,1,3,4,5,7,9,10));


        //Union

        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println("\n================ Print Union ===============");
        System.out.println(c);


        //Intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println("\n================ Print Union ===============");
        System.out.println(d);


        //Difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println("\n================ Print Difference ===============");
        System.out.println(e);

    }
}