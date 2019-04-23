package com.gisfaces.event;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

/**
 * Map graphic delete AJAX behavior event.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapGraphicDeleteEvent extends AjaxBehaviorEvent
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 6946812548161803819L;

	/** Layer ID. */
	private String layerId;

	/** Graphic ID. */
	private String graphicId;

	/**
	 * Constructor.
	 * @param component
	 * @param behavior
	 */
	public MapGraphicDeleteEvent(UIComponent component, Behavior behavior)
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
}
