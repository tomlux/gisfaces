package com.gisfaces.model.symbol;

import java.io.Serializable;

/**
 * Font class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-Font.html">ESRI Symbol Font</a>
 */
public class Font implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 6253107222387937071L;

	/** Font decoration (underline | line-through | none). */
	private String decoration;

	/** Font family. */
	private String family;

	/** Font size. */
	private String size;

	/** Font style (normal | italic | oblique). */
	private String style;

	/** Font weight (normal | bold | bolder | lighter). */
	private String weight;

	/**
	 * Constructor.
	 */
	public Font()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param family Font family.
	 * @param size String size
	 */
	public Font(String family, String size)
	{
		super();
		this.family = family;
		this.size = size;
	}

	/**
	 * Constructor.
	 * @param decoration Font decoration (underline | line-through | none).
	 * @param family Font family.
	 * @param size String size
	 * @param style Font style (normal | italic | oblique).
	 * @param weight Font weight (normal | bold | bolder | lighter).
	 */
	public Font(String decoration, String family, String size, String style, String weight)
	{
		super();
		this.decoration = decoration;
		this.family = family;
		this.size = size;
		this.style = style;
		this.weight = weight;
	}

	/**
	 * Method to get the font decoration.
	 * @return
	 */
	public String getDecoration()
	{
		return decoration;
	}

	/**
	 * Method to set the font decoration.
	 * @param decoration
	 */
	public void setDecoration(String decoration)
	{
		this.decoration = decoration;
	}

	/**
	 * Method to get the font family.
	 * @return
	 */
	public String getFamily()
	{
		return family;
	}

	/**
	 * Method to set the font family.
	 * @param family
	 */
	public void setFamily(String family)
	{
		this.family = family;
	}

	/**
	 * Method to get the font size.
	 * @return
	 */
	public String getSize()
	{
		return size;
	}

	/**
	 * Method to set the font size.
	 * @param size
	 */
	public void setSize(String size)
	{
		this.size = size;
	}

	/**
	 * Method to get the font style.
	 * @return
	 */
	public String getStyle()
	{
		return style;
	}

	/**
	 * Method to set the font style.
	 * @param style
	 */
	public void setStyle(String style)
	{
		this.style = style;
	}

	/**
	 * Method to get the font weight.
	 * @return
	 */
	public String getWeight()
	{
		return weight;
	}

	/**
	 * Method to set the font weight.
	 * @param weight
	 */
	public void setWeight(String weight)
	{
		this.weight = weight;
	}
}
