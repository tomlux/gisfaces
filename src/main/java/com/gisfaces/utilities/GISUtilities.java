package com.gisfaces.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.gisfaces.model.geometry.Point;

/**
 * GIS related utilities class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class GISUtilities
{
	/** Web mercator spatial reference. */
	public static final String SPATIAL_REFERENCE_WEB_MERCATOR = "102100";

	/** ESRI geocoder URL with required parameters. */
	private static final String ESRI_GEOCODER_URL = "https://geocode.arcgis.com/arcgis/rest/services/World/GeocodeServer/find?text=%s&outSR=%soutFields=%s&maxLocations=%s&f=pjson";

	/** ESRI reverse geocoder URL with required parameters. */
	private static final String ESRI_REVERSE_GEOCODER_URL = "https://geocode.arcgis.com/arcgis/rest/services/World/GeocodeServer/reverseGeocode?location=%S&outSR=%S&f=pjson";

	/**
	 * Constructor.
	 */
	private GISUtilities()
	{
		// Static methods only.
	}

	/**
	 * Method to geocode an address.
	 * @param address Address string.
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String geocode(String address) throws IOException
	{
		return GISUtilities.geocode(address, GISUtilities.SPATIAL_REFERENCE_WEB_MERCATOR, "*", 1);
	}

	/**
	 * Method to geocode an address.
	 * @param address Address string.
	 * @param outputSpatialReference Output spatial reference.
	 * @param outputFields Comma delimited output fields.
	 * @param maxLocations Maximum locations to return.
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String geocode(String address, String outputSpatialReference, String outputFields, int maxLocations) throws IOException
	{
		// Build the URL.
		String spec = String.format(GISUtilities.ESRI_GEOCODER_URL, StringUtilities.encode(address), outputSpatialReference, outputFields, maxLocations);

		// Get the JSON output.
		return GISUtilities.getUrlConnectionOutput(spec);
	}

	/**
	 * Method to reverse geocode a coordinate.
	 * @param latitude Latutude.
	 * @param longitude Longitude
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String reverseGeocode(double latitude, double longitude) throws IOException
	{
		return GISUtilities.reverseGeocode(latitude, longitude, GISUtilities.SPATIAL_REFERENCE_WEB_MERCATOR);
	}

	/**
	 * Method to reverse geocode a coordinate.
	 * @param latitude Latutude.
	 * @param longitude Longitude
	 * @param outputSpatialReference Output spatial reference.
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String reverseGeocode(double latitude, double longitude, String outputSpatialReference) throws IOException
	{
		// Build the URL.
		String coordinate = String.format("%s,%s", longitude, latitude);
		String spec = String.format(GISUtilities.ESRI_REVERSE_GEOCODER_URL, StringUtilities.encode(coordinate), outputSpatialReference);

		// Get the JSON output.
		return GISUtilities.getUrlConnectionOutput(spec);

	}

	/**
	 * Method to get URL output.
	 * @param spec URL text.
	 * @return JSON string.
	 * @throws IOException
	 */
	public static final String getUrlConnectionOutput(String spec) throws IOException
	{
		StringBuffer sb = new StringBuffer();

		URL url = new URL(spec);
		URLConnection connection = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null)
		{
			sb.append(line);
			sb.append(System.getProperty("line.separator"));
		}

		reader.close();

		return sb.toString();
	}

	/**
	 * Method to format the specified points for use with JavaScript methods.
	 * @param points List of Point objects.
	 * @return Coordinates in "[[longitude,latitude],...]" format.
	 */
	public static final String formatPoints(List<Point> points)
	{
		StringBuffer sb = new StringBuffer();

		if ((points != null) && (!points.isEmpty()))
		{
			for (Point p : points)
			{
				if (sb.length() > 0)
				{
					sb.append(",");
				}

				sb.append("[").append(p.getLongitude()).append(",").append(p.getLatitude()).append("]");
			}
		}

		sb.insert(0, "[").append("]");

		return sb.toString();
	}

	/**
	 * Method to calculate the scale for the specified LOD zoom level.
	 * @param lod Level Of Detail zoom level.
	 * @return Scale.
	 */
	public static final double calculateScale(int lod)
	{
		// Base ESRI tiled background layer scale.
		double scale = 591657527.591555;

		for (int i=0; i<lod; i++)
		{
			// Reduce scale by half for each LOD zoom level requested.
			scale /= 2;
		}

		return scale;
	}
}
