package aplication;

import entities.Contract;
import entities.Installment;
import services.ContractService;
import services.OnlinePaymentService;
import services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
	// write your code
        Locale.setDefault(Locale.US); //Tem que estar antes do scanner
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Date (dd/mm/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.println("Enter number of installments: ");
        int N = sc.nextInt();

        ContractService cs = new ContractService(new PaypalService());

        cs.processContract(contract, N);

        System.out.println("Installments: ");
        for(Installment it : contract.getInstallments()){
            System.out.println(it);
        }



        sc.close();
    }
}
