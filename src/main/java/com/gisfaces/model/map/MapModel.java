package com.gisfaces.model.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gisfaces.model.layer.Layer;

/**
 * Map model class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapModel implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 6173025415833761651L;

	/** Map configuration. */
	private Configuration configuration = new Configuration();

	/** Map layers. */
	private List<Layer> layers = new ArrayList<Layer>();

	/**
	 * Constructor.
	 */
	public MapModel()
	{
		super();
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
