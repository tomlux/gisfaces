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
 * Tile layer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-TileLayer.html">ESRI
 *      Tile Layer</a>
 */
public class TileLayer extends ScaledLayer implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -6745578369463055361L;

	/** Layer URL. */
	private String url;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public TileLayer() {
		super();
	}

	/**
	 * Method to get the layer URL.
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Method to set the layer URL.
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Method to get the refresh interval.
	 * 
	 * @return
	 */
	public Double getRefreshInterval() {
		return refreshInterval;
	}

	/**
	 * Method to set the refresh interval.
	 * 
	 * @param refreshInterval
	 */
	public void setRefreshInterval(Double refreshInterval) {
		this.refreshInterval = refreshInterval;
	}
}
