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

		/////// Testing, needed for quickLoad
		driver.scanner.close();
		driver.scanner = null;
		/////// Testing
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
				deposit();
				break;
			case "2":
				withdraw();
				break;
			case "3":
				balance();
				break;
			case "4":
				history();
				break;
			case "5":
				changeContact();
				break;
			case "6":
				resetPassword();
				break;
			case "0":
				command = "logout";
				break;
			}

			System.out.println();
		}

		writeCustomer();

	}

	private void deposit()
	{
		System.out.println("Enter Deposit Amount:");
		String amount = scanner.nextLine();

		try
		{
			float amountF = Float.parseFloat(amount);
			if (amountF < 0)
				System.out.println("Please Enter Postive Amount");
			else
			{
				balance += amountF;
				writeHistory("Deposit", String.valueOf(amountF));
			}

		}
		catch (Exception e)
		{
			System.out.println("Please Enter An Amount");
		}
	}

	private void withdraw()
	{
		System.out.println("Enter Withdraw Amount:");
		String amount = scanner.nextLine();

		try
		{
			float amountF = Float.parseFloat(amount);
			if (amountF < 0)
				System.out.println("Please Enter Positve Amount");
			else if ((balance - amountF) < 0)
			{
				System.out.println("No Funds For This Withdraw");
			}
			else
			{
				balance -= amountF;
				writeHistory("Withdraw", String.valueOf(amountF));
			}

		}
		catch (Exception e)
		{
			System.out.println("Please Enter An Amount");
		}
	}

	private void balance()
	{
		System.out.println("Your Balance Is: " + balance);
	}
	
	private void history() throws IOException
	{
		scanner = new Scanner(new File(directory + "/Database/customer/" + userID + ".txt"));
		
		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();

			if (line.equals("********************"))
			{
				System.out.println(line);
				while (scanner.hasNextLine())
					System.out.println(scanner.nextLine());
			}
		}
		scanner.close();
	}

	private void changeContact()
	{
		System.out.println("Please Enter Address:");
		address = scanner.nextLine();
		System.out.println("Please Enter Phone:");
		phoneNumber = scanner.nextLine();
	}
	
	private void resetPassword()
	{
		System.out.println("Please Enter Current Password:");
		String newP = String.valueOf(scanner.nextLine().hashCode());
		
		if (newP.equals(password))
		{
			System.out.println("Please Enter New Password:");
			password = String.valueOf(scanner.nextLine().hashCode());
		}
		else
			System.out.println("Incorrect Password");
	}

	private void writeHistory(String type, String amount) throws IOException
	{
		boolean startLog = false;
		java.util.Date date = new java.util.Date();

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
				printwriter.println("Balance: " + balance);
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

		oldFile.renameTo(newFile);
	}
	
	private void writeCustomer() throws IOException
	{
		FileWriter filewriter = new FileWriter(directory + "/Database/customer/" + userID + "-new.txt");
		PrintWriter printwriter = new PrintWriter(filewriter);
		scanner = new Scanner(new File(directory + "/Database/customer/" + userID + ".txt"));

		printwriter.println(password);
		printwriter.println(fname);
		printwriter.println(lname);
		printwriter.println(address);
		printwriter.println(phoneNumber);
		printwriter.println(balance);
		printwriter.println();
		
		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			
			if (line.equals("********************"))
			{
				printwriter.println(line);
				while (scanner.hasNextLine())
					printwriter.println(scanner.nextLine());
			}
		}


		printwriter.close();
		filewriter.close();
		scanner.close();
		
		File oldFile = new File(directory + "/Database/customer/" + userID + "-new.txt");
		File newFile = new File(directory + "/Database/customer/" + userID + ".txt");
		newFile.delete();

		oldFile.renameTo(newFile);
	}

}