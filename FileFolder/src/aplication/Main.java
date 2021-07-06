package aplication;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //Manipulando pastas

        /*
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho: ");

        String strPath = sc.nextLine();
        File path = new File(strPath);

        //Listar Diretórios
        File[] folders = path.listFiles(File::isDirectory);
        //Listar Arquivos
        //File[] folders = path.listFiles(File::isFile);


        System.out.println("Folders: ");
        for(File folder : folders){
            System.out.println(folder);
        }

        //Criando subpasta no path
        boolean success = new File(strPath + "/testeNovaPasta").mkdir();

        sc.close();

         */

        //Pegando informações do arquivo /home/alisson/JavaCourse/FileFolder/src/aplication/Main.java

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho e nome do arquivo: ");

        String strPath = sc.nextLine();
        File path = new File(strPath);

        System.out.println("Arquivo: " + path.getName());
        System.out.println("Caminho: " +path.getParent());

        sc.close();
    }
}
