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


import com.opensymphony.xwork2.util.ValueStack;

/**
 * This is the set of Freemarker models that our tag library makes available.
 * @author admin
 *
 */
public class VersiFreeMarkerModels {
	
	protected ValueStack stack;
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	
	protected EmailAnchorModel eam;
	
	public VersiFreeMarkerModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		this.stack = stack;
		this.req = req;
		this.res = res;
	}

	public EmailAnchorModel getEmailAnchor() {
		if (eam == null) {
			eam = new EmailAnchorModel(stack, req, res);
		}
		return eam;
	}
}
