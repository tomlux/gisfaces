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

import java.util.ArrayList;
import java.util.List;

/**
 * Symbol 3D abstract class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol3D.html">ESRI
 *      Symbol 3D</a>
 */
public abstract class Symbol3D implements Symbol {
	/** List of symbol layers. */
	private List<Symbol3DLayer> symbolLayers = new ArrayList<Symbol3DLayer>();

	/**
	 * Method to get the list of symbol layers.
	 * 
	 * @return
	 */
	public List<Symbol3DLayer> getSymbolLayers() {
		return symbolLayers;
	}

	/**
	 * Method to set the list of symbol layers.
	 * 
	 * @param symbolLayers
	 */
	public void setSymbolLayers(List<Symbol3DLayer> symbolLayers) {
		this.symbolLayers = symbolLayers;
	}
}
