package com.gisfaces.model.graphic;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import com.gisfaces.model.geometry.Geometry;
import com.gisfaces.model.map.PopupTemplate;
import com.gisfaces.model.symbol.SimpleMarkerSymbol;
import com.gisfaces.model.symbol.Symbol;

/**
 * Graphic class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-Graphic.html">ESRI Graphic</a>
 */
public class Graphic implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -2836518622754022184L;

	/** Graphic ID. */
	private String id;

	/** Graphic visibility. */
	private boolean visible;

	/** Graphic geometry. */
	private Geometry geometry;

	/** Graphic popup template. */
	private PopupTemplate popupTemplate;

	/** Graphic symbol. */
	private Symbol symbol;

	/** Graphic attributes displayed in the popup window. */
	private Map<String, Object> attributes;

	/** Data object associated to this graphic for future reference. */
	private Object data;

	/**
	 * Constructor.
	 */
	public Graphic()
	{
		super();
		reset();
	}

	/**
	 * Method to reset the graphic to defaults.
	 */
	public void reset()
	{
		this.visible = true;
		this.popupTemplate = new PopupTemplate("Graphic");
		this.symbol = new SimpleMarkerSymbol();
		this.attributes = new LinkedHashMap<String, Object>();
		this.data = null;
	}

	/**
	 * Method to get the graphic ID.
	 * @return Graphic ID.
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Method to set the graphic ID.
	 * @param id Graphic ID.
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Method to get the graphic visibility.
	 * @return Graphic visibility.
	 */
	public boolean isVisible()
	{
		return visible;
	}

	/**
	 * Method to set the graphic visibility.
	 * @param visible Graphic visibility.
	 */
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}

	/**
	 * Method to get the graphic geometry.
	 * @return
	 */
	public Geometry getGeometry()
	{
		return geometry;
	}

	/**
	 * Method to set the graphic geometry.
	 * @param geometry
	 */
	public void setGeometry(Geometry geometry)
	{
		this.geometry = geometry;
	}

	/**
	 * Method to get the graphic popup template.
	 * @return
	 */
	public PopupTemplate getPopupTemplate()
	{
		return popupTemplate;
	}

	/**
	 * Method to set the graphic popup template.
	 * @param popupTemplate
	 */
	public void setPopupTemplate(PopupTemplate popupTemplate)
	{
		this.popupTemplate = popupTemplate;
	}

	/**
	 * Method to get the graphic symbol.
	 * @return
	 */
	public Symbol getSymbol()
	{
		return symbol;
	}

	/**
	 * Method to set the graphic symbol.
	 * @param symbol
	 */
	public void setSymbol(Symbol symbol)
	{
		this.symbol = symbol;
	}

	/**
	 * Method to get the graphic attributes.
	 * @return Graphic attributes.
	 */
	public Map<String, Object> getAttributes()
	{
		return attributes;
	}

	/**
	 * Method to set the graphic attributes.
	 * @param attributes Graphic attributes.
	 */
	public void setAttributes(Map<String, Object> attributes)
	{
		this.attributes = attributes;
	}

	/**
	 * Method to get the object associated to this graphic.
	 * @return Associated object.
	 */
	public Object getData()
	{
		return data;
	}

	/**
	 * Method to set the object associated to this graphic.
	 * @param data Associated object.
	 */
	public void setData(Object data)
	{
		this.data = data;
	}
}
