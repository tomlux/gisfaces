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
 * Simple marker symbol path enum class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-SimpleMarkerSymbol.html#path">ESRI
 *      Symbol</a>
 */
public enum SimpleMarkerSymbolPath {
	ARROW("M 0,20 6,0 12,20 6,16 z"),
	CIRCLE("M16,14.584c-1.979,0-3.584-1.604-3.584-3.584S14.021,7.416,16,7.416S19.584,9.021,19.584,11S17.979,14.584,16,14.584z"),
	CROSS("M 415,214 415,230 M 407,222 423,222"), DIAMOND("M 415,214 423,222 415,230 407,222 Z"),
	MARKER("M16,3.5c-4.142,0-7.5,3.358-7.5,7.5c0,4.143,7.5,18.121,7.5,18.121S23.5,15.143,23.5,11C23.5,6.858,20.143,3.5,16,3.5z M16,14.584c-1.979,0-3.584-1.604-3.584-3.584S14.021,7.416,16,7.416S19.584,9.021,19.584,11S17.979,14.584,16,14.584z"),
	OCTOGON("M 60 0 L 120 0 L 180 60 L 180 120 L 120 180 L 60 180 L 0 120 L 0 60"), POLYGON("M -10,-10 L 10,0 L 10,10 L -10,10 L -10,-10 Z"),
	SQUARE("M 407,214 423,214 423,230 407,230 Z"), STAR("M 125,5 155,90 245,90 175,145 200,230 125,180 50,230 75,145 5,90 95,90 z"),
	X("M 407,214 423,230 M 407,230 423,214");

	/** Vector path string. */
	private String path;

	/**
	 * Constructor. Package scope required for enum constructors.
	 * 
	 * @param path SVG path string.
	 */
	SimpleMarkerSymbolPath(String path) {
		this.path = path;
	}

	/**
	 * Method to get the SVG path string.
	 * 
	 * @return String
	 */
	public String getPath() {
		return this.path;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.path;
	}
}
