package login;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import Service.BookService;
import dao.DatabaseService;
import dao.LoginDao;

public class LoginService 
{
	Scanner sc=new Scanner(System.in);
    public void doLogin()
    {
  	   System.out.println("Please Enter Username: ");
  	   String username=sc.nextLine();
   	   System.out.println("Please Enter Password: ");
   	   String password=sc.nextLine();
   	   
   	   try
   	   {
   		Connection conn =DatabaseService.getConnect();
   		LoginDao ld=new LoginDao();
   		String usertype=ld.doLogin(conn, username, password);
   		if(usertype==null)
   		{
   			System.out.println("Invalid User!!");
   			return;
   		}
   		System.out.println("Login Success.You Logged in as a " +usertype);
   		
   		if(usertype.equals("admin"))
   		{
   			displayAdminMenu(conn);
   		}
   		else
   		{
   			
   		}
   		   
   	   }
   	   catch(Exception e)
   	   {
   		   e.printStackTrace();
   	   }
    }
    
    public void displayAdminMenu(Connection conn)
    {
    	BookService bs=new BookService();
    	while(true)
    	{
    	System.out.println("************************************");
    	System.out.println("1.Search a Book");
    	System.out.println("2.Add New Book");
    	System.out.println("3.Update Quantity of a Book");
    	System.out.println("4.Show All Books");
    	System.out.println("5.Register User");
    	System.out.println("6.Show All Registered Users");
    	System.out.println("7.Exit");
    	System.out.println("************************************");
    	System.out.println("Enter Your Choice");
    	int choice=sc.nextInt();
    	
    	switch(choice)
    	{
    	case 1:
    		searchBook(conn);
    	break;
    	
    	case 2:
    		bs.addBook(conn);
    	break;
    	
    	case 3:
    		bs.updateBookQuantity(conn);
        break;
        
    	case 4:
    		bs.getAllBooks(conn);
        break;
        
    	case 5:
    	break;
    		
    	case 6:
    	break;
    	
    	case 7:
    	  System.out.println("Thank You!");
    	  System.exit(0);
    	  
    	default:
    	  System.out.println("Please Select Valid Option!!");
    	
    	}
    	}
    }
    
    private void searchBook(Connection conn)
    {
    	BookService bs=new BookService();
    	System.out.println("1.Search Book by Id");
    	System.out.println("2.Search Book by Name");
    	int choice=sc.nextInt();
    	
    	switch(choice)
    	{
    	case 1:
    		bs.searchById(conn);
    		break;
    		
    	case 2:
    		bs.searchByName(conn);
    		break;
    	}
    }
	
}



