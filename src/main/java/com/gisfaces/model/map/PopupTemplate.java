package com.gisfaces.model.map;

import java.io.Serializable;

/**
 * Popup template class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class PopupTemplate  implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 6392705110200613598L;

	/** Popup title. */
	private String title;

	/** Popup content. */
	private String content;

	/**
	 * Constructor
	 */
	public PopupTemplate()
	{
		this("Feature", "{*}");
	}

	/**
	 * Constructor.
	 * @param title Popup title.
	 */
	public PopupTemplate(String title)
	{
		this(title, "{*}");
	}

	/**
	 * Constructor.
	 * @param title Popup title.
	 * @param content Popup content.
	 */
	public PopupTemplate(String title, String content)
	{
		super();
		this.title = title;
		this.content = content;
	}

	/**
	 * Method to get the popup title.
	 * @return
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Method to set the popup title.
	 * @param title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * Method to get the popup content.
	 * @return
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * Method to set the popup content.
	 * @param content
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
}
