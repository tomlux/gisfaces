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

package com.gisfaces.model.symbol;

/**
 * Marker symbol class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-MarkerSymbol.html">ESRI
 *      MarkerSymbol</a>
 */
public abstract class MarkerSymbol implements Symbol {
	/** Symbol angle. */
	private int angle;

	/** Symbol X offset. */
	private String xoffset;

	/** Symbol Y offset. */
	private String yoffset;

	/**
	 * Method to get the symbol angle.
	 * 
	 * @return
	 */
	public int getAngle() {
		return angle;
	}

	/**
	 * Method to set the symbol angle.
	 * 
	 * @param angle
	 */
	public void setAngle(int angle) {
		this.angle = angle;
	}

	/**
	 * Method to get the symbol X offset.
	 * 
	 * @return
	 */
	public String getXoffset() {
		return xoffset;
	}

	/**
	 * Method to set the symbol X offset.
	 * 
	 * @param xoffset
	 */
	public void setXoffset(String xoffset) {
		this.xoffset = xoffset;
	}

	/**
	 * Method to get the symbol Y offset.
	 * 
	 * @return
	 */
	public String getYoffset() {
		return yoffset;
	}

	/**
	 * Method to set the symbol Y offset.
	 * 
	 * @param yoffset
	 */
	public void setYoffset(String yoffset) {
		this.yoffset = yoffset;
	}
}
