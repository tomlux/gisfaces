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

package com.gisfaces.model.symbol;

import java.io.Serializable;

/**
 * Picture marker symbol class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-PictureMarkerSymbol.html">ESRI
 *      PictureMarkerSymbol</a>
 */
public class PictureMarkerSymbol extends MarkerSymbol implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -2509040188199556346L;

	/** Symbol URL. */
	private String url;

	/** Symbol width. */
	private String width;

	/** Symbol height. */
	private String height;

	/**
	 * Constructor.
	 */
	public PictureMarkerSymbol() {
		this("http://static.arcgis.com/images/Symbols/Shapes/OrangePin2LargeB.png", "24px", "24px");
	}

	/**
	 * Constructor.
	 * 
	 * @param url    Symbol URL.
	 * @param width  Symbol width.
	 * @param height Symbol height.
	 */
	public PictureMarkerSymbol(String url, String width, String height) {
		super();

		this.url = url;
		this.width = width;
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gisfaces.symbol.Symbol#getType()
	 */
	@Override
	public String getType() {
		return SymbolType.PICTURE_MARKER.toString();
	}

	/**
	 * Method to get the symbol URL.
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Method to set the symbol URL.
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Method to get the symbol width.
	 * 
	 * @return
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Method to set the symbol width.
	 * 
	 * @param width
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * Method to get the symbol height.
	 * 
	 * @return
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Method to set the symbol height.
	 * 
	 * @param height
	 */
	public void setHeight(String height) {
		this.height = height;
	}
}
