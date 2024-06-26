package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Locale;
import java.util.Scanner;

public class Program {
        public static void main (String[] args){

/*                Scanner sc = new Scanner(System.in);

                String dt = sc.next();
                LocalDate date = LocalDate.parse(dt, DateTimeFormatter.ofPattern("dd/MM/yyyy"));


                System.out.println("Data: " + date);
                sc.close();*/


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

                Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));

                System.out.print("How many contracts  to this worker?");

                int n = sc.nextInt();
                for(int i=1;i <= n; i++){
                        System.out.println("Enter contract #" + i + "data:");
                        System.out.print("Date(DD/MM/YYYY): ");
                        LocalDate contractDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        System.out.print("Value per Hour: ");
                        Double valuePerHour = sc.nextDouble();
                        System.out.print("Duration (hours): ");
                        int hours = sc.nextInt();
                        HourContract contract = new HourContract(contractDate, valuePerHour, hours);
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
