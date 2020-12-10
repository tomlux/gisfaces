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

import com.gisfaces.model.symbol.Symbol;
import java.io.Serializable;

/**
 * Simple renderer class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-SimpleRenderer.html">ESRI
 *      SimpleRenderer</a>
 */
public class SimpleRenderer implements Renderer, Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 2767804349739248375L;

	/** Renderer symbol. */
	private Symbol symbol;

	/**
	 * Constructor.
	 */
	public SimpleRenderer() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param symbol
	 */
	public SimpleRenderer(Symbol symbol) {
		super();

		this.symbol = symbol;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gisfaces.model.renderer.Renderer#getType()
	 */
	@Override
	public String getType() {
		return RendererType.SIMPLE.toString();
	}

	/**
	 * Method to get the renderer symbol.
	 * 
	 * @return
	 */
	public Symbol getSymbol() {
		return symbol;
	}

	/**
	 * Method to set the renderer symbol.
	 * 
	 * @param symbol
	 */
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
}
