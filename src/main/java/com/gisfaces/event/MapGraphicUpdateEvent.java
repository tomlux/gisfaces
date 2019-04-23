package com.gisfaces.event;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

import com.gisfaces.model.geometry.Geometry;

/**
 * Map graphic update AJAX behavior event.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapGraphicUpdateEvent extends AjaxBehaviorEvent
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -4697692410554927714L;

	/** Layer ID. */
	private String layerId;

	/** Graphic ID. */
	private String graphicId;

	/** Graphic geometry. */
	private Geometry geometry;

	/**
	 * Constructor.
	 * @param component
	 * @param behavior
	 */
	public MapGraphicUpdateEvent(UIComponent component, Behavior behavior)
	{
		super(component, behavior);
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.AjaxBehaviorEvent#isAppropriateListener(javax.faces.event.FacesListener)
	 */
	@Override
	public boolean isAppropriateListener(FacesListener listener)
	{
		return (listener instanceof AjaxBehaviorListener);
	}

	/* (non-Javadoc)
	 * @see javax.faces.event.AjaxBehaviorEvent#processListener(javax.faces.event.FacesListener)
	 */
	@Override
	public void processListener(FacesListener listener)
	{
		((AjaxBehaviorListener) listener).processAjaxBehavior(this);
	}

	/**
	 * Method to get the layer ID.
	 * @return String
	 */
	public String getLayerId()
	{
		return layerId;
	}

	/**
	 * Method to set the layer ID.
	 * @param layerId
	 */
	public void setLayerId(String layerId)
	{
		this.layerId = layerId;
	}

	/**
	 * Method to get the graphic ID.
	 * @return
	 */
	public String getGraphicId()
	{
		return graphicId;
	}

	/**
	 * Method to set the graphic ID.
	 * @param graphicId
	 */
	public void setGraphicId(String graphicId)
	{
		this.graphicId = graphicId;
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
}
