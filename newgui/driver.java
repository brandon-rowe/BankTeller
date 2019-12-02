import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.lang.*;
import java.io.*;

public class driver
{
	static Scanner scanner;
	static String directory = "";
	static String usern;
	static String pass;
	static employee employee;
	

	
	public driver(String usern, String pass) {
		this.usern = usern;
		this.pass = pass;
	}
	
	
	public driver() {
	}

	public static void main(String[] args) throws IOException
	{
		scanner = null;
		
		//-------This is to bypass DB select and login. For testing past login--------
		//-------Uncomment next three lines. Change dirctory to your local DB location
		/*directory = "E:/Users/Tater/Documents/Git/BankTeller/src";
		quickLoadEmployee("E1000");
		System.exit(0);*/
		
		/*//-------This is to bypass DB select and login. For testing past login--------
		//-------Uncomment next three lines. Change dirctory to your local DB location
		directory = "E:/Users/Tater/Documents/Git/BankTeller/src";
		quickLoadCustomer("C1000");
		System.exit(0);*/

			///////////////////////////////////////////////////////////
		
			login(usern, pass);

	}

	static void login(String u, String p) throws IOException
	{
		String user = u;
		int password = p.hashCode();

		if (user.length() >= 6 && user.charAt(5) == '-')
		{
			System.out.println("Invalid user/password\n");
		}
		else if (user.charAt(0) == 'E')
		{
			try
			{
				scanner = new Scanner(new File(directory + user + ".txt"));

				if (scanner.nextLine().equals(Integer.toString(password)))
				{
					System.out.println();
					scanner.close();
					//loadEmployee(user);
				} else {
					errorBox("Invalid Username or Password.", "Login failed");
					scanner.close();
				}

				scanner = new Scanner(System.in);
			} catch (Exception e)
			{
				errorBox("Invalid Username or Password.", "Login failed");
				scanner.close();
			}
		}
		else if (user.charAt(0) == 'C')
		{
			try
			{
				scanner = new Scanner(new File(directory + user + ".txt"));

				if (scanner.nextLine().equals(Integer.toString(password)))
				{
					System.out.println();
					scanner.close();
					//loadCustomer(user);
				} else {
					errorBox("Invalid Username or Password.", "Login failed");
					scanner.close();
				}

				scanner = new Scanner(System.in);
			} catch (Exception e)
			{
				errorBox("Invalid Username or Password.", "Login failed");
				scanner.close();
			}
		}
		else {
			errorBox("Invalid Username or Password.", "Login failed");
			scanner.close();
		}
		
	}
	
//source: https://stackoverflow.com/questions/7080205/popup-message-boxes
	
	    public static void errorBox(String infoMessage, String titleBar)
	{
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}

	private static void loadEmployee(String user) throws IOException
	{
		scanner = new Scanner(new File(directory + user + ".txt"));
		employee = new employee(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),scanner.nextLine(), directory);
	}
	
	private static void loadCustomer(String user) throws IOException
	{
		scanner = new Scanner(new File(directory + user + ".txt"));
		customer customer;
		customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
					scanner.nextLine(), Double.valueOf(scanner.nextLine()), user, directory, true);
			
		//customer = null;
	}

	static void withdraw(String user, String amount) throws IOException
	{
		scanner = new Scanner(new File(directory +  user + ".txt"));
		customer customer;
			customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
					scanner.nextLine(), Double.valueOf(scanner.nextLine()), user, directory, true);
			customer.withdraw(amount);
			customer.writeCustomer();
			amount = "";
			
		//customer = null;
	}
	
	static void deposit(String user, String amount) throws IOException
	{
		scanner = new Scanner(new File(directory + user + ".txt"));
		customer customer;
			customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
					scanner.nextLine(), Double.valueOf(scanner.nextLine()), user, directory, true);
			customer.deposit(amount);
			customer.writeCustomer();
			amount = "";
			
		//customer = null;
	}
	
	static void resetPassword(String user, String pass) throws IOException
	{
		scanner = new Scanner(new File(directory + user + ".txt"));
		customer customer;
			customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
					scanner.nextLine(), Double.valueOf(scanner.nextLine()), user, directory, true);
			customer.resetPassword(pass);
			customer.writeCustomer();
			
		//customer = null;
	}
	
	
	
	static double balance(String user) throws IOException
	{
		scanner = new Scanner(new File(directory + user + ".txt"));
		customer customer;
			customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
					scanner.nextLine(), Double.valueOf(scanner.nextLine()), user, directory, true);
			return customer.balance();
			
	}
	
	static void changeContact(String user, String address, String phoneNumber) throws IOException
	{
		scanner = new Scanner(new File(directory + user + ".txt"));
		customer customer;
			customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
					scanner.nextLine(), Double.valueOf(scanner.nextLine()), user, directory, true);
			customer.changeContact(address, phoneNumber);
			customer.writeCustomer();
			customer = null;
			
	}
	
	static String[] history(String user) throws IOException
	{
		scanner = new Scanner(new File(directory + user + ".txt"));
		customer customer;
			customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
					scanner.nextLine(), Double.valueOf(scanner.nextLine()), user, directory, true);
			return customer.history();
			
	}

	// this creates an employee .txt file in the database and increments the employee counter
	// DO NOT EDIT THIS. WILL BREAK EVERYTHING
	private static void createEmployee(String first, String last, int pass, String address) throws IOException
	{

		scanner = new Scanner(new File(directory + "/Database/counters.txt"));
		scanner.nextInt();

		FileWriter filewriter = new FileWriter(directory + "E" + scanner.nextInt() + ".txt");
		PrintWriter printwriter = new PrintWriter(filewriter);

		printwriter.println(pass);
		printwriter.println(first);
		printwriter.println(last);
		printwriter.println(address);

		filewriter.flush();
		printwriter.flush();

		scanner = new Scanner(new File(directory + "counters.txt"));

		String[] counters = new String[2];
		counters[0] = scanner.nextLine();
		counters[1] = Integer.toString(Integer.parseInt(scanner.nextLine()) + 1);

		filewriter = new FileWriter(directory + "counters.txt");
		printwriter = new PrintWriter(filewriter);

		printwriter.println(counters[0]);
		printwriter.println(counters[1]);

		printwriter.close();
		filewriter.close();
	}

	// --------------------delete this later, for faster testing----------------------
	private static void quickLoadEmployee(String user) throws IOException
	{
		scanner = new Scanner(new File("E:/Users/Tater/Documents/Git/BankTeller/src/Database/employee/" + user + ".txt"));
		employee employee = new employee(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),scanner.nextLine(), directory);
		employee = null;
	}
	private static void quickLoadCustomer(String user) throws IOException
	{
		scanner = new Scanner(new File("E:/Users/Tater/Documents/Git/BankTeller/src/Database/customer/" + user + ".txt"));
		customer customer = new customer(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
				scanner.nextLine(), Double.valueOf(scanner.nextLine()), user, directory, true);
		customer = null;
	}
}