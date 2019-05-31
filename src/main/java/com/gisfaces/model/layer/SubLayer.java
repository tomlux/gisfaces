package com.gisfaces.model.layer;

import java.io.Serializable;

import com.gisfaces.model.map.PopupTemplate;
import com.gisfaces.model.renderer.Renderer;
import com.gisfaces.model.symbol.LabelClass;

/**
 * Sub layer class.
 * @author Chris Duncan (cduncan@gisfaces.com)
 * @see <a href="https://developers.arcgis.com/javascript/latest/api-reference/esri-layers-support-Sublayer.html">ESRI SubLayer</a>
 */
public class SubLayer extends ScaledLayer implements Serializable
{
	/** Serial Version UID. */
	private static final long serialVersionUID = 408037064384224622L;

	/** Layer definition expression. */
	private String definitionExpression;

	/** Labeling information. */
	private LabelClass[] labelingInfo;

	/** Label visibility. */
	private Boolean labelsVisible;

	/** Popup enabled indicator. */
	private boolean popupEnabled = true;

	/** Popup template. */
	private PopupTemplate popupTemplate;

	/** Symbology renderer. */
	private Renderer renderer;

	/**
	 * Constructor.
	 */
	public SubLayer()
	{
		super();
	}

	/**
	 * Constructor.
	 * @param id Layer ID.
	 */
	public SubLayer(String id)
	{
		this();
		this.setId(id);
	}

	/**
	 * Method to get the layer definition expression.
	 * @return
	 */
	public String getDefinitionExpression()
	{
		return definitionExpression;
	}

	/**
	 * Method to set the layer definition expression.
	 * @param definitionExpression
	 */
	public void setDefinitionExpression(String definitionExpression)
	{
		this.definitionExpression = definitionExpression;
	}

	/**
	 * Method to get the labeling information.
	 * @return
	 */
	public LabelClass[] getLabelingInfo()
	{
		return labelingInfo;
	}

	/**
	 * Method to set the labeling information.
	 * @param labelingInfo
	 */
	public void setLabelingInfo(LabelClass[] labelingInfo)
	{
		this.labelingInfo = labelingInfo;
	}

	/**
	 * Method to get the label visibility.
	 * @return
	 */
	public Boolean getLabelsVisible()
	{
		return labelsVisible;
	}

	/**
	 * Method to set the label visibility.
	 * @param labelsVisible
	 */
	public void setLabelsVisible(Boolean labelsVisible)
	{
		this.labelsVisible = labelsVisible;
	}

	/**
	 * Method to get the popup enabled indicator.
	 * @return
	 */
	public boolean isPopupEnabled()
	{
		return popupEnabled;
	}

	/**
	 * Method to set the popup enabled indicator.
	 * @param popupEnabled
	 */
	public void setPopupEnabled(boolean popupEnabled)
	{
		this.popupEnabled = popupEnabled;
	}

	/**
	 * Method to get the popup template.
	 * @return
	 */
	public PopupTemplate getPopupTemplate()
	{
		return popupTemplate;
	}

	/**
	 * Method to set the popup template.
	 * @param popupTemplate
	 */
	public void setPopupTemplate(PopupTemplate popupTemplate)
	{
		this.popupTemplate = popupTemplate;
	}

	/**
	 * Method to get the symbology renderer.
	 * @return
	 */
	public Renderer getRenderer()
	{
		return renderer;
	}

	/**
	 * Method to set the symbology renderer.
	 * @param renderer
	 */
	public void setRenderer(Renderer renderer)
	{
		this.renderer = renderer;
	}
}
