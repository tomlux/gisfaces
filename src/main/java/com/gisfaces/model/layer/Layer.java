package com.gisfaces.model.layer;

/**
 * Base map layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-Layer.html">ESRI Layer</a>
 */
public abstract class Layer
{
	/** Layer ID. */
	private String id;

	/** Layer opacity. */
	private Double opacity;

	/** Layer title to be used in the legend. */
	private String title;

	/** Layer visibility. */
	private Boolean visible = true;

	/**
	 * Method to get the layer ID.
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Method to set the layer ID.
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Method to get the layer opacity.
	 * @return
	 */
	public Double getOpacity()
	{
		return opacity;
	}

	/**
	 * Method to set the layer opacity.
	 * @param opacity
	 */
	public void setOpacity(Double opacity)
	{
		this.opacity = opacity;
	}

	/**
	 * Method to get the layer title.
	 * @return
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Method to set the layer title.
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * Method to get the layer visibility.
	 * @return
	 */
	public Boolean getVisible()
	{
		return visible;
	}

	/**
	 * Method to set the layer visibility.
	 * @param visible
	 */
	public void setVisible(Boolean visible)
	{
		this.visible = visible;
	}
}
