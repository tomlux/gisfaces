package com.gisfaces.component;

import com.gisfaces.model.map.Basemap;
import com.gisfaces.model.map.MapTheme;
import com.gisfaces.model.map.MapType;

/**
 * Constants class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public final class Constants
{
	public static final String DEFAULT_JSAPI		= "https://js.arcgis.com/4.11";
	public static final String DEFAULT_PROXY_PAGE	= "/proxy/proxy.jsp";

	public static final MapType DEFAULT_TYPE		= MapType.THREE_D;
	public static final Basemap DEFAULT_BASEMAP		= Basemap.STREETS;
	public static final MapTheme DEFAULT_THEME		= MapTheme.LIGHT;

	public static final double DEFAULT_LATITUDE		= 39.828175;
	public static final double DEFAULT_LONGITUDE	= -98.5795;
	public static final double DEFAULT_ZOOM			= 3.0;

	public static final String ATTRIBUTE_PANEL		= "panel";
	public static final String ATTRIBUTE_MODEL		= "model";
}
