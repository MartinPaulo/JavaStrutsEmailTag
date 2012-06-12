package au.edu.versi;

import com.opensymphony.xwork2.ActionSupport;

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
