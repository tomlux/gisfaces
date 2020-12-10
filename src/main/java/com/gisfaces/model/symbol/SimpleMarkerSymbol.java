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

import com.gisfaces.model.color.Color;
import java.io.Serializable;

/**
 * Simple marker symbol class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-SimpleMarkerSymbol.html">ESRI
 *      SimpleMarkerSymbol</a>
 */
public class SimpleMarkerSymbol extends MarkerSymbol implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 3717108066508265375L;

	/** Symbol style. */
	private String style;

	/** Symbol SVG path. */
	private String path;

	/** Symbol color. */
	private Color color;

	/** Symbol size. */
	private String size;

	/** Symbol line symbol. */
	private SimpleLineSymbol outline;

	/**
	 * Constructor.
	 */
	public SimpleMarkerSymbol() {
		super();

		this.style = SimpleMarkerSymbolStyle.CIRCLE.toString();
		this.color = new Color(255, 255, 0, 0.75d);
		this.size = "8px";
		this.outline = new SimpleLineSymbol();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gisfaces.symbol.Symbol#getType()
	 */
	@Override
	public String getType() {
		return SymbolType.SIMPLE_MARKER.toString();
	}

	/**
	 * Method to get the symbol style.
	 * 
	 * @return
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * Method to set the symbol style.
	 * 
	 * @param style
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * Method to get the symbol SVG path.
	 * 
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Method to set the symbol SVG path.
	 * 
	 * @param path
	 */
	public void setPath(String path) {
		this.path = path;
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
	 * Method to get the symbol size.
	 * 
	 * @return
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Method to set the symbol size.
	 * 
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Method to get the symbol line symbol.
	 * 
	 * @return
	 */
	public SimpleLineSymbol getOutline() {
		return outline;
	}

	/**
	 * Method to set the symbol line symbol.
	 * 
	 * @param outline
	 */
	public void setOutline(SimpleLineSymbol outline) {
		this.outline = outline;
	}
}
