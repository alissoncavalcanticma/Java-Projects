import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//TIP Instant <shortcut actionId="DateTime"/>

        LocalDate data1 = LocalDate.now();
        System.out.println("Data 01: " + data1);

        LocalDateTime data2 = LocalDateTime.now();
        System.out.println("Data 02: " + data2);

        //DataHora Global, com fuso horário
        Instant data3 = Instant.now();
        System.out.println("Data 03 (GLobal): " + data3);

        //TIP DateTime parse




        }
}