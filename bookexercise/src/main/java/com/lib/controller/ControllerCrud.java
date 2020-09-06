package com.lib.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lib.dao.Bookdao;
import com.lib.model.Book;
import com.lib.model.Library;
@Controller
public class ControllerCrud {
	 Bookdao dao = new Bookdao();
	 @RequestMapping("/add")
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		String libname = request.getParameter("library");
		Library library = dao.getLibrary(libname);
		 
		Book b = new Book();
		
		b.setLibrary(library);
		b.setBookId(Integer.parseInt(request.getParameter("bid")));
		b.setBookName(request.getParameter("bname"));
		b.setAuthor(request.getParameter("auth"));
		b.setPublisher(request.getParameter("publish"));
		
		dao.addBook(b);
		out.println("added book to db");
		
		
	}
	
	
	
	 @RequestMapping("/search")
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Book book = dao.searchBook(Integer.parseInt(request.getParameter("sbid")));
		if(book!=null)
		{
			out.println("Book Id : "+book.getBookId());
			out.println("Book Name : "+book.getBookName());
			out.println("Author of Book : "+book.getAuthor());
			out.println("Publisher of Book : "+book.getPublisher());
		}
		else {
			out.println("enter valid id");
		}
		
	}
	
	@RequestMapping("/update")
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Bookdao dao = new Bookdao();
		
		int bookId = Integer.parseInt(request.getParameter("upId"));
		Book book=dao.searchBook(bookId);
		String updatedBookName = request.getParameter("upName");
		String updatedAuth = request.getParameter("upAuthor");
		String updatedPub = request.getParameter("upPublish");
		out.println("<html>");
		out.println("<body>");
		Book updateBook = dao.updateBookDetails(bookId, updatedBookName, updatedAuth, updatedPub);
		out.println("Name : " + updateBook.getBookName());
		out.print("<br>");
		out.println("Author : " + updateBook.getAuthor());
		out.print("<br>");
		out.println("Publisher Name : " + updateBook.getPublisher());
		out.print("<br>");
		out.println("</body>");
		out.println("</html>");

}
	
	
	
	
	@RequestMapping("/deleteBook")
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hello");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		dao.deleteBook(Integer.parseInt(request.getParameter("delid")));
		out.println("Book Deleted");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
