import java.util.*;
import javax.swing.JFileChooser;
import java.lang.*;
import java.io.*;

/*
 * Fix deletion of customer when customer is selected. Will not delete do to open stream.
 */
public class employee
{
	String fname, lname, address, password;
	static customer customer;
	static String directory;
	static Scanner scanner;

	public employee(String password, String fname, String lname, String address, String directory) throws IOException
	{
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		employee.directory = directory;

	}

	private void menu() throws IOException
	{
		String command = "";

		while (!command.equals("logout"))
		{
			scanner = new Scanner(System.in);

			System.out.println("What would you like to do?");
			System.out.println("1: Customer Select");
			System.out.println("2: Customer Deposit");
			System.out.println("3: Customer Withdraw");
			System.out.println("4: Customer Balance");
			System.out.println("5: Customer History");
			System.out.println("6: Create Customer");
			System.out.println("7: Delete Customer");
			System.out.println("0: Exit");

			switch (scanner.nextLine())
			{
			case "1":
				System.out.println();
				//selectCustomer();
				break;
			case "2":
				if (customer == null)
				{
					System.out.println("Select Customer");
					break;
				}
				else
					// TODO
					break;
			case "3":
				if (customer == null)
				{
					System.out.println("Select Customer");
					break;
				}
				else
					// TODO
					break;
			case "4":
				if (customer == null)
				{
					System.out.println("Select Customer");
					break;
				}
				else
					// TODO
					break;
			case "5":
				if (customer == null)
				{
					System.out.println("Select Customer");
					break;
				}
				else
					// TODO
					break;
			case "6":
				System.out.println();
				createCustomerPrompt();
				break;
			case "7":
				System.out.println();
				deleteCustomer();
				break;
			case "11":
				readCustomer("C1000");
				break;
			case "0":
				command = "logout";
				break;
			}
			
			System.out.println();
		}

		customer = null;
	}

	void selectCustomer(String u) throws IOException
	{
		String userID = u;

		try
		{
			scanner = new Scanner(new File(directory + "/Database/customer/" + userID + ".txt"));
			customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
					scanner.nextLine(), Double.valueOf(scanner.nextLine()), userID, directory, false);

		}
		catch (FileNotFoundException e)
		{
			System.out.println("Customer ID Invalid");
		}
		System.out.println(customer);
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

		printwriter.println((first + last).hashCode());
		printwriter.println(first);
		printwriter.println(last);
		printwriter.println(address);
		printwriter.println(phone);
		printwriter.println(balance);
		printwriter.println();
		printwriter.println("********************");

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

	private static void deleteCustomer()
	{
		System.out.println("Please enter User ID to delete: ");
		String userID = scanner.next();

		File oldFile = new File(directory + "/Database/customer/" + userID + ".txt");
		File newFile = new File(directory + "/Database/customer/" + userID + "-deleted.txt");

		if (oldFile.renameTo(newFile))
			System.out.println("User Deleted");
		else
			System.out.println("Deletion Failed");
	}

	// Testing+++++++++++++++++++++++++++++++++++++++
	private static void readCustomer(String userID) throws FileNotFoundException
	{
		scanner = new Scanner(new File(directory + "/Database/customer/" + userID + ".txt"));
		while (scanner.hasNext())
			System.out.println(scanner.nextLine());
	}
}