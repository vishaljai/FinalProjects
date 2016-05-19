package cyb.cybnet.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import cyb.cybnet.util.DBUtility;

/**
 * Application Lifecycle Listener implementation class ConnectionInitializer
 *
 */
@WebListener
public class ConnectionInitializer implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ConnectionInitializer() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         DBUtility.getConnection();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         DBUtility.closeConnection();
    }
	
}
