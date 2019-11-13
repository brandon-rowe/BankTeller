import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.lang.*;
import java.io.*;

public class driver
{
	static Scanner scanner;
	static String directory;

	public static void main(String[] args) throws IOException
	{
		scanner = null;
		
		//-------This is to bypass DB select and login. For testing past login--------
		//-------Uncomment next three lines. Change dirctory to your local DB location
		directory = "E:/Users/Tater/Documents/Git/BankTeller/src";
		quickLoadEmployee("E1000");
		System.exit(0);

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
			directory = j.getCurrentDirectory().toString();
			///////////////////////////////////////////////////////////

			boolean exitProgram = false;

			//createEmployee("Josh", "Howard", "password".hashCode(), "South Carolina");

			scanner = new Scanner(System.in);
			while (exitProgram == false)
			{
				System.out.print("Login or exit program: ");
				String command = scanner.next();

				if (command.toLowerCase().equals("login"))
					login();
				else if (command.toLowerCase().equals("exit"))
					exitProgram = true;
				else
					System.out.println("Unknown Command\n");
			}

		} catch (Exception e)
		{
			System.out.println("Error: " + e);
		} finally
		{
			scanner.close();
			System.out.println("Finished"); // for testing
		}
	}

	private static void login() throws IOException
	{
		System.out.print("\nUsername: ");
		String user = scanner.next();
		System.out.print("Password: ");
		int password = scanner.next().hashCode();

		if (user.charAt(0) == 'E')
		{
			try
			{
				scanner = new Scanner(new File(directory + "/Database/employee/" + user + ".txt"));

				if (scanner.nextLine().equals(Integer.toString(password)))
				{
					System.out.println();
					loadEmployee(user);
				} else
					System.out.println("Invalide user/password");

				scanner = new Scanner(System.in);
			} catch (Exception e)
			{
				System.out.println("Invalid user/password\n");
			}
		}
		else if (user.charAt(0) == 'U')
		{
			// TODO
		}
		else
			System.out.println("Invalid user/password\n");
	}

	private static void loadEmployee(String user) throws IOException
	{
		scanner = new Scanner(new File(directory + "/Database/employee/" + user + ".txt"));
		employee employee = new employee(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),scanner.nextLine(), directory);
		employee = null;
	}

	private static void loadCustomer(String user, String directory)
	{
		// TODO
	}

	// this creates an employee .txt file in the database and increments the employee counter
	// DO NOT EDIT THIS. WILL BREAK EVERYTHING
	private static void createEmployee(String first, String last, int pass, String address) throws IOException
	{

		scanner = new Scanner(new File(directory + "/Database/counters.txt"));
		scanner.nextInt();

		FileWriter filewriter = new FileWriter(directory + "/Database/employee/" + "E" + scanner.nextInt() + ".txt");
		PrintWriter printwriter = new PrintWriter(filewriter);

		printwriter.println(pass);
		printwriter.println(first);
		printwriter.println(last);
		printwriter.println(address);

		filewriter.flush();
		printwriter.flush();

		scanner = new Scanner(new File(directory + "/Database/counters.txt"));

		String[] counters = new String[2];
		counters[0] = scanner.nextLine();
		counters[1] = Integer.toString(Integer.parseInt(scanner.nextLine()) + 1);

		filewriter = new FileWriter(directory + "/Database/counters.txt");
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
}