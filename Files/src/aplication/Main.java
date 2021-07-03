package aplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here

        /*
        *   Usando class File para ler arquivo.
        */
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
        }


    }
}
