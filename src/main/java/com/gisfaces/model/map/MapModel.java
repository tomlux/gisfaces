package com.gisfaces.model.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gisfaces.component.Constants;
import com.gisfaces.model.layer.Layer;

/**
 * Map model class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapModel implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 6173025415833761651L;

	/** Map type. */
	private MapType mapType;

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
	public MapModel()
	{
		super();
		this.mapType = Constants.DEFAULT_TYPE;
		this.basemap = Constants.DEFAULT_BASEMAP;
		this.mapTheme = Constants.DEFAULT_THEME;
		this.viewpoint = new Viewpoint();
		this.configuration = new Configuration();
		this.layers = new ArrayList<Layer>();
	}

	/**
	 * Method to get the map type.
	 * @return
	 */
	public MapType getMapType()
	{
		return mapType;
	}

	/**
	 * Method to set the map type.
	 * @param mapType
	 */
	public void setMapType(MapType mapType)
	{
		this.mapType = mapType;
	}

	/**
	 * Method to get the map theme.
	 * @return
	 */
	public MapTheme getMapTheme()
	{
		return mapTheme;
	}

	/**
	 * Method to set the map theme.
	 * @param mapTheme
	 */
	public void setMapTheme(MapTheme mapTheme)
	{
		this.mapTheme = mapTheme;
	}

	/**
	 * Method to get the map basemap.
	 * @return
	 */
	public Basemap getBasemap()
	{
		return basemap;
	}

	/**
	 * Method to set the map basemap.
	 * @param basemap
	 */
	public void setBasemap(Basemap basemap)
	{
		this.basemap = basemap;
	}

	/**
	 * Method to get the web map portal item ID.
	 * @return
	 */
	public String getWebMapPortalItemId()
	{
		return webMapPortalItemId;
	}

	/**
	 * Method to set the web map portal item ID.
	 * @param webMapPortalItemId
	 */
	public void setWebMapPortalItemId(String webMapPortalItemId)
	{
		this.webMapPortalItemId = webMapPortalItemId;
	}

	/**
	 * Method to get the map viewpoint.
	 * @return
	 */
	public Viewpoint getViewpoint()
	{
		return viewpoint;
	}

	/**
	 * Method to set the map viewpoint.
	 * @param viewpoint
	 */
	public void setViewpoint(Viewpoint viewpoint)
	{
		this.viewpoint = viewpoint;
	}

	/**
	 * Method to get the map configuration.
	 * @return
	 */
	public Configuration getConfiguration()
	{
		return configuration;
	}

	/**
	 * Method to set the map configuration.
	 * @param configuration
	 */
	public void setConfiguration(Configuration configuration)
	{
		this.configuration = configuration;
	}

	/**
	 * Method to get the map layers.
	 * @return
	 */
	public List<Layer> getLayers()
	{
		return layers;
	}

	/**
	 * Method to set the map layers.
	 * @param layers
	 */
	public void setLayers(List<Layer> layers)
	{
		this.layers = layers;
	}
}
