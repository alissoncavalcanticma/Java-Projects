package application;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {

        //TIP HashSet não garante a ordem, mas é o mais rápido.
        //Set<String> set = new HashSet<>();

        //TIP TreeSet ordena, mas não é o mais rápido.
        //Set<String> set = new TreeSet<>();

        //TIP LinkedHashSet mantém a ordem de entrada
        Set<String> set = new LinkedHashSet<>();
        Set<String> set1 = new LinkedHashSet<>();

        set.add("TV");
        set.add("Notebook");
        set.add("Tablet");

        set1.add("TV");
        set1.add("Notebook");
        set1.add("Tablet");


        System.out.println("==========Contains=======");
        System.out.println(set.contains("TV"));


        System.out.println("================Print sets===============");
        for(String p : set){
            System.out.println(p);
        }

        System.out.println("================Remove===================");
        set1.remove("TV");

        System.out.println("================Print sets after remove===============");
        for(String p : set1){
            System.out.println(p);
        }

        System.out.println("================RemoveIF===================");
       // set.removeIf(x -> x.length() <= 3);
        set.removeIf(x -> x.charAt(0) != 'T');

        System.out.println("================Print sets after remove===============");
        for(String p : set){
            System.out.println(p);
        }

    }
}