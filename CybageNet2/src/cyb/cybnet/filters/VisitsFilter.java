package cyb.cybnet.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class VisitFilter
 */
@WebFilter(urlPatterns="/IndexServlet")
public class VisitsFilter implements Filter {

    /**
     * Default constructor. 
     */
    public VisitsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("calling visits filter");
		Cookie cks[] = ((HttpServletRequest)request).getCookies();
		Cookie ck = findCookie(cks,"visits");
		if(ck==null){
			ck = new Cookie("visits","1");
			ck.setMaxAge(4000);
		}
		else{
			int visits = Integer.parseInt(ck.getValue());
			visits++;
			ck.setMaxAge(4000);
			ck.setValue(""+visits);	
		}
		((HttpServletResponse)response).addCookie(ck);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	public static Cookie findCookie(Cookie[] cks,String key){
		if(cks == null){
			return null;
		}
		for(Cookie ck:cks){
			if(ck.getName().equals(key)){
				return ck;
			}
		}
		return null;
	}

}
