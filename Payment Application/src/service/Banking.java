package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import database.DBConnection;
import java.io.IOException;



public class Banking {

	    //method to open an account
	    public void openAccount(String accno, String name, int balance) {
			Statement st = DBConnection.getStatement();
			String query;
			query = "insert into user(accno, name, balance) values('"+accno+"','"+name+"',"+balance+");";
			try {
				st.executeUpdate(query);
				System.out.println("Account Successfully created!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }

	    //method to display account balance
	    public void showAccount(String accno) {
	    	
			Statement st = DBConnection.getStatement();
			String query = "select * from user where accno = '"+ accno+" ';";
			ResultSet rs = null;
			try {
				rs = st.executeQuery(query);
				
				if(rs.next()) {

					String name = rs.getString("name");
					int balance = rs.getInt("balance");
					
					System.out.println("Account No: " +accno);
					System.out.println("Name: " +name);
					System.out.println("Balance: " +balance);
					
					
				}
				else {
					System.out.println("Invalid Credentials.");
				}
			}
			catch (SQLException e) {
				System.out.println("Error in sql query");
			}
	    	
	    }

	    //method to deposit money
	    public void deposit(String accno, int add) {
			Statement st = DBConnection.getStatement();
			String query = "select balance from user where accno='"+accno+"';";
			ResultSet rs = null;
			try {
				rs = st.executeQuery(query);
				
				if(rs.next()) {

					int adder= rs.getInt("balance");
					adder += add;
					query = "update user set balance = "+adder+" where accno = '"+accno+"';";
					st.executeUpdate(query);	
					
				}
				else {
					System.out.println("Invalid Credentials!");
				}
			}
			catch (SQLException e) {
				System.out.println("Error in sql query");
			}
	    }

	    //method to withdraw money
	    public void withdrawal(String accno, int wd) {
			Statement st = DBConnection.getStatement();
			String query = "select balance from user where accno='"+accno+"';";
			ResultSet rs = null;
			try {
				rs = st.executeQuery(query);
				
				if(rs.next()) {

					int curbal= rs.getInt("balance");
					if(curbal>=wd)
					{
					curbal -= wd;
					query = "update user set balance = "+curbal+" where accno = '"+accno+"';";
					st.executeUpdate(query);
					}
					else
					{
						System.out.println("Insufficient balance!");
					}
					
				}
				else {
					System.out.println("Invalid Credentials!");
				}
			}
			catch (SQLException e) {
				System.out.println("Error in sql query");
			}
	        
	    }

	    //method to search an account number
	    public void transfer(String accno, String ben, int trf) {
			Statement st = DBConnection.getStatement();
			String query = "select balance from user where accno='"+accno+"';";
			ResultSet rs = null;
			try {
				rs = st.executeQuery(query);
				
				if(rs.next()) {

					int curbal= rs.getInt("balance");
					if(curbal>=trf)
					{
					curbal -= trf;
					query = "update user set balance = "+curbal+" where accno = '"+accno+"';";
					st.executeUpdate(query);	
					}
					else
					{
						System.out.println("Insufficient balance!");
					}
					
				}
				else {
					System.out.println("Invalid Credentials!");
				}
				
				query = "select balance from user where accno='"+ben+"';";
				rs=null;
				rs = st.executeQuery(query);
				if(rs.next()) {

					int adder= rs.getInt("balance");
					adder += trf;
					query = "update user set balance = "+adder+" where accno = '"+ben+"';";
					st.executeUpdate(query);	
					
				}
				else {
					System.out.println("Invalid Credentials!");
				}
				
				
			}
			catch (SQLException e) {
				System.out.println("Error in sql query");
			}
	    	
	    }

}
