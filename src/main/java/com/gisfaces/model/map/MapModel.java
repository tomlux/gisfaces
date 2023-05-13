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

import com.gisfaces.component.Constants;
import com.gisfaces.model.layer.Layer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Map model class.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapModel implements Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 6173025415833761651L;

	/** Map type. */
	private MapDimension mapDimension;

	/** Map theme. */
	private MapTheme mapTheme;

	/** Map basemap. */
	private Basemap basemap;

	/** Web map portal item ID. */
	private String webMapPortalItemId;

	/** Map viewpoint. */
	private Viewpoint viewpoint;

	/** Map configuration. */
	private Configuration configuration;

	/** Map layers. */
	private List<Layer> layers;

	/**
	 * Constructor.
	 */
	public MapModel() {
		super();
		this.mapDimension = Constants.DEFAULT_DIMENSION;
		this.basemap = Constants.DEFAULT_BASEMAP;
		this.mapTheme = Constants.DEFAULT_THEME;
		this.viewpoint = new Viewpoint();
		this.configuration = new Configuration();
		this.layers = new ArrayList<Layer>();
	}

	/**
	 * Method to get the map dimension.
	 * 
	 * @return
	 */
	public MapDimension getMapDimension() {
		return mapDimension;
	}

	/**
	 * Method to set the map dimension.
	 * 
	 * @param mapDimension
	 */
	public void setMapDimension(MapDimension mapDimension) {
		this.mapDimension = mapDimension;
	}

	/**
	 * Method to get the map theme.
	 * 
	 * @return
	 */
	public MapTheme getMapTheme() {
		return mapTheme;
	}

	/**
	 * Method to set the map theme.
	 * 
	 * @param mapTheme
	 */
	public void setMapTheme(MapTheme mapTheme) {
		this.mapTheme = mapTheme;
	}

	/**
	 * Method to get the map basemap.
	 * 
	 * @return
	 */
	public Basemap getBasemap() {
		return basemap;
	}

	/**
	 * Method to set the map basemap.
	 * 
	 * @param basemap
	 */
	public void setBasemap(Basemap basemap) {
		this.basemap = basemap;
	}

	/**
	 * Method to get the web map portal item ID.
	 * 
	 * @return
	 */
	public String getWebMapPortalItemId() {
		return webMapPortalItemId;
	}

	/**
	 * Method to set the web map portal item ID.
	 * 
	 * @param webMapPortalItemId
	 */
	public void setWebMapPortalItemId(String webMapPortalItemId) {
		this.webMapPortalItemId = webMapPortalItemId;
	}

	/**
	 * Method to get the map viewpoint.
	 * 
	 * @return
	 */
	public Viewpoint getViewpoint() {
		return viewpoint;
	}

	/**
	 * Method to set the map viewpoint.
	 * 
	 * @param viewpoint
	 */
	public void setViewpoint(Viewpoint viewpoint) {
		this.viewpoint = viewpoint;
	}

	/**
	 * Method to get the map configuration.
	 * 
	 * @return
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * Method to set the map configuration.
	 * 
	 * @param configuration
	 */
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * Method to get the map layers.
	 * 
	 * @return
	 */
	public List<Layer> getLayers() {
		return layers;
	}

	/**
	 * Method to set the map layers.
	 * 
	 * @param layers
	 */
	public void setLayers(List<Layer> layers) {
		this.layers = layers;
	}
}
