package aplication;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter Department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base Salary: ");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

        System.out.print("How many contracts  to this worker?");

        int n = sc.nextInt();
        for(int i=1;i <= n; i++){
            System.out.println("Enter contract #" + i + "data:");
            System.out.print("Date(DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per Hour: ");
            Double valuePerhour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerhour, hours);
            worker.addContract(contract);
        }

        System.out.println("");
        System.out.print("Enter month and Year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " +monthAndYear+ ": " + String.format("%.2f", worker.income(month, year)));

        sc.close();
    }
}
