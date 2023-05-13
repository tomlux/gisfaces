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

package com.gisfaces.model.legend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Legend metadata class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class LegendMetadata implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = -2908703969567397577L;

	/** Map service URL. */
	private String serviceUrl;

	/** Map layers. */
	private List<LegendLayerMetadata> layers = new ArrayList<LegendLayerMetadata>();

	/**
	 * Constructor.
	 */
	public LegendMetadata() {
		super();
	}

	/**
	 * Method to find a legend layer.
	 * 
	 * @param layerId Layer ID.
	 * @return LegendLayerMetadata
	 */
	public LegendLayerMetadata findLayer(int layerId) {
		LegendLayerMetadata layer = null;

		if (this.layers != null) {
			for (LegendLayerMetadata l : this.layers) {
				if (l.getLayerId() == layerId) {
					layer = l;
					break;
				}
			}
		}

		return layer;
	}

	/**
	 * Method to find a legend layer symbol.
	 * 
	 * @param layerId     Layer ID.
	 * @param symbolLabel Symbol label.
	 * @return LegendLayerSymbolMetadata
	 */
	public LegendLayerSymbolMetadata findSymbol(int layerId, String symbolLabel) {
		LegendLayerSymbolMetadata symbol = null;

		LegendLayerMetadata layer = this.findLayer(layerId);

		if (layer != null) {
			if (layer.getSymbology() != null) {
				for (LegendLayerSymbolMetadata s : layer.getSymbology()) {
					if (symbolLabel.equals(s.getLabel())) {
						symbol = s;
						break;
					}
				}
			}
		}

		return symbol;
	}

	/**
	 * Method to get the map service URL.
	 * 
	 * @return String
	 */
	public String getServiceUrl() {
		return serviceUrl;
	}

	/**
	 * Method to set the map service URL.
	 * 
	 * @param serviceUrl
	 */
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	/**
	 * Method to get the map layers.
	 * 
	 * @return List
	 */
	public List<LegendLayerMetadata> getLayers() {
		return layers;
	}

	/**
	 * Method to set the map layers.
	 * 
	 * @param layers
	 */
	public void setLayers(List<LegendLayerMetadata> layers) {
		this.layers = layers;
	}
}
