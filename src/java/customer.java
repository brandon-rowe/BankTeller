import java.util.*;
import java.io.*;
import java.lang.*;

public class customer
{  
   long id;
   String fname, lname, address;
   double balance;
   
   public customer(long id, String fname, String lname, String address, double balance)
   {
      this.id = id;
      this.fname = fname;
      this.lname = lname;
      this.address = address;
      this.balance = balance;  
   }
   
   public double deposit(double amt)
   {
      this.balance += amt;
      return balance;
   }
   
   public double withdraw(double amt)
   {
      this.balance -= amt;
      return balance;
   }
   
   
   public double getBalance()
   {
      return this.balance;
   }
   
}

