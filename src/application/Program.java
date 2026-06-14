package application;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import entities.enums.OrderStatus;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {
	public static void main(String[] args )throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//Client data
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date: ");
		String birthdatestr = sc.nextLine();
		Date birthdate = sdf.parse(birthdatestr);
		Client client = new Client(name, email, birthdate);
		
		//Order data
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		OrderStatus stats = OrderStatus.valueOf(status);
		Order order = new Order(new Date(), stats, client);
		
		//Order item
		System.out.print("How many items to this order? ");
		int qtyorder = sc.nextInt();
		sc.nextLine();
		
		for (int i=0; i < qtyorder; i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			String productname = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			Product product = new Product(productname, price);
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			sc.nextLine();
			OrderItem orderitem = new OrderItem(quantity, price, product);
			order.addItems(orderitem);
		}
		
		//Order Summary
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order.toString());
		
		
		
		
		sc.close();
	}
}