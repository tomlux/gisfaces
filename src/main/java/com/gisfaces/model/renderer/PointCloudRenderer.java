package com.gisfaces.model.renderer;

/**
 * Point cloud renderer abstract base class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-renderers-PointCloudRenderer.html">ESRI PointCloudRenderer</a>
 */
public abstract class PointCloudRenderer implements Renderer
{
	/** Color modulation. */
	private ColorModulation colorModulation;

	/** Point size algorithm. */
	private PointSizeAlgorithm pointSizeAlgorithm;

	/** Points per inch. */
	private Integer pointsPerInch;

	/**
	 * Method to get the color modulation.
	 * @return
	 */
	public ColorModulation getColorModulation()
	{
		return colorModulation;
	}

	/**
	 * Method to set the color modulation.
	 * @param colorModulation
	 */
	public void setColorModulation(ColorModulation colorModulation)
	{
		this.colorModulation = colorModulation;
	}

	/**
	 * Method to get the point size algorithm.
	 * @return
	 */
	public PointSizeAlgorithm getPointSizeAlgorithm()
	{
		return pointSizeAlgorithm;
	}

	/**
	 * Method to set the point size algorithm.
	 * @param pointSizeAlgorithm
	 */
	public void setPointSizeAlgorithm(PointSizeAlgorithm pointSizeAlgorithm)
	{
		this.pointSizeAlgorithm = pointSizeAlgorithm;
	}

	/**
	 * Method to get the points per inch.
	 * @return
	 */
	public Integer getPointsPerInch()
	{
		return pointsPerInch;
	}

	/**
	 * Method to set the points per inch.
	 * @param pointsPerInch
	 */
	public void setPointsPerInch(Integer pointsPerInch)
	{
		this.pointsPerInch = pointsPerInch;
	}
}
