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
 * WMTS layer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-WMTSLayer.html">ESRI
 *      WMTS Layer</a>
 */
public class WMTSLayer extends ScaledLayer implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 4361993346777232903L;

	/** Active sub layer. */
	private WMTSSubLayer activeLayer;

	/** Copyright attribution. */
	private String copyright;

	/** Portal item. */
	private PortalItem portalItem;

	/** Layer URL. */
	private String url;

	/** Refresh interval in minutes. */
	private Double refreshInterval;

	/**
	 * Constructor.
	 */
	public WMTSLayer() {
		super();
	}

	/**
	 * Method to get the active sub layer.
	 * 
	 * @return
	 */
	public WMTSSubLayer getActiveLayer() {
		return activeLayer;
	}

	/**
	 * Method to set the active sub layer.
	 * 
	 * @param activeLayer
	 */
	public void setActiveLayer(WMTSSubLayer activeLayer) {
		this.activeLayer = activeLayer;
	}

	/**
	 * Method to get the copyright attribution.
	 * 
	 * @return
	 */
	public String getCopyright() {
		return copyright;
	}

	/**
	 * Method to set the copyright attribution.
	 * 
	 * @param copyright
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	/**
	 * Method to get the portal item.
	 * 
	 * @return
	 */
	public PortalItem getPortalItem() {
		return portalItem;
	}

	/**
	 * Method to set the portal item.
	 * 
	 * @param portalItem
	 */
	public void setPortalItem(PortalItem portalItem) {
		this.portalItem = portalItem;
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
