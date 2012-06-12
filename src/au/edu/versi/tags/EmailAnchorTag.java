/*
 * Copyright (C) 2012 VeRSI
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package au.edu.versi.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * This is the JSP Tag component wrapping the Struts tag component.
 * @author Martin Paulo
 * 
 */
public final class EmailAnchorTag extends ComponentTagSupport {

	private String defaultAddress;
	private String value;

	private String id;
	private String clath;
	private String title;
	private String style;
	private boolean writeWithJavaScript;

	private static final long serialVersionUID = 3311569555904578995L;

	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new EmailAnchor(stack);
	}

	@Override
	protected void populateParams() {
		super.populateParams();
		EmailAnchor ea = (EmailAnchor) component;
		ea.setDefault(defaultAddress);
		ea.setValue(value);
		ea.setId(id);
		ea.setClazz(clath);
		ea.setTitle(title);
		ea.setStyle(style);
		if (writeWithJavaScript) {
			ea.setWriteWithJavaScript(true);
		}
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setDefault(final String emailAddress) {
		this.defaultAddress = emailAddress;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setClazz(String clath) {
		this.clath = clath;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setWriteWithJavaScript(boolean writeWithJavaScript) {
		this.writeWithJavaScript = writeWithJavaScript;
	}
}
