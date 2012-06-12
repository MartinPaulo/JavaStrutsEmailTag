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
