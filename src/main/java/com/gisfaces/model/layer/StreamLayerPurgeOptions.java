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
 * Stream layer purge class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-StreamLayer.html#purgeOptions">ESRI
 *      Stream Layer Purge Options</a>
 */
public class StreamLayerPurgeOptions implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 102295549820696254L;

	/**
	 * The maximum number of features to display. Excess features are purged from
	 * the beginning of the graphics array.
	 */
	private Integer displayCount;

	/**
	 * The maximum time in minutes that a feature should be kept. After this time,
	 * the feature is removed from the layer.
	 */
	private Integer age;

	/**
	 * Constructor.
	 */
	public StreamLayerPurgeOptions() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param displayCount Maximum display count.
	 * @param age          Maximum age in minutes.
	 */
	public StreamLayerPurgeOptions(Integer displayCount, Integer age) {
		super();
		this.displayCount = displayCount;
		this.age = age;
	}

	/**
	 * Method to get the maximum display count.
	 * 
	 * @return
	 */
	public Integer getDisplayCount() {
		return displayCount;
	}

	/**
	 * Method to set the maximum display count.
	 * 
	 * @param displayCount
	 */
	public void setDisplayCount(Integer displayCount) {
		this.displayCount = displayCount;
	}

	/**
	 * Method to get the maximum age in minutes.
	 * 
	 * @return
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * Method to set the maximum age in minutes.
	 * 
	 * @param age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
}
