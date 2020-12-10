/*
 * The MIT License
 *
 * Copyright (c) 2013-2021 Chris Duncan (cduncan@gisfaces.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.gisfaces.utilities;

import java.util.List;
import java.util.Map;
import javax.el.ValueExpression;
import javax.faces.application.Resource;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UINamingContainer;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * JSF component utilities.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class ComponentUtilities {
	/**
	 * Constructor.
	 */
	private ComponentUtilities() {
		// Class contains static methods only.
	}

	/**
	 * Method to get the component form ID.
	 * 
	 * @param component UIComponent.
	 * @return Component form ID or <code>null</code> if not found.
	 */
	public static final String getFormId(UIComponent component) {
		String formId = null;

		UIComponent parent = component;
		while (parent != null) {
			if (parent instanceof UIForm) {
				formId = parent.getClientId();
				break;
			} else {
				parent = parent.getParent();
			}
		}

		return formId;
	}

	/**
	 * Method to get the client ID prefix.
	 * 
	 * @param id Faces Client ID.
	 * @return Client ID prefix not including the Faces separator.
	 */
	public static final String getClientIdPrefix(String id) {
		String prefix = null;

		if (id != null) {
			String separator = ComponentUtilities.getFacesSeparator();

			if (id.contains(separator)) {
				prefix = id.substring(0, id.lastIndexOf(separator));
			}
		}

		return prefix;
	}

	/**
	 * Method to determine if a client ID is qualified.
	 * 
	 * @param id Faces Client ID.
	 * @return <code>true</code> if client ID is qualified, <code>false</code>
	 *         otherwise.
	 */
	public static final boolean isClientIdQualified(String id) {
		boolean qualified = false;

		if (id != null) {
			String separator = ComponentUtilities.getFacesSeparator();
			qualified = id.contains(separator);
		}

		return qualified;
	}

	/**
	 * Method to qualify a client ID, if necessary.
	 * 
	 * @param parent Parent client ID.
	 * @param child  Child client ID to qualify, if necessary.
	 * @return Qualified client ID.
	 */
	public static final String qualifyClientId(String parent, String child) {
		String id = child;

		if ((parent != null) && (child != null)) {
			String separator = ComponentUtilities.getFacesSeparator();

			if (!ComponentUtilities.isClientIdQualified(child)) {
				// Qualify based on the parent ID.
				String prefix = ComponentUtilities.getClientIdPrefix(parent);
				id = prefix + separator + child;
			}

			if (id.startsWith(separator)) {
				// Remove the leading faces separator in order to match the generated HTML
				// element ID.
				id = id.substring(1);
			}
		}

		return id;
	}

	/**
	 * Method to get the Faces separator.
	 * 
	 * @return Faces separator.
	 */
	public static final String getFacesSeparator() {
		return Character.toString(UINamingContainer.getSeparatorChar(FacesContext.getCurrentInstance()));
	}

	/**
	 * Method to get an object component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @return Component object attribute if specified, <code>null</code> otherwise.
	 */
	public static final Object getObjectAttribute(UIComponent component, String key) {
		Object value = null;

		Object obj = component.getAttributes().get(key);
		if (obj != null) {
			value = obj;
		}

		return value;
	}

	/**
	 * Method to get a string component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @return Component attribute value.
	 */
	public static final String getStringAttribute(UIComponent component, String key) {
		return ComponentUtilities.getStringAttribute(component, key, null);
	}

	/**
	 * Method to get a string component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @param def       Default value.
	 * @return Component attribute value.
	 */
	public static final String getStringAttribute(UIComponent component, String key, String def) {
		String value = def;

		Object obj = component.getAttributes().get(key);
		if (obj != null) {
			value = obj.toString();
		}

		return value;
	}

	/**
	 * Method to get a boolean component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @return Component attribute value.
	 */
	public static final boolean getBooleanAttribute(UIComponent component, String key) {
		return ComponentUtilities.getBooleanAttribute(component, key, false);
	}

	/**
	 * Method to get a boolean component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @param def       Default value.
	 * @return Component attribute value.
	 */
	public static final boolean getBooleanAttribute(UIComponent component, String key, boolean def) {
		boolean value = def;

		Object obj = component.getAttributes().get(key);
		if (obj != null) {
			value = Boolean.valueOf(obj.toString());
		}

		return value;
	}

	/**
	 * Method to get an integer component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @return Component attribute value.
	 */
	public static final int getIntegerAttribute(UIComponent component, String key) {
		return ComponentUtilities.getIntegerAttribute(component, key, 0);
	}

	/**
	 * Method to get an integer component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @param def       Default value.
	 * @return Component attribute value.
	 */
	public static final int getIntegerAttribute(UIComponent component, String key, int def) {
		int value = def;

		try {
			Object obj = component.getAttributes().get(key);
			if (obj != null) {
				value = Integer.valueOf(obj.toString());
			}
		} catch (Exception e) {
			value = def;
		}

		return value;
	}

	/**
	 * Method to get a double component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @return Component attribute value.
	 */
	public static final double getDoubleAttribute(UIComponent component, String key) {
		return ComponentUtilities.getDoubleAttribute(component, key, 0d);
	}

	/**
	 * Method to get a double component attribute value.
	 * 
	 * @param component UIComponent.
	 * @param key       Attribute key.
	 * @param def       Default value.
	 * @return Component attribute value.
	 */
	public static final double getDoubleAttribute(UIComponent component, String key, double def) {
		double value = def;

		try {
			Object obj = component.getAttributes().get(key);
			if (obj != null) {
				value = Double.valueOf(obj.toString());
			}
		} catch (Exception e) {
			value = def;
		}

		return value;
	}

	/**
	 * Method to get the client behavior ajax script.
	 * 
	 * @param component UIComponent.
	 * @param event     Event name.
	 * @return Client behavior ajax script.
	 */
	public static final String getClientBehaviorAjaxScript(UIComponent component, String event) {
		String script = null;

		ClientBehaviorContext behaviorContext = ClientBehaviorContext.createClientBehaviorContext(FacesContext.getCurrentInstance(), component, event,
				component.getClientId(), null);
		Map<String, List<ClientBehavior>> behaviors = ((UICommand) component).getClientBehaviors();

		if (behaviors.containsKey(event)) {
			script = behaviors.get(event).get(0).getScript(behaviorContext);
		}

		return script;
	}

	/**
	 * Method to decode client behaviors.
	 * 
	 * @param component UIComponent.
	 */
	public static final void decodeClientBehaviors(UIComponent component) {
		if (component instanceof ClientBehaviorHolder) {
			FacesContext context = FacesContext.getCurrentInstance();
			ClientBehaviorHolder holder = (ClientBehaviorHolder) component;
			Map<String, List<ClientBehavior>> behaviors = holder.getClientBehaviors();

			if (!behaviors.isEmpty()) {
				ExternalContext external = context.getExternalContext();
				Map<String, String> params = external.getRequestParameterMap();
				String behaviorEvent = params.get("javax.faces.behavior.event");

				if (behaviorEvent != null) {
					List<ClientBehavior> behaviorsForEvent = behaviors.get(behaviorEvent);

					if (behaviors.size() > 0) {
						String behaviorSource = params.get("javax.faces.source");
						String clientId = component.getClientId();

						if ((behaviorSource != null) && (behaviorSource.equals(clientId))) {
							for (ClientBehavior behavior : behaviorsForEvent) {
								behavior.decode(context, component);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Method to remove extraneous script parameter value quotes. This is necessary
	 * because <code>ClientBehavior.getScript()</code> always puts single quotes
	 * around the parameter value. The <code>ClientBehaviorContext.Parameter</code>
	 * class needs an indicator for this.
	 * 
	 * @param script     JavaScript generated from a
	 *                   <code>ClientBehavior.getScript()</code> invocation.
	 * @param parameters List of <code>ClientBehaviorContext.Parameter</code>.
	 * @return String
	 */
	public static final String removeScriptParameterValueQuotes(String script, List<ClientBehaviorContext.Parameter> parameters) {
		for (ClientBehaviorContext.Parameter parameter : parameters) {
			// Get the parameter value.
			String value = parameter.getValue().toString();

			if (value != null)
				;
			{
				// Remove single quotes surrounding parameter value.
				script = script.replace("'" + value + "'", value);
			}
		}

		return script;
	}

	/**
	 * Method to determine if the command has an action or action listener attached.
	 * 
	 * @param component UICommand.
	 * @return <code>true</code> if the component has an <code>action</code> or
	 *         <code>actionListener</code> attribute specified, <code>false</code>
	 *         otherwise.
	 */
	public static final boolean hasActionOrActionListener(UICommand component) {
		return ((component.getActionListeners().length > 0) || (component.getActionExpression() != null));
	}

	/**
	 * Method to determine if the request is initiated by the specified client ID.
	 * 
	 * @param fc       FacesContext
	 * @param clientId Client ID.
	 * @return <code>true</code> if the specified component client ID initiated the
	 *         request, <code>false</code> otherwise.
	 */
	public static final boolean isComponentRequest(FacesContext fc, String clientId) {
		boolean result = false;

		// Get the requesting component ID.
		String sourceId = fc.getExternalContext().getRequestParameterMap().get("javax.faces.source");

		if ((sourceId != null) && (sourceId.equals(clientId))) {
			result = true;
		}

		return result;
	}

	/**
	 * Method to determine if an attribute is a value expression.
	 * 
	 * @param component UIComponent
	 * @param attribute Attribute name.
	 * @return <code>true</code> if the component attribute is a value expression,
	 *         <code>false</code> otherwise.
	 */
	public static final boolean isValueExpression(UIComponent component, String attribute) {
		return (component.getValueExpression(attribute) != null);
	}

	/**
	 * Method to set the value expression value, if appropriate.
	 * 
	 * @param fc        FacesContext
	 * @param component UIComponent
	 * @param attribute Attribute name.
	 * @param value     New value.
	 * @return <code>true</code> if the value was set, <code>false</code> otherwise.
	 */
	public static final boolean setValueExpressionValue(FacesContext fc, UIComponent component, String attribute, Object value) {
		boolean result = false;

		// Get the value binding expression.
		ValueExpression ve = component.getValueExpression(attribute);
		if ((ve != null) && (!ve.isReadOnly(fc.getELContext()))) {
			// Set the new value.
			ve.setValue(fc.getELContext(), value);

			result = true;
		}

		return result;
	}

	/**
	 * Method to get the specified resource from the resources directory. The
	 * <code>getContentType</code> and <code>getRequestPath</code> methods are
	 * particularly useful when building <code>link</code> and <code>script</code>
	 * tags dynamically.
	 * 
	 * @param fc      FacesContext
	 * @param library Resource library (directory) name.
	 * @param name    Resource file name.
	 * @return Library resource.
	 */
	public static final Resource getResource(FacesContext fc, String library, String name) {
		return fc.getApplication().getResourceHandler().createResource(name, library);
	}
}
