package au.edu.versi.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.opensymphony.xwork2.util.ValueStack;

/**
 * This is the set of Freemarker Mode
 * @author admin
 *
 */
public class VersiModels {
	
	protected ValueStack stack;
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	
	protected EmailAnchorModel eam;
	
	public VersiModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
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
