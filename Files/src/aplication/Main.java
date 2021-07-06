package aplication;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        //---------- Usando class File para ler arquivo.

        /*File file = new File("/home/alisson/JavaCourse/Files/morning.txt");
        Scanner sc = null;
        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
                System.out.print("Error: " + e.getMessage());
        }finally{
            if(sc != null) {
                sc.close();
            }
        }
        */

        //----------Usando FileReader e BufferedReader com fechamento da instancia em finally

        /*

        String path = "/home/alisson/JavaCourse/Files/morning.txt";

        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch(IOException e){
            System.out.print("Error: " + e.getMessage());
        }finally{
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }*/

        //---------- Usando FileReader e BufferedReader com try-with-resources

        /*

        String path = "/home/alisson/JavaCourse/Files/morning.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch(IOException e){
            System.out.print("Error: " + e.getMessage());
        }*/

        //----------Escrevendo com FileWriter e BufferedWriter

        /*
        String path = "/home/alisson/JavaCourse/Files/new.txt";

        //String[] lines = new String[]{"Alisson", "Faby", "Christian"};
        String[] lines = new String[]{"Tayllor"};

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
       */

        //Manipulando pastas

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho: ");

        String strPath = new sc.nextLine();






        sc.close();

    }
}
