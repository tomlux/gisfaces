package com.gisfaces.model.layer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gisfaces.model.geometry.Extent;
import com.gisfaces.model.geometry.Point;
import com.gisfaces.model.graphic.Graphic;

/**
 * Graphics layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-GraphicsLayer.html">ESRI Graphics Layer</a>
 */
public class GraphicsLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -1201118874074813515L;

	/** Edit indicator. */
	private boolean editable;

	/** List of graphic models. */
	private List<Graphic> graphics;

	/**
	 * Constructor.
	 */
	public GraphicsLayer()
	{
		super();
		reset();
	}

	/**
	 * Method to reset the graphics model.
	 */
	public void reset()
	{
		this.setTitle("Graphics Layer");
		this.editable = false;
		this.graphics = new ArrayList<Graphic>();
	}

	/**
	 * Method to find the specified graphic.
	 * @param id Graphic ID.
	 * @return <code>Graphic</code> if found, <code>null</code> otherwise.
	 */
	public Graphic findGraphic(String id)
	{
		Graphic graphic = null;

		if ((id != null) && (this.graphics != null) && (!this.graphics.isEmpty()))
		{
			for (Graphic g : this.graphics)
			{
				if (id.equals(g.getId()))
				{
					graphic = g;
					break;
				}
			}
		}

		return graphic;
	}

	/**
	 * Method to get the extent of the associated graphics.
	 * @return Extent.
	 */
	public Extent getExtent()
	{
		Extent extent = null;

		if (this.graphics != null)
		{
			for (Graphic g : this.graphics)
			{
				if (g.getGeometry() != null)
				{
					if (g.getGeometry() instanceof Point)
					{
						extent = Extent.union(extent, new Extent((Point)g.getGeometry()));
					}
					else if (g.getGeometry() instanceof Extent)
					{
						extent = Extent.union(extent, ((Extent)g.getGeometry()));
					}
				}
			}
		}

		return extent;
	}

	/**
	 * Method to get the edit indicator.
	 * @return
	 */
	public boolean isEditable()
	{
		return editable;
	}

	/**
	 * Method to set the edit indicator.
	 * @param editable
	 */
	public void setEditable(boolean editable)
	{
		this.editable = editable;
	}
	/**
	 * Method to get the list of graphics.
	 * @return List of Graphic objects.
	 */
	public List<Graphic> getGraphics()
	{
		return graphics;
	}

	/**
	 * Method to set the list of graphics.
	 * @param graphics List of Graphic objects.
	 */
	public void setGraphics(List<Graphic> graphics)
	{
		this.graphics = graphics;
	}
}
