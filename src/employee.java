import java.util.*;
import javax.swing.JFileChooser;
import java.lang.*;
import java.io.*;

public class employee
{
	String fname, lname, address, password;
	static String directory;
	static Scanner scanner;

	public employee(String password, String fname, String lname, String address, String directory) throws IOException
	{
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		employee.directory = directory;

		menu();
	}

	private static void menu() throws IOException
	{
		String command = "";

		while (!command.equals("logout"))
		{
			scanner = new Scanner(System.in);

			System.out.println("What would you like to do?");
			System.out.println("1: Create Customer");
			System.out.println("0: Exit");

			switch (scanner.next())
			{
			case "1":
				System.out.println();
				createCustomerPrompt();
				break;
			case "0":
				command = "logout";
				break;
			}

			System.out.println();
		}
	}

	private static void createCustomerPrompt() throws IOException
	{
		System.out.print("First Name: ");
		String cfname = scanner.next();
		scanner.nextLine();
		
		System.out.print("Last Name: ");
		String clname = scanner.next();
		scanner.nextLine();
		
		System.out.print("Address: ");
		String caddress = scanner.nextLine();
		
		System.out.print("Phone: ");
		String cphone = scanner.next();
		scanner.nextLine();

		createCustomer(cfname, clname, caddress, cphone, 0.0);
	}

	// this creates an customer .txt file in the database and increments the
	// customer counter
	// DO NOT EDIT THIS. WILL BREAK EVERYTHING
	private static void createCustomer(String first, String last, String address, String phone, double balance)
			throws IOException
	{

		scanner = new Scanner(new File(directory + "/Database/counters.txt"));

		FileWriter filewriter = new FileWriter(directory + "/Database/customer/" + "C" + scanner.nextInt() + ".txt");
		PrintWriter printwriter = new PrintWriter(filewriter);

		printwriter.println(first + last);
		printwriter.println(first);
		printwriter.println(last);
		printwriter.println(address);
		printwriter.println(phone);
		printwriter.println(balance);

		filewriter.flush();
		printwriter.flush();

		scanner = new Scanner(new File(directory + "/Database/counters.txt"));

		String[] counters = new String[2];

		counters[0] = Integer.toString(Integer.parseInt(scanner.nextLine()) + 1);
		counters[1] = scanner.nextLine();

		filewriter = new FileWriter(directory + "/Database/counters.txt");
		printwriter = new PrintWriter(filewriter);

		printwriter.println(counters[0]);
		printwriter.println(counters[1]);

		printwriter.close();
		filewriter.close();
	}
}