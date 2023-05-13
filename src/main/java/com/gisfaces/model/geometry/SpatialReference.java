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

package com.gisfaces.model.geometry;

import java.io.Serializable;

/**
 * Spatial reference class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-SpatialReference.html">ESRI
 *      SpatialReference</a>
 */
public class SpatialReference implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -2394864966318913892L;

	/** Default WKID. */
	public static final int WKID_WGS84 = 4326;

	/** Well known ID. */
	private int wkid = SpatialReference.WKID_WGS84;

	/**
	 * Constructor.
	 */
	public SpatialReference() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param wkid Well known ID.
	 */
	public SpatialReference(int wkid) {
		super();
		this.wkid = wkid;
	}

	/**
	 * Method to get the wkid.
	 * 
	 * @return
	 */
	public int getWkid() {
		return wkid;
	}

	/**
	 * Method to set the wkid.
	 * 
	 * @param wkid
	 */
	public void setWkid(int wkid) {
		this.wkid = wkid;
	}
}
