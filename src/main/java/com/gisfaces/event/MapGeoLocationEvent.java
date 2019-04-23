package com.gisfaces.event;

import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.AjaxBehaviorListener;
import javax.faces.event.FacesListener;

/**
 * Map geolocation AJAX behavior event.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://dev.w3.org/geo/api/spec-source.html">Geolocation API Specification</a>
 */
public class MapGeoLocationEvent extends AjaxBehaviorEvent
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -7539452873861081760L;

	/** Timestamp. */
	private Long timestamp;

	/** Latitude. */
	private Double latitude;

	/** Longitude. */
	private Double longitude;

	/** Altitude (meters). */
	private Double altitude;

	/** Accuracy (meters). */
	private Double accuracy;

	/** Altitude accuracy (meters). */
	private Double altitudeAccuracy;

	/** Heading (degrees). */
	private Double heading;

	/** Speed (meters per second). */
	private Double speed;

	/**
	 * Constructor.
	 * @param component
	 * @param behavior
	 */
	public MapGeoLocationEvent(UIComponent component, Behavior behavior)
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
	 * Method to get the timestamp as a date.
	 * @return
	 */
	public Date getTimestampDate()
	{
		Date d = null;

		if (this.timestamp != null)
		{
			d = new Date(this.timestamp);
		}

		return d;
	}

	/**
	 * Method to get the timestamp.
	 * @return
	 */
	public Long getTimestamp()
	{
		return timestamp;
	}

	/**
	 * Method to set the timestamp.
	 * @param timestamp
	 */
	public void setTimestamp(Long timestamp)
	{
		this.timestamp = timestamp;
	}

	/**
	 * Method to get the latitude.
	 * @return
	 */
	public Double getLatitude()
	{
		return latitude;
	}

	/**
	 * Method to set the latitude.
	 * @param latitude
	 */
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * Method to get the longitude.
	 * @return
	 */
	public Double getLongitude()
	{
		return longitude;
	}

	/**
	 * Method to set the longitude.
	 * @param longitude
	 */
	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * Method to get the altitude.
	 * @return
	 */
	public Double getAltitude()
	{
		return altitude;
	}

	/**
	 * Method to set the altitude.
	 * @param altitude
	 */
	public void setAltitude(Double altitude)
	{
		this.altitude = altitude;
	}

	/**
	 * Method to get the accuracy.
	 * @return
	 */
	public Double getAccuracy()
	{
		return accuracy;
	}

	/**
	 * Method to set the accuracy.
	 * @param accuracy
	 */
	public void setAccuracy(Double accuracy)
	{
		this.accuracy = accuracy;
	}

	/**
	 * Method to get the altitude accuracy.
	 * @return
	 */
	public Double getAltitudeAccuracy()
	{
		return altitudeAccuracy;
	}

	/**
	 * Method to set the altitude accuracy.
	 * @param altitudeAccuracy
	 */
	public void setAltitudeAccuracy(Double altitudeAccuracy)
	{
		this.altitudeAccuracy = altitudeAccuracy;
	}

	/**
	 * Method to get the heading.
	 * @return
	 */
	public Double getHeading()
	{
		return heading;
	}

	/**
	 * Method to set the heading.
	 * @param heading
	 */
	public void setHeading(Double heading)
	{
		this.heading = heading;
	}

	/**
	 * Method to get the speed.
	 * @return
	 */
	public Double getSpeed()
	{
		return speed;
	}

	/**
	 * Method to set the speed.
	 * @param speed
	 */
	public void setSpeed(Double speed)
	{
		this.speed = speed;
	}
}
