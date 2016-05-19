package cyb.cybnet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyb.cybnet.dao.BookDAO;
import cyb.cybnet.dao.impl.BookDAOImpl;
import cyb.cybnet.dto.Book;
import cyb.cybnet.dto.User;
import cyb.cybnet.exception.BookDAOException;
import cyb.cybnet.util.DBUtility;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDao = new BookDAOImpl(DBUtility.getConnection());
		
		PrintWriter pw = response.getWriter();
		pw.print(
		"<!DOCTYPE html>"+
		"<html>"+
		"<head>"+
		"<meta charset='ISO-8859-1'>"+
		"<title>Search</title>"+
		"<link rel='stylesheet' type='text/css' href='res/css/subbase.css'>"+
		"</head>"+
		"<body>"+
			"<div class='maindiv'>"+
				"<form method='get' action='SearchBookServlet'>"+
					"<a href='/CybageNet/'><div class='logodiv'>"+
						"<span class='logo'>Cybage Net</span>"+
					"</div></a>"+
					"<input class='base-size search' type='text'"+
						"placeholder='type name here ...' name='title'> "+
						"<input class='base-size' type='submit' value='search'>"+
				"</form>"+
			"</div>");
		try {
			List<Book> books = bookDao.getBookListByName(request.getParameter("title"));
			pw.print("<center>"+
		"<table border='1px solid' >"+
			"<tr>"+
				"<th>Title</th>"+
				"<th>Author</th>"+
				"<th>Publication</th>"+
				"<th>Genre</th>"+
				"<th>Options</th>"+
			"</tr>");
			for(Book book : books){
				pw.write("<tr>"+
				"<td>"+book.getBookTitle()+"</td>"+
				"<td>"+book.getBookAuthor()+"</td>"+
				"<td>"+book.getBookPublication()+"</td>"+
				"<td>"+book.getBookGenre()+"</td>"+
				"<td>"
				+ "<a class='btn' href='ShowDescription?id="+book.getBookId()+"'>description</a>"+
				  "<a class='btn' href='AddReviewServlet?id="+book.getBookId()+"'>write review</a>"
				);
				User user = (User)request.getSession().getAttribute("user");
				if(user!=null){
				if(user.getUserRole().equals("admin")){
					pw.write("<a class='btn' href='admin/DeleteBookServlet?id="+book.getBookId()+"'>Delete</a>");
				}
				}
				
			pw.write("</td></tr>");
			}
		} 
		catch(BookDAOException ex){
			ex.printStackTrace();
			pw.write("<center>"+
					"<div class='nobookmsg'>"+
					"<p>Sorry, no such book found</p>"+
					"</div>"+
					"</center>");
		}
		catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		finally{
			pw.print("</table>"+
					 "</center>"+
					 "</body>"+
					 "</html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
