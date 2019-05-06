package com.gisfaces.model.renderer;

import java.io.Serializable;

/**
 * Splat point size algorithm for point cloud renderer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRGBRenderer.html#pointSizeAlgorithm">ESRI PointSizeAlgorithm</a>
 */
public class SplatPointSizeAlgorithm implements PointSizeAlgorithm, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -4115310347190051384L;

	/** Specifies the scale factor that is applied to the size estimated by the density. */
	private Integer scaleFactor;

	/**
	 * Constructor.
	 */
	public SplatPointSizeAlgorithm()
	{
		this(1);
	}

	/**
	 * Constructor.
	 * @param scaleFactor Scale factor.
	 */
	public SplatPointSizeAlgorithm(Integer scaleFactor)
	{
		super();

		this.scaleFactor = scaleFactor;
	}

	/* (non-Javadoc)
	 * @see com.gisfaces.model.renderer.PointSizeAlgorithm#getType()
	 */
	@Override
	public String getType()
	{
		return "splat";
	}

	/**
	 * Method to get the scale factor.
	 * @return
	 */
	public Integer getScaleFactor()
	{
		return scaleFactor;
	}

	/**
	 * Method to set the scale factor.
	 * @param scaleFactor
	 */
	public void setScaleFactor(Integer scaleFactor)
	{
		this.scaleFactor = scaleFactor;
	}
}
