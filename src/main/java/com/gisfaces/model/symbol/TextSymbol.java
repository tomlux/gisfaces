package com.gisfaces.model.symbol;

import java.io.Serializable;

import com.gisfaces.model.color.Color;

/**
 * Text symbol class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-symbols-TextSymbol.html">ESRI TextSymbol</a>
 */
public class TextSymbol implements Symbol, Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -1548600450462462330L;

	/** Symbol angle. */
	private Integer angle;

	/** Symbol background color. */
	private Color backgroundColor;

	/** Symbol border line color. */
	private Color borderLineColor;

	/** Symbol border line size. */
	private Integer borderLineSize;

	/** Symbol color. */
	private Color color;

	/** Symbol font. */
	private Font font;

	/** Symbol halo color. */
	private Color haloColor;

	/** Symbol halo size. */
	private String haloSize;

	/** Symbol horizontal alignment. */
	private String horizontalAlignment;

	/** Symbol text kerning. */
	private Boolean kerning;

	/** Symbol text rotated. */
	private Boolean rotated;

	/** Symbol text. */
	private String text;

	/** Symbol vertical alignment. */
	private String verticalAlignment;

	/** Symbol X offset. */
	private String xoffset;

	/** Symbol Y offset. */
	private String yoffset;

	/**
	 * Constructor.
	 */
	public TextSymbol()
	{
		super();
	}

	/* (non-Javadoc)
	 * @see com.gisfaces.symbol.Symbol#getType()
	 */
	@Override
	public String getType()
	{
		return SymbolType.TEXT.toString();
	}

	/**
	 * Method to get the symbol angle.
	 * @return
	 */
	public Integer getAngle()
	{
		return angle;
	}

	/**
	 * Method to set the symbol angle.
	 * @param angle
	 */
	public void setAngle(Integer angle)
	{
		this.angle = angle;
	}

	/**
	 * Method to get the symbol color.
	 * @return
	 */
	public Color getColor()
	{
		return color;
	}

	/**
	 * Method to set the symbol color.
	 * @param color
	 */
	public void setColor(Color color)
	{
		this.color = color;
	}

	/**
	 * Method to get the symbol background color.
	 * @return
	 */
	public Color getBackgroundColor()
	{
		return backgroundColor;
	}

	/**
	 * Method to set the symbol background color.
	 * @param backgroundColor
	 */
	public void setBackgroundColor(Color backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	/**
	 * Method to get the symbol border line color.
	 * @return
	 */
	public Color getBorderLineColor()
	{
		return borderLineColor;
	}

	/**
	 * Method to set the symbol border line color.
	 * @param borderLineColor
	 */
	public void setBorderLineColor(Color borderLineColor)
	{
		this.borderLineColor = borderLineColor;
	}

	/**
	 * Method to get the symbol border line size.
	 * @return
	 */
	public Integer getBorderLineSize()
	{
		return borderLineSize;
	}

	/**
	 * Method to set the symbol border line size.
	 * @param borderLineSize
	 */
	public void setBorderLineSize(Integer borderLineSize)
	{
		this.borderLineSize = borderLineSize;
	}

	/**
	 * Method to get the symbol font.
	 * @return
	 */
	public Font getFont()
	{
		return font;
	}

	/**
	 * Method to set the symbol font.
	 * @param font
	 */
	public void setFont(Font font)
	{
		this.font = font;
	}

	/**
	 * Method to get the symbol halo color.
	 * @return
	 */
	public Color getHaloColor()
	{
		return haloColor;
	}

	/**
	 * Method to set the symbol halo color.
	 * @param haloColor
	 */
	public void setHaloColor(Color haloColor)
	{
		this.haloColor = haloColor;
	}

	/**
	 * Method to get the symbol halo size.
	 * @return
	 */
	public String getHaloSize()
	{
		return haloSize;
	}

	/**
	 * Method to set the symbol halo size.
	 * @param haloSize
	 */
	public void setHaloSize(String haloSize)
	{
		this.haloSize = haloSize;
	}

	/**
	 * Method to get the symbol horizontal alignment.
	 * @return
	 */
	public String getHorizontalAlignment()
	{
		return horizontalAlignment;
	}

	/**
	 * Method to set the symbol horizontal alignment.
	 * @param horizontalAlignment
	 */
	public void setHorizontalAlignment(String horizontalAlignment)
	{
		this.horizontalAlignment = horizontalAlignment;
	}

	/**
	 * Method to get the symbol text kerning.
	 * @return
	 */
	public Boolean getKerning()
	{
		return kerning;
	}

	/**
	 * Method to set the symbol text kerning.
	 * @param kerning
	 */
	public void setKerning(Boolean kerning)
	{
		this.kerning = kerning;
	}

	/**
	 * Method to get the symbol text rotated.
	 * @return
	 */
	public Boolean getRotated()
	{
		return rotated;
	}

	/**
	 * Method to set the symbol text rotated.
	 * @param rotated
	 */
	public void setRotated(Boolean rotated)
	{
		this.rotated = rotated;
	}

	/**
	 * Method to get the symbol text.
	 * @return
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * Method to set the symbol text.
	 * @param text
	 */
	public void setText(String text)
	{
		this.text = text;
	}

	/**
	 * Method to get the symbol vertical alignment.
	 * @return
	 */
	public String getVerticalAlignment()
	{
		return verticalAlignment;
	}

	/**
	 * Method to set the symbol vertical alignment.
	 * @param verticalAlignment
	 */
	public void setVerticalAlignment(String verticalAlignment)
	{
		this.verticalAlignment = verticalAlignment;
	}

	/**
	 * Method to get the symbol X offset.
	 * @return
	 */
	public String getXoffset()
	{
		return xoffset;
	}

	/**
	 * Method to set the symbol X offset.
	 * @param xoffset
	 */
	public void setXoffset(String xoffset)
	{
		this.xoffset = xoffset;
	}

	/**
	 * Method to get the symbol Y offset.
	 * @return
	 */
	public String getYoffset()
	{
		return yoffset;
	}

	/**
	 * Method to set the symbol Y offset.
	 * @param yoffset
	 */
	public void setYoffset(String yoffset)
	{
		this.yoffset = yoffset;
	}
}
