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

package com.gisfaces.model.geometry;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Geometry polyline class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-geometry-Polyline.html">ESRI
 *      Polyline</a>
 */
public class Polyline implements Geometry, Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -4215084863724245402L;

	/** Polyline paths. */
	private Double paths[][][];

	/**
	 * Constructor.
	 */
	public Polyline() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gisfaces.model.geometry.Geometry#getType()
	 */
	@Override
	public String getType() {
		return GeometryType.POLYLINE.toString();
	}

	/**
	 * Method to get the polyline paths.
	 * 
	 * @return
	 */
	public Double[][][] getPaths() {
		return paths;
	}

	/**
	 * Method to set the polyline paths.
	 * 
	 * @param paths
	 */
	public void setPaths(Double[][][] paths) {
		this.paths = paths;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("{type='%s', paths=%s}", this.getType(), Arrays.deepToString(this.paths));
	}
}
