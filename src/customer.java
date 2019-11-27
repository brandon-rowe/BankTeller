import java.util.*;
import java.io.*;
import java.lang.*;

public class customer
{
	String password, fname, lname, address, phoneNumber, userID;
	static String directory;
	static Scanner scanner;
	double balance;

	public customer(String password, String fname, String lname, String address, String phoneNumber, double balance,
			String userID, String directory, boolean menu) throws IOException
	{
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.userID = userID;
		customer.directory = directory;

		///////Testing, needed for quickLoad
		driver.scanner.close();
		driver.scanner = null;
		///////Testing
		if (menu == true)
			menu();
	}

	private void menu() throws IOException
	{
		String command = "";

		while (!command.equals("logout"))
		{
			scanner = new Scanner(System.in);

			System.out.println("What would you like to do?");
			System.out.println("1: Deposit");
			System.out.println("2: Withdraw");
			System.out.println("3: Balance");
			System.out.println("4: History");
			System.out.println("5: Change Contact Info");
			System.out.println("6: Change Password");
			System.out.println("0: Exit");

			switch (scanner.nextLine())
			{
			case "1":
				break;
			case "2":
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				break;
			case "6":
				break;
			case "11":
				writeHistory("Deposit", "100.00");//Testing
				break;
			case "0":
				command = "logout";
				break;
			}

			System.out.println();
		}

	}

	public double deposit(double amt)
	{
		balance += amt;
		return balance;
	}

	public double withdraw(double amt)
	{
		balance -= amt;
		return balance;
	}

	public double getBalance()
	{
		return balance;
	}

	public boolean resetPassword(String newPassword)
	{
		password = newPassword;
		// if the new password is the string "wrong", then password reset fails. For
		// testing purposes.
		if (newPassword.equals("wrong"))
			return false;
		return true;
	}

	public void changeContact(String address, String phoneNumber)
	{
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	private void writeHistory(String type, String amount) throws IOException
	{
		boolean startLog = false;
		java.util.Date date=new java.util.Date();
		
		scanner = new Scanner(new File(directory + "/Database/customer/" + userID + ".txt"));
		FileWriter filewriter = new FileWriter(directory + "/Database/customer/" + userID + "-edit.txt");
		PrintWriter printwriter = new PrintWriter(filewriter);
		
		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			
			if (line.equals("********************") && startLog == false)
			{
				printwriter.println(line);
				printwriter.println(date);
				printwriter.println(type + ": " + amount);
				printwriter.println(line);
				startLog = true;
			}
			else
				printwriter.println(line);
		}    
		
		printwriter.close();
		filewriter.close();
		scanner.close();
		
		File oldFile = new File(directory + "/Database/customer/" + userID + "-edit.txt");
		File newFile = new File(directory + "/Database/customer/" + userID + ".txt");
		newFile.delete();

		if (oldFile.renameTo(newFile))
			System.out.println("User Deleted");
		else
			System.out.println("Deletion Failed");
	}

}