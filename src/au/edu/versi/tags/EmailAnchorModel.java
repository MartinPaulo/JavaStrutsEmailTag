package au.edu.versi.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.freemarker.tags.TagModel;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * This is the FreeMarker Model wrapping the Struts tag component.
 * @author Martin Paulo
 */
public class EmailAnchorModel extends TagModel {

	public EmailAnchorModel(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		super(stack, req, res);
	}

	@Override
	protected Component getBean() {
		return new EmailAnchor(stack);
	}

}
