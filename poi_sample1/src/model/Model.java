/**
 * 
 */
package model;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Olga Deryabina. Prototype of all the model classes which are designed to access the business logic level if such
 * request was sent from a certain url (which a specific model class is programmically tied to).
 *
 */
public interface Model {
	
	/**
	 * 
	 * @param request
	 */
	public void process(HttpServletRequest request);

}
