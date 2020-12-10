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

/**
 * Point cloud renderer abstract base class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRenderer.html">ESRI
 *      PointCloudRenderer</a>
 */
public abstract class PointCloudRenderer implements Renderer {
	/** Color modulation. */
	private ColorModulation colorModulation;

	/** Point size algorithm. */
	private PointSizeAlgorithm pointSizeAlgorithm;

	/** Points per inch. */
	private Integer pointsPerInch;

	/**
	 * Method to get the color modulation.
	 * 
	 * @return
	 */
	public ColorModulation getColorModulation() {
		return colorModulation;
	}

	/**
	 * Method to set the color modulation.
	 * 
	 * @param colorModulation
	 */
	public void setColorModulation(ColorModulation colorModulation) {
		this.colorModulation = colorModulation;
	}

	/**
	 * Method to get the point size algorithm.
	 * 
	 * @return
	 */
	public PointSizeAlgorithm getPointSizeAlgorithm() {
		return pointSizeAlgorithm;
	}

	/**
	 * Method to set the point size algorithm.
	 * 
	 * @param pointSizeAlgorithm
	 */
	public void setPointSizeAlgorithm(PointSizeAlgorithm pointSizeAlgorithm) {
		this.pointSizeAlgorithm = pointSizeAlgorithm;
	}

	/**
	 * Method to get the points per inch.
	 * 
	 * @return
	 */
	public Integer getPointsPerInch() {
		return pointsPerInch;
	}

	/**
	 * Method to set the points per inch.
	 * 
	 * @param pointsPerInch
	 */
	public void setPointsPerInch(Integer pointsPerInch) {
		this.pointsPerInch = pointsPerInch;
	}
}
