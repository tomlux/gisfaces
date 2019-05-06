package com.gisfaces.model.renderer;

import java.io.Serializable;

/**
 * Fixed size point size algorithm for point cloud renderer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRGBRenderer.html#pointSizeAlgorithm">ESRI PointSizeAlgorithm</a>
 */
public class FixedSizePointSizeAlgorithm implements PointSizeAlgorithm, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -3367460624359738233L;

	/** Specifies whether size is in real world units or screen-space units. */
	private Boolean useRealWorldSymbolSizes;

	/** Point size in meters (useRealWorldSymbolSizes = true) or points. */
	private Integer size;

	/**
	 * Constructor.
	 */
	public FixedSizePointSizeAlgorithm()
	{
		this(true, 10);
	}

	/**
	 * Constructor.
	 * @param useRealWorldSymbolSizes Indicator for real world units or screen-space units.
	 * @param size Point size in meters.
	 */
	public FixedSizePointSizeAlgorithm(Boolean useRealWorldSymbolSizes, Integer size)
	{
		super();

		this.useRealWorldSymbolSizes = useRealWorldSymbolSizes;
		this.size = size;
	}

	/* (non-Javadoc)
	 * @see com.gisfaces.model.renderer.PointSizeAlgorithm#getType()
	 */
	@Override
	public String getType()
	{
		return "fixed-size";
	}

	/**
	 * Method to get the real world size indicator.
	 * @return
	 */
	public Boolean getUseRealWorldSymbolSizes()
	{
		return useRealWorldSymbolSizes;
	}

	/**
	 * Method to set the real world size indicator.
	 * @param useRealWorldSymbolSizes
	 */
	public void setUseRealWorldSymbolSizes(Boolean useRealWorldSymbolSizes)
	{
		this.useRealWorldSymbolSizes = useRealWorldSymbolSizes;
	}

	/**
	 * Method to get the point size in meters.
	 * @return
	 */
	public Integer getSize()
	{
		return size;
	}

	/**
	 * Method to set the point size in meters.
	 * @param size
	 */
	public void setSize(Integer size)
	{
		this.size = size;
	}
}
