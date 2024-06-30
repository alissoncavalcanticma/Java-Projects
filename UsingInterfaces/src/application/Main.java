package application;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("========== Dados de locação ==========");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.println("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), format);
        System.out.println("Retirada (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), format);

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.println("Qual o preço/hora?");
        double pricePerHour = sc.nextDouble();
        System.out.println("Qual  preço/dia?");
        double pricePerDay= sc.nextDouble();


        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("================== FATURA =======================");
        System.out.println("Pagamento básico: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Imposto aplicado: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total: " +  String.format("%.2f", cr.getInvoice().getTotalPayment()));


        sc.close();
    }
}