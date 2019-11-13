import java.util.*;
import java.io.*;
import java.lang.*;

public class customer
{
	String password, fname, lname, address, phoneNumber;
	double balance;

	public customer(String fname, String lname, String password, String address, String phoneNumber, double balance)
	{
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
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

	public String getPassword()
	{
		return password;
	}
	
	public void changeContact(String address, String phoneNumber) {
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

}