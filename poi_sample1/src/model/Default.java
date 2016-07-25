/**
 * 
 */
package model;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Olga Deryabina
 * Default model class which is used for the url where no database manipulations is required.
 */
public class Default implements Model 
{
	private final Logger logger = LoggerFactory.getLogger(getClass());


	/* (non-Javadoc)
	 * @see model.Model#process(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void process(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
		logger.info("ENTER process(request)");
		
		try {
		} finally {
			logger.info("EXIT process(request)");
		}
	

	}

}
