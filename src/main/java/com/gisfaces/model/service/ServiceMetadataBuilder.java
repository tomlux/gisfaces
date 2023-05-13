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

package com.gisfaces.model.service;

import com.gisfaces.utilities.ArcGisJsonUtilities;
import com.gisfaces.utilities.json.JSONArray;
import com.gisfaces.utilities.json.JSONException;
import com.gisfaces.utilities.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Service metadata builder class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceMetadataBuilder {
	/**
	 * Constructor.
	 */
	public ServiceMetadataBuilder() {
		super();
	}

	/**
	 * Method to build the service metadata.
	 * 
	 * @param serviceUrl ESRI ArcGIS map service URL. e.g
	 *                   "http://server.arcgisonline.com/arcgis/rest/services/Demographics/USA_Tapestry/MapServer"
	 * @param name       Map service name. e.g "USA_Tapestry"
	 * @param type       Map service type. e.g "MapServer"
	 * @return ServiceMetadata
	 * @throws IOException
	 * @throws JSONException
	 */
	public ServiceMetadata build(String serviceUrl, String name, String type) throws IOException, JSONException {
		// Sanitize URL.
		String url = ArcGisJsonUtilities.stripUrl(serviceUrl);

		// Create a new metadata object.
		ServiceMetadata metadata = new ServiceMetadata();
		metadata.setUrl(url);
		metadata.setName(name);
		metadata.setType(type);

		// Get the JSON query results.
		String json = ArcGisJsonUtilities.executeJsonQuery(url);

		// Populate the metadata using the JSON query results.
		this.populate(metadata, json);

		return metadata;
	}

	/**
	 * Method to populate the metadata object from the JSON query results.
	 * 
	 * @param metadata Target metadata object.
	 * @param json     JSON query results.
	 * @throws IOException
	 * @throws JSONException
	 */
	private void populate(ServiceMetadata metadata, String json) throws IOException, JSONException {
		JSONObject obj = new JSONObject(json);

		if (obj != null) {
			if (obj.has("currentVersion")) {
				metadata.setVersion(obj.getString("currentVersion"));
			}

			if (obj.has("serviceDescription")) {
				metadata.setDescription(obj.getString("serviceDescription"));
			}

			if (obj.has("layers")) {
				ServiceLayerMetadataBuilder builder = new ServiceLayerMetadataBuilder();

				JSONArray layers = obj.getJSONArray("layers");

				if (layers.length() > 0) {
					// Create the list of service layers.
					metadata.setLayers(new ArrayList<ServiceLayerMetadata>());

					for (int i = 0; i < layers.length(); i++) {
						// Get the service name and type.
						JSONObject layer = layers.getJSONObject(i);
						String id = layer.getString("id");

						// Build a URL to the specified map service.
						String url = String.format("%s/%s", metadata.getUrl(), id);

						// Add new service layer.
						metadata.getLayers().add(builder.build(url, id));
					}
				}
			}
		}
	}
}
