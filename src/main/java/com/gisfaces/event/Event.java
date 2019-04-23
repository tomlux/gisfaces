package com.gisfaces.event;

/**
 * Enumeration of supported AJAX event types.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public enum Event
{
	BASEMAP,
	CLICK,
	EXTENT,
	SELECT,
	GEOLOCATION,
	GRAPHICCREATE,
	GRAPHICUPDATE,
	GRAPHICDELETE;

	@Override
	public String toString()
	{
		return this.name().toLowerCase();
	}
}
