package Service;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import dao.BookDao;
import dto.Book;

public class BookService {
    Scanner sc=new Scanner(System.in);
    
	public void searchById(Connection conn)
	{
		System.out.println("Enter Book Id:");
		int id=sc.nextInt();
		BookDao bd=new BookDao();
		Book book=bd.getBooksById(conn, id);
		if(book!=null)
		{
			System.out.println("*****Book Details*****");
			System.out.println("Book Id: " +book.getId());
			System.out.println("Book Name: " +book.getName());
			System.out.println("Book Author: " +book.getAuthor());
			System.out.println("Book Quantity: " +book.getQuantity());
		}
		else
		{
			System.out.println("No Book with Id " +id+ " Found.");
		}
	}
	
	public void searchByName(Connection conn)
	{
		System.out.println("Enter Book Name:");
		String name=sc.next();
		BookDao bd=new BookDao();
		Book book=bd.getBooksByName(conn, name);
		if(book!=null)
		{
			System.out.println("*****Book Details*****");
			System.out.println("Book Id: " +book.getId());
			System.out.println("Book Name: " +book.getName());
			System.out.println("Book Author: " +book.getAuthor());
			System.out.println("Book Quantity: " +book.getQuantity());
		}
		else
		{
			System.out.println("No Book Found with the Name " +name);
		}
	}
	
	public void addBook(Connection conn)
	{
		
		System.out.println("Enter Book Name: ");
		String name=sc.next();
		
		System.out.println("Enter Author Name: ");
		String author=sc.next();
		
		System.out.println("Enter Quantity of Books: ");
		int quantity=sc.nextInt();
		
		BookDao bd=new BookDao();
		Book book=bd.getBooksByNameOrAuthor(conn, name, author);
		if(book!=null)
		{
			System.out.println("Book Already Exist!!");
			return;
		}
		Book b=new Book();
		b.setName(name);
		b.setAuthor(author);
		b.setQuantity(quantity); 
		bd.saveBook(conn, b);
	}
	
	public void getAllBooks(Connection conn)
	{
		BookDao bd=new BookDao();
		List<Book> books=bd.getAllBooks(conn);
		
		for (Book book : books) 
		{
			System.out.println("Book Id: " +book.getId());
			System.out.println("Book Name: " +book.getName());
			System.out.println("Book Author: " +book.getAuthor());
			System.out.println("Quantity: " +book.getQuantity());
			System.out.println();
		}
	}
	
	public void updateBookQuantity(Connection conn)
	{
		System.out.println("Enter Book Id: ");
		int id=sc.nextInt();
		
		BookDao bd=new BookDao();
		Book book=bd.getBooksById(conn, id);
		if(book==null)
		{
			System.out.println("Book Not Available.");
			return;
		}
		System.out.println("Enter No of Books to be Added: ");
		int qty=sc.nextInt();
		Book b=new Book();
		b.setQuantity(b.getQuantity() + qty); 
		b.setId(id);
		bd.updateBookQuantity(conn, b);
	}
}
