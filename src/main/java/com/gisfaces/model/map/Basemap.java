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
	STREETS("streets", "Streets", 24, "This worldwide street map presents highway-level data for the world.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/streets.jpg", false),
	SATELLITE("satellite", "Imagery", 24,
			"World Imagery provides one meter or better satellite and aerial imagery in many parts of the world and lower resolution satellite imagery worldwide.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/satellite.jpg", false),
	HYBRID("hybrid", "Imagery with Labels", 24,
			" This map presents country boundaries, first order (State/Province) internal administrative boundaries for most countries, second order administrative boundaries for the United States (counties) and some countries in Europe, and place names for the world.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/hybrid.jpg", false),
	TOPOGRAPHIC("topo", "Topographic", 24, "This map is designed to be used as a basemap by GIS professionals and as a reference map by anyone.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/topo.jpg", false),
	LIGHTGRAY("gray", "Light Gray Canvas", 24,
			"This map draws attention to your thematic content by providing a neutral background with minimal colors, labels, and features.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/gray.jpg", false),
	DARKGRAY("dark-gray", "Dark Gray Canvas", 24,
			"This map draws attention to your thematic content by providing a neutral background with minimal colors, labels, and features.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/dark-gray.jpg", false),
	OSM("osm", "OpenStreetMap", 20, "The OpenStreetMap is a community map layer that is designed to be used as a basemap for various maps and applications.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/osm.jpg", false),
	OCEANS("oceans", "Oceans", 17, " This map service is designed to be used as the reference layer for the ocean base map.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/oceans.jpg", false),
	NATGEO("national-geographic", "National Geographic", 17,
			"This map is designed to be used as a general reference map for informational and educational purposes as well as a base map by GIS professionals and other users for creating web maps and web mapping applications.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/national-geographic.jpg", false),
	TERRAIN("terrain", "Terrain with Labels", 14,
			"This map is designed to be used as a base map by GIS professionals to overlay other thematic layers such as demographics or land cover.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/terrain.jpg", false),
	STREETS_VECTOR("streets-vector", "Streets (Vector)", 23,
			"This vector tile layer provides a detailed basemap for the world featuring a classic Esri street map style.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/streets.jpg", true),
	STREETS_NIGHT_VECTOR("streets-night-vector", "Streets Night (Vector)", 23,
			"This vector tile layer provides a detailed basemap for the world featuring a custom 'night time' street map style.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/streets-night.jpg", true),
	STREETS_NAVIGATION_VECTOR("streets-navigation-vector", "Streets Navigation (Vector)", 23,
			"This vector tile layer provides a detailed basemap for the world featuring a custom navigation map style.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/streets-navigation.jpg", true),
	STREETS_RELIEF_VECTOR("streets-relief-vector", "Streets Relief (Vector)", 23,
			"This vector tile layer provides a detailed basemap for the world featuring a classic Esri street map style designed for use with a relief map.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/streets-relief.jpg", true),
	TOPOGRAPHIC_VECTOR("topo-vector", "Topographic (Vector)", 23,
			"This vector tile layer provides a detailed basemap for the world featuring a classic Esri topographic map style designed for use with a relief map.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/topo.jpg", true),
	LIGHTGRAY_VECTOR("gray-vector", "Light Gray Canvas (Vector)", 23,
			"This vector tile layer provides a detailed basemap for the world featuring a light neutral background style with minimal colors, labels, and features.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/gray.jpg", true),
	DARKGRAY_VECTOR("dark-gray-vector", "Dark Gray Canvas (Vector)", 23,
			"This vector tile layer provides a detailed basemap for the world featuring a dark neutral background style with minimal colors, labels, and features.",
			"https://developers.arcgis.com/javascript/assets/img/apiref/basemap/dark-gray.jpg", true);

	/** Value. */
	private String value;

	/** Title. */
	private String title;

	/** Levels of detail. */
	private int lods;

	/** Description. */
	private String description;

	/** Thumbnail url. */
	private String thumbnail;

	/** Vector indicator. */
	private boolean vector;

	/**
	 * Constructor. Package scope required for enum constructors.
	 * 
	 * @param value       Value.
	 * @param title       Title.
	 * @param lods        Levels of detail.
	 * @param description Description.
	 * @param thumbnail   Thumbnail URL.
	 * @param vector      Vector indicator.
	 */
	Basemap(String value, String title, int lods, String description, String thumbnail, boolean vector) {
		this.value = value;
		this.title = title;
		this.lods = lods;
		this.description = description;
		this.thumbnail = thumbnail;
		this.vector = vector;
	}

	/**
	 * Method to get the basemap value.
	 * 
	 * @return Basemap value.
	 */
	public String getValue() {
		return value;
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
	 * Method to get the number of basemap LODs.
	 * 
	 * @return Number of basemap LODs.
	 */
	public int getLods() {
		return lods;
	}

	/**
	 * Method to get the basemap description.
	 * 
	 * @return Basemap description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Method to get the basemap thumb-nail image.
	 * 
	 * @return Basemap thumb-nail image.
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * Method to get the basemap vector indicator.
	 * 
	 * @return
	 */
	public boolean isVector() {
		return vector;
	}

	/**
	 * Method to get the enum by the specified title.
	 * 
	 * @param title Title
	 * @return Basemap if found, <code>null</code> otherwise.
	 */
	public static final Basemap getBasemapByTitle(String title) {
		for (Basemap b : Basemap.values()) {
			if (b.getTitle().equalsIgnoreCase(title)) {
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
			String description = String.format("%s Contains %d levels of detail.", b.getDescription(), b.getLods());
			items.add(new SelectItem(b.getValue(), b.getTitle(), description));
		}

		return items;
	}
}
