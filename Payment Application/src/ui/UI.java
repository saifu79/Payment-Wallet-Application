package ui;
import java.util.Scanner;

import service.Banking;

public class UI {
	
	    public static void main(String arg[]) {
	        Scanner KB = new Scanner(System.in);
	        Banking bank= new Banking();
	        
	        System.out.println("Choose the option:\n 1: New User\n 2: Existing User");
	        int c= KB.nextInt();
	        if(c==1)
	        {
	    	    String accno;
	    	    String name;
	    	    int balance;
	    	    System.out.println("enter account number");
	    	    accno = KB.next();
		        System.out.println("Enter Name");
		        name = KB.next();
		        System.out.println("Enter Balance");
		        balance = KB.nextInt();
		        
		        bank.openAccount(accno, name, balance);
	
	        }
	        else if(c==2)
	        {
	        	System.out.print("Enter account number: ");
	        	String accno = KB.next();
	        	
		        int ch;
		        do {
		            System.out.println("Main Menu:\n 1. Display balance\n 2. Deposit\n 3. Withdrawal\n 4. Fund transfer\n 5. Exit ");
		                System.out.println("Ur Choice :"); 
		                ch = KB.nextInt();
		                
		                switch (ch) {
		                    case 1:
		                        bank.showAccount(accno);
		                        break;

		                    case 2:
		                    	System.out.println("Enter the amount to be added!");
		                    	int add=KB.nextInt();
		                    	if(add>=0)
		                    		bank.deposit(accno, add);
		                    	else
		                    	{
		                    		System.out.println("Entered invalid amount!");
		                    	}
	                            break;

		                    case 3:
		                    	System.out.println("Enter the amount to be withdrawn!");
		                    	int wd=KB.nextInt();
		                    	if(wd>=0)
		                    		bank.withdrawal(accno, wd);
		                    	else
		                    	{
		                    		System.out.println("Entered invalid amount!");
		                    	}
	                            break;
		                    case 4:
		                    	System.out.println("Enter the account no. of the beneficiary!");
		                    	String ben = KB.next();
		                    	System.out.println("Enter the amount to be transferred!");
		                    	int trf=KB.nextInt();
		                    	if(trf>=0)
		                    		bank.transfer(accno, ben, trf);
		                    	else
		                    	{
		                    		System.out.println("Entered invalid amount!");
		                    	}
	                            break;	                            

		                    case 5:
		                        System.out.println("Good Bye..");
		                        break;
		                    default:
		                    	System.out.println("Invalid option!");
		                    break;
		                }
		            }
		            while (ch != 5);
	        	
	        }
	        else
	        {
	        	System.out.println("Chosen invalid option");
	        }
	        

	        
	        }


}
