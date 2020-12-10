/*
 * The MIT License
 *
 * Copyright (c) 2013-2021 Chris Duncan (cduncan@gisfaces.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class PostConstructApplicationEventListener implements SystemEventListener {
	/** Logger. */
	private static final Logger logger = Logger.getLogger(PostConstructApplicationEventListener.class.getCanonicalName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.faces.event.SystemEventListener#isListenerForSource(java.lang.Object)
	 */
	@Override
	public boolean isListenerForSource(Object source) {
		return (source instanceof Application);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.event.SystemEventListener#processEvent(javax.faces.event.
	 * SystemEvent)
	 */
	@Override
	public void processEvent(SystemEvent event) throws AbortProcessingException {
		logger.info("Running on GISFaces " + this.getProperties().getProperty("version", ""));
	}

	/**
	 * Method to get the library properties.
	 * 
	 * @return Properties
	 */
	public Properties getProperties() {
		Properties props = new Properties();

		try {
			InputStream stream = this.getClass().getResourceAsStream("/META-INF/maven/com.gisfaces/gisfaces/pom.properties");

			props.load(stream);

			stream.close();
		} catch (Exception e) {
			logger.info("Error loading gisfaces pom.properties file.");
		}

		return props;
	}
}
