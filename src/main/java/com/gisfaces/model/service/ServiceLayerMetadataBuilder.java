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

package com.gisfaces.model.service;

import com.gisfaces.utilities.ArcGisJsonUtilities;
import com.gisfaces.utilities.json.JSONArray;
import com.gisfaces.utilities.json.JSONException;
import com.gisfaces.utilities.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Service layer metadata builder class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceLayerMetadataBuilder {
	/**
	 * Constructor.
	 */
	public ServiceLayerMetadataBuilder() {
		super();
	}

	/**
	 * Method to build the service layer metadata.
	 * 
	 * @param serviceUrl ESRI ArcGIS map service layer URL. e.g.
	 *                   "http://server.arcgisonline.com/arcgis/rest/services/Demographics/USA_Tapestry/MapServer/0"
	 * @param id         May service layer ID. e.g. "0"
	 * @return ServiceLayerMetadata
	 * @throws IOException
	 * @throws JSONException
	 */
	public ServiceLayerMetadata build(String serviceUrl, String id) throws IOException, JSONException {
		// Sanitize URL.
		String url = ArcGisJsonUtilities.stripUrl(serviceUrl);

		// Create a new metadata object.
		ServiceLayerMetadata metadata = new ServiceLayerMetadata();
		metadata.setUrl(url);
		metadata.setId(id);

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
	private void populate(ServiceLayerMetadata metadata, String json) throws IOException, JSONException {
		JSONObject obj = new JSONObject(json);

		if (obj != null) {
			if (obj.has("name")) {
				metadata.setName(obj.getString("name"));
			}

			if (obj.has("type")) {
				metadata.setType(obj.getString("type"));
			}

			if (obj.has("geometryType")) {
				metadata.setGeometryType(obj.getString("geometryType"));
			}

			if ((obj.has("fields")) && (!obj.getString("fields").equals("null"))) {
				JSONArray fields = obj.getJSONArray("fields");

				if (fields.length() > 0) {
					// Create the list of service layer fields.
					metadata.setFields(new ArrayList<ServiceLayerFieldMetadata>());

					for (int i = 0; i < fields.length(); i++) {
						JSONObject f = fields.getJSONObject(i);

						ServiceLayerFieldMetadata field = new ServiceLayerFieldMetadata();
						if (f.has("name")) {
							field.setName(f.getString("name"));
						}
						if (f.has("type")) {
							field.setType(f.getString("type"));
						}
						if (f.has("alias")) {
							field.setAlias(f.getString("alias"));
						}
						if (f.has("length")) {
							field.setLength(f.getInt("length"));
						}
						if ((f.has("domain")) && (!f.getString("domain").equals("null"))) {
							JSONObject d = f.getJSONObject("domain");

							if (d.has("codedValues")) {
								// Create the map for service layer field domains.
								field.setValues(new LinkedHashMap<String, String>());

								JSONArray values = d.getJSONArray("codedValues");

								for (int j = 0; j < values.length(); j++) {
									JSONObject value = values.getJSONObject(j);

									field.getValues().put(value.getString("code"), value.getString("name"));
								}
							}
						}

						metadata.getFields().add(field);
					}
				}
			}
		}
	}
}
