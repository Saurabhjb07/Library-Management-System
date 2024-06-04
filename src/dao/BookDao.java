package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Book;

public class BookDao 
{
    public Book getBooksById(Connection conn,int id)
    {
    	String query="select * from books where id=?";
    	try
    	{
    		PreparedStatement ps=conn.prepareStatement(query);
    		ps.setInt(1, id);
    		ResultSet rs=ps.executeQuery();
    		if(rs.next())
    		{
    			Book book=new Book();
        		book.setId(rs.getInt("id"));
        		book.setName(rs.getString("name"));
        		book.setAuthor(rs.getString("author"));
        		book.setQuantity(rs.getInt("quantity"));
        		
        		return book;
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return null;
		
    	
    }
    
    
    public Book getBooksByName(Connection conn,String name)
    {
    	String query="select * from books where name=?";
    	try
    	{
    		PreparedStatement ps=conn.prepareStatement(query);
    		ps.setString(1, name);
    		ResultSet rs=ps.executeQuery();
    		if(rs.next())
    		{
    			Book book=new Book();
        		book.setId(rs.getInt("id"));
        		book.setName(rs.getString("name"));
        		book.setAuthor(rs.getString("author"));
        		book.setQuantity(rs.getInt("quantity"));
        		
        		return book;
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return null;
		
    	
    }
    
    public Book getBooksByNameOrAuthor(Connection conn,String name,String author)
    {
    	String query="select * from books where name=? or author=?";
    	try
    	{
    		PreparedStatement ps=conn.prepareStatement(query);
    		ps.setString(1, name);
    		ps.setString(2, author);
    		ResultSet rs=ps.executeQuery();
    		if(rs.next())
    		{
    			Book book=new Book();
        		
        		book.setName(rs.getString("name"));
        		book.setAuthor(rs.getString("author"));
        		book.setQuantity(rs.getInt("quantity"));
        		
        		return book;
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return null;
		
    	
    }
    
    public void saveBook(Connection conn,Book book)
    {
    	String query="insert into books (name, author, quantity) values (?,?,?)";
    	try
    	{
    		PreparedStatement ps=conn.prepareStatement(query);
    		ps.setString(1, book.getName());
    		ps.setString(2, book.getAuthor());
    		ps.setInt(3, book.getQuantity());
    		int rows=ps.executeUpdate();
    		if(rows>0)
    		{
    			System.out.println("Book Added Successfully!!");
    		}
    		else
    		{
    			System.out.println("Failed to add Book!!");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    
    public List<Book> getAllBooks(Connection conn)
    {
    	String query="select * from books";
    	List<Book> books=new ArrayList<>();
    	try
    	{
    		PreparedStatement ps=conn.prepareStatement(query);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			Book book=new Book();
        		book.setId(rs.getInt("id"));
        		book.setName(rs.getString("name"));
        		book.setAuthor(rs.getString("author"));
        		book.setQuantity(rs.getInt("quantity"));
        		
        		books.add(book);
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return books;
		
    	
    }
    
    public void updateBookQuantity(Connection conn,Book book)
    {
    	String query="update books set quantity=quantity + ? where id=?";
    	try
    	{
    	PreparedStatement ps=conn.prepareStatement(query);
    	ps.setInt(1, book.getQuantity());
    	ps.setInt(2, book.getId());
    	int rows=ps.executeUpdate();
    	if(rows>0)
    	{
    		System.out.println("Book Quantity Updated Successfully!!");
    	}
    	else
    	{
    		System.out.println("Failed to Update Book Quantity!!");
    	}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
