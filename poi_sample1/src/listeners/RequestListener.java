package listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application Lifecycle Listener implementation class RequestListener, tracks the uri for each request
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
       
        
        logger.info("EXIT requestInitialized(sre)");
    }

    /**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        logger.info("ENTER requestDestroyed(sre)");

       
        logger.info("EXIT requestDestroyed(sre)");
        }
}
