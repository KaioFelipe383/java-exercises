package application;


import java.util.Scanner;
import model.entities.Account;
import model.exceptions.DomainException;
import java.util.InputMismatchException;
import java.util.Locale;


public class Program {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			Double balance = sc.nextDouble();
			sc.nextLine();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			sc.nextLine();
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			acc.withdraw(withdraw);
			
			System.out.println("New balance: " + acc.getBalance());
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Error: expected a number, but received invalid input");
		}
		catch(RuntimeException e){
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}
}
