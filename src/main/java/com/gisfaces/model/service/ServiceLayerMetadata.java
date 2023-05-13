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
import java.util.List;

/**
 * Service layer metadata class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceLayerMetadata implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -6077242743780953638L;

	/** Service layer URL. */
	private String url;

	/** Service layer ID. */
	private String id;

	/** Service layer name. */
	private String name;

	/** Service layer type. */
	private String type;

	/** Service layer geometry type. */
	private String geometryType;

	/** Service layer fields. */
	private List<ServiceLayerFieldMetadata> fields;

	/**
	 * Constructor.
	 */
	public ServiceLayerMetadata() {
		super();
	}

	/**
	 * Method to get the service layer URL.
	 * 
	 * @return String
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Method to set the service layer URL.
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Method to get the service layer ID.
	 * 
	 * @return String
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method to set the service layer ID.
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get the service layer name.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the service layer name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to get the service layer type.
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Method to set the service layer type.
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method to get the service layer geometry type.
	 * 
	 * @return String
	 */
	public String getGeometryType() {
		return geometryType;
	}

	/**
	 * Method to set the service layer geometry type.
	 * 
	 * @param geometryType
	 */
	public void setGeometryType(String geometryType) {
		this.geometryType = geometryType;
	}

	/**
	 * Method to get the service layer fields.
	 * 
	 * @return List
	 */
	public List<ServiceLayerFieldMetadata> getFields() {
		return fields;
	}

	/**
	 * Method to set the service layer fields.
	 * 
	 * @param fields
	 */
	public void setFields(List<ServiceLayerFieldMetadata> fields) {
		this.fields = fields;
	}
}
