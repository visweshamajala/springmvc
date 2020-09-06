package com.lib.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lib.model.Book;
import com.lib.model.Library;

public class Bookdao {
	
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("bookexercise");
	private static EntityManager manager= factory.createEntityManager();
	
	public void addBook(Book b) {
		manager.getTransaction().begin();		
		manager.persist(b);		
		manager.getTransaction().commit();
	}
	public Library getLibrary(String libraryName) {
		TypedQuery<Library> query = manager.createQuery("SELECT lib FROM Library lib", Library.class);
		List<Library> libs = query.getResultList();	
		for(Library lib : libs ) {
			if(lib.getLibraryName().equals(libraryName)) {
				return lib;
			}
		}
		return null;
	}
	public Book searchBook(int bookId)
	{
		return manager.find(Book.class, bookId);
		
	}
	public Book updateBookDetails(int bookId,String bookName,String author,String publisher)
	{
		
		manager.getTransaction().begin();
		Book book = searchBook(bookId);
		if(bookName.length()!=0) {
			book.setBookName(bookName);
		}
		if(author.length()!=0) {
			book.setAuthor(author);
		}
		if(publisher.length()!=0) {
			book.setPublisher(publisher);
		}
		manager.getTransaction().commit();
		return book;
		
	}
	public void deleteBook(int bookId)
	{
		
		manager.getTransaction().begin();
		Book book = searchBook(bookId);
		manager.remove(book);
		manager.getTransaction().commit();
	}
	public List<Book> getAllBooks()
	{
		manager.getTransaction().begin();
		TypedQuery<Book>query=manager.createQuery("select * from Book b",Book.class);
		List<Book> books = query.getResultList();
		
		manager.getTransaction().commit();
		
		return books;
	}

	

}
