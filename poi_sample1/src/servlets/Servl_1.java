package servlets;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils_for_servlet.Web_page_config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Servlet implementation class Servl_1. This is the Controller Servlet only intended to get a uri from a request 
 * and to include into a requestdispatcher object all the necessary jsp files.
 */
@WebServlet(name="Servl_1", urlPatterns= {"/map/*"})
public class Servl_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(Servl_1.class);
	private Map<String, Web_page_config> webPages;
	
	
       
	@SuppressWarnings("unchecked")
	@Override
public void init() throws ServletException {
		webPages = (Map<String,Web_page_config>)getServletContext().getAttribute("webPages");
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
   
 protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
 {
	logger.info("ENTER service(request,response)");
	
	final Web_page_config webPage = perform(request);
	if (webPage != null) 
		
		{
		try 
		{
			if (((webPages.get(request.getRequestURI()).getView().equals("/WEB-INF/jsp/map.jsp")))) 
			{
				request.setAttribute("pageTitle", webPage.getDisplayNameKey());
				request.setAttribute("on_map", true);
				request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").include(request, response);
				request.getRequestDispatcher("/WEB-INF/jsp/left_sidebar.jsp").include(request, response);
				
				request.getRequestDispatcher(webPage.getView()).include(request, response);
				request.getRequestDispatcher("/WEB-INF/jsp/filters.jsp").include(request, response);
		    	request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);
			}
			
			    		else {
			    		
				    		request.setAttribute("pageTitle", webPage.getDisplayNameKey());
							request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").include(request, response);
						//	request.getRequestDispatcher("/WEB-INF/jsp/left_sidebar.jsp").include(request, response);
							request.getRequestDispatcher(webPage.getView()).include(request, response);
					    	request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);
			    		
				}
					
				
			 } catch (Exception e) {
					logger.info("ajax requested");
			} 
		}else {
				

		response.sendError(0);
	} 
	
	
	logger.info("EXIT service(request,response)");
 }
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	protected Web_page_config perform(HttpServletRequest request) {
		logger.info("enter perform(HttpServletRequest request) ");
		
		final String uri = request.getRequestURI();
		final Web_page_config webPage = webPages.get(uri);

		try {
			if (webPage != null) {
				webPage.getModel().process(request);
			}
			
			return webPage;
		} finally {
			logger.info("exit perform(HttpServletRequest request) ");
		}
	}
	
	

}
