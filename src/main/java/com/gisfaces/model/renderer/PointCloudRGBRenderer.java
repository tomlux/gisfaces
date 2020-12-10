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

package com.gisfaces.model.renderer;

import java.io.Serializable;

/**
 * Point cloud RGB renderer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRGBRenderer.html">ESRI
 *      PointCloudRGBRenderer</a>
 */
public class PointCloudRGBRenderer extends PointCloudRenderer implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 6899446377169873722L;

	/** RGB value field. */
	private String field;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gisfaces.model.renderer.Renderer#getType()
	 */
	@Override
	public String getType() {
		return PointCloudRendererType.POINT_CLOUD_RGB.toString();
	}

	/**
	 * Method to get the RGB value field.
	 * 
	 * @return
	 */
	public String getField() {
		return field;
	}

	/**
	 * Method to set the RGB value field.
	 * 
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}
}
