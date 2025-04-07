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
import com.gisfaces.event.MapBasemapEvent;
import com.gisfaces.event.MapClickEvent;
import com.gisfaces.event.MapDimensionEvent;
import com.gisfaces.event.MapExtentEvent;
import com.gisfaces.event.MapGeoLocationEvent;
import com.gisfaces.event.MapGraphicCreateEvent;
import com.gisfaces.event.MapGraphicDeleteEvent;
import com.gisfaces.event.MapGraphicUpdateEvent;
import com.gisfaces.event.MapSelectEvent;
import com.gisfaces.model.geometry.Extent;
import com.gisfaces.model.geometry.Geometry;
import com.gisfaces.model.geometry.GeometryFactory;
import com.gisfaces.model.geometry.SpatialReference;
import com.gisfaces.model.graphic.Graphic;
import com.gisfaces.model.layer.CSVLayer;
import com.gisfaces.model.layer.FeatureLayer;
import com.gisfaces.model.layer.GeoJSONLayer;
import com.gisfaces.model.layer.GeoRSSLayer;
import com.gisfaces.model.layer.GraphicsLayer;
import com.gisfaces.model.layer.ImageryLayer;
import com.gisfaces.model.layer.IntegratedMeshLayer;
import com.gisfaces.model.layer.KMLLayer;
import com.gisfaces.model.layer.Layer;
import com.gisfaces.model.layer.LayerType;
import com.gisfaces.model.layer.MapImageLayer;
import com.gisfaces.model.layer.PointCloudLayer;
import com.gisfaces.model.layer.PortalLayer;
import com.gisfaces.model.layer.SceneLayer;
import com.gisfaces.model.layer.StreamLayer;
import com.gisfaces.model.layer.TileLayer;
import com.gisfaces.model.layer.VectorTileLayer;
import com.gisfaces.model.layer.WMSLayer;
import com.gisfaces.model.layer.WMTSLayer;
import com.gisfaces.model.map.*;
import com.gisfaces.utilities.ComponentUtilities;
import com.gisfaces.utilities.StringUtilities;
import com.gisfaces.utilities.json.JSONException;
import com.gisfaces.utilities.json.JSONObject;
import com.gisfaces.utilities.json.JSONVisitor;
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
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 * GIS map custom component using the ESRI ArcGIS JavaScript API.
 *
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
@FacesComponent("com.gisfaces.component.Map")
@ResourceDependencies({@ResourceDependency(library = "javax.faces", name = "jsf.js", target = "head")})
public class UIMap extends UIComponentBase implements ClientBehaviorHolder {
    /**
     * Constructor.
     */
    public UIMap() {
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
        return Arrays.asList(Event.BASEMAP.toString(), Event.CLICK.toString(), Event.EXTENT.toString(), Event.SELECT.toString(), Event.DIMENSION.toString(),
                Event.GEOLOCATION.toString(), Event.GRAPHICCREATE.toString(), Event.GRAPHICUPDATE.toString(), Event.GRAPHICDELETE.toString());
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see javax.faces.component.UIComponentBase#getDefaultEventName()
	 */
    @Override
    public String getDefaultEventName() {
        return Event.CLICK.toString();
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

		if (ComponentUtilities.isComponentRequest(context, clientId)) {
			// Get the request parameters.
			Map<String, String> params = context.getExternalContext().getRequestParameterMap();

            // Get the ajax behavior event name.
            String name = params.get("javax.faces.behavior.event");

            if (Event.BASEMAP.toString().equals(name)) {
                // Check for registered event listeners.
                List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.BASEMAP.toString());
                if ((behaviors != null) && !behaviors.isEmpty()) {
                    // Get the request parameters.
                    String title = params.get("gisfaces.basemap.title");

					// Get the basemap based on the title, if possible.
					// The Basemap Gallery widget only sends a basemap title.
					// The map basemap must be set using a valid basemap ID, however.
					// The documentation does not explicitly map basemap IDs to titles.
					// Basemaps are free or licensed. Licensed basemaps cannot be set manually without login.
					Basemap b = Basemap.getBasemap(title);
					if (b != null) {
						// Set the new values in the managed bean.
						MapModel model = (MapModel) ComponentUtilities.getObjectAttribute(this, Constants.ATTRIBUTE_MODEL);
						if (model != null) {
							model.setBasemap(b);
						}

						// Send an event to all registered listeners.
						for (ClientBehavior behavior : behaviors) {
							// Create the custom map event.
							MapBasemapEvent event = new MapBasemapEvent(this, behavior);
							event.setBasemapTitle(title);

							// Send the event.
							queueEvent(event);
						}
					}
				}
			} else if (Event.CLICK.toString().equals(name)) {
				// Check for registered event listeners.
				List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.CLICK.toString());
				if ((behaviors != null) && !behaviors.isEmpty()) {
					// Get the request parameters.
					String latitude = params.get("gisfaces.latitude");
					String longitude = params.get("gisfaces.longitude");

                    // Send an event to all registered listeners.
                    for (ClientBehavior behavior : behaviors) {
                        // Create the custom map event.
                        MapClickEvent event = new MapClickEvent(this, behavior);
                        event.setLatitude(Double.parseDouble(latitude));
                        event.setLongitude(Double.parseDouble(longitude));

                        // Send the event.
                        queueEvent(event);
                    }
                }
            } else if (Event.EXTENT.toString().equals(name)) {
                // Get the request parameters.
                String latitude = params.get("gisfaces.latitude");
                String longitude = params.get("gisfaces.longitude");
                String zoom = params.get("gisfaces.zoom");
                String scale = params.get("gisfaces.scale");
                String wkid = params.get("gisfaces.extent.wkid");
                String xmin = params.get("gisfaces.extent.xmin");
                String ymin = params.get("gisfaces.extent.ymin");
                String xmax = params.get("gisfaces.extent.xmax");
                String ymax = params.get("gisfaces.extent.ymax");

				// Set the new values in the managed bean.
				MapModel model = (MapModel) ComponentUtilities.getObjectAttribute(this, Constants.ATTRIBUTE_MODEL);
				if (model != null) {
					model.getViewpoint().setLatitude(Double.parseDouble(latitude));
					model.getViewpoint().setLongitude(Double.parseDouble(longitude));
					model.getViewpoint().setZoom(Double.parseDouble(zoom));
				}

                // Check for registered event listeners.
                List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.EXTENT.toString());
                if ((behaviors != null) && !behaviors.isEmpty()) {
                    // Send an event to all registered listeners.
                    for (ClientBehavior behavior : behaviors) {
                        Extent extent = new Extent();
                        extent.setSpatialReference(new SpatialReference(Integer.parseInt(wkid)));
                        extent.setXmin(Double.parseDouble(xmin));
                        extent.setYmin(Double.parseDouble(ymin));
                        extent.setXmax(Double.parseDouble(xmax));
                        extent.setYmax(Double.parseDouble(ymax));

                        // Create the custom map event.
                        MapExtentEvent event = new MapExtentEvent(this, behavior);
                        event.setLatitude(Double.parseDouble(latitude));
                        event.setLongitude(Double.parseDouble(longitude));
                        event.setZoom(Double.parseDouble(zoom));
                        event.setScale(Double.parseDouble(scale));
                        event.setExtent(extent);

                        // Send the event.
                        queueEvent(event);
                    }
                }
            } else if (Event.SELECT.toString().equals(name)) {
                // Check for registered event listeners.
                List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.SELECT.toString());
                if ((behaviors != null) && !behaviors.isEmpty()) {
                    // Get the request parameters.
                    String id = params.get("gisfaces.id");
                    String layerId = params.get("gisfaces.layerId");
                    String sublayerId = params.get("gisfaces.sublayerId");
                    String attribsJson = StringUtilities.decode(params.get("gisfaces.attributes"));

                    // Convert json strings to maps.
                    Map<String, Object> attribsMap = StringUtilities.toMap(attribsJson);

                    // Send an event to all registered listeners.
                    for (ClientBehavior behavior : behaviors) {
                        // Create the custom map event.
                        MapSelectEvent event = new MapSelectEvent(this, behavior);
                        event.setGraphicId(id);
                        event.setLayerId(layerId);
                        event.setSubLayerId(sublayerId);
                        event.setAttributesJson(attribsJson);
                        event.setAttributesMap(attribsMap);

                        // Send the event.
                        queueEvent(event);
                    }
                }
            } else if (Event.DIMENSION.toString().equals(name)) {
                // Check for registered event listeners.
                List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.DIMENSION.toString());
                if ((behaviors != null) && !behaviors.isEmpty()) {
                    // Get the request parameters.
                    String dimension = params.get("gisfaces.dimension");

                    // Set the new values in the managed bean.
                    MapModel model = (MapModel) ComponentUtilities.getObjectAttribute(this, Constants.ATTRIBUTE_MODEL);
                    if (model != null) {
                        model.setMapDimension(MapDimension.getMapDimensionByValue(dimension));
                    }

                    // Send an event to all registered listeners.
                    for (ClientBehavior behavior : behaviors) {
                        // Create the custom map event.
                        MapDimensionEvent event = new MapDimensionEvent(this, behavior);
                        event.setDimension(MapDimension.getMapDimensionByValue(dimension));

                        // Send the event.
                        queueEvent(event);
                    }
                }
            } else if (Event.GEOLOCATION.toString().equals(name)) {
                // Get the request parameters.
                String timestamp = params.get("gisfaces.timestamp");
                String latitude = params.get("gisfaces.latitude");
                String longitude = params.get("gisfaces.longitude");
                String altitude = params.get("gisfaces.altitude");
                String accuracy = params.get("gisfaces.accuracy");
                String altitudeAccuracy = params.get("gisfaces.altitudeAccuracy");
                String heading = params.get("gisfaces.heading");
                String speed = params.get("gisfaces.speed");

                // Set the new values in the managed bean.
                MapModel model = (MapModel) ComponentUtilities.getObjectAttribute(this, Constants.ATTRIBUTE_MODEL);
                if (model != null) {
                    model.getViewpoint().setLatitude(Double.parseDouble(latitude));
                    model.getViewpoint().setLongitude(Double.parseDouble(longitude));
                }

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
            } else if (Event.GRAPHICCREATE.toString().equals(name)) {
                // Check for registered event listeners.
                List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.GRAPHICCREATE.toString());
                if ((behaviors != null) && !behaviors.isEmpty()) {
                    // Get the request parameters.
                    String layerId = params.get("gisfaces.layerId");
                    String graphicId = params.get("gisfaces.graphicId");
                    String geometryType = params.get("gisfaces.geometryType");
                    String geometryJson = params.get("gisfaces.geometryJson");

                    try {
                        // Create a JSON object from the geometry JSON parameters.
                        JSONObject jo = new JSONObject(geometryJson);
                        jo.put("type", geometryType);

                        // Create the graphic geometry.
                        Geometry geometry = new GeometryFactory().create(jo);

                        // Send an event to all registered listeners.
                        for (ClientBehavior behavior : behaviors) {
                            // Create the custom map event.
                            MapGraphicCreateEvent event = new MapGraphicCreateEvent(this, behavior);
                            event.setLayerId(layerId);
                            event.setGraphicId(graphicId);
                            event.setGeometry(geometry);

                            // Send the event.
                            queueEvent(event);
                        }
                    } catch (JSONException e) {
                        throw new IllegalArgumentException("An error occurred processing graphic JSON geometry.", e);
                    }
                }
            } else if (Event.GRAPHICUPDATE.toString().equals(name)) {
                // Check for registered event listeners.
                List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.GRAPHICUPDATE.toString());
                if ((behaviors != null) && !behaviors.isEmpty()) {
                    // Get the request parameters.
                    String layerId = params.get("gisfaces.layerId");
                    String graphicId = params.get("gisfaces.graphicId");
                    String geometryType = params.get("gisfaces.geometryType");
                    String geometryJson = params.get("gisfaces.geometryJson");

                    try {
                        // Create a JSON object from the geometry JSON parameters.
                        JSONObject jo = new JSONObject(geometryJson);
                        jo.put("type", geometryType);

                        // Create the graphic geometry.
                        Geometry geometry = new GeometryFactory().create(jo);

                        // Send an event to all registered listeners.
                        for (ClientBehavior behavior : behaviors) {
                            // Create the custom map event.
                            MapGraphicUpdateEvent event = new MapGraphicUpdateEvent(this, behavior);
                            event.setLayerId(layerId);
                            event.setGraphicId(graphicId);
                            event.setGeometry(geometry);

                            // Send the event.
                            queueEvent(event);
                        }
                    } catch (JSONException e) {
                        throw new IllegalArgumentException("An error occurred processing graphic JSON geometry.", e);
                    }
                }
            } else if (Event.GRAPHICDELETE.toString().equals(name)) {
                // Check for registered event listeners.
                List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.GRAPHICDELETE.toString());
                if ((behaviors != null) && !behaviors.isEmpty()) {
                    // Get the request parameters.
                    String layerId = params.get("gisfaces.layerId");
                    String graphicId = params.get("gisfaces.graphicId");

                    // Send an event to all registered listeners.
                    for (ClientBehavior behavior : behaviors) {
                        // Create the custom map event.
                        MapGraphicDeleteEvent event = new MapGraphicDeleteEvent(this, behavior);
                        event.setLayerId(layerId);
                        event.setGraphicId(graphicId);

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
        // Get the component attributes.
        String panel = ComponentUtilities.getStringAttribute(this, Constants.ATTRIBUTE_PANEL);
        MapModel model = (MapModel) ComponentUtilities.getObjectAttribute(this, Constants.ATTRIBUTE_MODEL);

        // Set a default map model if not explicitly defined.
        if (model == null) {
            model = new MapModel();
        }

        // 3D indicator.
        boolean is3d = MapDimension.THREE_D.equals(model.getMapDimension());

        // Get the component client ID.
        String clientId = this.getClientId();

        // Qualify the specified panel component element IDs.
        panel = ComponentUtilities.qualifyClientId(clientId, panel);

        // Get the response writer.
        ResponseWriter writer = context.getResponseWriter();

        // Encode custom component html with client ID necessary for event
        // functionality.
        writer.startElement("span", this);
        writer.writeAttribute("id", clientId, null);
        writer.endElement("span");

        if (!context.isPostback()) {
            // Encode ESRI JSAPI resources.
            writer.write(String.format("<link rel='stylesheet' type='text/css' href='%s/esri/themes/%s/main.css'></link>",
                    model.getConfiguration().getJsApiUrl(), model.getMapTheme().getValue()));
            writer.write(String.format("<script type='text/javascript' src='%s'></script>", model.getConfiguration().getJsApiUrl()));

            // Encode the GISFaces resources.
            writer.write(String.format("<link rel='stylesheet' type='text/css' href='%s'></link>",
                    ComponentUtilities.getResource(context, "css", "gisfaces.css").getRequestPath()));
            writer.write(String.format("<script type='text/javascript' src='%s'></script>",
                    ComponentUtilities.getResource(context, "javascript", "gisfaces.js").getRequestPath()));
        }

        // Encode the javascript block open.
        writer.startElement("script", this);
        writer.writeAttribute("type", "text/javascript", null);

        if (!context.isPostback()) {
            // Encode the initialization function.
            writer.write("com.gisfaces.initializeMapView = function() {");

            // Detect WebGL support.
            writer.write("com.gisfaces.getWebGLSupportLevel();");

            // Encode the local service configuration overrides.
            if ((model != null) && (model.getConfiguration() != null)) {
                Configuration config = model.getConfiguration();

                if (config.getGeometryServiceUrl() != null) {
                    // Encode the local geometry service URL.
                    writer.write(String.format("com.gisfaces.setGeometryService('%s');", config.getGeometryServiceUrl()));
                }

                if (config.getGeoRssServiceUrl() != null) {
                    // Encode the local geoRSS service URL.
                    writer.write(String.format("com.gisfaces.setGeoRssService('%s');", config.getGeoRssServiceUrl()));
                }

                if (config.getKmlServiceUrl() != null) {
                    // Encode the local KML service URL.
                    writer.write(String.format("com.gisfaces.setKmlService('%s');", config.getKmlServiceUrl()));
                }

                if (config.getPortalUrl() != null) {
                    // Encode the local portal service URL.
                    writer.write(String.format("com.gisfaces.setPortalService('%s');", config.getPortalUrl()));
                }

                if (config.isProxyEnabled()) {
                    // Get the proxy url override.
                    String url = config.getProxyUrl();
                    if (url == null) {
                        // Build the url to the included proxy page.
                        ExternalContext ec = context.getExternalContext();
                        url = String.format("%s://%s:%s%s%s", ec.getRequestScheme(), ec.getRequestServerName(), ec.getRequestServerPort(),
                                ec.getRequestContextPath(), Constants.DEFAULT_PROXY_PAGE);
                    }

                    // Encode the local proxy service URL.
                    writer.write(String.format("com.gisfaces.setProxyService('%s');", url));
                }
            }

            // Encode the JSF client ID.
            writer.write(String.format("com.gisfaces.clientId = '%s';", clientId));

			// Encode the map.
			if (model.getWebMapPortalItemId() != null) {
				// Encode the web map portal item.
				writer.write(String.format("com.gisfaces.createWebMap('%s');", model.getWebMapPortalItemId()));
			} else {
				if (is3d) {
					// Encode the map.
					// 3d map ground layer "world-topobathymetry" uses "world-elevation" for land
					// and includes oceans.
					writer.write(String.format("com.gisfaces.createMap('%s', 'world-topobathymetry');", model.getBasemap().getId()));
				} else {
					// Encode the 2d map.
					writer.write(String.format("com.gisfaces.createMap('%s', null);", model.getBasemap().getId()));
				}
			}

            // Encode the view.
            if (is3d) {
                // Encode a 3d scene view.
                writer.write(String.format("com.gisfaces.createSceneView('%s', %s, %s, %s);", panel, model.getViewpoint().getLatitude(),
                        model.getViewpoint().getLongitude(), model.getViewpoint().getZoom()));
            } else {
                // Encode a 2d map view.
                writer.write(String.format("com.gisfaces.createMapView('%s', %s, %s, %s);", panel, model.getViewpoint().getLatitude(),
                        model.getViewpoint().getLongitude(), model.getViewpoint().getZoom()));
            }

            // Encode all map widgets.
            if (model.getMapWidgets() == null) {
                writer.write("com.gisfaces.createAllWidgets();");
            } else {
                for (Widget widget : model.getMapWidgets()) {
                    writer.write("com.gisfaces.create" + widget.getValue() + "();");
                }
            }

            // Encode all map layers.
            this.encodeMapLayers(context, this, writer, model);

            // Encode the JSF application callback registrations.
            writer.write("com.gisfaces.addMapBasemapListener(com.gisfaces.generateJsfMapBasemapEvent);");
            writer.write("com.gisfaces.addMapClickListener(com.gisfaces.generateJsfMapClickEvent);");
            writer.write("com.gisfaces.addMapExtentListener(com.gisfaces.generateJsfMapExtentEvent);");
            writer.write("com.gisfaces.addMapSelectListener(com.gisfaces.generateJsfMapSelectEvent);");
            writer.write("com.gisfaces.addMapDimensionListener(com.gisfaces.generateJsfMapDimensionEvent);");
            writer.write("com.gisfaces.addMapGeoLocationListener(com.gisfaces.generateJsfMapGeoLocationEvent);");
            writer.write("com.gisfaces.addMapGraphicCreateListener(com.gisfaces.generateJsfMapGraphicCreateEvent);");
            writer.write("com.gisfaces.addMapGraphicUpdateListener(com.gisfaces.generateJsfMapGraphicUpdateEvent);");
            writer.write("com.gisfaces.addMapGraphicDeleteListener(com.gisfaces.generateJsfMapGraphicDeleteEvent);");

            writer.write("};");

            // Encode the JSF client behavior functions.
            this.encodeJsfMapBasemapFunction(context, this, writer);
            this.encodeJsfMapClickFunction(context, this, writer);
            this.encodeJsfMapExtentFunction(context, this, writer);
            this.encodeJsfMapSelectFunction(context, this, writer);
            this.encodeJsfMapDimensionFunction(context, this, writer);
            this.encodeJsfMapGeoLocationFunction(context, this, writer);
            this.encodeJsfMapGraphicCreateFunction(context, this, writer);
            this.encodeJsfMapGraphicUpdateFunction(context, this, writer);
            this.encodeJsfMapGraphicDeleteFunction(context, this, writer);

            // Invoke initialization once all modules are loaded.
            writer.write("com.gisfaces.addDomLoadedListener(com.gisfaces.initializeMapView);");
        } else {
            // Update the map extent.
            writer.write(String.format("com.gisfaces.zoomToCoordinate(%s, %s, %s);", model.getViewpoint().getLatitude(), model.getViewpoint().getLongitude(),
                    model.getViewpoint().getZoom()));

			// Update the map basemap layer.
			// The BasemapGallery widget sends a basemap title and not ID necessary to update correctly.
			// The decode() method saves the basemap based upon title, if possible.
			//writer.write(String.format("com.gisfaces.setMapBasemap('%s');", model.getBasemap().getId()));

            // Encode all map layers.
            this.encodeMapLayers(context, this, writer, model);
        }

        // Encode the javascript block close.
        writer.endElement("script");
    }

    /**
     * Method to encode all map layers.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @param model     MapModel
     * @throws IOException
     */
    private void encodeMapLayers(FacesContext context, UIComponent component, ResponseWriter writer, MapModel model) throws IOException {
        // Encode map layer removals.
        this.encodeMapLayerRemovals(context, component, writer, model);

        // Encode map layer inserts and updates.
        this.encodeMapLayerUpdates(context, component, writer, model);
    }

    /**
     * Method to encode map layer removals.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @param model     MapModel
     * @throws IOException
     */
    private void encodeMapLayerRemovals(FacesContext context, UIComponent component, ResponseWriter writer, MapModel model) throws IOException {
        if (model != null) {
            // Build a list of the currently specified layer IDs.
            List<String> ids = new ArrayList<String>();
            if (model.getLayers() != null) {
                for (Layer layer : model.getLayers()) {
                    ids.add(String.format("'%s'", layer.getId()));
                }
            }

            // Synchronize the layers for possible removals.
            writer.write(String.format("com.gisfaces.syncLayers([%s]);", String.join(",", ids)));
        }
    }

    /**
     * Method to encode map layer inserts and updates.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @param model     MapModel
     * @throws IOException
     */
    private void encodeMapLayerUpdates(FacesContext context, UIComponent component, ResponseWriter writer, MapModel model) throws IOException {
        if ((model != null) && (model.getLayers() != null)) {
            // Process all defined layers.
            List<Layer> layers = model.getLayers();
            for (int i = 0; i < layers.size(); i++) {
                // Get the layer.
                Layer layer = layers.get(i);

                if (layer instanceof CSVLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((CSVLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.CSV.toString(), jo, i, false));
                } else if (layer instanceof FeatureLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((FeatureLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.FEATURE.toString(), jo, i, false));
                } else if (layer instanceof GeoJSONLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((GeoJSONLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.GEOJSON.toString(), jo, i, false));
                } else if (layer instanceof GeoRSSLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((GeoRSSLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.GEO_RSS.toString(), jo, i, false));
                } else if (layer instanceof GraphicsLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((GraphicsLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    // Remove the graphics and manually add.
                    jo.remove("graphics");

                    // Add/update the layer.
                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.GRAPHICS.toString(), jo, i, false));

                    if (!context.isPostback()) {
                        // Enable sketch widget.
                        if (((GraphicsLayer) layer).isEditable()) {
                            writer.write(String.format("com.gisfaces.createSketchWidget(com.gisfaces.findLayer('%s'));", layer.getId()));
                        }
                    }

                    // Process layer graphics only when visible.
                    if (((GraphicsLayer) layer).getVisible()) {
                        // Remove all existing graphics.
                        writer.write(String.format("com.gisfaces.removeAllGraphics('%s');", layer.getId()));

                        // Add defined graphics.
                        if (((GraphicsLayer) layer).getGraphics() != null) {
                            for (Graphic g : ((GraphicsLayer) layer).getGraphics()) {
                                JSONObject gjo = new JSONObject(g, true);
                                this.sanitizeJsonObject(gjo);
                                writer.write(String.format("com.gisfaces.addGraphic('%s', com.gisfaces.createGraphic(%s));", layer.getId(), gjo));
                            }
                        }
                    }
                } else if (layer instanceof ImageryLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((ImageryLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.IMAGERY.toString(), jo, i, false));
                } else if (layer instanceof IntegratedMeshLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((IntegratedMeshLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.INTEGRATED_MESH.toString(), jo, i, false));
                } else if (layer instanceof KMLLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((KMLLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.KML.toString(), jo, i, false));
                } else if (layer instanceof MapImageLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((MapImageLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    if (((MapImageLayer) layer).getSublayers().isEmpty()) {
                        // Remove the sublayers key if not explicitly specified.
                        jo.remove("sublayers");
                    }

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.MAP_IMAGE.toString(), jo, i, false));
                } else if (layer instanceof PointCloudLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((PointCloudLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    // Opacity is not supported on point cloud layers.
                    jo.remove("opacity");

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.POINT_CLOUD.toString(), jo, i, false));
                } else if (layer instanceof PortalLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((PortalLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.PORTAL.toString(), jo, i, false));
                } else if (layer instanceof SceneLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((SceneLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.SCENE.toString(), jo, i, false));
                } else if (layer instanceof StreamLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((StreamLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.STREAM.toString(), jo, i, false));
                } else if (layer instanceof TileLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((TileLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.TILE.toString(), jo, i, false));
                } else if (layer instanceof VectorTileLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((VectorTileLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.VECTOR_TILE.toString(), jo, i, false));
                } else if (layer instanceof WMSLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((WMSLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.WMS.toString(), jo, i, false));
                } else if (layer instanceof WMTSLayer) {
                    // Build a JSON object from the layer.
                    JSONObject jo = new JSONObject((WMTSLayer) layer, true);
                    this.sanitizeJsonObject(jo);

                    writer.write(String.format("com.gisfaces.processLayer('%s', %s, %d, %b);", LayerType.WMTS.toString(), jo, i, false));
                }
            }
        }
    }

    /**
     * Method to sanitize the JSON object before usage.
     *
     * @param jo JSONObject.
     */
    private void sanitizeJsonObject(JSONObject jo) {
        try {
            JSONVisitor visitor = new JSONVisitor(jo);
            visitor.visit(new JSONVisitor.Filter() {
                @Override
                public void accept(JSONObject jo, String key) {
                    if (jo.isNull(key) || "class".equals(key)) {
                        jo.remove(key);
                    }
                }
            });
        } catch (JSONException e) {
            throw new IllegalArgumentException("An error occurred processing JSON nodes.", e);
        }
    }

    /**
     * Method to encode the function which generates a JSF map basemap AJAX event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapBasemapFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapBasemapEvent = function(title) {");

        // Get the list of client behavior event listeners specified.
        List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.BASEMAP.toString());

        if ((behaviors != null) && !behaviors.isEmpty()) {
            writer.write("var event = null;");

            // Add parameters for decode.
            List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.basemap.title", "title"));

            // Generate an event for registered listeners.
            for (ClientBehavior behavior : behaviors) {
                // Generate the callback script.
                ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.BASEMAP.toString(), this.getClientId(),
                        parameters);
                String script = behavior.getScript(cbc);

                // Remove extraneous parameter value quotes.
                script = ComponentUtilities.removeScriptParameterValueQuotes(script, parameters);

                // Generate the ajax script.
                writer.write(script + ";");
            }
        }

        writer.write("};");
    }

    /**
     * Method to encode the function which generates a JSF map click AJAX event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapClickFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapClickEvent = function(e) {");

        // Get the list of client behavior event listeners specified.
        List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.CLICK.toString());

        if ((behaviors != null) && !behaviors.isEmpty()) {
            writer.write("var event = null;");

            // Add parameters for decode.
            List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.latitude", "e.mapPoint.latitude"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.longitude", "e.mapPoint.longitude"));

            // Generate an event for registered listeners.
            for (ClientBehavior behavior : behaviors) {
                // Generate the callback script.
                ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.CLICK.toString(), this.getClientId(),
                        parameters);
                String script = behavior.getScript(cbc);

                // Remove extraneous parameter value quotes.
                script = ComponentUtilities.removeScriptParameterValueQuotes(script, parameters);

                // Generate the ajax script.
                writer.write(script + ";");
            }
        }

        writer.write("};");
    }

    /**
     * Method to encode the function which generates a JSF map extent change AJAX
     * event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapExtentFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapExtentEvent = function(view) {");

        // Get the list of client behavior event listeners specified.
        List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.EXTENT.toString());

        if ((behaviors != null) && !behaviors.isEmpty()) {
            writer.write("var event = null;");
            writer.write("var extent = com.gisfaces.convertGeometryToGeographicUnits(view.extent);");

            // Add parameters for decode.
            List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.latitude", "view.center.latitude"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.longitude", "view.center.longitude"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.zoom", "view.zoom"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.scale", "view.scale"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.extent.wkid", "extent.spatialReference.wkid"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.extent.xmin", "extent.xmin"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.extent.ymin", "extent.ymin"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.extent.xmax", "extent.xmax"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.extent.ymax", "extent.ymax"));

            // Generate an event for registered listeners.
            for (ClientBehavior behavior : behaviors) {
                // Generate the callback script.
                ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.EXTENT.toString(), this.getClientId(),
                        parameters);
                String script = behavior.getScript(cbc);

                // Remove extraneous parameter value quotes.
                script = ComponentUtilities.removeScriptParameterValueQuotes(script, parameters);

                // Generate the ajax script.
                writer.write(script + ";");
            }
        }

        writer.write("};");
    }

    /**
     * Method to encode the function which generates a JSF map select AJAX event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapSelectFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapSelectEvent = function(graphic) {");

        // Get the list of client behavior event listeners specified.
        List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.SELECT.toString());

        if ((behaviors != null) && !behaviors.isEmpty()) {
            writer.write("var event = null;");

            // Get the ID of the selected graphic.
            writer.write("var id = graphic.get('id') || '';");

            // Get the source information.
            // Attempt to get MapImageLayer layer and sublayer source.
            writer.write("var layerId = graphic.get('sourceLayer.parent.id') || '';");
            writer.write("var sublayerId = graphic.get('sourceLayer.id') || '';");
            // Attempt to get the GraphicsLayer and CSVLayer local layer source, if
            // necessary.
            writer.write("if (!layerId) { layerId = graphic.get('layer.id') || ''; }");

            // Get the graphic attributes.
            writer.write("var attribs = escape(JSON.stringify(graphic.attributes));");

            // Add parameters for decode.
            List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.id", "id"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.layerId", "layerId"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.sublayerId", "sublayerId"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.attributes", "attribs"));

            // Generate an event for registered listeners.
            for (ClientBehavior behavior : behaviors) {
                // Generate the callback script.
                ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.SELECT.toString(), this.getClientId(),
                        parameters);
                String script = behavior.getScript(cbc);

                // Remove extraneous parameter value quotes.
                script = ComponentUtilities.removeScriptParameterValueQuotes(script, parameters);

                // Generate the ajax script.
                writer.write(script + ";");
            }
        }

        writer.write("};");
    }

    /**
     * Method to encode the function which generates a JSF map dimension AJAX event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapDimensionFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapDimensionEvent = function(view) {");

        // Get the list of client behavior event listeners specified.
        List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.DIMENSION.toString());

        if ((behaviors != null) && !behaviors.isEmpty()) {
            writer.write("var event = null;");

            // Add parameters for decode.
            List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.dimension", "view.type"));

			// Generate an event for registered listeners.
			for (ClientBehavior behavior : behaviors) {
				// Generate the callback script.
				ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.DIMENSION.toString(),
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

    /**
     * Method to encode the function which generates a JSF map geolocation AJAX
     * event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapGeoLocationFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapGeoLocationEvent = function(position) {");

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

    /**
     * Method to encode the function which generates a JSF map graphic create AJAX
     * event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapGraphicCreateFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapGraphicCreateEvent = function(e) {");

        // Get the list of client behavior event listeners specified.
        List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.GRAPHICCREATE.toString());

        if ((behaviors != null) && !behaviors.isEmpty()) {
            writer.write("var event = null;");

            // Get the graphic layer and graphic data.
            writer.write("var layerId = e.graphic.layer.id || '';");
            writer.write("var graphicId = e.graphic.id || '';");
            writer.write("var geometryType = e.graphic.geometry.type;");
            writer.write("var geometryJson = JSON.stringify(com.gisfaces.convertGeometryToGeographicUnits(e.graphic.geometry));");

            // Add parameters for decode.
            List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.layerId", "layerId"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.graphicId", "graphicId"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.geometryType", "geometryType"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.geometryJson", "geometryJson"));

            // Generate an event for registered listeners.
            for (ClientBehavior behavior : behaviors) {
                // Generate the callback script.
                ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.GRAPHICCREATE.toString(),
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

    /**
     * Method to encode the function which generates a JSF map graphic update AJAX
     * event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapGraphicUpdateFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapGraphicUpdateEvent = function(e) {");

        // Get the list of client behavior event listeners specified.
        List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.GRAPHICUPDATE.toString());

        if ((behaviors != null) && !behaviors.isEmpty()) {
            writer.write("var event = null;");

            // Iterate over event graphics array.
            writer.write("e.graphics.forEach(function(item) {");

            // Get the graphic layer and graphic data.
            writer.write("var layerId = item.get('layer.id') || '';");
            writer.write("var graphicId = item.id || '';");
            writer.write("var geometryType = item.geometry.type;");
            writer.write("var geometryJson = JSON.stringify(com.gisfaces.convertGeometryToGeographicUnits(item.geometry));");

            // Add parameters for decode.
            List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.layerId", "layerId"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.graphicId", "graphicId"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.geometryType", "geometryType"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.geometryJson", "geometryJson"));

            // Generate an event for registered listeners.
            for (ClientBehavior behavior : behaviors) {
                // Generate the callback script.
                ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.GRAPHICUPDATE.toString(),
                        this.getClientId(), parameters);
                String script = behavior.getScript(cbc);

                // Remove extraneous parameter value quotes.
                script = ComponentUtilities.removeScriptParameterValueQuotes(script, parameters);

                // Generate the ajax script.
                writer.write(script + ";");
            }

            writer.write("});");
        }

        writer.write("};");
    }

    /**
     * Method to encode the function which generates a JSF map graphic delete AJAX
     * event.
     *
     * @param context   FacesContext
     * @param component UIComponent
     * @param writer    ResponseWriter
     * @throws IOException
     */
    private void encodeJsfMapGraphicDeleteFunction(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
        writer.write("com.gisfaces.generateJsfMapGraphicDeleteEvent = function(e) {");

        // Get the list of client behavior event listeners specified.
        List<ClientBehavior> behaviors = this.getClientBehaviors().get(Event.GRAPHICDELETE.toString());

        if ((behaviors != null) && !behaviors.isEmpty()) {
            writer.write("var event = null;");

            // Iterate over event graphics array.
            writer.write("e.graphics.forEach(function(item) {");

            // Get the graphic layer and graphic data.
            writer.write("var layerId = item.get('layer.id') || '';");
            writer.write("var graphicId = item.id || '';");

            // Add parameters for decode.
            List<ClientBehaviorContext.Parameter> parameters = new ArrayList<ClientBehaviorContext.Parameter>();
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.layerId", "layerId"));
            parameters.add(new ClientBehaviorContext.Parameter("gisfaces.graphicId", "graphicId"));

            // Generate an event for registered listeners.
            for (ClientBehavior behavior : behaviors) {
                // Generate the callback script.
                ClientBehaviorContext cbc = ClientBehaviorContext.createClientBehaviorContext(context, component, Event.GRAPHICDELETE.toString(),
                        this.getClientId(), parameters);
                String script = behavior.getScript(cbc);

                // Remove extraneous parameter value quotes.
                script = ComponentUtilities.removeScriptParameterValueQuotes(script, parameters);

                // Generate the ajax script.
                writer.write(script + ";");
            }

            writer.write("});");
        }

        writer.write("};");
    }
}
