/**
 * 
 */
package utils_for_servlet;

import model.Model;

/**
 * @author Olga
 *
 */
public class Web_page_config {

	/**
	 * The uri of the web page
	 */
	private final String uri;
	
	/**
	 * The key name to the page
	 */
	private final String displayNameKey;
	
	/**
	 * The role that has access to see the page
	 */
	private final String [] role;
	
	/**
	 * The model that will deal with this page
	 */
	private final Model model;
	
	/**
	 * The view for the page
	 */
	private final String view;
	
	/**
	 * 
	 */
	private final boolean displayInMenu;
	
	/**
	 * 
	 * @param uri
	 * @param displayNameKey
	 * @param role
	 * @param model
	 * @param view
	 */
	
	public Web_page_config(String uri, String displayNameKey, String[] role,
			String view, boolean displayInMenu, Model model)
	{
		
		this.uri = uri;
		this.displayNameKey = displayNameKey;
		this.role = role;
		this.model = model;
		this.view = view;
		this.displayInMenu = displayInMenu;
	}

	/**
	 * 
	 * @return
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * 
	 * @return
	 */
	public String getDisplayNameKey() {
		return displayNameKey;
	}

	/**
	 * 
	 * @return
	 */
	public String[] getRole() {
		return role;
	}

	/**
	 * 
	 * @return
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * 
	 * @return
	 */
	public String getView() {
		return view;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean getDisplayInMenu() {
		return displayInMenu;
	}

}
