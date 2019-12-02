import java.util.*;

import javax.swing.JOptionPane;

import java.io.*;
import java.lang.*;

public class customer
{
	String password, fname, lname, address, phoneNumber, userID;
	static String directory;
	static Scanner scanner;
	static String debitCard, pin;
	double balance;

	public customer(String password, String fname, String lname, String address, String phoneNumber, double balance, String debitCard, String debitPin,
			String userID, String directory, boolean menu) throws IOException
	{
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.userID = userID;
		this.debitCard = debitCard;
		this.pin = debitPin;
		customer.directory = directory;

		/////// Testing, needed for quickLoad
		driver.scanner.close();
		driver.scanner = null;
		/////// Testing
	}



	void deposit(String amount)
	{
		
		try
		{
			float amountF = Float.parseFloat(amount);
			if (amountF < 0)
				errorBox("Please enter a positive value.", "Invalid amount");
			else
			{
				balance += amountF;
				writeHistory("Deposit", String.valueOf(amountF));
			}

		}
		catch (Exception e)
		{
			errorBox("No amount entered.", "Deposit Failed");
		}
	}

	void withdraw(String amount)
	{

		try
		{
			float amountF = Float.parseFloat(amount);
			if (amountF < 0)
				errorBox("Please enter a positive value.", "Invalid amount");
			else if ((balance - amountF) < 0)
			{
				errorBox("Insufficient funds.", "Withdraw denied.");
			}
			else
			{
				balance -= amountF;
				writeHistory("Withdraw", String.valueOf(amountF));
				//writeCustomer();
			}

		}
		catch (Exception e)
		{
			errorBox("No amount entered.", "Withdraw Failed");
		}
		

	}

	double balance()
	{
		return balance;
	}
	
	@SuppressWarnings("null")
	String[] history() throws IOException
	{
		String[] history = new String[100];
		
		scanner = new Scanner(new File(directory + userID + ".txt"));
		
		while (scanner.hasNextLine())
		{
			String line = scanner.nextLine();
			int i = 0;

			if (line.equals("********************"))
			{
				//System.out.println(line);
				history[i] = line;
				while (scanner.hasNextLine())
					//System.out.println(scanner.nextLine());
					i++;
					history[i] = line;
			}
		}
		scanner.close();
		
		return history;
	}

	void changeContact(String a, String p)
	{
		address = a;
		phoneNumber = p;
	}

	void debitCardPinChange(String p) {
		pin = String.valueOf(p.hashCode());
	}
	
	void debitCardCancel() {
		debitCard = "";
		pin = "";
	}
	
	void resetPassword(String pass)
	{
		//System.out.println("Please Enter Current Password:");
		//String newP = String.valueOf(scanner.nextLine().hashCode());
		
	//	if (newP.equals(password))
		//{
		//	System.out.println("Please Enter New Password:");
	//		//password = String.valueOf(scanner.nextLine().hashCode());
	//	}
		//else
		//	System.out.println("Incorrect Password");
		password = String.valueOf(pass.hashCode());
	}


	private void writeHistory(String type, String amount) throws IOException
	{
		boolean startLog = false;
		java.util.Date date = new java.util.Date();

		scanner = new Scanner(new File(directory + userID + ".txt"));
		FileWriter filewriter = new FileWriter(directory + userID + "-edit.txt");
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

		File oldFile = new File(directory + userID + "-edit.txt");
		File newFile = new File(directory + userID + ".txt");
		newFile.delete();

		oldFile.renameTo(newFile);
		
		//source: https://stackoverflow.com/questions/7080205/popup-message-boxes
	}
		
	    public static void errorBox(String infoMessage, String titleBar)
	{
	        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	void writeCustomer() throws IOException
	{
		FileWriter filewriter = new FileWriter(directory + userID + "-new.txt");
		PrintWriter printwriter = new PrintWriter(filewriter);
		scanner = new Scanner(new File(directory + userID + ".txt"));

		printwriter.println(password);
		printwriter.println(fname);
		printwriter.println(lname);
		printwriter.println(address);
		printwriter.println(phoneNumber);
		printwriter.println(balance);
		printwriter.println(debitCard);
		printwriter.println(pin);
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
		
		File oldFile = new File(directory + userID + "-new.txt");
		File newFile = new File(directory + userID + ".txt");
		newFile.delete();

		oldFile.renameTo(newFile);
	}

}