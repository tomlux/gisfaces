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

package com.gisfaces.model.map;

import java.io.Serializable;

/**
 * Web map portal class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class WebMap implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 2131003735305807498L;

	/** Portal item ID. */
	private String portalItemId;

	/**
	 * Constructor.
	 */
	public WebMap() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param portalItemId Portal item ID.
	 */
	public WebMap(String portalItemId) {
		super();

		this.portalItemId = portalItemId;
	}

	/**
	 * Method to get the portal item ID.
	 * 
	 * @return
	 */
	public String getPortalItemId() {
		return portalItemId;
	}

	/**
	 * Method to set the portal item ID.
	 * 
	 * @param portalItemId
	 */
	public void setPortalItemId(String portalItemId) {
		this.portalItemId = portalItemId;
	}
}