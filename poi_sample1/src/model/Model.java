/**
 * 
 */
package model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Olga
 *
 */
public interface Model {
	
	/**
	 * 
	 * @param request
	 */
	public void process(HttpServletRequest request);

}
