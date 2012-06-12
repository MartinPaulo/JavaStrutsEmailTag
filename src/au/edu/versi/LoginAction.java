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
package au.edu.versi;

import com.opensymphony.xwork2.ActionSupport;

/**
 * A simple action to help us with development. We want to be able to show the the users email address and have them
 * move through to the next page as logged on user.
 * 
 * @author Martin Paulo
 */
public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = -6596625795249783673L;
	private String username = "admin";
	private String password = "*****";
	private String email = "martin.paulo@versi.edu.au";

	public String execute() {
		if ("admin".equals(this.username) && "admin".equals(this.password)) {
			addActionMessage("Well done: you made it through..");
			return "success";
		} else {
			addActionError("You have not entered valid credentials!");
			return "error";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
