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

package com.gisfaces.model.service;

import java.io.Serializable;
import java.util.List;

/**
 * Service metadata class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceMetadata implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -2965407670093405738L;

	/** Service URL. */
	private String url;

	/** Service version. */
	private String version;

	/** Service name. */
	private String name;

	/** Service type. */
	private String type;

	/** Service description. */
	private String description;

	/** Service layers. */
	private List<ServiceLayerMetadata> layers;

	/**
	 * Constructor.
	 */
	public ServiceMetadata() {
		super();
	}

	/**
	 * Method to get the service URL.
	 * 
	 * @return String
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Method to set the service URL.
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Method to get the service version.
	 * 
	 * @return String
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Method to set the service version.
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Method to get the service name.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the service name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to get the service type.
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Method to set the service type.
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method to get the service description.
	 * 
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method to set the service description.
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Method to get the service layers.
	 * 
	 * @return List
	 */
	public List<ServiceLayerMetadata> getLayers() {
		return layers;
	}

	/**
	 * Method to set the service layers.
	 * 
	 * @param layers
	 */
	public void setLayers(List<ServiceLayerMetadata> layers) {
		this.layers = layers;
	}
}
