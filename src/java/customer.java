import java.util.*;
import java.io.*;
import java.lang.*;

public class customer
{  
   long id;
   String password, fname, lname, address;
   double balance;
   
   public customer(String fname, String lname, long id, String password, String address, double balance)
   {
      this.fname = fname;
      this.lname = lname;
      this.id = id;
      this.password = password;
      this.address = address;
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
	   //if the new password is the string "wrong", then password reset fails. For testing purposes.
	   if (newPassword.equals("wrong"))
		   return false;
	   return true;
   }
   
   public String getPassword() {
	   return password;
   }
   
}