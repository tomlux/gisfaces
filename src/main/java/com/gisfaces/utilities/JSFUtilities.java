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

package com.gisfaces.utilities;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.el.ELContext;
import javax.el.MethodExpression;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * JSF 1.2+ related utilities.
 * 
 * @author Chris Duncan (cduncan@gisfaces.com)
 */
public class JSFUtilities {
	/**
	 * Constructor.
	 */
	private JSFUtilities() {
		// Class contains static methods only.
	}

	/**
	 * Method to get a fully-qualified URL string for the current view.
	 * 
	 * @return Fully-qualified URL string.
	 */
	public static final String getViewUrl() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();

		return String.format("%s://%s:%s%s", ec.getRequestScheme(), ec.getRequestServerName(), ec.getRequestServerPort(), request.getRequestURI());
	}

	/**
	 * Method to execute the specified method binding action.
	 * 
	 * @param action Method binding expression action.
	 * @return JSF navigation outcome returned by specified action.
	 */
	public static final String executeAction(String action) {
		String outcome = null;

		// Make sure the specified action is a valid method binding expression.
		String mbe = action;
		if (!JSFUtilities.isValidBindingExpression(action)) {
			mbe = JSFUtilities.wrapAsBindingExpression(action);
		}

		// Execute the specified method binding action.
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elc = fc.getELContext();
		Application app = fc.getApplication();
		MethodExpression me = app.getExpressionFactory().createMethodExpression(elc, mbe, String.class, new Class[] {});
		Object obj = me.invoke(elc, null);

		if (obj != null) {
			outcome = obj.toString();
		}

		return outcome;
	}

	/**
	 * Method to navigate to the specified outcome.
	 * 
	 * @param outcome JSF navigation outcome string.
	 */
	public static final void navigate(String outcome) {
		FacesContext fc = FacesContext.getCurrentInstance();

		NavigationHandler handler = fc.getApplication().getNavigationHandler();
		handler.handleNavigation(fc, null, outcome);
	}

	/**
	 * Method to refresh the specified component after an AJAX request.
	 * 
	 * @param id Fully qualified component ID.
	 */
	public static final void render(String id) {
		FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add(id);
	}

	/**
	 * Method to get the specified managed bean.
	 * 
	 * @param name Managed bean name.
	 * @return Managed bean.
	 */
	public static final Object getManagedBean(String name) {
		Object bean = null;

		// Make sure the specified bean name is a valid value binding expression.
		String vbe = name;
		if (!JSFUtilities.isValidBindingExpression(name)) {
			vbe = JSFUtilities.wrapAsBindingExpression(name);
		}

		// Get the managed bean.
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elc = fc.getELContext();
		bean = fc.getApplication().getExpressionFactory().createValueExpression(elc, vbe, Object.class).getValue(elc);

		return bean;
	}

	/**
	 * Method to set the specified managed bean value.
	 * 
	 * @param name  Managed bean name.
	 * @param value Managed bean value.
	 */
	public static final void setManagedBean(String name, Object value) {
		// Make sure the specified bean name is a valid value binding expression.
		String vbe = name;
		if (!JSFUtilities.isValidBindingExpression(name)) {
			vbe = JSFUtilities.wrapAsBindingExpression(name);
		}

		// Get the managed bean.
		FacesContext fc = FacesContext.getCurrentInstance();
		ELContext elc = fc.getELContext();
		fc.getApplication().getExpressionFactory().createValueExpression(elc, vbe, Object.class).setValue(elc, value);
	}

	/**
	 * Method to validate a binding expression.
	 * 
	 * @param value Binding expression.
	 * @return <code>true</code> if valid, <code>false</code> otherwise.
	 */
	public static final boolean isValidBindingExpression(String value) {
		return value.trim().matches("^\\#\\{.+\\}$");
	}

	/**
	 * Method to get binding expression string.
	 * 
	 * @param value Binding expression.
	 * @return String portion of binding expression.
	 */
	public static final String getBindingExpressionString(String value) {
		// Default to input string.
		String name = value;

		if (JSFUtilities.isValidBindingExpression(value)) {
			Pattern pattern = Pattern.compile("^\\#\\{(.+)\\}$");
			Matcher matcher = pattern.matcher(value);
			if (matcher.find() && (matcher.groupCount() == 1)) {
				name = matcher.group(1).trim();
			}
		}

		return name;
	}

	/**
	 * Method to wrap the specified value in a binding expression.
	 * 
	 * @param value Unwrapped managed bean name, value binding, or method binding
	 *              string.
	 * @return Specified value wrapped in as a binding expression.
	 */
	public static final String wrapAsBindingExpression(String value) {
		return String.format("#{%s}", value);
	}

	/**
	 * Method to get the value for the specified key in the specified bundle.
	 * 
	 * @param bundle Name of properties file bundle.
	 * @param key    Name of key to get value for.
	 * @return Value of specified key.
	 */
	public static final String getResourceValue(String bundle, String key) {
		return JSFUtilities.getResourceValue(bundle, key, null);
	}

	/**
	 * Method to get the value for the specified key in the specified bundle.
	 * 
	 * @param bundle Name of properties file bundle.
	 * @param key    Name of key to get value for.
	 * @param params Replacement values applied to text value.
	 * @return Value of specified key.
	 */
	public static final String getResourceValue(String bundle, String key, Object[] params) {
		String text = null;

		try {
			// Get the locale to determine which bundle to use.
			Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

			// Get the value from the appropriate bundle.
			ResourceBundle rb = ResourceBundle.getBundle(bundle, locale);
			text = rb.getString(key);

			if (params != null) {
				// Apply replacement values to message text.
				MessageFormat mf = new MessageFormat(text, locale);
				text = mf.format(params, new StringBuffer(), null).toString();
			}
		} catch (Exception e) {
			// Key not found in bundle.
			text = "???" + key + "???";
		}

		return text;
	}

	/**
	 * Method to add a JSF information message.
	 * 
	 * @param text Text used for summary and detail message.
	 */
	public static final void addInfoMessage(String text) {
		JSFUtilities.addInfoMessage(text, text);
	}

	/**
	 * Method to add a JSF information message.
	 * 
	 * @param summary Summary text.
	 * @param detail  Detail text.
	 */
	public static final void addInfoMessage(String summary, String detail) {
		JSFUtilities.addMessage(FacesMessage.SEVERITY_INFO, null, summary, detail);
	}

	/**
	 * Method to add a JSF warning message.
	 * 
	 * @param text Text used for summary and detail message.
	 */
	public static final void addWarningMessage(String text) {
		JSFUtilities.addWarningMessage(text, text);
	}

	/**
	 * Method to add a JSF warning message.
	 * 
	 * @param summary Summary text.
	 * @param detail  Detail text.
	 */
	public static final void addWarningMessage(String summary, String detail) {
		JSFUtilities.addMessage(FacesMessage.SEVERITY_WARN, null, summary, detail);
	}

	/**
	 * Method to add a JSF error message.
	 * 
	 * @param text Text used for summary and detail message.
	 */
	public static final void addErrorMessage(String text) {
		JSFUtilities.addErrorMessage(text, text);
	}

	/**
	 * Method to add a JSF error message.
	 * 
	 * @param summary Summary text.
	 * @param detail  Detail text.
	 */
	public static final void addErrorMessage(String summary, String detail) {
		JSFUtilities.addMessage(FacesMessage.SEVERITY_ERROR, null, summary, detail);
	}

	/**
	 * Method to add a JSF fatal message.
	 * 
	 * @param text Text used for summary and detail message.
	 */
	public static final void addFatalMessage(String text) {
		JSFUtilities.addFatalMessage(text, text);
	}

	/**
	 * Method to add a JSF fatal message.
	 * 
	 * @param summary Summary text.
	 * @param detail  Detail text.
	 */
	public static final void addFatalMessage(String summary, String detail) {
		JSFUtilities.addMessage(FacesMessage.SEVERITY_FATAL, null, summary, detail);
	}

	/**
	 * Method to add a JSF message.
	 * 
	 * @param severity FacesMessage.Severity
	 * @param id       Client id to attach message to.
	 * @param summary  Message summary.
	 * @param detail   Message detail.
	 */
	public static final void addMessage(Severity severity, String id, String summary, String detail) {
		FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(id, message);
	}

	/**
	 * Method to go to the first page of a datatable.
	 * 
	 * @param datatable UIData which is the base class of HtmlDataTable and
	 *                  HtmlDataTableEx.
	 */
	public static final void gotoFirstDataTablePage(UIData datatable) {
		if (datatable != null) {
			datatable.setFirst(0);
		}
	}

	/**
	 * Method to go to the last page of a datatable.
	 * 
	 * @param datatable UIData which is the base class of HtmlDataTable and
	 *                  HtmlDataTableEx.
	 */
	public static final void gotoLastDataTablePage(UIData datatable) {
		if (datatable != null) {
			// Get the rows per page.
			int rows = datatable.getRows();

			// Determine if paging is enabled.
			if (rows > 0) {
				// Get the total rows in the datatable.
				int count = datatable.getRowCount();

				// Calculate the first record for the last page.
				int first = count - ((count % rows != 0) ? count % rows : rows);

				// Update the datatable.
				datatable.setFirst(first);
			}
		}
	}

	/**
	 * Method to find the nearest parent UIData.
	 * 
	 * @param component
	 * @return Nearest parent UIData component.
	 */
	public static final UIData findParentUIData(UIComponent component) {
		if (component == null) {
			return null;
		}

		if (component instanceof UIData) {
			return (UIData) component;
		}

		return JSFUtilities.findParentUIData(component.getParent());
	}

	/**
	 * Method to set a view attribute. Note: Does not work with all JSF 1.1
	 * containers since saveState() and restoreState() are not invoked with
	 * server-side state saving.
	 * 
	 * @param viewId View ID (eg. "/page.jsp").
	 * @param key    Attribute name.
	 * @param value  Attribute value.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static final void setViewAttribute(String viewId, String key, Object value) {
		FacesContext context = FacesContext.getCurrentInstance();

		// Add view id to view list, if necessary.
		List views = (List) context.getExternalContext().getSessionMap().get("com.sun.faces.VIEW_LIST");
		if ((views != null) && (!views.contains(viewId))) {
			views.add(viewId);
		}

		// Get the view.
		UIViewRoot view = (UIViewRoot) context.getExternalContext().getSessionMap().get(viewId);
		if (view == null) {
			// Create the view, if necessary.
			ViewHandler viewHandler = context.getApplication().getViewHandler();
			view = viewHandler.createView(context, viewId);
		}

		// Set the view attribute value.
		view.getAttributes().put(key, value);

		// Put the view [back] into the session.
		context.getExternalContext().getSessionMap().put(viewId, view);
	}

	/**
	 * Method to set a view attribute. Note: Does not work with all JSF 1.1
	 * containers since saveState() and restoreState() are not invoked with
	 * server-side state saving.
	 * 
	 * @param viewId View ID (eg. "/page.jsp").
	 * @param key    Attribute name.
	 * @return Attribute value, if it exists, <code>null</code> otherwise.
	 */
	public static final Object getViewAttribute(String viewId, String key) {
		Object value = null;

		// Get the view.
		UIViewRoot view = (UIViewRoot) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(viewId);
		if (view != null) {
			// Get the view attribute value.
			value = view.getAttributes().get(key);
		}

		return value;
	}

	/**
	 * Method to remove a view attribute. Note: Does not work with all JSF 1.1
	 * containers since saveState() and restoreState() are not invoked with
	 * server-side state saving.
	 * 
	 * @param viewId View ID (eg. "/page.jsp").
	 * @param key    Attribute name.
	 * @return <code>true</code> if value was removed, <code>false</code> otherwise.
	 */
	public static final boolean removeViewAttribute(String viewId, String key) {
		boolean removed = false;

		// Get the view.
		UIViewRoot view = (UIViewRoot) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(viewId);
		if (view != null) {
			if (view.getAttributes().containsKey(key)) {
				// Remove the view attribute value.
				removed = (view.getAttributes().remove(key) != null);
			}
		}

		return removed;
	}

	/**
	 * Method to set a view attribute.
	 * 
	 * @param key   Attribute name.
	 * @param value Attribute value.
	 */
	public static final void setViewAttribute(String key, Object value) {
		FacesContext.getCurrentInstance().getViewRoot().getAttributes().put(key, value);
	}

	/**
	 * Method to set a view attribute.
	 * 
	 * @param key Attribute name.
	 * @return Attribute value, if it exists, <code>null</code> otherwise.
	 */
	public static final Object getViewAttribute(String key) {
		return FacesContext.getCurrentInstance().getViewRoot().getAttributes().get(key);
	}

	/**
	 * Method to remove a view attribute.
	 * 
	 * @param key Attribute name.
	 * @return <code>true</code> if value was removed, <code>false</code> otherwise.
	 */
	public static final boolean removeViewAttribute(String key) {
		return (FacesContext.getCurrentInstance().getViewRoot().getAttributes().remove(key) != null);
	}

	/**
	 * Method to find component.
	 * 
	 * @param base Base component.
	 * @param id   ID of component to find.
	 * @return UIComponent
	 */
	@SuppressWarnings("rawtypes")
	public static final UIComponent findComponent(UIComponent base, String id) {
		if (id.equals(base.getId())) {
			return base;
		}

		UIComponent kid = null;
		UIComponent result = null;
		Iterator kids = base.getFacetsAndChildren();
		while (kids.hasNext() && (result == null)) {
			kid = (UIComponent) kids.next();
			if (id.equals(kid.getId())) {
				result = kid;
				break;
			}
			result = JSFUtilities.findComponent(kid, id);
			if (result != null) {
				break;
			}
		}

		return result;
	}

	/**
	 * Method to find component.
	 * 
	 * @param id ID of component to find.
	 * @return UIComponent
	 */
	public static final UIComponent findComponent(String id) {
		UIComponent component = null;

		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			UIComponent root = context.getViewRoot();
			component = JSFUtilities.findComponent(root, id);
		}

		return component;
	}
}
