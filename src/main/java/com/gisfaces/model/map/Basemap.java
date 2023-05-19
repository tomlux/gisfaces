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

package com.gisfaces.model.map;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 * Basemap enum class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href=
 *      "https://developers.arcgis.com/javascript/latest/api-reference/esri-Map.html#basemap">ESRI
 *      Basemaps</a>
 */
public enum Basemap {
	SATELLITE("satellite", "Imagery"),
	HYBRID("hybrid", "Imagery Hybrid"),
	STREETS_VECTOR("streets-vector", "Streets"),
	TOPO_VECTOR("topo-vector", "Topographic"),
	STREETS_NAVIGATION_VECTOR("streets-navigation-vector", "Navigation"),
	STREETS_NIGHT_VECTOR("streets-night-vector", "Streets (Night)"),
	STREETS_RELIEF_VECTOR("streets-relief-vector", "Terrain with Labels"),
	GRAY_VECTOR("gray-vector", "Light Gray Canvas"),
	DARK_GRAY_VECTOR("dark-gray-vector", "Dark Gray Canvas"),
	OCEANS("oceans", "Oceans"),
	NATIONAL_GEOGRAPHIC("national-geographic", "National Geographic Style Map"),
	OSM("osm", "OpenStreetMap");

	/** ID. */
	private String id;

	/** Title. */
	private String title;

	/**
	 * Constructor. Package scope required for enum constructors.
	 * 
	 * @param id          ID.
	 * @param title       Title.
	 */
	Basemap(String id, String title) {
		this.id = id;
		this.title = title;
	}

	/**
	 * Method to get the basemap id.
	 * 
	 * @return Basemap id.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method to get the basemap title.
	 * 
	 * @return Basemap title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method to get the enum.
	 * 
	 * @param value Value
	 * @return Basemap if found, <code>null</code> otherwise.
	 */
	public static final Basemap getBasemap(String value) {
		for (Basemap b : Basemap.values()) {
			if (b.getId().equalsIgnoreCase(value) || b.getTitle().equalsIgnoreCase(value)) {
				return b;
			}
		}

		return null;
	}

	/**
	 * Method to get the basemap select items.
	 * 
	 * @return List of SelectItem objects.
	 */
	public static final List<SelectItem> getSelectItems() {
		List<SelectItem> items = new ArrayList<SelectItem>();

		for (Basemap b : Basemap.values()) {
			items.add(new SelectItem(b.getId(), b.getTitle()));
		}

		return items;
	}
}
