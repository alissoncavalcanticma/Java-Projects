import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //TIP <b>Documentação Formatter</b>: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
        //<p> Criando Padrão de formato de data </p>

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        //TIP Instant DateTime

        LocalDate data1 = LocalDate.now();
        System.out.println("Data 01: " + data1);

        LocalDateTime data2 = LocalDateTime.now();
        System.out.println("Data 02: " + data2);

        //TIP DataHora Global, com fuso horário
        Instant data3 = Instant.now();
        System.out.println("Data 03 (GLobal): " + data3);

        //TIP DateTime parse

        LocalDate data4 = LocalDate.parse("2024-06-23");
        System.out.println("Data 04: " + data4);

        LocalDateTime data5 = LocalDateTime.parse("2024-06-23T11:05:26");
        System.out.println("Data 05: " + data5);

        Instant data6 = Instant.parse("2021-05-18T01:30:26Z");
        System.out.println("Data 06: " + data6);

        LocalDate data7 = LocalDate.parse("24/06/2024", fmt1);
        System.out.println("Data 07 (Format): " + data7);

        LocalDateTime data8 = LocalDateTime.parse("05/08/2024 08:56", fmt2);
        System.out.println("Data 08 (Format): " + data8);

        LocalDateTime data9 = LocalDateTime.parse("27/12/2024 08:56", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.println("Data 09 (Format): " + data9);

        LocalDate data10 = LocalDate.of(2025,10,02);
        System.out.println("Data 10 (of): " + data10);

        LocalDateTime data11 = LocalDateTime.of(2025,10,02, 15, 52, 21);
        System.out.println("Data 11 (of): " + data11);

        //TIP Convertendo Date em String

        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //TIP Formatter considerando o timezone do computador local
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());

        LocalDate data12 = LocalDate.parse("2024-11-25");
        System.out.println("Data 12: " + data12.format(fmt3));
        //TIP System.out.println("Data 12: " + fmt3.format(data12));

        //Formatando DateTime obtido do Instant
        Instant data13 = Instant.parse("2024-06-24T23:21:23Z");
        System.out.println("Data 13 (Instant with ZoneId): " + fmt4.format(data13));

        //TIP Formatando Instant para local considerando timeZone
        LocalDate data14 = LocalDate.ofInstant(data13,ZoneId.systemDefault());
        System.out.println("Data 14 (Instant ZoneId): " + data14);

        LocalDate data15 = LocalDate.now(ZoneId.systemDefault());
        System.out.println("Data 15 (LocalDate with Now()): " + data15);

        //TIP Formatando Instant para Timezone GMT de Portugal
        LocalDate data16 = LocalDate.ofInstant(data13,ZoneId.of("Portugal"));
        System.out.println("Data 16 (Instant ZoneId 'PORTUGAL'): " + data16);

        //TIP Obtendo valores do DateTime

        LocalDateTime data17 = LocalDateTime.parse("2024-06-24T05:03:23");
        System.out.println("Data 17 (Dia): " + data17.getDayOfMonth());
        System.out.println("Data 17 (Mês): " + data17.getMonth() + ", (" + data17.getMonthValue() + ")");
        System.out.println("Data 17 (Ano): " + data17.getYear());
        System.out.println("Data 17 (Hora): " + data17.getHour());
        System.out.println("Data 17 (Hora): " + data17.getMinute());
        System.out.println("Data 17 (Hora): " + data17.getSecond());


        //TIP Cálculos com Data-hora

        LocalDateTime data18 = LocalDateTime.parse("2024-06-24T05:03:23");

        System.out.println("Data 18 + 1 year: " + data18.plusYears(1).minusDays(3));
        System.out.println("Data 18 - 1 year: " + data18.minusYears(1));




        }
}