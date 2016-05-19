package cyb.cybnet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyb.cybnet.dao.BookDAO;
import cyb.cybnet.dao.impl.BookDAOImpl;
import cyb.cybnet.dto.Book;
import cyb.cybnet.util.DBUtility;

/**
 * Servlet implementation class DeleteBookServlet
 */
@WebServlet("/admin/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		pw.write("<!DOCTYPE html>"+
				"<html>"+
				"<head>"+
				"<meta charset='ISO-8859-1'>"+
				"<title>Are you sure</title>"+
				"<link rel='stylesheet' type='text/css' href='res/css/base.css'>"+
				"</head>"+
				"<body>"+	
				"<form method='post' action='#'>"+
				"<br><br><br><br><br><br><br><br><br><br><br><br>"+	
				"<div style='text-align: center'>"+
				"<h1>Are you sure?</h1><br>"+
				"<p>Are you sure that you want to delete this book?</p><br>"+
				"<input type='hidden' value='"+request.getParameter("id")+"'>"+
				"<input class='subbtn' type='submit' name='btn' value='yes'>&nbsp;&nbsp;&nbsp;<input class='subbtn' type='submit' name='btn' value='no'>"+
				"</div>"+
				"</form>"+
				"</body>"+
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn").equals("yes")){
			BookDAO dao = new BookDAOImpl(DBUtility.getConnection());
			int id = Integer.parseInt(request.getParameter("id"));
			try{
				dao.deleteBook(new Book(id));
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		response.sendRedirect("../IndexServlet");
	}

}
