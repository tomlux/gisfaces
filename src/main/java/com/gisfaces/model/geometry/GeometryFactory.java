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

package com.gisfaces.model.geometry;

import com.gisfaces.utilities.json.JSONArray;
import com.gisfaces.utilities.json.JSONException;
import com.gisfaces.utilities.json.JSONObject;

/**
 * Geometry factory class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class GeometryFactory {
	/**
	 * Constructor.
	 */
	public GeometryFactory() {
		super();
	}

	/**
	 * Factory method to create a geometry object.
	 * 
	 * @param jo JSONObject
	 * @return Geometry
	 * @throws JSONException
	 */
	public Geometry create(JSONObject jo) throws JSONException {
		Geometry geometry = null;

		if (jo != null) {
			String type = jo.getString("type");

			if (GeometryType.POINT.toString().equals(type)) {
				geometry = this.createPoint(jo);
			} else if (GeometryType.POLYLINE.toString().equals(type)) {
				geometry = this.createPolyline(jo);
			} else if (GeometryType.POLYGON.toString().equals(type)) {
				geometry = this.createPolygon(jo);
			} else {
				throw new JSONException(String.format("Unsupported geometry type '%s'.", type));
			}
		}

		return geometry;
	}

	/**
	 * Factory method to create a point geometry object.
	 * 
	 * @param jo JSONObject
	 * @return Point
	 * @throws JSONException
	 */
	private Point createPoint(JSONObject jo) throws JSONException {
		Point p = new Point();
		p.setLongitude(jo.getDouble("x"));
		p.setLatitude(jo.getDouble("y"));

		return p;
	}

	/**
	 * Factory method to create a polyline geometry object.
	 * 
	 * @param jo JSONObject
	 * @return Polyline
	 * @throws JSONException
	 */
	private Polyline createPolyline(JSONObject jo) throws JSONException {
		JSONArray paths = jo.getJSONArray("paths");

		Polyline p = new Polyline();
		p.setPaths(this.convertArray(paths));

		return p;
	}

	/**
	 * Factory method to create a polygon geometry object.
	 * 
	 * @param jo JSONObject
	 * @return Polygon
	 * @throws JSONException
	 */
	private Polygon createPolygon(JSONObject jo) throws JSONException {
		JSONArray rings = jo.getJSONArray("rings");

		Polygon p = new Polygon();
		p.setRings(this.convertArray(rings));

		return p;
	}

	/**
	 * Method to convert a JSONArray to a primitive multi-dimensional array.
	 * 
	 * @param source JSONArray
	 * @return Double[][][]
	 * @throws JSONException
	 */
	private Double[][][] convertArray(JSONArray source) throws JSONException {
		Double[][][] target = null;

		for (int i = 0; i < source.length(); i++) {
			JSONArray outer = source.getJSONArray(i);
			for (int j = 0; j < outer.length(); j++) {
				JSONArray inner = outer.getJSONArray(j);
				for (int k = 0; k < inner.length(); k++) {
					Double d = inner.getDouble(k);

					if (target == null) {
						// Initialize the multi-dimensional array with known dimensions.
						target = new Double[source.length()][outer.length()][inner.length()];
					}

					target[i][j][k] = d;
				}
			}
		}

		return target;
	}
}
