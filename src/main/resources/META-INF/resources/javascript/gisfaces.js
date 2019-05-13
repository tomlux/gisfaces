/* Copyright © 2013-2019 Chris Duncan (cduncan@gisfaces.com) - All Rights Reserved */

/**
 * GISFaces map library for ESRI JSAPI 4.x.
 * @author Chris Duncan (cduncan@gisfaces.com)
 */

// Create the gisfaces namespace.
if (!com) var com = {};
if (!com.gisfaces) com.gisfaces = {
	/**
	 * Function to add an application listener on DOM and ESRI JSAPI load completion.
	 */
	addDomLoadedListener: function(f) {
		com.gisfaces.domLoadedListener = f;
	},

	/**
	 * Function to add an application listener on map and view load completion.
	 */
	addMapLoadedListener: function(f) {
		com.gisfaces.mapLoadedListener = f;
	}
};

// Handler for DOM and API loaded listener.
require(["dojo/ready"], function(ready) {
	ready(function() {
		console.log("DOM and API loaded.");

		// Invoke registered listener.
		if (com.gisfaces.domLoadedListener) {
			com.gisfaces.domLoadedListener();
		}
	});
});

// Create the map functions using the ESRI JavaScript library.
require([
	"esri/Color",
	"esri/config",
	"esri/Graphic",
	"esri/Map",
	"esri/WebMap",
	"esri/WebScene",
	"esri/core/urlUtils",
	"esri/core/watchUtils",
	"esri/views/MapView",
	"esri/views/SceneView",
	"esri/layers/CSVLayer",
	"esri/layers/FeatureLayer",
	"esri/layers/GeoJSONLayer",
	"esri/layers/GeoRSSLayer",
	"esri/layers/GraphicsLayer",
	"esri/layers/ImageryLayer",
	"esri/layers/IntegratedMeshLayer",
	"esri/layers/KMLLayer",
	"esri/layers/Layer",
	"esri/layers/MapImageLayer",
	"esri/layers/PointCloudLayer",
	"esri/layers/SceneLayer",
	"esri/layers/StreamLayer",
	"esri/layers/TileLayer",
	"esri/layers/VectorTileLayer",
	"esri/layers/WMSLayer",
	"esri/layers/WMTSLayer",
	"esri/geometry/Extent",
	"esri/geometry/Point",
	"esri/geometry/Polyline",
	"esri/geometry/Polygon",
	"esri/geometry/support/webMercatorUtils",
	"esri/symbols/SimpleMarkerSymbol",
	"esri/symbols/SimpleLineSymbol",
	"esri/symbols/SimpleFillSymbol",
	"esri/symbols/PictureMarkerSymbol",
	"esri/symbols/TextSymbol",
	"esri/widgets/BasemapGallery",
	"esri/widgets/CoordinateConversion",
	"esri/widgets/Compass",
	"esri/widgets/Directions",
	"esri/widgets/Expand",
	"esri/widgets/Fullscreen",
	"esri/widgets/LayerList",
	"esri/widgets/Legend",
	"esri/widgets/Locate",
	"esri/widgets/Print",
	"esri/widgets/ScaleBar",
	"esri/widgets/Search",
	"esri/widgets/Sketch",
	"esri/widgets/Track",
	"dojo/domReady!"
], function(
	Color,
	esriConfig,
	Graphic,
	Map,
	WebMap,
	WebScene,
	urlUtils,
	watchUtils,
	MapView,
	SceneView,
	CSVLayer,
	FeatureLayer,
	GeoJSONLayer,
	GeoRSSLayer,
	GraphicsLayer,
	ImageryLayer,
	IntegratedMeshLayer,
	KMLLayer,
	Layer,
	MapImageLayer,
	PointCloudLayer,
	SceneLayer,
	StreamLayer,
	TileLayer,
	VectorTileLayer,
	WMSLayer,
	WMTSLayer,
	Extent,
	Point,
	Polyline,
	Polygon,
	webMercatorUtils,
	SimpleMarkerSymbol,
	SimpleLineSymbol,
	SimpleFillSymbol,
	PictureMarkerSymbol,
	TextSymbol,
	BasemapGallery,
	CoordinateConversion,
	Compass,
	Directions,
	Expand,
	Fullscreen,
	LayerList,
	Legend,
	Locate,
	Print,
	ScaleBar,
	Search,
	Sketch,
	Track
) {
	/**
	 * Function to add an application listener on a map basemap update.
	 * The map click event will be passed to the listener.
	 */
	com.gisfaces.addMapBasemapListener = function(f) {
		com.gisfaces.mapBasemapListener = f;
	}

	/**
	 * Function to add an application listener on a map click.
	 * The map click event will be passed to the listener.
	 */
	com.gisfaces.addMapClickListener = function(f) {
		com.gisfaces.mapClickListener = f;
	}

	/**
	 * Function to add an application listener on a map extent update.
	 * The map view will be passed to the listener.
	 */
	com.gisfaces.addMapExtentListener = function(f) {
		com.gisfaces.mapExtentListener = f;
	}

	/**
	 * Function to add an application listener on a map graphic create.
	 * The map view will be passed to the listener.
	 */
	com.gisfaces.addMapGraphicCreateListener = function(f) {
		com.gisfaces.mapGraphicCreateListener = f;
	}

	/**
	 * Function to add an application listener on a map graphic update.
	 * The map view will be passed to the listener.
	 */
	com.gisfaces.addMapGraphicUpdateListener = function(f) {
		com.gisfaces.mapGraphicUpdateListener = f;
	}

	/**
	 * Function to add an application listener on a map graphic delete.
	 * The map view will be passed to the listener.
	 */
	com.gisfaces.addMapGraphicDeleteListener = function(f) {
		com.gisfaces.mapGraphicDeleteListener = f;
	}

	/**
	 * Function to add an application listener on a map popup select.
	 * The selected map popup feature will be passed to the listener.
	 */
	com.gisfaces.addMapSelectListener = function(f) {
		com.gisfaces.mapSelectListener = f;
	}

	/**
	 * Function to add an application listener on a map geolocation event.
	 * The geolocation event will be passed to the listener.
	 */
	com.gisfaces.addMapGeoLocationListener = function(f) {
		com.gisfaces.mapGeoLocationListener = f;
	}

	/**
	 * Function to add an application listener on a graphic click.
	 * The graphic attributes will be passed to the listener.
	 */
	com.gisfaces.addGraphicClickListener = function(f) {
		com.gisfaces.graphicClickListener = f;
	}

	/**
	 * Function to set the geometry service.
	 * @param url Service URL.
	 */
	com.gisfaces.setGeometryService = function(url) {
		esriConfig.geometryServiceUrl = url;
	}

	/**
	 * Function to set the GeoRSS service.
	 * @param url Service URL.
	 */
	com.gisfaces.setGeoRssService = function(url) {
		esriConfig.geoRSSServiceUrl = url;
	}

	/**
	 * Function to set the KML service.
	 * @param url Service URL.
	 */
	com.gisfaces.setKmlService = function(url) {
		esriConfig.kmlServiceUrl = url;
	}

	/**
	 * Function to set the portal service.
	 * @param url Service URL.
	 */
	com.gisfaces.setPortalService = function(url) {
		esriConfig.portalUrl = url;
	}

	/**
	 * Function to set the service service.
	 * @param url Service URL.
	 */
	com.gisfaces.setProxyService = function(url) {
		esriConfig.request.proxyUrl = url;
	}

	/**
	 * Function to create the map widget.
	 * @param basemap Must be "streets", "satellite", "hybrid", "topo", "gray", "dark-gray", "oceans", "national-geographic", "terrain", "osm", "dark-gray-vector", "gray-vector", "streets-vector", "topo-vector", "streets-night-vector", "streets-relief-vector", "streets-navigation-vector".
	 * @param ground Must be "world-elevation", "world-topobathymetry".
	 */
	com.gisfaces.createMap = function(basemap, ground) {
		console.log("Creating map.");

		var props = {
				basemap: basemap
		};

		if (ground) {
			// Ground can only be applied to 3d maps.
			props.ground = ground;
		}

		com.gisfaces.map = new Map(props);
	}

	/**
	 * Function to create the web map widget.
	 * @param id WebMap PortalItem ID.
	 */
	com.gisfaces.createWebMap = function(id) {
		console.log("Creating web map.");

		com.gisfaces.map = new WebMap({
			portalItem: {
				id: id
			}
		});
	}

	/**
	 * Function to create a 3d web scene map widget.
	 */
	com.gisfaces.createWebSceneMap = function(id) {
		console.log("Creating web scene map.");

		com.gisfaces.map = new WebScene({
			portalItem: {
				id: id
			}
		});
	}

	/**
	 * Function to create a 2d map view.
	 * @param panel Target div panel for the map view.
	 * @param latitude Latitude.
	 * @param longitude Longitude.
	 * @param zoom Zoom.
	 */
	com.gisfaces.createMapView = function(panel, latitude, longitude, zoom) {
		console.log("Creating map view.");

		com.gisfaces.view = new MapView({
			container: panel,
			map: com.gisfaces.map,
			center: [ longitude, latitude ],
			zoom: zoom
		});

		// Processing after the view has been completely loaded.
		com.gisfaces.view.when(function(instance) {
			// Add view listeners.
			com.gisfaces.addViewListeners();

			// Invoke registered listener.
			if (com.gisfaces.mapLoadedListener) {
				com.gisfaces.mapLoadedListener();
			}
		});
	}

	/**
	 * Function to create a 3d scene view.
	 * @param panel Target div panel for the map view.
	 * @param latitude Latitude.
	 * @param longitude Longitude.
	 * @param zoom Zoom.
	 */
	com.gisfaces.createSceneView = function(panel, latitude, longitude, zoom) {
		console.log("Creating scene view.");

		com.gisfaces.view = new SceneView({
			container: panel,
			map: com.gisfaces.map,
			center: [ longitude, latitude ],
			zoom: zoom
		});

		// Processing after the view has been completely loaded.
		com.gisfaces.view.when(function(instance) {
			// Add view listeners.
			com.gisfaces.addViewListeners();

			// Invoke registered listener.
			if (com.gisfaces.mapLoadedListener) {
				com.gisfaces.mapLoadedListener();
			}
		});
	}

	/**
	 * Function to create the search widget.
	 */
	com.gisfaces.createSearchWidget = function() {
		console.log("Creating search widget.");

		com.gisfaces.search = new Search({
			view: com.gisfaces.view
		});

		com.gisfaces.view.ui.add(new Expand({
			content: com.gisfaces.search,
			expandIconClass: "esri-icon-search",
			expandTooltip: "Show Search",
			collapseTooltip: "Hide Search"
		}), {
			position: "top-left",
			index: 0
		});
	}

	/**
	 * Function to create the basemap gallery widget.
	 */
	com.gisfaces.createBasemapGalleryWidget = function() {		
		console.log("Creating basemap gallery widget.");

		com.gisfaces.basemapGallery = new BasemapGallery({
			view: com.gisfaces.view
		});

		com.gisfaces.view.ui.add(new Expand({
			content: com.gisfaces.basemapGallery,
			expandIconClass: "esri-icon-basemap",
			expandTooltip: "Show Basemap Background Gallery",
			collapseTooltip: "Hide Basemap Background Gallery"
		}), {
			position: "top-right"
		});

		// Attach a watch listener to the basemap gallery.
		watchUtils.watch(com.gisfaces.basemapGallery, "activeBasemap", function(basemap) {
			console.log("Basemap updated to '%s'.", basemap.title);

			if (com.gisfaces.mapBasemapListener) {
				com.gisfaces.mapBasemapListener(basemap.title);
			}
		});
	}

	/**
	 * Function to create the layer list widget.
	 */
	com.gisfaces.createLayerListWidget = function() {
		console.log("Creating layer list widget.");

		com.gisfaces.layerlist = new LayerList({
			view: com.gisfaces.view
		});

		com.gisfaces.view.ui.add(new Expand({
			content: com.gisfaces.layerlist,
			expandIconClass: "esri-icon-layers",
			expandTooltip: "Show Layer List",
			collapseTooltip: "Hide Layer List"
		}), {
			position: "top-right"
		});
	}

	/**
	 * Function to create the legend widget.
	 */
	com.gisfaces.createLegendWidget = function() {
		console.log("Creating legend widget.");

		com.gisfaces.legend = new Legend({
			view: com.gisfaces.view
		});

		com.gisfaces.view.ui.add(new Expand({
			content: com.gisfaces.legend,
			expandIconClass: "esri-icon-description",
			expandTooltip: "Show Legend",
			collapseTooltip: "Hide Legend"
		}), {
			position: "top-right"
		});
	}

	/**
	 * Function to create the track widget.
	 * Requires https or localhost for execution.
	 */
	com.gisfaces.createTrackWidget = function() {
		console.log("Creating track widget.");

		com.gisfaces.track = new Track({
			view: com.gisfaces.view
		});

		com.gisfaces.view.ui.add(com.gisfaces.track, {
			position: "top-right"
		});

		// Add position event handler.
		com.gisfaces.track.on("track", function(event) {
			if (event && event.position && event.position.coords) {
				var c = event.position.coords;
				console.log("Geolocation tracking position latitude='%s', longitude='%s', heading='%s', speed='%s', accuracy='%s', altitude='%s', altitudeAccuracy='%s', timestamp='%s'.", c.latitude, c.longitude, c.heading, c.speed, c.accuracy, c.altitude, c.altitudeAccuracy, event.position.timestamp);				

				// Invoke registered listener.
				if (com.gisfaces.mapGeoLocationListener) {
					com.gisfaces.mapGeoLocationListener(event.position);
				}
			}
		});
	}

	/**
	 * Function to create the fullscreen widget.
	 */
	com.gisfaces.createFullscreenWidget = function() {
		console.log("Creating fullscreen widget.");

		com.gisfaces.fullscreen = new Fullscreen({
			view: com.gisfaces.view
		});

		com.gisfaces.view.ui.add(com.gisfaces.fullscreen, {
			position: "top-right"
		});
	}

	/**
	 * Function to create the directions widget.
	 * Requires proxy page and esri login.
	 */
	com.gisfaces.createDirectionsWidget = function() {
		console.log("Creating directions widget.");

		com.gisfaces.directions = new Directions({
			view: com.gisfaces.view
		});

		com.gisfaces.view.ui.add(new Expand({
			content: com.gisfaces.directions,
			expandIconClass: "esri-icon-directions",
			expandTooltip: "Show Directions",
			collapseTooltip: "Hide Directions"
		}), {
			position: "top-right"
		});
	}

	/**
	 * Function to create the coordinates widget.
	 */
	com.gisfaces.createCoordinateWidget = function() {
		console.log("Creating coordinates widget.");

		com.gisfaces.coordinateconversion = new CoordinateConversion({
			view: com.gisfaces.view
		});

		com.gisfaces.view.ui.add(new Expand({
			content: com.gisfaces.coordinateconversion,
			expandIconClass: "esri-icon-blank-map-pin",
			expandTooltip: "Show Coordinates",
			collapseTooltip: "Hide Coordinates"
		}), {
			position: "bottom-right"
		});
	}

	/**
	 * Function to create the help widget.
	 */
	com.gisfaces.createHelpWidget = function() {
		console.log("Creating help widget.");

		var content = "";
		content += "<table>";
		content += "<tr><td><b>Action</b></td><td><b>Behavior</b></td></tr>";
		content += "<tr><td>Left Click + Drag</td><td>2D map pan.</td></tr>";
		content += "<tr><td>Right Click + Drag</td><td>3D map rotation.</td></tr>";
		content += "<tr><td>P</td><td>Move the view to look perpendicular.</td></tr>";
		content += "<tr><td>N</td><td>Adjust the compass to point north.</td></tr>";
		content += "<tr><td>J</td><td>3D move down.</td></tr>";
		content += "<tr><td>U</td><td>3D move up.</td></tr>";
		content += "<tr><td>Double Click</td><td>Zoom in at the cursor.</td></tr>";
		content += "<tr><td>Mouse Wheel Scroll Up</td><td>Zoom in at the cursor.</td></tr>";
		content += "<tr><td>Mouse Wheel Scroll Down</td><td>Zoom out at the cursor.</td></tr>";
		content += "<tr><td>Arrow Keys</td><td>Pan left, right, up, or down.</td></tr>";
		content += "<tr><td>B + Left Click + Drag</td><td>3D rotate around the current position.</td></tr>";
		content += "</table>";

		com.gisfaces.help = document.createElement("div");
		com.gisfaces.help.setAttribute("class", "gisfaces-help-panel esri-widget");
		com.gisfaces.help.innerHTML = content;

		com.gisfaces.view.ui.add(new Expand({
			content: com.gisfaces.help,
			expandIconClass: "esri-icon-question",
			expandTooltip: "Show Help",
			collapseTooltip: "Hide Help"
		}), {
			position: "bottom-left"
		});
	}

	/**
	 * Function to create the 2d/3d dimension view widget.
	 */
	com.gisfaces.createDimensionWidget = function() {
		console.log("Creating dimension view widget.");

		var is2d = (com.gisfaces.view.type === "2d");
		var icon = is2d ? "esri-icon-globe" : "esri-icon-maps";
		var tooltip = is2d ? "Show 3D Map View" : "Show 2D Map View";

		var dimension = new Expand({
			content: "",
			expandIconClass: icon,
			expandTooltip: tooltip
		});

		com.gisfaces.view.ui.add(dimension, {
			position: "top-right"
		});

		// Watch for widget click/expansion.
		dimension.watch("expanded", function(value) {
			// Backup current properties.
			var container = com.gisfaces.view.container;
			var viewpoint = com.gisfaces.view.viewpoint.clone();

			// Clear out the current container.
			com.gisfaces.view.container = null;

			// Create the new view.
			if (com.gisfaces.view.type === "2d") {
				com.gisfaces.view = new SceneView({
					container: container,
					map: com.gisfaces.map
				});
			} else {
				com.gisfaces.view = new MapView({
					container: container,
					map: com.gisfaces.map
				});
			}

			// Restore properties.
			com.gisfaces.view.viewpoint = viewpoint;

			// Add view listeners once the view has completely loaded.
			com.gisfaces.view.when(function(instance) {
				// Add view listeners.
				com.gisfaces.addViewListeners();
			});

			// Re-create all widgets.
			com.gisfaces.createAllWidgets();
		});
	}

	/**
	 * Function to create the compass widget.
	 * This widget is automatically added for 3d views.
	 */
	com.gisfaces.createCompassWidget = function() {
		console.log("Creating compass widget.");

		com.gisfaces.compass = new Compass({
			view: com.gisfaces.view,
			unit: "dual"
		});

		com.gisfaces.view.ui.add(com.gisfaces.compass, {
			position: "top-left"
		});
	}

	/**
	 * Function to create the print widget.
	 * Currently only works with 2d map view.
	 */
	com.gisfaces.createPrintWidget = function() {
		console.log("Creating print widget.");

		com.gisfaces.print = new Print({
			view: com.gisfaces.view,
			printServiceUrl: "https://utility.arcgisonline.com/arcgis/rest/services/Utilities/PrintingTools/GPServer/Export%20Web%20Map%20Task"
		});

		com.gisfaces.view.ui.add(new Expand({
			content: com.gisfaces.print,
			expandIconClass: "esri-icon-printer",
			expandTooltip: "Show Print/Export",
			collapseTooltip: "Hide Print/Export"
		}), {
			position: "top-right"
		});
	}

	/**
	 * Function to create the sketch widget.
	 * NOTE: The sketch widget has issues when enclosed in a form and cannot be added via view ui.
	 * @param layer Graphics layer.
	 */
	com.gisfaces.createSketchWidget = function(layer) {
		console.log("Creating sketch widget for graphics layer '%s'.", layer.id);

		// Get the map div rectangle.
		var rect = com.gisfaces.view.container.childNodes[0].getBoundingClientRect(); 

		// Calculate the offsets.
		var top = rect.top + 15;
		var left = rect.left + 60;

		// Create a new div for the sketch widget.
		var div = document.createElement("div");
		div.style = "position:absolute; top:" + top + "px; left:" + left + "px;";
		document.body.appendChild(div);

		com.gisfaces.sketch = new Sketch({
			container: div,
			layer: layer,
			view: com.gisfaces.view
		});

		com.gisfaces.sketch.on("create", com.gisfaces.onSketchCreate);
		com.gisfaces.sketch.on("update", com.gisfaces.onSketchUpdate);
		com.gisfaces.sketch.on("delete", com.gisfaces.onSketchDelete);
	}

	/**
	 * Function to create the scalebar widget.
	 * Currently only works with 2d map view.
	 */
	com.gisfaces.createScaleBarWidget = function() {
		console.log("Creating scalebar widget.");

		com.gisfaces.scalebar = new ScaleBar({
			view: com.gisfaces.view,
			unit: "dual"
		});

		com.gisfaces.view.ui.add(com.gisfaces.scalebar, {
			position: "bottom-left"
		});
	}

	/**
	 * Function to create all widgets.
	 */
	com.gisfaces.createAllWidgets = function() {
		console.log("Creating all widgets.");

		// Create 2d/3d common widgets.
		com.gisfaces.createSearchWidget();
		com.gisfaces.createBasemapGalleryWidget();
		com.gisfaces.createLayerListWidget();
		com.gisfaces.createLegendWidget();
		com.gisfaces.createTrackWidget();
		com.gisfaces.createFullscreenWidget();
		com.gisfaces.createCoordinateWidget();
		com.gisfaces.createHelpWidget();
		com.gisfaces.createDimensionWidget();
		//com.gisfaces.createDirectionsWidget();

		// Create 2d only widgets.
		if (com.gisfaces.view.type === "2d")
		{
			com.gisfaces.createCompassWidget();
			com.gisfaces.createScaleBarWidget();
			//com.gisfaces.createPrintWidget();
		}
	}

	/**
	 * Function to add view listeners.
	 * The view must be completely loaded before invoking this function.
	 */
	com.gisfaces.addViewListeners = function() {
		console.log("Adding view listeners.");

		// Add click handler.
		com.gisfaces.view.on("click", function(e) {
			console.log("Map clicked.");

			if (e.mapPoint) {
				console.log("Ground coordinates are [%s, %s].", e.mapPoint.longitude, e.mapPoint.latitude);

				// Invoke registered listener.
				if (com.gisfaces.mapClickListener) {
					com.gisfaces.mapClickListener(e);
				}
			}

			// Get the screen point necessary for a hit test.
			var screenPoint = {
				x: e.x,
				y: e.y
			};

			// Search the graphics via hit test.
			com.gisfaces.view.hitTest(screenPoint).then(com.gisfaces.showGraphicDialog);
		});

		// Add extent handler.
		watchUtils.whenTrue(com.gisfaces.view, "stationary", function() {
			console.log("Map view is stationary.");

			// Must keep track of extent updates due to the track widget continually sending updates when enabled.
			var updated = true;

			// Compare previous and current extents.
			if (com.gisfaces.view.get("previousExtent")) {
				if (com.gisfaces.view.extent.equals(com.gisfaces.view.get("previousExtent"))) {
					updated = false;
				}
			}

			// Store previous extent.
			com.gisfaces.view.set("previousExtent", com.gisfaces.view.extent.clone());

			if (updated) {
				console.log("Map extent updated '%s'", JSON.stringify(com.gisfaces.convertGeometryToGeographicUnits(com.gisfaces.view.extent)));

				// Invoke registered listener.
				if (com.gisfaces.mapExtentListener) {
					com.gisfaces.mapExtentListener(com.gisfaces.view);
				}
			}
		});

		// Add popup dialog feature select handler.
		watchUtils.watch(com.gisfaces.view.popup, "selectedFeature", function(g) {
			if (g) {
				console.log("Map popup feature selected '%s'.", JSON.stringify(g));

				if (g.get("layer.id")) {
					// Local layer detected (csv, graphic).
					console.log("Selected layer ID is '%s'.", g.get("layer.id"));
				} else if (g.get("sourceLayer.id")) {
					// Map image layer detected.
					console.log("Selected layer ID '%s', sublayer ID '%s', title '%s'.", g.get("sourceLayer.parent.id"), g.get("sourceLayer.id"), g.get("sourceLayer.title"));
				}

				// Invoke registered listener.
				if (com.gisfaces.mapSelectListener) {
					com.gisfaces.mapSelectListener(g);
				}
			}
		});

		// Add popup dialog close handler.
		watchUtils.whenNot(com.gisfaces.view.popup, "visible", function() {
			console.log("Map popup dialog hidden.");

			// Remove all popup features.
			// Some layer types including KML and GeoRSS do not seem to update the popup selectedFeature property on subsequent click events for the same feature.
			com.gisfaces.view.popup.features = [];
		});
	}

	/**
	 * Function to show the popup dialog.
	 * @param response
	 */
	com.gisfaces.showGraphicDialog = function(response) {
		// Get the top-most graphic.
		var graphic = response.results[0].graphic;

		if (graphic) {
			console.log("Showing map popup dialog for graphic '%s'.", JSON.stringify(graphic));

			// Invoke registered listener.
			if (com.gisfaces.graphicClickListener) {
				com.gisfaces.graphicClickListener(graphic);
			}
		}
	}

	/**
	 * Function to hide the popup dialog.
	 */
	com.gisfaces.hideGraphicDialog = function() {
		if (com.gisfaces.view.popup) {
			console.log("Hidinging map popup dialog.");
			com.gisfaces.view.popup.close();
		}
	}

	/**
	 * Function to set the map basemap. Note: there is a basemap gallery widget.
	 * @param basemap Must be "streets", "satellite", "hybrid", "topo", "gray", "dark-gray", "oceans", "national-geographic", "terrain", "osm", "dark-gray-vector", "gray-vector", "streets-vector", "topo-vector", "streets-night-vector", "streets-relief-vector", "streets-navigation-vector".
	 */
	com.gisfaces.setMapBasemap = function(basemap) {
		console.log("Setting map basemap to '%s'.", basemap);

		if (com.gisfaces.map) {
			com.gisfaces.map.basemap = basemap;
		}
	}

	/**
	 * Function to process a new or existing layer.
	 * @param type Layer type.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 * @param reset Hard reset indicator since some layer properties cannot be easily updated.
	 */
	com.gisfaces.processLayer = function(type, properties, index, reset) {
		console.log("Processing layer of type '%s' with properties '%s' at index '%s'.", type, JSON.stringify(properties), index);

		if (reset) {
			// Remove the layer for hard reset.
			com.gisfaces.removeLayer(properties.id);
		}

		// Get the layer.
		var layer = com.gisfaces.findLayer(properties.id);

		if (layer) {
			// Update an existing layer.
			com.gisfaces.updateLayer(layer, properties, index);
		} else {
			// Add a new layer.
			com.gisfaces.addLayer(type, properties, index);
		}
	}

	/**
	 * Function to add a new layer.
	 * @param type Layer type.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addLayer = function(type, properties, index) {
		console.log("Adding layer of type '%s' at index '%s'.", type, index);

		switch (type) {
			case "csv":
				com.gisfaces.addCSVLayer(properties, index);
				break;
			case "feature":
				com.gisfaces.addFeatureLayer(properties, index);
				break;
			case "geojson":
				com.gisfaces.addGeoJSONLayer(properties, index);
				break;
			case "geo-rss":
				com.gisfaces.addGeoRSSLayer(properties, index);
				break;
			case "graphics":
				break;
			case "imagery":
				com.gisfaces.addImageryLayer(properties, index);
				break;
			case "integrated-mesh":
				com.gisfaces.addIntegratedMeshLayer(properties, index);
				break;
			case "kml":
				com.gisfaces.addKMLLayer(properties, index);
				break;
			case "map-image":
				com.gisfaces.addMapImageLayer(properties, index);
				break;
			case "point-cloud":
				com.gisfaces.addPointCloudLayer(properties, index);
				break;
			case "portal":
				com.gisfaces.addPortalLayer(properties, index);
				break;
			case "scene":
				com.gisfaces.addSceneLayer(properties, index);
				break;
			case "stream":
				com.gisfaces.addStreamLayer(properties, index);
				break;
			case "tile":
				com.gisfaces.addTileLayer(properties, index);
				break;
			case "vector-tile":
				com.gisfaces.addVectorTileLayer(properties, index);
				break;
			case "wms":
				com.gisfaces.addWMSLayer(properties, index);
				break;
			case "wmts":
				com.gisfaces.addWMTSLayer(properties, index);
				break;
		}
	}

	/**
	 * Function to create and add a new ArcGIS Server layer.
	 * Layer types include FeatureLayer, TileLayer, MapImageLayer, SceneLayer, StreamLayer, ElevationLayer or GroupLayer.
	 * @param layerId Layer ID used for later reference.
	 * @param layerUrl ArcGIS Server layer URL.
	 * @param layerProperties Layer properties.
	 * @param index Layer index.
	 */
	com.gisfaces.addArcGisServerLayer = function(layerId, layerUrl, layerProperties, index) {
		console.log("Adding ArcGIS Server layer with id '%s', url '%s', and properties '%s'.", layerId, layerUrl, JSON.stringify(layerProperties));

		// Verify layer properties exists.
		if (!layerProperties) {
			layerProperties.id = {};
		}

		// Set the layer ID.
		layerProperties.id = layerId

		// Create a new ArcGIS Server layer.
		Layer.fromArcGISServerUrl({
			url: layerUrl,
			properties: layerProperties
		}).then(function(layer) {
			// Add the new layer to the map.
			com.gisfaces.map.add(layer, index);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});
	}

	/**
	 * Function to create and add a new CSV layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addCSVLayer = function(properties, index) {
		console.log("Adding CSV layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new CSVLayer(properties);

		layer.when(function() {
			console.log("CSV layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new feature layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addFeatureLayer = function(properties, index) {
		console.log("Adding feature layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new FeatureLayer(properties);

		layer.when(function() {
			console.log("Feature layer '%s' loaded.", layer.id);

			if (!properties.popupTemplate) {
				// Set the default popup template.
				console.log("Setting default popup template for feature layer '%s'.", layer.id);
				layer.popupTemplate = { title: layer.title, content: "{*}" };
			}
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new GeoJSON layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addGeoJSONLayer = function(properties, index) {
		console.log("Adding GeoJSON layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new GeoJSONLayer(properties);

		layer.when(function() {
			console.log("GeoJSON layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new GeoRSS layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addGeoRSSLayer = function(properties, index) {
		console.log("Adding GeoRSS layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new GeoRSSLayer(properties);

		layer.when(function() {
			console.log("GeoRSS layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new graphics layer.
	 * @param layerId Layer ID used for later reference.
	 * @param title Layer title displayed in Legend and LayerList widgets.
	 * @param index Layer index.
	 */
	com.gisfaces.addGraphicsLayer = function(layerId, title, index) {
		console.log("Adding graphics layer with id '%s' and title '%s'.", layerId, title);

		// Create a new graphics layer.
		var layer = new GraphicsLayer({
			id: layerId,
			title: title
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new imagery layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addImageryLayer = function(properties, index) {
		console.log("Adding imagery layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new ImageryLayer(properties);

		layer.when(function() {
			console.log("Imagery layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new integrated mesh layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addIntegratedMeshLayer = function(properties, index) {
		console.log("Adding integrated mesh layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new IntegratedMeshLayer(properties);

		layer.when(function() {
			console.log("Integrated mesh layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new KML layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addKMLLayer = function(properties, index) {
		console.log("Adding KML layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new KMLLayer(properties);

		layer.when(function() {
			console.log("KML layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new map image layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addMapImageLayer = function(properties, index) {
		console.log("Adding map image layer with properties '%s'.", JSON.stringify(properties));

		// Create a new map image layer.
		var layer = new MapImageLayer(properties);

		layer.when(function() {
			console.log("Map service layer '%s' loaded.", layer.id);

			if (!properties.sublayers) {
				// Set the default popup template for each sublayer.
				layer.allSublayers.forEach(function(item) {
					console.log("Setting default popup template for map image layer '%s' and sublayer '%s'.", layer.id, item.id);
					item.popupTemplate = { title: item.title, content: "{*}" };
				});
			}
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new point cloud layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addPointCloudLayer = function(properties, index) {
		console.log("Adding point cloud layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new PointCloudLayer(properties);

		layer.when(function() {
			console.log("Point cloud layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new portal layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addPortalLayer = function(properties, index) {
		console.log("Adding portal layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		Layer.fromPortalItem(properties).then(function(layer) {
			// Add the new layer to the map.
			com.gisfaces.map.add(layer, index);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});
	}

	/**
	 * Function to create and add a new scene layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addSceneLayer = function(properties, index) {
		console.log("Adding scene layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new SceneLayer(properties);

		layer.when(function() {
			console.log("Scene layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new stream layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addStreamLayer = function(properties, index) {
		console.log("Adding stream layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new StreamLayer(properties);

		layer.when(function() {
			console.log("Stream layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new tile layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addTileLayer = function(properties, index) {
		console.log("Adding tile layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new TileLayer(properties);

		layer.when(function() {
			console.log("Tile layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new vector tile layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addVectorTileLayer = function(properties, index) {
		console.log("Adding vector tile layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new VectorTileLayer(properties);

		layer.when(function() {
			console.log("Vector tile layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new WMS layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addWMSLayer = function(properties, index) {
		console.log("Adding WMS layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new WMSLayer(properties);

		layer.when(function() {
			console.log("WMS layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to create and add a new WMTS layer.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.addWMTSLayer = function(properties, index) {
		console.log("Adding WMTS layer with properties '%s'.", JSON.stringify(properties));

		// Create the new layer.
		var layer = new WMTSLayer(properties);

		layer.when(function() {
			console.log("WMTS layer '%s' loaded.", layer.id);
		}, function(e) {
			// Error loading layer.
			console.error(e);
		});

		// Add the new layer to the map.
		com.gisfaces.map.add(layer, index);
	}

	/**
	 * Function to update an existing layer.
	 * @param layer Layer object.
	 * @param properties JSON properties defining layer.
	 * @param index Layer index.
	 */
	com.gisfaces.updateLayer = function(layer, properties, index) {
		console.log("Updating layer with properties '%s'.", JSON.stringify(properties));

		if (layer && properties && properties.id) {
			// Update all properties.
			for (var key in properties) {
				console.log("Updating layer '%s' property '%s' value '%s'.", properties.id, key, JSON.stringify(properties[key]));
				layer.set(key, properties[key]);
			}

			// Set the layer index for possible reorder.
			if (index) {
				console.log("Reordering layer '%s' to index '%s'.", properties.id, index);
				com.gisfaces.map.reorder(layer, index);
			}
		}
	}

	/**
	 * Function to find a layer by ID.
	 * @param layerId Layer ID.
	 */
	com.gisfaces.findLayer = function(layerId) {
		console.log("Finding map layer with id '%s'.", layerId);
		return com.gisfaces.map.findLayerById(layerId);
	}

	/**
	 * Function to remove a layer by ID.
	 * @param layerId Layer ID.
	 */
	com.gisfaces.removeLayer = function(layerId) {
		console.log("Removing map layer with id '%s'.", layerId);

		// Get the layer.
		var layer = com.gisfaces.findLayer(layerId);
		if (layer) {
			// Remove the layer from the map.
			com.gisfaces.map.remove(layer);
		}
	}

	/**
	 * Function to synchronize the requested layer IDs with the current map layer IDs.
	 * @param requestedLayerIds Array of requested layer IDs.
	 */
	com.gisfaces.syncLayers = function(requestedLayerIds) {
		console.log("Synchronizing requested map layers '%s' with current map layers.", requestedLayerIds);

		// Build an array of the current map layer IDs.
		var currentLayerIds = [];
		com.gisfaces.map.layers.forEach(function(layer) {
			currentLayerIds.push(layer.id);
		});

		// Remove all of the requested layer IDs from the current IDs.
		requestedLayerIds.forEach(function(requestedLayerId) {
			// Find the requested ID in the current ID array.
			var index = currentLayerIds.indexOf(requestedLayerId);
			if (index >= 0) {
				// Remove the requested ID from the current ID array.
				currentLayerIds.splice(index, 1);
			}
		});

		// Remove the layers currently in the map that are not requested.
		console.log("Removing current map layers '%s' no longer requested.", currentLayerIds);
		currentLayerIds.forEach(function(id) {
			com.gisfaces.removeLayer(id);
		});
	}

	/**
	 * Function to get WebMap layer IDs.
	 * @param webMapId WebMap PortalItem ID.
	 */
	com.gisfaces.getWebMapLayerIds = function(webMapId) {
		console.log("Getting layer ids for web map '%s'.", webMapId);

		var webmap = new WebMap({
			portalItem: {
				id: webMapId
			}
		});

		return webmap.load().then(function() {
			var layers = webmap.layers;
			return layers.map(function(layer) {
				return layer.portalItem.id;
			});
		});
	}

	/**
	 * Function to create a new picture marker graphic for use with a graphics layer.
	 * @param graphicId Unique graphic ID.
	 * @param latitude Latitude.
	 * @param longitude Longitude.
	 * @param title Popup title.
	 * @param attributes Popup attributes.
	 * @param imageUrl Fully qualified image url.
	 * @param imageHeight Image height in pixels.
	 * @param imageWidth Image width in pixels.
	 */
	com.gisfaces.createPictureMarkerGraphic = function(graphicId, latitude, longitude, title, attributes, imageUrl, imageHeight, imageWidth) {
		console.log("Creating picture markger graphic.");

		// Image defaults, if not specified.
		if (!imageUrl) {
			imageUrl = "http://static.arcgis.com/images/Symbols/Shapes/OrangePin2LargeB.png";
			imageHeight = 20;
			imageWidth = 20;
		}

		// Create the geometry.
		var point = new Point({
			longitude: longitude,
			latitude: latitude
		});

		// Create the symbol.
		var symbol = new PictureMarkerSymbol({
			url: imageUrl,
			height: imageHeight,
			width: imageWidth
		});

		// Create the graphic.
		var graphic = new Graphic({
			geometry: point,
			symbol: symbol
		});

		// Set the popup attributes, if specified.
		if (attributes) {
			graphic.attributes = attributes;
			graphic.popupTemplate = { title: title, content: "{*}" };
		}

		// Set the ID for later usage.
		graphic.id = graphicId;

		return graphic;
	}

	/**
	 * Function to create a new text marker graphic for use with a graphics layer.
	 * @param graphicId Unique graphic ID.
	 * @param latitude Latitude.
	 * @param longitude Longitude.
	 * @param title Popup title.
	 * @param attributes Popup attributes.
	 * @param fontText Font text or unicode. See https://developers.arcgis.com/javascript/latest/guide/esri-icon-font/ for codes.
	 * @param fontColor Font color in #XXXXXX hex notation.
	 * @param fontSize Font size.
	 */
	com.gisfaces.createTextMarkerGraphic = function(graphicId, latitude, longitude, title, attributes, fontText, fontColor, fontSize) {
		console.log("Creating text markger graphic.");

		// Image defaults, if not specified.
		if (!fontText) {
			fontText = "\ue61d";
			fontColor = "#FFFF00";
			fontSize = 20;
		}

		// Create the geometry.
		var point = new Point({
			longitude: longitude,
			latitude: latitude
		});

		// Create the symbol.
		var symbol = new TextSymbol({
			text: fontText,
			color: fontColor,
			font: {
				size: fontSize,
				family: "calcite-web-icons"
			}
		});

		// Create the graphic.
		var graphic = new Graphic({
			geometry: point,
			symbol: symbol
		});

		// Set the popup attributes, if specified.
		if (attributes) {
			graphic.attributes = attributes;
			graphic.popupTemplate = { title: title, content: "{*}" };
		}

		// Set the ID for later usage.
		graphic.id = graphicId;

		return graphic;
	}

	/**
	 * Function to create a new polygon graphic for use with a graphics layer.
	 * @param graphicId Unique graphic ID.
	 * @param paths Array of array of longitude, latitude coordinates.
	 * @param title Popup title.
	 * @param attributes Popup attributes.
	 * @param width Polyline width.
	 * @param color Polyline color (color name, #RRGGBB, or [r,g,b,a]).
	 * @param opacity Polyline opacity (value between 0.0 and 1.0).
	 */
	com.gisfaces.createPolygonGraphic = function(graphicId, paths, title, attributes, width, color, opacity) {
		console.log("Creating polygon graphic graphic.");

		// Create the geometry.
		var polyline = new Polyline({
			paths: paths
		});

		// Create a color with opacity.
		var c = new Color(color);
		c.a = opacity;

		// Create the symbol.
		var symbol = new SimpleLineSymbol({
			style: "solid",
			cap: "round",
			width: width,
			color: c
		});

		// Create the graphic.
		var graphic = new Graphic({
			geometry: polyline,
			symbol: symbol
		});

		// Set the popup attributes, if specified.
		if (attributes) {
			graphic.attributes = attributes;
			graphic.popupTemplate = { title: title, content: "{*}" };
		}

		// Set the ID for later usage.
		graphic.id = graphicId;

		return graphic;
	}

	/**
	 * Function to create a new graphic using the specified properties.
	 * @param properties
	 */
	com.gisfaces.createGraphic = function(properties) {
		console.log("Creating graphic with properties '%s'.", JSON.stringify(properties));

		// Create the graphic.
		var graphic =  new Graphic(properties);

		// Set the ID property.
		graphic.id = properties.id;

		return graphic;
	}

	/**
	 * Function to add a new graphic to the specified graphics layer.
	 * @param layerId
	 * @param graphic
	 */
	com.gisfaces.addGraphic = function(layerId, graphic) {
		console.log("Adding graphic to layer id '%s' with graphic '%s'.", layerId, JSON.stringify(graphic));

		// Get the layer.
		var layer = com.gisfaces.findLayer(layerId);
		if (layer) {
			// Add the graphic to the layer.
			layer.add(graphic);
		}
	}

	/**
	 * Function to remove a graphic from the specified graphics layer.
	 * @param layerId
	 * @param graphicId
	 */
	com.gisfaces.removeGraphic = function(layerId, graphicId) {
		console.log("Removing graphic from layer id '%s' with graphic id '%s'.", layerId, graphicId);

		// Get the layer.
		var layer = com.gisfaces.findLayer(layerId);
		if (layer) {
			var graphic = com.gisfaces.findGraphic(graphicId);
			if (graphic) {
				// Remove the graphic from the layer.
				layer.remove(graphic);
			}
		}
	}

	/**
	 * Function to find a graphic by ID.
	 * @param layerId
	 * @param graphicId
	 */
	com.gisfaces.findGraphic = function(layerId, graphicId) {
		console.log("Finding graphic in layer id '%s' with graphic id '%s'.", layerId, graphicId);

		var graphic;

		// Get the layer.
		var layer = com.gisfaces.findLayer(layerId);
		if (layer && layer.graphics && (layer.graphics.length > 0)) {
			layer.graphics.find(function(g) {
				if (g.id == graphicId) {
					graphic = g;
				}
			});
		}

		return graphic;
	}

	/**
	 * Function to remove all graphics.
	 * @param layerId
	 */
	com.gisfaces.removeAllGraphics = function(layerId) {
		console.log("Removing all graphics from layer id '%s'.", layerId);

		var layer = com.gisfaces.findLayer(layerId);
		if (layer) {
			layer.removeAll();
		}
	}

	/**
	 * Function to show a graphic popup dialog.
	 * @param graphic
	 */
	com.gisfaces.showGraphicPopup = function(graphic) {
		console.log("Showing popup for graphic '%s'.", JSON.stringify(graphic));

		com.gisfaces.view.popup.open({
			features: [graphic],
			updateLocationEnabled: true
		});
	}

	/**
	 * Function to adjust the current zoom level by the specified amount.
	 * @param levels Number of levels.
	 * @return Promise
	 */
	com.gisfaces.adjustZoomLevel = function(levels) {
		return com.gisfaces.zoomToTarget({ zoom: com.gisfaces.view.zoom + levels });
	}

	/**
	 * Function to zoom to a coordinate.
	 * @param latitude
	 * @param longitude
	 * @param zoom
	 * @return Promise
	 */
	com.gisfaces.zoomToCoordinate = function(latitude, longitude, zoom) {
		return com.gisfaces.zoomToTarget({ target: [longitude, latitude], zoom: zoom });
	}

	/**
	 * Function to zoom to a graphic.
	 * @param graphic
	 * @param zoom
	 * @return Promise
	 */
	com.gisfaces.zoomToGraphic = function(graphic, zoom) {
		return com.gisfaces.zoomToTarget({ target: graphic.geometry, zoom: zoom });
	}

	/**
	 * Function to zoom to graphics.
	 * @param graphics Array of graphics.
	 * @return Promise
	 */
	com.gisfaces.zoomToGraphics = function(graphics) {
		// Get the graphic geometries.
		// The view.goTo() function states a graphic[] is a target option, but does not work.
		var geometries = [];
		for (var i = 0; i < graphics.length; i++) {
			geometries.push(graphics[i].geometry);
		}

		// Build the zoom target.
		var target = { target: geometries };

		// Execute the zoom.
		return com.gisfaces.zoomToTarget(target);
	}

	/**
	 * Function to zoom to a predefined target.
	 * @param target Predefined target object.
	 * @return Promise
	 */
	com.gisfaces.zoomToTarget = function(target) {
		// Build the zoom options.
		var options = { animate: true, maxDuration: 1000 };

		console.log("Zooming to target '%s' with options '%s'.", JSON.stringify(target), JSON.stringify(options));

		// Execute the zoom.
		return com.gisfaces.view.goTo(target, options);	
	}

	/**
	 * Function to fit graphics in the current view.
	 * @param graphics Array of graphics.
	 * @param adjust Zoom level adjust after rotation.
	 */
	com.gisfaces.fitGraphics = function(graphics, adjust) {
		// Get the graphic geometries.
		// The view.goTo() function states a graphic[] is a target option, but does not work.
		var geometries = [];
		for (var i = 0; i < graphics.length; i++) {
			geometries.push(graphics[i].geometry);
		}

		// Calculate the heading degrees.
		var degrees = com.gisfaces.calculateHeading(graphics);

		// Build the zoom target.
		var target = { target: geometries, heading: degrees };

		// Execute the zoom.
		com.gisfaces.zoomToTarget(target).when(function() {
			// Adjust the zoom level after the initial zoom and rotate.
			com.gisfaces.adjustZoomLevel(adjust);
		});
	}

	/**
	 * Function to automatically rotate the map heading.
	 * @param graphics
	 * @return Promise
	 */
	com.gisfaces.autoRotateHeading = function(graphics) {
		// Calculate the heading degrees.
		var degrees = com.gisfaces.calculateHeading(graphics);

		// Build the zoom target.
		var target = { heading: degrees };

		// Execute the zoom.
		return com.gisfaces.zoomToTarget(target);
	}

	/**
	 * Function to calculate the map heading.
	 * @param graphics
	 */
	com.gisfaces.calculateHeading = function(graphics) {
		console.log("Begin heading calculation.");

		// Calculate the slope.
		var slope = com.gisfaces.calculateSlope(graphics);

		// Calculate the angle in radians.
		var radians = Math.atan(slope);

		// Convert angle from radians to degrees.
		var degrees = radians * (180 / Math.PI);

		console.log("Calculated degree heading='%s'.", degrees);
		console.log("End heading calculation.");

		return degrees;
	}

	/**
	 * Function to calculate the slope using simple linear regression.
	 * The formula is M = (n∑xy - ∑x∑y) / (n∑x² - (∑x)²).
	 * @param graphics
	 */
	com.gisfaces.calculateSlope = function(graphics) {
		console.log("Begin slope calculation.");

		// Summation variables.
		var n = graphics.length;
		var sumx = 0;
		var sumy = 0;
		var sumxx = 0;
		var sumxy = 0;

		for (var i = 0; i < n; i++) {
			var graphic = graphics[i];

			// Get the geometry center point.
			var point;
			if (graphic.geometry.type === "point") {
				point = graphic.geometry;
			} else {
				point = graphic.geometry.extent.center;
			}

			var x = point.longitude;
			var y = point.latitude;
			console.log("Processing point x='%s', y='%s'.", x, y);

			// Process summations.
			sumx += x;
			sumy += y;
			sumxx += (x * x);
			sumxy += (x * y);
		}

		// Calculate the slope using the simple linear regression formula.
		// M = (n∑xy - ∑x∑y) / (n∑x² - (∑x)²)
		//var slope = ((n * sumxy) - (sumx * sumy)) / ((n * sumxx) - (sumx * sumx));
		// M = (∑y∑x² - ∑x∑xy) / (n∑x² - (∑x)²)
		var slope = ((sumy * sumxx) - (sumx * sumxy)) / ((n * sumxx) - (sumx * sumx));

		console.log("Calculated slope='%s'.", slope);
		console.log("End slope calculation.");

		return slope;
	}

	/**
	 * Function to calculate the extent union of the specified graphics.
	 * @param graphics Graphic[]
	 * @return Extent
	 */
	com.gisfaces.calculateExtentUnion = function(graphics) {
		console.log("Begin extent union calculation.");

		var extent = null;

		// Calculate the union extent.
		for (var i = 0; i < graphics.length; i++) {
			var e = null;

			// Get the graphic extent.
			if (graphics[i].geometry.type === "point") {
				e = new Extent();
				e.centerAt(graphics[i].geometry);
			} else {
				e = graphics[i].geometry.extent.clone();
			}

			if (e) {
				if (extent) {
					// Union in the graphic extent.
					extent.union(e);
				} else {
					// Initialize the extent.
					extent = e;
				}
			}
		}

		console.log("End extent union calculation.");

		return extent;
	}

	/**
	 * Function to convert geometry from web mercator units to geographic units.
	 * @param geometry Geometry.
	 */
	com.gisfaces.convertGeometryToGeographicUnits = function(geometry) {
		return webMercatorUtils.webMercatorToGeographic(geometry);
	}

	/**
	 * Function to handle sketch widget create events.
	 * @param event Sketch event.
	 */
	com.gisfaces.onSketchCreate = function(event) {
		if (event.state === "complete") {
			console.log("Sketch widget graphic created.");
			console.log(event.graphic);

			// Invoke registered listener.
			if (com.gisfaces.mapGraphicCreateListener) {
				com.gisfaces.mapGraphicCreateListener(event);
			}
		}
	}

	/**
	 * Function to handle sketch widget update events.
	 * @param event Sketch event.
	 */
	com.gisfaces.onSketchUpdate = function(event) {
		if (event.state === "complete") {
			console.log("Sketch widget graphics updated.");
			console.log(event.graphics);

			// Invoke registered listener.
			if (com.gisfaces.mapGraphicUpdateListener) {
				com.gisfaces.mapGraphicUpdateListener(event);
			}
		}
	}

	/**
	 * Function to handle sketch widget delete events.
	 * @param event Sketch event.
	 */
	com.gisfaces.onSketchDelete = function(event) {
		console.log("Sketch widget graphics deleted.");
		console.log(event.graphics);

		// Invoke registered listener.
		if (com.gisfaces.mapGraphicDeleteListener) {
			com.gisfaces.mapGraphicDeleteListener(event);
		}
	}

	/**
	 * Function to detect browser WebGL support level.
	 * @ return -1 if not supported, 0 if supported but not enabled, 1 if enabled.
	 */
	com.gisfaces.getWebGLSupportLevel = function() {
		console.log("Detecting browser WebGL support level.");

		if (!! window.WebGLRenderingContext) {
	        var canvas = document.createElement("canvas");
	        var names = ["webgl2", "webgl", "experimental-webgl", "moz-webgl", "webkit-3d"];

	        for (var i in names) {
				try {
					var context = canvas.getContext(names[i]);
					if (context && typeof context.getParameter === "function") {
						// WebGL is supported and enabled.
						console.log("WebGL is supported and enabled.");
						return 1;
					}
				} catch (e) {
				}
			}

			// WebGL is supported but disabled.
			console.log("WebGL is supported but disabled.");
			return 0;
		}

		// WebGL is not supported.
		console.log("WebGL is not supported.");
		return -1;
	}

});
