package cyb.cybnet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyb.cybnet.dao.UserDAO;
import cyb.cybnet.dao.impl.UserDAOImpl;
import cyb.cybnet.dto.User;
import cyb.cybnet.exception.UserDAOException;
import cyb.cybnet.util.DBUtility;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write(pageDesign());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAOImpl(DBUtility.getConnection());
		PrintWriter pw = response.getWriter();
		//if login request
		try{
		//get user details 
		User user = dao.getUser(new User(request.getParameter("user")));
			//check password
			if (user.getUserPass().equals(request.getParameter("pass"))) {
				request.getSession().setAttribute("user", user);
				request.getSession().setAttribute("newSession", true);
				response.sendRedirect("IndexServlet");
			} else {
				response.setContentType("text/html");
				pw.write(pageDesign());
				pw.print("<center><span color:'red'>Invaid password</span></center>");
			}
		}//if user not found in the data base
		catch (UserDAOException ex) {
			response.setContentType("text/html");
			pw.write(pageDesign());
			pw.print("<center><span style='color:red'>Invaid username</span></center>");
		}
		//for any other exception
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String pageDesign(){
		return "<!DOCTYPE html>"+
				"<html>"+
				"<head>"+
				"<meta charset='ISO-8859-1'>"+
				"<title>login page</title>"+
				"<link rel='stylesheet' type='text/css' href='res/css/base.css' >"+
				"</head>"+
				"<body>"+
					"<br><br><br><br><br>"+
					"<center>"+
					"<div class='center'>"+
						"<span class='logo' style='font-size : 60px;'>Cybage Net</span>"+
						"<form method='post' action='#'>"+
							"<table class='login-form' align='center'>"+
								"<tr>"+
									"<td>Username</td>"+
									"<td><input type='text' name='user' required='required'></td>"+
								"</tr>"+
								"<tr>"+
									"<td>Password</td>"+
									"<td><input type='password' name='pass' required='required'></td>"+
								"</tr>"+
								"<tr>"+
									"<td colspan='2' style='padding-top: 15px'><input class='subbtn' type='submit' value='login'>"+
									"<input class='subbtn' type='reset' value='clear'></td>"+
								"</tr>"+
							"</table>"+
						"</form>"+
					"</div>"+
					"</center>"+
				"</body>"+
				"</html>";
	}

}
