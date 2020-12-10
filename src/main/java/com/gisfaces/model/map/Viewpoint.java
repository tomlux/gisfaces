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

package com.gisfaces.model.map;

import com.gisfaces.component.Constants;
import java.io.Serializable;

/**
 * Map view point class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-Viewpoint.html">ESRI
 *      Viewpoint</a>
 */
public class Viewpoint implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 4353555265931757902L;

	/** Map latitude coordinate. */
	private double latitude;

	/** Map longitude coordinate. */
	private double longitude;

	/** Map zoom level. Most ESRI background layers range from 0 to 16 or 23. */
	private double zoom;

	/**
	 * Constructor.
	 */
	public Viewpoint() {
		super();
		this.latitude = Constants.DEFAULT_LATITUDE;
		this.longitude = Constants.DEFAULT_LONGITUDE;
		this.zoom = Constants.DEFAULT_ZOOM;
	}

	/**
	 * Method to get the map latitude.
	 * 
	 * @return
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * Method to set the map latitude.
	 * 
	 * @param latitude
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Method to get the map longitude.
	 * 
	 * @return
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * Method to set the map longitude.
	 * 
	 * @param longitude
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Method to get the map zoom level.
	 * 
	 * @return
	 */
	public double getZoom() {
		return zoom;
	}

	/**
	 * Method to set the map zoom level.
	 * 
	 * @param zoom
	 */
	public void setZoom(double zoom) {
		this.zoom = zoom;
	}
}
