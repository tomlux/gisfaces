/*
 * The MIT License
 *
 * Copyright (c) 2013-2023 Chris Duncan (cduncan@gisfaces.com)
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

package com.gisfaces.model.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Service directory metadata class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceDirectoryMetadata implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -6430850674927017440L;

	/** Service directory URL. */
	private String url;

	/** Service directory version. */
	private String version;

	/** Service directory sub-folders. */
	private List<String> folders = new ArrayList<String>();

	/** Service directory services. */
	private List<ServiceMetadata> services;

	/**
	 * Constructor.
	 */
	public ServiceDirectoryMetadata() {
		super();
	}

	/**
	 * Method to get the service directory URL.
	 * 
	 * @return String
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Method to set the service directory URL.
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Method to get the service directory version.
	 * 
	 * @return String
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Method to set the service directory version.
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Method to get the service directory sub-folders.
	 * 
	 * @return List
	 */
	public List<String> getFolders() {
		return folders;
	}

	/**
	 * Method to set the service directory sub-folders.
	 * 
	 * @param folders
	 */
	public void setFolders(List<String> folders) {
		this.folders = folders;
	}

	/**
	 * Method to get the service directory services.
	 * 
	 * @return List
	 */
	public List<ServiceMetadata> getServices() {
		return services;
	}

	/**
	 * Method to set the service directory services.
	 * 
	 * @param services
	 */
	public void setServices(List<ServiceMetadata> services) {
		this.services = services;
	}
}
