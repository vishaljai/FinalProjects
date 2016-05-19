package cyb.cybnet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyb.cybnet.dao.BookDAO;
import cyb.cybnet.dao.impl.BookDAOImpl;
import cyb.cybnet.dto.Book;
import cyb.cybnet.exception.BookDAOException;
import cyb.cybnet.util.DBUtility;

/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/admin/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter pw = resp.getWriter();
    	pw.write(
    			"<!DOCTYPE html>"+
    			"<html>"+
    			"<head>"+
    			"<meta charset='ISO-8859-1'>"+
    			"<title>Admin's Dashboard</title>"+
    			"<link rel='stylesheet' type='text/css' href='../res/css/addbook.css'>"+
    			"</head>"+
    			"<body>"+
    				"<div class='maindiv'>"+
    						"<a href='/CybageNet/IndexServlet'>"+
    						"<div class='logodiv'>"+
    							"<span class='logo'>Cybage Net - Add Book</span>"+
    						"</div>"+
    						"</a>"+
    					"</div>"+
    				"<center>"+
    				"<br>"+
    				"<br>"+
    				"<br>"+
    				"<br>"+
    				"<br>"+
    				"<br>"+
    				"<br>"+
    				"<br>"+
    				"<br>"+
    				"<form action='#' method='post'>"+
    				"<table class='addbooktable'>"+
    					"<tr>"+
    						"<td>Title</td>"+
    						"<td><input type='text' name='title' required='required'></td>"+
    					"</tr>"+
    					"<tr>"+
    						"<td>Author</td>"+
    						"<td><input type='text' name='author' required='required'></td>"+
    					"</tr>"+
    					"<tr>"+
    						"<td>ISBN Code</td>"+
    						"<td><input type='number' name='isbn' required='required'></td>"+
    					"</tr>"+
    					"<tr>"+
    						"<td>Number of pages</td>"+
    						"<td><input type='number' name='nop' required='required'></td>"+
    					"</tr>"+
    					"<tr>"+
    						"<td>Publication</td>"+
    						"<td><input type='text' name='pub' required='required'></td>"+
    					"</tr>"+
    					"<tr>"+
    						"<td>Description</td>"+
    						"<td><textarea cols='100' rows='5' name='desc' required='required'></textarea></td>"+
    					"</tr>"+
    					"<tr>"+
    						"<td>Genre</td>"+
    						"<td><input type='text' name='genre' required='required'></td>"+
    					"</tr>"+
    					"<tr>"+
    						"<td><input class='btn' type='submit' value='Add Book'>"+
    						"<input class='btn' type='reset' value='clear'></td>"+
    					"</tr>"+
    				"</table>"+
    				"</form>"+
    				"</center>"+
    			"</body>"+
    			"</html>");
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		Book b = new Book();
		b.setBookTitle(request.getParameter("title"));
		b.setBookAuthor(request.getParameter("author"));
		b.setBookDescription(request.getParameter("desc"));
		b.setBookGenre(request.getParameter("genre"));
		b.setBookISBN(Integer.parseInt(request.getParameter("isbn")));
		b.setBookNOP(Integer.parseInt(request.getParameter("nop")));
		b.setBookPublication(request.getParameter("pub"));
		
		byte[] bytes = new byte[1];
		b.setBookCover(bytes);
		
		BookDAO bookDAO = new BookDAOImpl(DBUtility.getConnection());
		RequestDispatcher rd = request.getRequestDispatcher("../IndexServlet");
		PrintWriter pw = response.getWriter();
		
		try {
			bookDAO.addBook(b);
			pw.write("<div class='notification success'>Book Added Sucessfully</div>");
			
		}
		catch(BookDAOException ex){
			pw.write("<div class='notification danger'>"+ex.getMessage()+"</div>");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.write("<div class='notification danger'>Some internal error occured</div>");
		}
		rd.include(request, response);
	}

}
