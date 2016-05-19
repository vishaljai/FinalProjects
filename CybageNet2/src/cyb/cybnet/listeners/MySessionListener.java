package cyb.cybnet.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class mySessionListener
 *
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
	
	private static int sessionCount=0;
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("creating session");
         sessionCount++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("deleting session");
        sessionCount--;
    }
	
    public static int getSessionCount(){
    	return sessionCount;
    }
}
