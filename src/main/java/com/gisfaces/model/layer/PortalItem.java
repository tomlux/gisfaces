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

package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Portal item class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-portal-PortalItem.html">ESRI
 *      Portal Item</a>
 */
public class PortalItem implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -6543761256288872328L;

	/** Portal item ID. */
	private String id;

	/** Portal item title. */
	private String title;

	/**
	 * Constructor.
	 */
	public PortalItem() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param id Portal Item ID.
	 */
	public PortalItem(String id) {
		super();
		this.id = id;
	}

	/**
	 * Method to get the portal item ID.
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method to set the portal item ID.
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get the portal item title.
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method to set the portal item title.
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
