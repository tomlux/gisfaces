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

package com.gisfaces.model.layer;

import java.io.Serializable;

/**
 * Bing maps layer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-BingMapsLayer.html">ESRI
 *      Bing Maps Layer</a>
 */
public class BingMapsLayer extends ScaledLayer implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -5365901268552030015L;

	/** Bing map key. */
	private String key;

	/** Bing map style. */
	private BingMapsStyle style;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public BingMapsLayer() {
		super();
	}

	/**
	 * Method to get the bing map key.
	 * 
	 * @return
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Method to set the bing map key.
	 * 
	 * @param key
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Method to get the bing map style.
	 * 
	 * @return
	 */
	public BingMapsStyle getStyle() {
		return style;
	}

	/**
	 * Method to set the bing map style.
	 * 
	 * @param style
	 */
	public void setStyle(BingMapsStyle style) {
		this.style = style;
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
