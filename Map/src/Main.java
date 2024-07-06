import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Map<String, String> cookies = new TreeMap<>();

        cookies.put("name", "Alisson");
        cookies.put("employeer", "AMcom");
        cookies.put("email", "alisson@alisson.com");

        System.out.println("\n=================== MAP: "+ cookies + "==============================");

        System.out.println("\n======================================================================================");

        //TIP Removendo key
        cookies.remove("email");

        System.out.println("=================== MAP com remove: "+ cookies + "==============================");

        System.out.println("======================================================================================");

        //TIP verificando a existência de key
        System.out.println("Verificando se existe key 'name':");
        System.out.println("Constains key name? " + cookies.containsKey("name"));




        //TIP listando keys com for
        for (String key : cookies.keySet()){
            System.out.println(key + " : " + cookies.get(key));
        }



    }
}