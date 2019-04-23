package com.gisfaces.model.symbol;

import java.io.Serializable;

import com.gisfaces.model.color.Color;

/**
 * Color material class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Symbol3DLayer.html#material">ESRI Symbol 3D Material</a>
 */
public class ColorMaterial implements Material, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -2371433458773144773L;

	/** Symbol material color. */
	private Color color;

	/**
	 * Constructor.
	 */
	public ColorMaterial()
	{
		this(new Color(255, 255, 255, 0.5));
	}

	/**
	 * Constructor.
	 * @param color Color.
	 */
	public ColorMaterial(Color color)
	{
		super();
		this.color = color;
	}

	/**
	 * Method to get the symbol material color.
	 * @return
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * Method to set the symbol material color.
	 * @param color
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}
}
