import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterFile{
    public static void main(String[] args) {

        String path = "c:\\temp\\out.txt";

        String[] lines = new String[]{"Alisson", "Fabiana", "Christian", "Ashley"};

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}