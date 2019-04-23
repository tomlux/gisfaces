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
	public static final String DEFAULT_JSAPI				= "https://js.arcgis.com/4.11";
	public static final String DEFAULT_PROXY_PAGE			= "/proxy/proxy.jsp";
	public static final String DEFAULT_THEME				= MapTheme.LIGHT.getValue();
	public static final String DEFAULT_TYPE					= MapType.THREE_D.getValue();
	public static final String DEFAULT_BASEMAP				= Basemap.STREETS.getValue();
	public static final double DEFAULT_LATITUDE				= 39.828175;
	public static final double DEFAULT_LONGITUDE			= -98.5795;
	public static final double DEFAULT_ZOOM					= 3.0;

	public static final String ATTRIBUTE_JSAPI				= "jsapi";
	public static final String ATTRIBUTE_THEME				= "theme";
	public static final String ATTRIBUTE_TYPE				= "type";
	public static final String ATTRIBUTE_MAP_PANEL			= "panel";
	public static final String ATTRIBUTE_WEBMAP				= "webmap";
	public static final String ATTRIBUTE_BASEMAP			= "basemap";
	public static final String ATTRIBUTE_LATITUDE			= "latitude";
	public static final String ATTRIBUTE_LONGITUDE			= "longitude";
	public static final String ATTRIBUTE_ZOOM				= "zoom";
	public static final String ATTRIBUTE_MODEL				= "model";
}
