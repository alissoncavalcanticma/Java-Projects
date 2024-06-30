package application;

import devices.ComboDevice;
import devices.Printer;
import devices.Scanner;

public class Main {
    public static void main(String[] args) {

        Printer p = new Printer("Epson Cx3300");
        p.processDoc("MyLetter");
        p.print("MyLetter");

        Scanner s = new Scanner("LG ScanMulti LG2598");
        s.processDoc("My E-mail");
        System.out.println("Scan result: " + s.scan());

        ComboDevice c = new ComboDevice("2081");
        c.processDoc("MyDissertation");
        c.print("My Printing");
        System.out.println("ComboDevice Scan result: " + c.scan());

    }
}