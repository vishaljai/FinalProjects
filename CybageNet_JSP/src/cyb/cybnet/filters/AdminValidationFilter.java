package cyb.cybnet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyb.cybnet.dto.User;

@WebFilter(urlPatterns="/admin/*")
public class AdminValidationFilter implements Filter {

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Admin filter called");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		User user = (User) req.getSession(false).getAttribute("user");
		
		if(user!=null && user.getUserRole().equals("admin")){
			chain.doFilter(request, response);
		}
		else{
			resp.sendRedirect("/CybageNet_JSP/Login.jsp");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}
	
	@Override
	public void destroy() {}

}
