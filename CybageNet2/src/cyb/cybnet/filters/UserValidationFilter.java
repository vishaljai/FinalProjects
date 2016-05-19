package cyb.cybnet.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/AddReviewServlet")
public class UserValidationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("User filter called");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if(req.getSession(false).getAttribute("user")!=null){
			chain.doFilter(request, response);
		}
		else{
			resp.sendRedirect("LoginServlet");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}
		
	@Override
	public void destroy() {}

}
