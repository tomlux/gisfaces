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

import com.gisfaces.model.color.Color;
import java.io.Serializable;

/**
 * Simple line symbol class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-LineSymbol.html">ESRI
 *      LineSymbol</a>
 */
public class SimpleLineSymbol implements Symbol, Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 6929173323773587094L;

	/** Symbol color. */
	private Color color;

	/** Symbol width. */
	private String width;

	/**
	 * Constructor.
	 */
	public SimpleLineSymbol() {
		super();

		this.color = new Color("#000000");
		this.width = "1px";
	}

	/**
	 * Constructor.
	 * 
	 * @param color Symbol color.
	 * @param width Symbol width.
	 */
	public SimpleLineSymbol(Color color, String width) {
		super();

		this.color = color;
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gisfaces.symbol.Symbol#getType()
	 */
	@Override
	public String getType() {
		return SymbolType.SIMPLE_LINE.toString();
	}

	/**
	 * Method to get the symbol color.
	 * 
	 * @return
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Method to set the symbol color.
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		this.color = color;
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
}
