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

import com.gisfaces.utilities.ArcGisJsonUtilities;
import com.gisfaces.utilities.json.JSONArray;
import com.gisfaces.utilities.json.JSONException;
import com.gisfaces.utilities.json.JSONObject;
import java.io.IOException;

/**
 * Legend metadata builder class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class LegendMetadataBuilder {
	/**
	 * Constructor.
	 */
	public LegendMetadataBuilder() {
		super();
	}

	/**
	 * Method to build a map service legend.
	 * 
	 * @param mapServiceUrl Map service URL.
	 * @return LegendMetadata
	 * @throws IOException
	 * @throws JSONException
	 */
	public LegendMetadata build(String mapServiceUrl) throws IOException, JSONException {
		// Sanitize URL.
		String url = ArcGisJsonUtilities.stripUrl(mapServiceUrl);

		// Create a new metadata object.
		LegendMetadata legend = new LegendMetadata();
		legend.setServiceUrl(url);

		// Get the legend JSON query results.
		String json = ArcGisJsonUtilities.executeJsonLegendQuery(url);

		// Populate the metadata using the JSON query results.
		this.populate(url, legend, json);

		return legend;
	}

	/**
	 * Method to populate a legend using JSON data.
	 * 
	 * @param mapServiceUrl Map service URL.
	 * @param legend        LegendMetadata to populate.
	 * @param json          JSON data string.
	 * @throws JSONException
	 */
	private void populate(String mapServiceUrl, LegendMetadata legend, String json) throws JSONException {
		JSONObject obj = new JSONObject(json);

		JSONArray layers = obj.getJSONArray("layers");
		if (layers != null) {
			for (int i = 0; i < layers.length(); i++) {
				JSONObject layer = layers.getJSONObject(i);

				// Build a new legend layer.
				LegendLayerMetadata legendLayer = new LegendLayerMetadata();
				if (layer.has("layerId")) {
					legendLayer.setLayerId(Integer.valueOf(layer.getString("layerId")));
				}
				if (layer.has("layerName")) {
					legendLayer.setLayerName(layer.getString("layerName"));
				}
				if (layer.has("layerType")) {
					legendLayer.setLayerType(layer.getString("layerType"));
				}
				if (layer.has("minScale")) {
					legendLayer.setMinScale(Integer.valueOf(layer.getString("minScale")));
				}
				if (layer.has("maxScale")) {
					legendLayer.setMaxScale(Integer.valueOf(layer.getString("maxScale")));
				}

				// Add the new layer to the legend.
				legend.getLayers().add(legendLayer);

				JSONArray symbology = layer.getJSONArray("legend");
				if (symbology != null) {
					for (int j = 0; j < symbology.length(); j++) {
						JSONObject symbol = symbology.getJSONObject(j);

						// Build a new legend layer symbol.
						LegendLayerSymbolMetadata lls = new LegendLayerSymbolMetadata();
						if (symbol.has("label")) {
							lls.setLabel(symbol.getString("label"));
						}
						if (symbol.has("url")) {
							lls.setUrl(String.format("%s/%s/images/%s", mapServiceUrl, legendLayer.getLayerId(), symbol.getString("url")));
						}
						if (symbol.has("imageData")) {
							lls.setImageData(symbol.getString("imageData"));
						}
						if (symbol.has("contentType")) {
							lls.setContentType(symbol.getString("contentType"));
						}
						if (symbol.has("height")) {
							lls.setHeight(Integer.valueOf(symbol.getString("height")));
						}
						if (symbol.has("width")) {
							lls.setWidth(Integer.valueOf(symbol.getString("width")));
						}

						// Add the new symbol to the legend layer.
						legendLayer.getSymbology().add(lls);
					}
				}
			}
		}
	}

	/*
	 * public static void main(String[] args) throws IOException, JSONException {
	 * LegendMetadataBuilder builder = new LegendMetadataBuilder(); LegendMetadata
	 * legend = builder.build(
	 * "http://rmgsc.cr.usgs.gov/arcgis/rest/services/igems_haz/MapServer");
	 * LegendLayerSymbolMetadata symbol = legend.findSymbol(0, "Major Flooding"); if
	 * (symbol != null) { System.out.format("label='%s', url='%s'",
	 * symbol.getLabel(), symbol.getUrl()); } else {
	 * System.err.println("symbol not found!"); } }
	 */
}
