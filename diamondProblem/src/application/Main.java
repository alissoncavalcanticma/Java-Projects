package application;

import devices.Printer;
import devices.Scanner;

public class Main {
    public static void main(String[] args) {

        Printer p = new Printer("Epson Cx3300");
        p.processDoc("MyLetter");
        p.print("MyLetter");

        Scanner s = new Scanner("LG ScanMulti LG2598");
        s.processoDoc("MyE-mail");
        System.out.println("Scan result: " + s.scan());

    }
}