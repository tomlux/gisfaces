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
import java.util.Map;

/**
 * Service layer field metadata class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceLayerFieldMetadata implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 3184478797212590240L;

	/** Service layer field name. */
	private String name;

	/** Service layer field type. */
	private String type;

	/**
	 * Service layer field alias. Defaults to the name if not specifically
	 * overridden.
	 */
	private String alias;

	/**
	 * Service layer field length. Not applicable for domain values or ESRI types.
	 */
	private int length;

	/**
	 * Service layer field values. Applicable only for statically-defined domain
	 * values.
	 */
	private Map<String, String> values;

	/**
	 * Constructor.
	 */
	public ServiceLayerFieldMetadata() {
		super();
	}

	/**
	 * Method to get the service layer field name.
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the service layer field name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to get the service layer field type.
	 * 
	 * @return String
	 */
	public String getType() {
		return type;
	}

	/**
	 * Method to set the service layer field type.
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method to get the service layer field alias.
	 * 
	 * @return String
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * Method to set the service layer field alias.
	 * 
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * Method to get the service layer field length.
	 * 
	 * @return int
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Method to set the service layer field length.
	 * 
	 * @param length
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Method to get the service layer field values.
	 * 
	 * @return Map
	 */
	public Map<String, String> getValues() {
		return values;
	}

	/**
	 * Method to set the service layer field values.
	 * 
	 * @param values
	 */
	public void setValues(Map<String, String> values) {
		this.values = values;
	}
}
