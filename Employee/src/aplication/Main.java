package aplication;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Employees: ");
        int n = sc.nextInt();
        List<Employee> list = new ArrayList<>();

        for(int i=1;i<=n;i++){
            System.out.print("Employee #"+i+" data:");
            System.out.print("Outsourced (y/n)");
            char out = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per Hours: ");
            Double value = sc.nextDouble();
            if(out =='y'){
                System.out.print("Additional charge: ");
                Double addit = sc.nextDouble();
                Employee emp = new OutsourcedEmployee(name, hours, value, addit);
                list.add(emp);
            }else {
                Employee emp = new Employee(name, hours, value);
                list.add(emp);
            }
            System.out.println();
        }

        for(Employee ls : list){
            System.out.print("Name: ");
            System.out.println(ls.getName());
            System.out.print("Hours: ");
            System.out.println(ls.getHours());
            System.out.print("Value per hours: ");
            System.out.println(ls.getValuePerHour());
            System.out.print("Payment: " + ls.payment());
            System.out.print("\n\n");
        }

        sc.close();
    }
}
