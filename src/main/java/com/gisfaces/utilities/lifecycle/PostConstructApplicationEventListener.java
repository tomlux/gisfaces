package com.gisfaces.utilities.lifecycle;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.faces.application.Application;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

/**
 * Post construction application event listener.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class PostConstructApplicationEventListener implements SystemEventListener
{
	/** Logger. */
	private static final Logger logger = Logger.getLogger(PostConstructApplicationEventListener.class.getCanonicalName());

	/* (non-Javadoc)
	 * @see javax.faces.event.SystemEventListener#isListenerForSource(java.lang.Object)
	 */
	@Override
	public boolean isListenerForSource(Object source)
	{
		return (source instanceof Application);
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.SystemEventListener#processEvent(javax.faces.event.SystemEvent)
	 */
	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException
	{
		logger.info("Running on GISFaces " + this.getProperties().getProperty("version", ""));
	}

	/**
	 * Method to get the library properties.
	 * @return Properties
	 */
	public Properties getProperties()
	{
		Properties props = new Properties();

		try
		{
			InputStream stream = this.getClass().getResourceAsStream("/META-INF/maven/com.gisfaces/gisfaces/pom.properties");

			props.load(stream);

			stream.close();
		}
		catch (Exception e)
		{
			logger.info("Error loading gisfaces pom.properties file.");
		}

		return props;
	}
}
