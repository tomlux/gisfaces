package com.gisfaces.event;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

import com.gisfaces.model.geometry.Extent;

/**
 * Map extent AJAX behavior event.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class MapExtentEvent extends AjaxBehaviorEvent
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 5264612377050477775L;

	/** Map center latitude. */
	private double latitude;

	/** Map center longitude. */
	private double longitude;

	/** Map zoom level. */
	private double zoom;

	/** Map scale. */
	private double scale;

	/** Map extent. */
	private Extent extent;

	/**
	 * Constructor.
	 * @param component
	 * @param behavior
	 */
	public MapExtentEvent(UIComponent component, Behavior behavior)
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
	 * Method to get the map center latitude.
	 * @return double
	 */
	public double getLatitude()
	{
		return latitude;
	}

	/**
	 * Method to set the map center latitude.
	 * @param latitude
	 */
	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * Method to get the map center longitude.
	 * @return double
	 */
	public double getLongitude()
	{
		return longitude;
	}

	/**
	 * Method to set the map center longitude.
	 * @param longitude
	 */
	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * Method to get the map zoom level.
	 * @return double
	 */
	public double getZoom()
	{
		return zoom;
	}

	/**
	 * Method to set the map zoom level.
	 * @param zoom
	 */
	public void setZoom(double zoom)
	{
		this.zoom = zoom;
	}

	/**
	 * Method to get the map scale.
	 * @return double
	 */
	public double getScale()
	{
		return scale;
	}

	/**
	 * Method to set the map scale.
	 * @param scale
	 */
	public void setScale(double scale)
	{
		this.scale = scale;
	}

	/**
	 * Method to get the map extent.
	 * @return Extent
	 */
	public Extent getExtent()
	{
		return extent;
	}

	/**
	 * Method to set the map extent.
	 * @param extent
	 */
	public void setExtent(Extent extent)
	{
		this.extent = extent;
	}
}
