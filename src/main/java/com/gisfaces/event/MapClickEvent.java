package com.gisfaces.event;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

/**
 * Map click AJAX behavior event.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapClickEvent extends AjaxBehaviorEvent
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 5179890280858855519L;

	/** Map latitude. */
	private double latitude;

	/** Map longitude. */
	private double longitude;

	/**
	 * Constructor.
	 * @param component
	 * @param behavior
	 */
	public MapClickEvent(UIComponent component, Behavior behavior)
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
	 * Method to get the map latitude.
	 * @return double
	 */
	public double getLatitude()
	{
		return latitude;
	}

	/**
	 * Method to set the map latitude.
	 * @param latitude
	 */
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * Method to get the map longitude.
	 * @return double
	 */
	public double getLongitude()
	{
		return longitude;
	}

	/**
	 * Method to set the map longitude.
	 * @param longitude
	 */
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}
}
