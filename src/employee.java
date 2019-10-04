import java.util.*;
import javax.swing.JFileChooser;
import java.lang.*;
import java.io.*;

public class employee
{
	String fname, lname, address,password;

	public employee(String password, String fname, String lname, String address)
	{
		password = password;
		fname = fname;
		lname = lname;
		address = address;
		
		menu();
	}

	private static void menu()
	{
		System.out.println("Testing");
	}
	
	private void createCustomer(String fname, String lname, String password, String address)
	{
	}
}