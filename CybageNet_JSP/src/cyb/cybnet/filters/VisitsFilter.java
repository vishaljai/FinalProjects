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

@WebFilter(urlPatterns="/index.jsp")
public class VisitsFilter implements Filter {

    public VisitsFilter() {}
	public void destroy() {}
	public void init(FilterConfig arg0) throws ServletException {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request; 
		HttpServletResponse resp = (HttpServletResponse) response;
		
		Cookie cks[] = req.getCookies();
		Cookie ck = searchCookie(cks,"visits");
		
		if(ck==null){
			ck = new Cookie("visits","0");
			ck.setMaxAge(30);	
		}
		else{
			int visits = Integer.parseInt(ck.getValue());
			visits++;
			ck.setMaxAge(4000);
			ck.setValue(""+visits);	
		}
		resp.addCookie(ck);
		chain.doFilter(request, response);
	}

	private Cookie searchCookie(Cookie[] cks,String key){
		if(cks==null){
			return null;
		}
		for(Cookie c : cks){
			if(c.getName().equals(key)){
				return c;
			}
		}
		return null;
	}

}
