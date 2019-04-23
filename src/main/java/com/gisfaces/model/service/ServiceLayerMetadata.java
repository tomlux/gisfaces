package com.gisfaces.model.service;

import java.io.Serializable;
import java.util.List;

/**
 * Service layer metadata class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceLayerMetadata implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = -6077242743780953638L;

	/** Service layer URL. */
	private String url;

	/** Service layer ID. */
	private String id;

	/** Service layer name. */
	private String name;

	/** Service layer type. */
	private String type;

	/** Service layer geometry type. */
	private String geometryType;

	/** Service layer fields. */
	private List<ServiceLayerFieldMetadata> fields;

	/**
	 * Constructor.
	 */
	public ServiceLayerMetadata()
	{
		super();
	}

	/**
	 * Method to get the service layer URL.
	 * @return String
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * Method to set the service layer URL.
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * Method to get the service layer ID.
	 * @return String
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Method to set the service layer ID.
	 * @param id
	 */
	public void setId(String id)
	{
		this.id = id;
	}

	/**
	 * Method to get the service layer name.
	 * @return String
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Method to set the service layer name.
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Method to get the service layer type.
	 * @return String
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Method to set the service layer type.
	 * @param type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Method to get the service layer geometry type.
	 * @return String
	 */
	public String getGeometryType()
	{
		return geometryType;
	}

	/**
	 * Method to set the service layer geometry type.
	 * @param geometryType
	 */
	public void setGeometryType(String geometryType)
	{
		this.geometryType = geometryType;
	}

	/**
	 * Method to get the service layer fields.
	 * @return List
	 */
	public List<ServiceLayerFieldMetadata> getFields()
	{
		return fields;
	}

	/**
	 * Method to set the service layer fields.
	 * @param fields
	 */
	public void setFields(List<ServiceLayerFieldMetadata> fields)
	{
		this.fields = fields;
	}
}
