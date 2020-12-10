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
 * Scaled layer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public abstract class ScaledLayer extends Layer {
	/** Minimum map scale for layer visibility. */
	private Integer minScale;

	/** Maximum map scale for layer visibility. */
	private Integer maxScale;

	/**
	 * Method to get the minimum map scale for layer visibility.
	 * 
	 * @return
	 */
	public Integer getMinScale() {
		return minScale;
	}

	/**
	 * Method to set the minimum map scale for layer visibility.
	 * 
	 * @param minScale
	 */
	public void setMinScale(Integer minScale) {
		this.minScale = minScale;
	}

	/**
	 * Method to get the maximum map scale for layer visibility.
	 * 
	 * @return
	 */
	public Integer getMaxScale() {
		return maxScale;
	}

	/**
	 * Method to set the maximum map scale for layer visibility.
	 * 
	 * @param maxScale
	 */
	public void setMaxScale(Integer maxScale) {
		this.maxScale = maxScale;
	}
}
