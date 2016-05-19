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
import cyb.cybnet.dao.ReviewDAO;
import cyb.cybnet.dao.UserDAO;
import cyb.cybnet.dao.impl.BookDAOImpl;
import cyb.cybnet.dao.impl.ReviewDAOImpl;
import cyb.cybnet.dao.impl.UserDAOImpl;
import cyb.cybnet.dto.Book;
import cyb.cybnet.dto.Review;
import cyb.cybnet.dto.User;
import cyb.cybnet.exception.BookDAOException;
import cyb.cybnet.exception.ReviewDAOException;
import cyb.cybnet.exception.UserDAOException;
import cyb.cybnet.util.DBUtility;

/**
 * Servlet implementation class ShowDescription
 */
@WebServlet("/ShowDescription")
public class ShowDescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDescription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter pw = new PrintWriter(response.getWriter());
		
		BookDAO bookDao = new BookDAOImpl(DBUtility.getConnection());
		UserDAO userDao = new UserDAOImpl(DBUtility.getConnection());
		ReviewDAO reviewDAO = new ReviewDAOImpl(DBUtility.getConnection());
		
		try {
			Book book = bookDao.getBook(new Book(id));
			
			pw.write(
					"<!DOCTYPE html>"+
					"<html>"+
					"<head>"+
					"<meta charset='ISO-8859-1'>"+
					"<title>Admin's Dashboard</title>"+
					"<link rel='stylesheet' type='text/css' href='res/css/addbook.css'>"+
					"<link rel='stylesheet' type='text/css' href='res/css/review.css'>"+
					"</head>"+
					"<body>"+
						"<div class='maindiv'>"+
								"<a href='/CybageNet/IndexServlet'>"+
								"<div class='logodiv'>"+
									"<span class='logo'>Cybage Net - Book Description</span>"+
								"</div>"+
								"</a>"+
							"</div>"+
						"<br>"+
						"<div class='reviewHome'><h1>Book Details</h1></div>"+
						"<center><table class='addbooktable' border='1'>"+
							"<tr>"+
								"<td>Title</td>"+
								"<td><span class='element'>"+book.getBookTitle()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Author</td>"+
								"<td><span class='element'>"+book.getBookAuthor()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>ISBN Code</td>"+
								"<td><span class='element'>"+book.getBookISBN()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Number of pages</td>"+
								"<td><span class='element'>"+book.getBookNOP()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Publication</td>"+
								"<td><span class='element'>"+book.getBookPublication()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Description</td>"+
								"<td><span class='element'>"+book.getBookDescription()+"</span></textarea></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Genre</td>"+
								"<td><span class='element'>"+book.getBookGenre()+"</span></td>"+
							"</tr>"+
						"</table>"+
						"</center>"+
						"<div class='reviewHome'>"
						+ "<h1>Reviews</h1>"
					);

			pw.write("<div class='revMain'>");
			List<Review> reviewList = reviewDAO.getReviewListByBook(book); 
				for(Review r:reviewList){
					pw.write(
			                 "<div class='revPane'><div class='revby'>"+(userDao.getUserById(new User(r.getReviewBy()))).getUserName()+"</div>"
			                 +"<div class='revCont'>"+r.getReviewReview()+"</div>"+
		                     "</div>");
				}
				
			pw.write("</div></div></body>"+
					"</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BookDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch(ReviewDAOException e){
			 e.printStackTrace();
		 }
		catch (UserDAOException e) {
			e.printStackTrace();
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
