package aplication;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room Number: ");
            int number = sc.nextInt();
            System.out.print("Check-in Date: (DD/MM/YYYY)");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out Date: (DD/MM/YYYY)");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.print("Enter data to update reservation: ");
            System.out.print("Check-in Date: (DD/MM/YYYY)");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out Date: (DD/MM/YYYY)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.print("Reservation Update: " + reservation);

        }catch(ParseException e){
            System.out.print("Format Date error");
        }catch(DomainException e){
            System.out.print("Error: " + e.getMessage());
        }


    }
}
