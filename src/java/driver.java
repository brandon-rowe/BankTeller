import java.util.*;
import java.lang.*;
import java.io.*;

public class driver
{
   public static void main(String[] args)
   {
      customer c1, c2, c3;
      c1 = new customer(0001, "Lucky", "Rowe", "260 road, st, 29303", 1000.00);
      c2 = new customer(0002, "Conner", "Murray", "2000 road, st, 29323", 3000.00);
      c3 = new customer(0003, "Josh", "Howard", "300 road, st, 29499", 5000.00);
      
      System.out.println("Customer 1 is " + c1.fname + " " + c1.lname + " and they live at " + c1.address);
      System.out.println(c1.fname + " has a balance of " + c1.balance + " before deposits/withdraws.");
      c1.deposit(100.00);
      System.out.println(c1.fname + " has a balance of " + c1.balance + " after deposits.");
      c1.withdraw(200.00);
      System.out.println(c1.fname + " has a balance of " + c1.balance + " after withdraws.");
      
      System.out.println();
      
      System.out.println("Customer 2 is " + c2.fname + " " + c2.lname + " and they live at " + c2.address);
      System.out.println(c2.fname + " has a balance of " + c2.balance + " before deposits/withdraws.");
      c2.deposit(1000.00);
      System.out.println(c2.fname + " has a balance of " + c2.balance + " after deposits.");
      c2.withdraw(1500.00);
      System.out.println(c2.fname + " has a balance of " + c2.balance + " after withdraws.");
      
      System.out.println();
      
      System.out.println("Customer 3 is " + c3.fname + " " + c3.lname + " and they live at " + c3.address);
      System.out.println(c3.fname + " has a balance of " + c3.balance + " before deposits/withdraws.");
      c3.deposit(2000.00);
      System.out.println(c3.fname + " has a balance of " + c3.balance + " after deposits.");
      c3.withdraw(3500.00);
      System.out.println(c3.fname + " has a balance of " + c3.balance + " after withdraws.");
   }
}