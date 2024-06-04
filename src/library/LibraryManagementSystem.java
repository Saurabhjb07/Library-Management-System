package library;

import login.LoginService;

public class LibraryManagementSystem {

	public static void main(String[] args) 
	{
           System.out.println("******Welcome to Library******");
           System.out.println("Please Login!!");
           LoginService ls=new LoginService();
           ls.doLogin();
	}

}
