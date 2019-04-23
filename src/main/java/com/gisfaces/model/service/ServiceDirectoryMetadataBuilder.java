package com.gisfaces.model.service;

import java.io.IOException;
import java.util.ArrayList;

import com.gisfaces.utilities.ArcGisJsonUtilities;
import com.gisfaces.utilities.json.JSONArray;
import com.gisfaces.utilities.json.JSONException;
import com.gisfaces.utilities.json.JSONObject;

/**
 * Service directory metadata builder class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceDirectoryMetadataBuilder
{
	/**
	 * Constructor.
	 */
	public ServiceDirectoryMetadataBuilder()
	{
		super();
	}

	/**
	 * Method to build the service directory metadata.
	 * @param serviceUrl ESRI ArcGIS map service directory URL. e.g. "http://server.arcgisonline.com/arcgis/rest/services"
	 * @return ServiceDirectoryMetadata
	 * @throws IOException
	 * @throws JSONException
	 */
	public ServiceDirectoryMetadata build(String serviceUrl) throws IOException, JSONException
	{
		// Sanitize URL.
		String url = ArcGisJsonUtilities.stripUrl(serviceUrl);

		// Create a new metadata object.
		ServiceDirectoryMetadata metadata = new ServiceDirectoryMetadata();
		metadata.setUrl(url);

		// Get the JSON query results.
		String json = ArcGisJsonUtilities.executeJsonQuery(url);

		// Populate the metadata using the JSON query results.
		this.populate(metadata, json);

		return metadata;
	}

	/**
	 * Method to populate the metadata object from the JSON query results.
	 * @param metadata Target metadata object.
	 * @param json JSON query results.
	 * @throws IOException
	 * @throws JSONException
	 */
	private void populate(ServiceDirectoryMetadata metadata, String json) throws IOException, JSONException
	{
		JSONObject obj = new JSONObject(json);

		if (obj != null)
		{
			if (obj.has("currentVersion"))
			{
				metadata.setVersion(obj.getString("currentVersion"));
			}

			if (obj.has("folders"))
			{
				JSONArray folders = obj.getJSONArray("folders");
				for (int i=0; i<folders.length(); i++)
				{
					String folder = folders.getString(i);

					metadata.getFolders().add(folder);
				}
			}

			if (obj.has("services"))
			{
				ServiceMetadataBuilder builder = new ServiceMetadataBuilder();

				JSONArray services = obj.getJSONArray("services");

				if (services.length() > 0)
				{
					// Create the list of services.
					metadata.setServices(new ArrayList<ServiceMetadata>());

					for (int i=0; i<services.length(); i++)
					{
						// Get the service name and type.
						JSONObject service = services.getJSONObject(i);
						String name = service.getString("name");
						String type = service.getString("type");

						// Remove the prepended sub directory, if present.
						name = name.replaceFirst(".*\\/", "");

						// Build a URL to the specified map service.
						String url = String.format("%s/%s/%s", metadata.getUrl(), name, type);

						// Add new service.
						metadata.getServices().add(builder.build(url, name, type));
					}
				}
			}
		}
	}

	/*
	public static void main(String[] args) throws IOException, JSONException
	{
		String url = "http://server.arcgisonline.com/arcgis/rest/services";

		ServiceDirectoryMetadataBuilder builder = new ServiceDirectoryMetadataBuilder();
		ServiceDirectoryMetadata directory = builder.build(url);

		System.out.println("service directory:");
		System.out.println("url: " + directory.getUrl());
		System.out.println("version: " + directory.getVersion());
		System.out.println("folders: " + directory.getFolders());
		System.out.println("");

		if (directory.getServices() != null)
		{
			for (ServiceMetadata service : directory.getServices())
			{
				System.out.println("service:");
				System.out.println("url: " + service.getUrl());
				System.out.println("version: " + service.getVersion());
				System.out.println("name: " + service.getName());
				System.out.println("type: " + service.getType());
				System.out.println("description: " + service.getDescription());
				System.out.println("");

				if (service.getLayers() != null)
				{
					for (ServiceLayerMetadata layer : service.getLayers())
					{
						System.out.println("service layer:");
						System.out.println("id: " + layer.getId());
						System.out.println("name: " + layer.getName());
						System.out.println("type: " + layer.getType());
						System.out.println("geometry type: " + layer.getGeometryType());
						System.out.println("");

						if (layer.getFields() != null)
						{
							for (ServiceLayerFieldMetadata field : layer.getFields())
							{
								System.out.println("service layer field:");
								System.out.println("name: " + field.getName());
								System.out.println("type: " + field.getType());
								System.out.println("alias: " + field.getAlias());
								System.out.println("length: " + field.getLength());
								System.out.println("domain: " + field.getValues());
								System.out.println("");
							}
						}
					}
				}
			}
		}
	}
	*/
}
