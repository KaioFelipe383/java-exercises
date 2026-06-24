package application;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import entities.Employee;
import entities.OutsourcedEmployee;
public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		
		List <Employee> list = new ArrayList<>();
		
		System.out.print("Enter the number of employees: ");
		int n = sc.nextInt();
		sc.nextLine();

		for(int i=0; i < n; i++){
			System.out.println("Employee #" + (i + 1) + " data: ");
			System.out.print("Outsourced (y/n)? ");
			String answer = sc.nextLine();
			if(answer.equals("y")) {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Hours: ");
				Integer hours = sc.nextInt();
				sc.nextLine();
				System.out.print("Value per hour: ");
				Double valuePerHour = sc.nextDouble();
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				sc.nextLine();
				OutsourcedEmployee outsorced = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				list.add(outsorced);
			} else {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("Hours: ");
				Integer hours = sc.nextInt();
				sc.nextLine();
				System.out.print("Value per hour: ");
				Double valuePerHour = sc.nextDouble();
				sc.nextLine();
				Employee employee = new Employee(name, hours, valuePerHour);
				list.add(employee);
			}
		}
		
		System.out.println("PAYMENTS: ");
		for(Employee x: list) {
			System.out.println(x.getName() +": "+ x.payment());
		}
		sc.close();
	}
}
