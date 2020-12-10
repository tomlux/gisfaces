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

import java.io.Serializable;

/**
 * Font class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Font.html">ESRI
 *      Symbol Font</a>
 */
public class Font implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 6253107222387937071L;

	/** Font decoration (underline | line-through | none). */
	private String decoration;

	/** Font family. */
	private String family;

	/** Font size. */
	private String size;

	/** Font style (normal | italic | oblique). */
	private String style;

	/** Font weight (normal | bold | bolder | lighter). */
	private String weight;

	/**
	 * Constructor.
	 */
	public Font() {
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param family Font family.
	 * @param size   String size
	 */
	public Font(String family, String size) {
		super();
		this.family = family;
		this.size = size;
	}

	/**
	 * Constructor.
	 * 
	 * @param decoration Font decoration (underline | line-through | none).
	 * @param family     Font family.
	 * @param size       String size
	 * @param style      Font style (normal | italic | oblique).
	 * @param weight     Font weight (normal | bold | bolder | lighter).
	 */
	public Font(String decoration, String family, String size, String style, String weight) {
		super();
		this.decoration = decoration;
		this.family = family;
		this.size = size;
		this.style = style;
		this.weight = weight;
	}

	/**
	 * Method to get the font decoration.
	 * 
	 * @return
	 */
	public String getDecoration() {
		return decoration;
	}

	/**
	 * Method to set the font decoration.
	 * 
	 * @param decoration
	 */
	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	/**
	 * Method to get the font family.
	 * 
	 * @return
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * Method to set the font family.
	 * 
	 * @param family
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	/**
	 * Method to get the font size.
	 * 
	 * @return
	 */
	public String getSize() {
		return size;
	}

	/**
	 * Method to set the font size.
	 * 
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Method to get the font style.
	 * 
	 * @return
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * Method to set the font style.
	 * 
	 * @param style
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * Method to get the font weight.
	 * 
	 * @return
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * Method to set the font weight.
	 * 
	 * @param weight
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}
}
