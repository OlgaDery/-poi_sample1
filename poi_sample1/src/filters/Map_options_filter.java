package filters;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class Copy_selected_on_map
 */
@WebFilter(
		filterName="Map_options_filter",
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/map/main" })
public class Map_options_filter implements Filter {
	private final Logger logger = LoggerFactory.getLogger(Map_options_filter.class);

   
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
		// TODO Auto-generated method stub
		// place your code here
		logger.info("enter doFilter()");
		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpSession session = httpRequest.getSession();
		
		if (httpRequest.getParameter("Add_selected")!= null) 
		{
			httpRequest.setAttribute("Add_selected", true);
			if (session.getAttribute("pois_for_vis")== null) {
				request.setAttribute("success_message", "You have not selected any points");
			}
			logger.info("attribute set");
		} else {
			if (httpRequest.getParameter("Add_to_gr")!= null) 
			{
		
				httpRequest.setAttribute("Add_to_gr", true);
				request.setAttribute("success_message", "Please select the groups to copy points to and press COPY button");
				httpRequest.setAttribute("No_copy_button", true);
				logger.info("attribute set");
			} else 
			{
		
				if (httpRequest.getParameter("Select_g")!= null) 
				{
					httpRequest.setAttribute("Select_g", true);
					httpRequest.setAttribute("No_copy_button", true);
					logger.info("attribute set");
				} else 
				{
		
					if (httpRequest.getParameter("Back_to_collections")!= null) 
					{
						session.setAttribute("group_to_copy", null);
						session.setAttribute("group_to_update", null);
						session.setAttribute("group_to_update1", null);
						logger.info("attribute set");
				} else {
					if (httpRequest.getParameter("filter_pois_only")!= null) 
					{
						session.setAttribute("filter_pois_only", true);
						session.setAttribute("show_collect", null);
						logger.info("filter pois only");
					} else 
					{
						if (httpRequest.getParameter("show_collect")!= null) 
						{
							session.setAttribute("filter_pois_only", null);
							session.setAttribute("show_collect", true);
							logger.info("show collections only");
							
						} else 
						{ if (httpRequest.getParameter("clear_all")!= null) 
						{
							session.setAttribute("filter_pois_only", null);
							session.setAttribute("show_collect", null);
							logger.info("clearing all");
							
						}
							
						}
					}
				}
		}
		}
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
