package com.gisfaces.model.map;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

/**
 * Map type enum class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public enum MapType
{
	TWO_D("2d", "2D"),
	THREE_D("3d", "3D");

	/** Value. */
	private String value;

	/** title. */
	private String title;

	/**
	 * Constructor.
	 * Package scope required for enum constructors.
	 * @param value Value.
	 * @param title Title.
	 */
	MapType(String value, String title)
	{
		this.value = value;
		this.title = title;
	}

	/**
	 * Method to get the enum value.
	 * @return Enum value.
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * Method to get the enum title.
	 * @return Enum title.
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Method to get the enum select items.
	 * @return List of SelectItem objects.
	 */
	public static final List<SelectItem> getSelectItems()
	{
		List<SelectItem> items = new ArrayList<SelectItem>();

		for (MapType b : MapType.values())
		{
			items.add(new SelectItem(b.getValue(), b.getTitle(), b.getTitle()));
		}

		return items;
	}
}
