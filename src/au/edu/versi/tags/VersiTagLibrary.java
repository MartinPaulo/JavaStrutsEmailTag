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

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.TagLibrary;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * A factory that returns the classes that are going be used as either Freemarker or Velocity tags.
 * 
 * The {@link #getVelocityDirectiveClasses()} method means that we won't have to have velocity.properties file
 * giving our directives.
 * 
 * @author Martin Paulo
 */
public class VersiTagLibrary implements TagLibrary {

	@Override
	public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new VersiFreeMarkerModels(stack, req, res);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Class> getVelocityDirectiveClasses() {
		Class[] directives = new Class[] { EmailAnchorDirective.class, };
		return Arrays.asList(directives);
	}

}
