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

import com.gisfaces.model.renderer.PointCloudRenderer;
import java.io.Serializable;

/**
 * Point image layer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-PointCloudLayer.html">ESRI
 *      Point Cloud Layer</a>
 */
public class PointCloudLayer extends Layer implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -4413224473086563237L;

	/** Layer URL. */
	private String url;

	/** Symbology renderer. */
	private PointCloudRenderer renderer;

	/**
	 * Constructor.
	 */
	public PointCloudLayer() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param id  Layer ID.
	 * @param url Layer URL.
	 */
	public PointCloudLayer(String id, String url) {
		super();
		this.setId(id);
		this.setUrl(url);
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
	 * Method to get the symbology renderer.
	 * 
	 * @return
	 */
	public PointCloudRenderer getRenderer() {
		return renderer;
	}

	/**
	 * Method to set the symbology renderer.
	 * 
	 * @param renderer
	 */
	public void setRenderer(PointCloudRenderer renderer) {
		this.renderer = renderer;
	}
}
