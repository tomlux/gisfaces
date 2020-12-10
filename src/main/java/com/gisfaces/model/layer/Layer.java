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

/**
 * Base map layer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-Layer.html">ESRI
 *      Layer</a>
 */
public abstract class Layer {
	/** Layer ID. */
	private String id;

	/** Layer opacity. */
	private Double opacity;

	/** Layer title to be used in the legend. */
	private String title;

	/** Layer visibility. */
	private Boolean visible = true;

	/**
	 * Method to get the layer ID.
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method to set the layer ID.
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get the layer opacity.
	 * 
	 * @return
	 */
	public Double getOpacity() {
		return opacity;
	}

	/**
	 * Method to set the layer opacity.
	 * 
	 * @param opacity
	 */
	public void setOpacity(Double opacity) {
		this.opacity = opacity;
	}

	/**
	 * Method to get the layer title.
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method to set the layer title.
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Method to get the layer visibility.
	 * 
	 * @return
	 */
	public Boolean getVisible() {
		return visible;
	}

	/**
	 * Method to set the layer visibility.
	 * 
	 * @param visible
	 */
	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
}
