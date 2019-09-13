import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.lang.*;
import java.io.*;

public class driver
{
	static Scanner scanner;
	
	public static void main(String[] args) throws IOException
	{
		scanner = null;

		try
		{
			// This block is for testing purposes only. To be removed when we get a PI
			// This is for selecting our Database on different computers
			///////////////////////////////////////////////////////////
			JFileChooser j = new JFileChooser();
			j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

			System.out.println("Please choose your Database Folder.");
			System.out.println();
			j.showOpenDialog(null);
			///////////////////////////////////////////////////////////

			scanner = new Scanner(new File(j.getCurrentDirectory() + "/Database/counters.txt"));
			
			createEmployee("Josh", "Howard", "password".hashCode(), "South Carolina", 1000.40, j);
			
			//employee employee = new employee("1000", "password".hashCode());
			
		} 
		catch (Exception e)
		{
			System.out.println("Error: " + e);
		} 
		finally
		{
			scanner.close();
			System.out.println("Finished"); //for testing
		}

		/*
		 * customer c1, c2, c3;
		 * String newPassword;
		 * c1 = new customer("Lucky", "Rowe", 0001, "pass", "260 road, st, 29303", 1000.00);
		 * c2 = new customer("Conner", "Murray", 0002, "pass2", "2000 road, st, 29323", 3000.00);
		 * c3 = new customer("Josh", "Howard", 0003, "pass3", "300 road, st, 29499", 6000.00);
		 * 
		 * System.out.println("Customer 1 is " + c1.fname + " " + c1.lname + " and they live at " + c1.address);
		 * System.out.println(c1.fname + " has a balance of " + c1.balance + " before deposits/withdraws.");
		 * c1.deposit(100.00);
		 * System.out.println(c1.fname + " has a balance of " + c1.balance + " after deposits.");
		 * c1.withdraw(200.00);
		 * System.out.println(c1.fname + " has a balance of " + c1.balance + " after withdraws.");
		 * 
		 * System.out.println();
		 * 
		 * System.out.println("Customer 2 is " + c2.fname + " " + c2.lname +
		 * " and they live at " + c2.address); System.out.println(c2.fname +
		 * " has a balance of " + c2.balance + " before deposits/withdraws.");
		 * c2.deposit(1000.00); System.out.println(c2.fname + " has a balance of " +
		 * c2.balance + " after deposits."); c2.withdraw(1500.00);
		 * System.out.println(c2.fname + " has a balance of " + c2.balance +
		 * " after withdraws.");
		 * 
		 * System.out.println();
		 * 
		 * System.out.println("Customer 3 is " + c3.fname + " " + c3.lname +
		 * " and they live at " + c3.address); System.out.println(c3.fname +
		 * " has a balance of " + c3.balance + " before deposits/withdraws.");
		 * c3.deposit(2000.00); System.out.println(c3.fname + " has a balance of " +
		 * c3.balance + " after deposits."); c3.withdraw(3500.00);
		 * System.out.println(c3.fname + " has a balance of " + c3.balance +
		 * " after withdraws.");
		 * 
		 * // example password reset for Customer 1
		 * System.out.println("\nCustomer 1 would like to change their password");
		 * Scanner scan = new Scanner(System.in); do {
		 * System.out.println("Please enter new password for Customer 1:"); newPassword
		 * = scan.next(); } while (c1.resetPassword(newPassword) != true); scan.close();
		 * System.out.println("Password has been reset successfully!");
		 * System.out.println("Customer 1's new password is: " + c1.getPassword());
		 */
	}
	
	//this creates an employee .txt file in the database and increments the employee counter
	//DO NOT EDIT THIS. WILL BREAK EVERYTHING
	private static void createEmployee(String first, String last, int pass, String address, double amount, JFileChooser j) throws IOException
	{
		scanner.nextInt();
		
		FileWriter filewriter = new FileWriter(j.getCurrentDirectory() + "/Database/employee/" + scanner.nextInt() + ".txt");
		PrintWriter printwriter = new PrintWriter(filewriter);
		
		printwriter.println(first);
		printwriter.println(last);
		printwriter.println(pass);
		printwriter.println(address);
		printwriter.println(amount);
		
		filewriter.flush();
		printwriter.flush();
		
		scanner = new Scanner(new File(j.getCurrentDirectory() + "/Database/counters.txt"));
		
		String[] counters = new String[2];
		counters[0] = scanner.nextLine();
		counters[1] = Integer.toString(Integer.parseInt(scanner.nextLine()) + 1);
		
		filewriter = new FileWriter(j.getCurrentDirectory() + "/Database/counters.txt");
		printwriter = new PrintWriter(filewriter);
		
		printwriter.println(counters[0]);
		printwriter.println(counters[1]);
		
		printwriter.close();
		filewriter.close();
	}
}