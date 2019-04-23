package com.gisfaces.event;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

/**
 * Map basemap AJAX behavior event.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapBasemapEvent extends AjaxBehaviorEvent
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -5769525317991960624L;

	/** Basemap title. */
	private String basemapTitle;

	/**
	 * Constructor.
	 * @param component
	 * @param behavior
	 */
	public MapBasemapEvent(UIComponent component, Behavior behavior)
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
	 * Method to get the basemap title.
	 * @return
	 */
	public String getBasemapTitle()
	{
		return basemapTitle;
	}

	/**
	 * Method to set the basemap title.
	 * @param basemapTitle
	 */
	public void setBasemapTitle(String basemapTitle)
	{
		this.basemapTitle = basemapTitle;
	}
}
