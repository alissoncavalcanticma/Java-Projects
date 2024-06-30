import java.io.File;
import java.util.Scanner;

public class HandlingFoldersAndFiles {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o caminho da pasta:");
    String strPath = sc.nextLine();

    File path = new File(strPath);

    //Usando reference Methods como parâmetro, para listar apenas pastas
    File[] listFolders = path.listFiles(File::isDirectory);
    System.out.println("Folders: ");
    for(File folder : listFolders){
        System.out.println(folder);
    }

    //Usando reference Methods como parâmetro, para listar apenas arquivos
    File[] listFiles = path.listFiles(File::isFile);
    System.out.println("Files: ");
    for(File file : listFiles){
        System.out.println(file);
    }

    //TIP Criando sub pasta no path
    boolean success = new File(strPath + "\\subdir").mkdir();
    String ad = success ? "" : "not ";
    System.out.println("Directory " + ad + "created");


    //TIP Capturando informações
    System.out.println("Informações do path (File or Folder): ");
        String newPath = sc.nextLine();
        File file = new File(newPath);
        //Name
        System.out.println("getName: " + file.getName());
        //Folder
        System.out.println("getParent: " + file.getParent());
        //Path
        System.out.println("getPath: " + file.getPath());



    sc.close();
    }
}