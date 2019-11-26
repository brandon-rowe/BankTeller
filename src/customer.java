import java.util.*;
import java.io.*;
import java.lang.*;

public class customer
{
	String password, fname, lname, address, phoneNumber, userID;
	static String directory;
	double balance;

	public customer(String password, String fname, String lname, String address, String phoneNumber, double balance, String userID, String directory, boolean menu)
	{
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.userID = userID;
		customer.directory = directory;
		
		if (menu == true)
			menu();
	}
	
	

	private void menu()
	{
		// TODO
		
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

}