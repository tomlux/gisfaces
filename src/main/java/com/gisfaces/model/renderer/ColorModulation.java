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

package com.gisfaces.model.renderer;

import java.io.Serializable;

/**
 * Color modulation for point cloud renderer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRGBRenderer.html#colorModulation">ESRI
 *      ColorModulation</a>
 */
public class ColorModulation implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -9035383193001994181L;

	/**
	 * Field to use for the color modulation. Commonly, modulation is used with the
	 * intensity field.
	 */
	private String field;

	/** Field value at which the point color becomes darkest. */
	private Integer minValue;

	/** Field value at which the point color will be left unchanged. */
	private Integer maxValue;

	/**
	 * Constructor.
	 */
	public ColorModulation() {
		super();
	}

	/**
	 * Method to get the color modulation field.
	 * 
	 * @return
	 */
	public String getField() {
		return field;
	}

	/**
	 * Method to set the color modulation field.
	 * 
	 * @param field
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * Method to get the minimum value.
	 * 
	 * @return
	 */
	public Integer getMinValue() {
		return minValue;
	}

	/**
	 * Method to set the minimum value.
	 * 
	 * @param minValue
	 */
	public void setMinValue(Integer minValue) {
		this.minValue = minValue;
	}

	/**
	 * Method to get the maximum value.
	 * 
	 * @return
	 */
	public Integer getMaxValue() {
		return maxValue;
	}

	/**
	 * Method to set the maximum value.
	 * 
	 * @param maxValue
	 */
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
	}
}
