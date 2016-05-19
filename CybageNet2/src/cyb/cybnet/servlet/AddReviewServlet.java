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
import cyb.cybnet.dao.ReviewDAO;
import cyb.cybnet.dao.impl.BookDAOImpl;
import cyb.cybnet.dao.impl.ReviewDAOImpl;
import cyb.cybnet.dto.Book;
import cyb.cybnet.dto.Review;
import cyb.cybnet.dto.User;
import cyb.cybnet.exception.BookDAOException;
import cyb.cybnet.exception.ReviewDAOException;
import cyb.cybnet.util.DBUtility;

/**
 * Servlet implementation class ShowDescription
 */
@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewServlet() {
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
				
		try {
			Book book = bookDao.getBook(new Book(id));
			
			pw.write(
					"<!DOCTYPE html>"+
					"<html>"+
					"<head>"+
					"<meta charset='ISO-8859-1'>"+
					"<title>Admin's Dashboard</title>"+
					"<link rel='stylesheet' type='text/css' href='res/css/addbook.css'>"+
					"</head>"+
					"<body>"+
						"<div class='maindiv'>"+
								"<a href='/CybageNet/IndexServlet'>"+
								"<div class='logodiv'>"+
									"<span class='logo'>Cybage Net - Review Page</span>"+
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
						"<form action='AddReviewServlet' method='post'>"+
						"<table class='addbooktable'>"+
							"<input type='hidden' name='bk_id' value='"+book.getBookId()+"'>"+
							"<tr>"+
								"<td>Title</td>"+
								"<td><span class='element'>"+book.getBookTitle()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Author</td>"+
								"<td><span class='element'>"+book.getBookAuthor()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Publication</td>"+
								"<td><span class='element'>"+book.getBookPublication()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Genre</td>"+
								"<td><span class='element'>"+book.getBookGenre()+"</span></td>"+
							"</tr>"+
							"<tr>"+
								"<td>Review</td>"+
								"<td><textarea cols='100' rows='5' name='review' required='required'></textarea></td>"+
							"</tr>"+
							"<tr>"+
								"<td colspan='2'><input class='btn' type='submit' value='save'>"+
								"<input class='btn' type='reset' value='clear'></td>"+
							"</tr>"+
						"</table>"+
						"</form>"+
						"</cnter>"+
					"</body>"+
					"</html>"
					);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BookDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		int bkId = Integer.parseInt(request.getParameter("bk_id"));
		
		ReviewDAO reviewDao = new ReviewDAOImpl(DBUtility.getConnection());
		
		RequestDispatcher rd = request.getRequestDispatcher("/AddReviewServlet?id="+bkId);
		PrintWriter pw = response.getWriter();
		
		try {
			reviewDao.addReview(new Review(user.getUserId(), request.getParameter("review"), bkId));
			response.sendRedirect("/CybageNet/ShowDescription?id="+bkId);
		} catch (SQLException e) {
			rd.include(request,response);
			pw.write("<center><span style='color:red'>Some internal error has occured</span><center>");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReviewDAOException ex) {
			rd.include(request,response);
			pw.write("<center><span style='color:red'>"+ex.getMessage()+"</span><center>");
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
