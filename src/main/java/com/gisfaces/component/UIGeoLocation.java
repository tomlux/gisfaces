/*
 * The MIT License
 *
 * Copyright (c) 2013-2023 Chris Duncan (cduncan@gisfaces.com)
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

package com.gisfaces.component;

import com.gisfaces.event.Event;
import com.gisfaces.event.MapGeoLocationEvent;
import com.gisfaces.utilities.ComponentUtilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 * GIS geo-location custom component.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
@FacesComponent("com.gisfaces.component.GeoLocation")
@ResourceDependencies({ @ResourceDependency(library = "javax.faces", name = "jsf.js", target = "head"),
		@ResourceDependency(library = "javascript", name = "gisfaces-geolocation.js", target = "head"), })
public class UIGeoLocation extends UIComponentBase implements ClientBehaviorHolder {
	/**
	 * Constructor.
	 */
	public UIGeoLocation() {
		super();
		setRendererType(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.UIComponent#getFamily()
	 */
	@Override
	public String getFamily() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.UIComponentBase#getEventNames()
	 */
	@Override
	public Collection<String> getEventNames() {
		return Arrays.asList(Event.GEOLOCATION.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.UIComponentBase#getDefaultEventName()
	 */
	@Override
	public String getDefaultEventName() {
		return Event.GEOLOCATION.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.UIComponentBase#getRendersChildren()
	 */
	@Override
	public boolean getRendersChildren() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.UIComponentBase#decode(javax.faces.context.
	 * FacesContext)
	 */
	@Override
	public void decode(FacesContext context) {
		String clientId = this.getClientId();

		if (ComponentUtilities.isComponentRequest(context, clientId))
			;
		{
			Map<String, String> params = context.getExternalContext().getRequestParameterMap();

			// Get the ajax behavior event name.
			String name = params.get("javax.faces.behavior.event");

			if (Event.GEOLOCATION.toString().equals(name)) {
				// Get the request parameters.
				String timestamp = params.get("gisfaces.timestamp");
				String latitude = params.get("gisfaces.latitude");
				String longitude = params.get("gisfaces.longitude");
				String altitude = params.get("gisfaces.altitude");
				String accuracy = params.get("gisfaces.accuracy");
				String altitudeAccuracy = params.get("gisfaces.altitudeAccuracy");
				String heading = params.get("gisfaces.heading");
				String speed = params.get("gisfaces.speed");

				// Check for registered event listeners.
				List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.GEOLOCATION.toString());
				if ((behaviors != null) && !behaviors.isEmpty()) {
					// Send an event to all registered listeners.
					for (ClientBehavior behavior : behaviors) {
						// Create the custom map event.
						MapGeoLocationEvent event = new MapGeoLocationEvent(this, behavior);
						event.setTimestamp(Long.parseLong(timestamp));
						event.setLatitude(Double.parseDouble(latitude));
						event.setLongitude(Double.parseDouble(longitude));
						event.setAltitude(Double.parseDouble(altitude));
						event.setAccuracy(Double.parseDouble(accuracy));
						event.setAltitudeAccuracy(Double.parseDouble(altitudeAccuracy));
						event.setHeading(Double.parseDouble(heading));
						event.setSpeed(Double.parseDouble(speed));

						// Send the event.
						queueEvent(event);
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.UIComponentBase#encodeBegin(javax.faces.context.
	 * FacesContext)
	 */
	@Override
	public void encodeBegin(FacesContext context) throws IOException {
		// Get the component client ID.
		String clientId = this.getClientId();

		// Get the component attributes.
		boolean watch = ComponentUtilities.getBooleanAttribute(this, "watch", true);
		boolean accuracy = ComponentUtilities.getBooleanAttribute(this, "accuracy", true);
		int timeout = ComponentUtilities.getIntegerAttribute(this, "timeout", 60000);
		int maximumAge = ComponentUtilities.getIntegerAttribute(this, "maximumAge", 0);

		// Get the response writer.
		ResponseWriter writer = context.getResponseWriter();

		// Encode custom component html with client ID necessary for event
		// functionality.
		writer.startElement("span", this);
		writer.writeAttribute("id", clientId, null);
		writer.endElement("span");

		// Encode the javascript block open.
		writer.startElement("script", this);
		writer.writeAttribute("type", "text/javascript", null);

		if (!context.isPostback()) {
			// Make sure the namespace is available.
			writer.write("if (!com) var com = {};");
			writer.write("if (!com.gisfaces) com.gisfaces = {};");

			// Encode the variables.
			writer.write("com.gisfaces.geolocationWatchId = null;");

			// Encode the client behavior functions.
			this.encodeJsfGisGeoLocationFunction(context, this, writer);
		}

		// Encode the geolocation call using the current parameters.
		writer.write(String.format("com.gisfaces.startWatchCurrentPosition(%s, %s, %s, %s);", watch, accuracy, timeout, maximumAge));

		// Encode the javascript block close.
		writer.endElement("script");
	}

	/**
	 * Method to encode the function which generates a JSF map geo-location AJAX
	 * event.
	 * 
	 * @param context   FacesContext
	 * @param component UIComponent
	 * @param writer    ResponseWriter
	 * @throws IOException
	 */
	private void encodeJsfGisGeoLocationFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
		writer.write("com.gisfaces.generateJsfGisGeoLocationEvent = function(position) {");

		// Get the list of client behavior event listeners specified.
		List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.GEOLOCATION.toString());

		if ((behaviors != null) && !behaviors.isEmpty()) {
			writer.write("var event = null;");

			// Add parameters for decode.
			List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
			parameters.add(new ClientBehaviorContext.Parameter("gisfaces.timestamp", "Number(position.timestamp)"));
			parameters.add(new ClientBehaviorContext.Parameter("gisfaces.latitude", "Number(position.coords.latitude)"));
			parameters.add(new ClientBehaviorContext.Parameter("gisfaces.longitude", "Number(position.coords.longitude)"));
			parameters.add(new ClientBehaviorContext.Parameter("gisfaces.altitude", "Number(position.coords.altitude)"));
			parameters.add(new ClientBehaviorContext.Parameter("gisfaces.accuracy", "Number(position.coords.accuracy)"));
			parameters.add(new ClientBehaviorContext.Parameter("gisfaces.altitudeAccuracy", "Number(position.coords.altitudeAccuracy)"));
			parameters.add(new ClientBehaviorContext.Parameter("gisfaces.heading", "Number(position.coords.heading)"));
			parameters.add(new ClientBehaviorContext.Parameter("gisfaces.speed", "Number(position.coords.speed)"));

			// Generate an event for registered listeners.
			for (ClientBehavior behavior : behaviors) {
				// Generate the callback script.
				ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.GEOLOCATION.toString(),
						this.getClientId(), parameters);
				String script = behavior.getScript(cbc);

				// Remove extraneous parameter value quotes.
				script = ComponentUtilities.removeScriptParameterValueQuotes(script, parameters);

				// Generate the ajax script.
				writer.write(script + ";");
			}
		}

		writer.write("};");
	}
}
