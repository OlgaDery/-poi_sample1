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
 * Servlet Filter implementation class Pois_for_visualization_filter
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
		
		//IMPORTANT: after having the event listeners created in will be more efficient to keep the list of previously selected
		//values and parameters. At this case we will need just to add or remove one param to the previous selection
		// unless "CLEAR_ALL button is submitted"
		
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
						
//						if (data.keySet().contains("Select_poi_filters")) {
//							data.remove("Select_poi_filters", data.get("Select_poi_filters"));
//						}
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
			else {
				if (data.containsKey("Poi_to_copy[]")||data.containsKey("pois_of_user[]")||data.containsKey("Poi_in_group[]")
					||data.containsKey("groups_of_user[]")||data.containsKey("group_to_copy_to[]"))
				//	||data.containsKey("district[]")||data.containsKey("poi_subc1[]")||data.containsKey("poi_subc2[]"))
				{
					
//					for (String key : data.keySet()) {
//						logger.info("key {}:", key);
//					}
//						
					
					try {
						po = (POI_operations_stateless) context.lookup("java:global/poi_app/POI_stateless_bean");
						my_pois = po.selectPoisToShow(data);
						lst = po.returnJson(my_pois);
						logger.info("json list :{}", lst.size());
						
						//HOW TO SEND JSON&&&
					} catch (Exception e) {
						logger.info(e.getMessage(), e);
					}
					
				}
			}
			request.setAttribute("pois_for_vis", lst);
			response.setContentType("application/json");
//			response.setContentType("text/html");
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (POI_IF poi : my_pois)
			{
				sb.append("{").append("'id'").append(":'").append(poi.getPoi_name()).append("',").append("'poi_lat'").append(":").append(poi.getPoi_lat()).append(",").
				append("'poi_lng'").append(":").append(poi.getPoi_lng()).append("},");
								
			}
			sb.delete((sb.length()-1), sb.length());
			sb.append("]");
			logger.info(sb.toString());
			PrintWriter out = response.getWriter();
						
			out.print(lst);//sb.toString());//);
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
