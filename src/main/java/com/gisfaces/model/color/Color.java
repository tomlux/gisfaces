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

package com.gisfaces.model.color;

import java.io.Serializable;

/**
 * Color class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-Color.html">ESRI
 *      Color</a>
 */
public class Color implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -3686838425059885831L;

	/** Red value (0-255). */
	private int r;

	/** Green value (0-255). */
	private int g;

	/** Blue value (0-255). */
	private int b;

	/** Alpha value (0.0-1.0). */
	private double a;

	/**
	 * Constructor.
	 * 
	 * @param hex Hex string.
	 */
	public Color(String hex) {
		super();

		// Ensure proper hex color string format.
		if ((hex != null) && (!hex.startsWith("#"))) {
			hex = "#".concat(hex);
		}

		// Parse the hex color string.
		java.awt.Color c = java.awt.Color.decode(hex);
		this.r = c.getRed();
		this.g = c.getGreen();
		this.b = c.getBlue();
		this.a = 1.0d;
	}

	/**
	 * Constructor.
	 * 
	 * @param r Red value.
	 * @param g Green value.
	 * @param b Blue value.
	 */
	public Color(int r, int g, int b) {
		this(r, g, b, 1.0d);
	}

	/**
	 * Constructor.
	 * 
	 * @param r Red value.
	 * @param g Green value.
	 * @param b Blue value.
	 * @param a Alpha value.
	 */
	public Color(int r, int g, int b, double a) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	/**
	 * Method to get the red value.
	 * 
	 * @return
	 */
	public int getR() {
		return r;
	}

	/**
	 * Method to set the red value.
	 * 
	 * @param r
	 */
	public void setR(int r) {
		this.r = r;
	}

	/**
	 * Method to get the green value.
	 * 
	 * @return
	 */
	public int getG() {
		return g;
	}

	/**
	 * Method to set the green value.
	 * 
	 * @param g
	 */
	public void setG(int g) {
		this.g = g;
	}

	/**
	 * Method to get the blue value.
	 * 
	 * @return
	 */
	public int getB() {
		return b;
	}

	/**
	 * Method to set the blue value.
	 * 
	 * @param b
	 */
	public void setB(int b) {
		this.b = b;
	}

	/**
	 * Method to get the alpha value.
	 * 
	 * @return
	 */
	public double getA() {
		return a;
	}

	/**
	 * Method to set the alpha value.
	 * 
	 * @param a
	 */
	public void setA(double a) {
		this.a = a;
	}
}
