package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

	private final Logger logger = LoggerFactory.getLogger(RequestListener.class);

    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        logger.info("ENTER requestInitialized(sre)");

        final HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("URI: {}", request.getRequestURI());
       
        
        if (request.getSession().getAttribute("user")== null && request.getSession().getAttribute("user_name") == null ) {
    		request.setAttribute("user_name", "guest");
            logger.info("Login: {}", "guest");
        }   
      
        request.setAttribute("pois_for_vis", new JSONArray ());
        request.setAttribute("no_data_message", null);
        

        logger.info("EXIT requestInitialized(sre)");
    }

    /**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("ENTER requestDestroyed(sre)");

        final HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        logger.info("URI: {}", request.getRequestURI());

        if (request.getSession().getAttribute("user_name") == null & request.getUserPrincipal() != null) {
        	request.getSession().setAttribute("user_name", request.getUserPrincipal().getName());
                 
            }
        
        else {
        	if (request.getSession().getAttribute("user_name") == null) {
        		request.setAttribute("user_name", "guest");
                logger.info("Login: {}", "guest");
        	} else {
        		
        		logger.info("Login: {}", request.getSession().getAttribute("user_name"));
        	}
        	
        }
        logger.info("EXIT requestDestroyed(sre)");
        }
}
