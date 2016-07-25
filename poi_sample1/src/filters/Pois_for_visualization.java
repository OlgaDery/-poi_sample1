package filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.InitialContext;
import javax.naming.NamingException;

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

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import bean_interfaces.POI_operations_stateless;
import objests_interfaces.POI_IF;

/**
 * Servlet Filter implementation class Pois_for_visualization_filter. This is a special filter for the url 
 * reserved for communication to Ajax listener, responsible for the visualization of points on the Google map.
 * The doFilter method gets the parameter for points filtering, calls the EJB method what is designed to select the points
 * by certain parameters, then calls the another method to create a Json array from a list of points,
 * and sends this json array to Ajax.
 */ 
@WebFilter(
		filterName="Pois_for_visualization",
		dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE
		}, 
		urlPatterns = { "/map/ajax"
		})
public class Pois_for_visualization implements Filter {
	private final Logger logger = LoggerFactory.getLogger(Pois_for_visualization.class);
	private InitialContext context;
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		logger.info("ENTER destroy(request,response)");
		// TODO Auto-generated method stub
		logger.info("EXIT destroy(request,response)");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		
		logger.info("ENTER dofilter((ServletRequest, ServletResponse)");
		POI_operations_stateless po;
		List<? extends POI_IF> my_pois = new LinkedList<POI_IF> ();
		JSONArray lst = new JSONArray();
		// to parse the request param to understand what pois will be filtered
		Map <String, String[]> data = request.getParameterMap();
		
		if (data.size()>0) {
			logger.info("data from ajex received");
			logger.info("data: {}", data.size());
			if (data.containsKey("district[]")||data.containsKey("poi_subc1[]")||data.containsKey("poi_subc2[]")||data.containsKey("status[]")||data.containsKey("rating[]")||
					data.containsKey("avail[]")||data.containsKey("period[]")||data.containsKey("spec_places[]"))//(request.getParameter("Select_poi_filters")!= null) 
					{
						logger.info("map size: {}", request.getParameterMap().size());

						try {
							po = (POI_operations_stateless) context.lookup("java:global/poi_app/POI_stateless_bean");
							List <? extends POI_IF> pois_all = po.select_all();
							Set <? extends POI_IF> my_pois1 = new HashSet <POI_IF>();
							((Set <POI_IF>)my_pois1).addAll(pois_all);
							my_pois = po.select_filtered_POIs(my_pois1, data);
	                		final HttpServletRequest httpRequest = (HttpServletRequest) request;
	                		final HttpSession session = httpRequest.getSession();
							session.setAttribute("pois_for_vis", my_pois);
							
							if (my_pois.size() == 0) 
							{
								request.setAttribute("pois_for_vis", null);
								request.setAttribute("success_message", "sorry, no data has found");
							}
							else {

							lst = po.returnJson(my_pois);
							request.setAttribute("pois_for_vis", lst);
							
							}
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							logger.info(e.getMessage(), e);
						}	
					}

			request.setAttribute("pois_for_vis", lst);
			response.setContentType("application/json");

			PrintWriter out = response.getWriter();
						
			out.print(lst);
			out.flush();
		}


		// pass the request along the filter chain
		chain.doFilter(request, response);
		logger.info("EXIT dofilter((ServletRequest, ServletResponse)");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("ENTER init(request,response)");
		
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			logger.info("naming exception()");
		}
		
		logger.info("EXIT init(request,response)");
	}
}
