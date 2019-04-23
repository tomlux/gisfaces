package com.gisfaces.model.service;

import java.io.Serializable;
import java.util.Map;

/**
 * Service layer field metadata class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ServiceLayerFieldMetadata implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 3184478797212590240L;

	/** Service layer field name. */
	private String name;

	/** Service layer field type. */
	private String type;

	/** Service layer field alias. Defaults to the name if not specifically overridden. */
	private String alias;

	/** Service layer field length. Not applicable for domain values or ESRI types. */
	private int length;

	/** Service layer field values. Applicable only for statically-defined domain values. */
	private Map<String, String> values;

	/**
	 * Constructor.
	 */
	public ServiceLayerFieldMetadata()
	{
		super();
	}

	/**
	 * Method to get the service layer field name.
	 * @return String
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Method to set the service layer field name.
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Method to get the service layer field type.
	 * @return String
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Method to set the service layer field type.
	 * @param type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Method to get the service layer field alias.
	 * @return String
	 */
	public String getAlias()
	{
		return alias;
	}

	/**
	 * Method to set the service layer field alias.
	 * @param alias
	 */
	public void setAlias(String alias)
	{
		this.alias = alias;
	}

	/**
	 * Method to get the service layer field length.
	 * @return int
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * Method to set the service layer field length.
	 * @param length
	 */
	public void setLength(int length)
	{
		this.length = length;
	}

	/**
	 * Method to get the service layer field values.
	 * @return Map
	 */
	public Map<String, String> getValues()
	{
		return values;
	}

	/**
	 * Method to set the service layer field values.
	 * @param values
	 */
	public void setValues(Map<String, String> values)
	{
		this.values = values;
	}
}
