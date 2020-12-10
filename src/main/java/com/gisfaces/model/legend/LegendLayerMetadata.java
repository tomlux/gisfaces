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

package com.gisfaces.model.legend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Legend layer metadata class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class LegendLayerMetadata implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 5515197571285862093L;

	/** Layer ID. */
	private int layerId;

	/** Layer name. */
	private String layerName;

	/** Layer type. */
	private String layerType;

	/** Layer minimum scale range. */
	private int minScale;

	/** Layer maximum scale range. */
	private int maxScale;

	/** Layer symbology. */
	private List<LegendLayerSymbolMetadata> symbology = new ArrayList<LegendLayerSymbolMetadata>();

	/**
	 * Constructor.
	 */
	public LegendLayerMetadata() {
		super();
	}

	/**
	 * Method to get the layer ID.
	 * 
	 * @return int
	 */
	public int getLayerId() {
		return layerId;
	}

	/**
	 * Method to set the layer ID.
	 * 
	 * @param layerId
	 */
	public void setLayerId(int layerId) {
		this.layerId = layerId;
	}

	/**
	 * Method to get the layer name.
	 * 
	 * @return String
	 */
	public String getLayerName() {
		return layerName;
	}

	/**
	 * Method to set the layer name.
	 * 
	 * @param layerName
	 */
	public void setLayerName(String layerName) {
		this.layerName = layerName;
	}

	public String getLayerType() {
		return layerType;
	}

	/**
	 * Method to get the layer type.
	 * 
	 * @param layerType
	 */
	public void setLayerType(String layerType) {
		this.layerType = layerType;
	}

	/**
	 * Method to set the layer type.
	 * 
	 * @return int
	 */
	public int getMinScale() {
		return minScale;
	}

	/**
	 * Method to get the layer minimum scale range.
	 * 
	 * @param minScale
	 */
	public void setMinScale(int minScale) {
		this.minScale = minScale;
	}

	/**
	 * Method to set the layer minimum scale range.
	 * 
	 * @return int
	 */
	public int getMaxScale() {
		return maxScale;
	}

	/**
	 * Method to get the layer maximum scale range.
	 * 
	 * @param maxScale
	 */
	public void setMaxScale(int maxScale) {
		this.maxScale = maxScale;
	}

	/**
	 * Method to get the layer symbology.
	 * 
	 * @return List
	 */
	public List<LegendLayerSymbolMetadata> getSymbology() {
		return symbology;
	}

	/**
	 * Method to set the layer symbology.
	 * 
	 * @param symbology
	 */
	public void setSymbology(List<LegendLayerSymbolMetadata> symbology) {
		this.symbology = symbology;
	}
}
