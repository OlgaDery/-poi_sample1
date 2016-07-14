package servlets;

import java.io.IOException;

import java.util.Map;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils_for_servlet.Web_page_config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Servlet implementation class Servl_1
 */
@WebServlet(name="Servl_1", urlPatterns= {"/map/*", "/user/*", "/user"})
public class Servl_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger logger = LoggerFactory.getLogger(Servl_1.class);
	private Map<String, Web_page_config> webPages;
	
	@Inject
	@HttpRequestEvent
	private Event <HttpServletRequest> reqEvent;
	
       
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
	final HttpSession session = request.getSession();
	
	final Web_page_config webPage = perform(request);
	if (webPage != null) 
		
		{
		try {
		if (((webPages.get(request.getRequestURI()).getView().equals("/WEB-INF/jsp/map.jsp")))) 
		{
			request.setAttribute("pageTitle", webPage.getDisplayNameKey());
			request.setAttribute("on_map", true);
			request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").include(request, response);
			request.getRequestDispatcher("/WEB-INF/jsp/left_sidebar.jsp").include(request, response);
			
			request.getRequestDispatcher(webPage.getView()).include(request, response);
			//request.getRequestDispatcher("/WEB-INF/jsp/filter_distr.jsp").include(request, response);
			request.getRequestDispatcher("/WEB-INF/jsp/filters.jsp").include(request, response);
	    	request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);
		}
		else {
		if (webPages.get(request.getRequestURI()).getView().equals("/WEB-INF/jsp/user.jsp")) 
				{
			        reqEvent.fire(request);
			        //REQUEST EVENT MUST BE FIRED OFF ALSO FOR profile PAGE
			        request.setAttribute("on_map", true);
			        session.setAttribute("group_to_update", null);
			        session.setAttribute("group_to_update1", null);
			        session.setAttribute("group_to_copy", null);
			        session.setAttribute("pois_for_vis", null);
			        session.setAttribute("poisToShow", null);	 
					request.setAttribute("pageTitle", webPage.getDisplayNameKey());
					request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").include(request, response);
					request.getRequestDispatcher(webPage.getView()).include(request, response);
					request.getRequestDispatcher("/WEB-INF/jsp/map.jsp").include(request, response);
					request.getRequestDispatcher("/WEB-INF/jsp/filters.jsp").include(request, response);
			    	request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);
			    	
				}
	
		    else
			{
		    	if (webPages.get(request.getRequestURI()).getView().equals("/WEB-INF/jsp/modify_gr.jsp")) 
		    	{
		    		session.setAttribute("pois_for_vis", null);
		    		request.setAttribute("pageTitle", webPage.getDisplayNameKey());
					request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").include(request, response);
					request.getRequestDispatcher(webPage.getView()).include(request, response);
					request.getRequestDispatcher("/WEB-INF/jsp/map.jsp").include(request, response);
					request.getRequestDispatcher("/WEB-INF/jsp/modify_gr_right.jsp").include(request, response);
			    	request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);
		    	}
		    	else 
		    	{
		    	if (webPages.get(request.getRequestURI()).getView().equals("/WEB-INF/jsp/create_poi.jsp")||webPages.get(request.getRequestURI()).getView().equals("/WEB-INF/jsp/modify_poi.jsp"))
		    	{
		    		session.setAttribute("pois_for_vis", null);
		    		session.setAttribute("poisToShow", null);	 
		    		request.setAttribute("pageTitle", webPage.getDisplayNameKey());
		    		request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").include(request, response);
					request.getRequestDispatcher(webPage.getView()).include(request, response);
					request.getRequestDispatcher("/WEB-INF/jsp/map.jsp").include(request, response);
					request.getRequestDispatcher("/WEB-INF/jsp/left_sidebar.jsp").include(request, response);
			    	request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);
		    	}
		    	
		    	else
		    		if (webPages.get(request.getRequestURI()).getView().equals("/WEB-INF/jsp/create_group.jsp"))
		    	{
		    			request.setAttribute("pageTitle", webPage.getDisplayNameKey());
						request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").include(request, response);
						request.getRequestDispatcher(webPage.getView()).include(request, response);
						request.getRequestDispatcher("/WEB-INF/jsp/map.jsp").include(request, response);
						request.getRequestDispatcher("/WEB-INF/jsp/left_sidebar.jsp").include(request, response);
				    	request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);
				
			
		    	} 
		    		
		    		else {
		    		if (webPages.get(request.getRequestURI()).getView().equals("/WEB-INF/jsp/user_profile.jsp")) 
		    		{
		    			
		    			reqEvent.fire(request);
		    		}
		    		
		    		session.setAttribute("poisToShow", null);	 
		    			session.setAttribute("pois_for_vis", null);
			    		request.setAttribute("pageTitle", webPage.getDisplayNameKey());
						request.getRequestDispatcher("/WEB-INF/jsp/header.jsp").include(request, response);
						request.getRequestDispatcher("/WEB-INF/jsp/left_sidebar.jsp").include(request, response);
						request.getRequestDispatcher(webPage.getView()).include(request, response);
				    	request.getRequestDispatcher("/WEB-INF/jsp/footer.jsp").include(request, response);
		    		
		    	}
			}
		   }
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
