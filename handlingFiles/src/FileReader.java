import java.io.IOException;
import java.io.BufferedReader;


//Aula trabalhando com Arquivo CSV em JAVA: https://www.youtube.com/watch?v=Y7UviY05U78

public class FileReader {
    public static void main(String[] args) {

        String path = "c:\\temp\\in.txt";
        //FileReader fr = null;
        //BufferedReader br = null;

        //TIP Usando try-with-resources para instanciar as classes de file streams na chamada do try

        try(BufferedReader br = new BufferedReader(new java.io.FileReader(path))){
            //fr = new FileReader(path);
            //br = new BufferedReader(fr);

            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        // ============================================================================s



            //TIP Usando class File e Scanner

        /*
            Scanner sc = null;
            File file = new File("c:\\temp\\in.txt");

            try{
                sc = new Scanner(file);
                while(sc.hasNextLine()){
                    System.out.println(sc.nextLine());
                }
            }catch(IOException e){
                System.out.println("Error: " + e.getMessage());
            }finally{
                if(sc != null){
                    sc.close();
                }
            }
            */

        }
}
