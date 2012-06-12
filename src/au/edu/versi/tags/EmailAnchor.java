/**
 * 
 */
package au.edu.versi.tags;

import java.io.IOException;
import java.io.Writer;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * The basic Struts2 anchor component.
 * @author Martin Paulo
 */
@StrutsTag(name = "emailAnchor", tldBodyContent = "empty", tldTagClass = "au.edu.versi.EmailAnchorTag", description = "Prints out a email address as a mailto: anchor")
public final class EmailAnchor extends Component {
	private static final Logger LOG = LoggerFactory.getLogger(EmailAnchor.class);
	protected String defaultAddress;
	protected boolean writeWithJavaScript;
	private String value;

	// The following are the common html elements that the user might want to have included.
	private String id;
	private String clath; // lispy as opposed to slytherin :)
	private String title;
	private String style;

	/**
	 * @param stack
	 */
	public EmailAnchor(ValueStack stack) {
		super(stack);
	}

	/**
	 * @param writeWithJavaScript
	 *            the writeWithJavaScript to set
	 */
	@StrutsTagAttribute(description = "If true, then the output will be rendered by java script.", type = "Boolean", defaultValue = "false")
	public void setWriteWithJavaScript(boolean writeWithJavaScript) {
		this.writeWithJavaScript = writeWithJavaScript;
	}

	@StrutsTagAttribute(description = "Value to be displayed", type = "Object", defaultValue = "&lt;top of stack&gt;")
	public void setValue(String value) {
		this.value = value;
	}

	@StrutsTagAttribute(description = "Default address to e-mail to", type = "String")
	public void setDefault(final String emailAddress) {
		this.defaultAddress = emailAddress;
	}

	@StrutsTagAttribute(description = "The element id", type = "String")
	public void setId(String id) {
		this.id = id;
	}

	@StrutsTagAttribute(description = "The element class", type = "String")
	public void setClazz(String clath) {
		this.clath = clath;
	}

	@StrutsTagAttribute(description = "The elment title", type = "String")
	public void setTitle(String title) {
		this.title = title;
	}

	@StrutsTagAttribute(description = "The elment style", type = "String")
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * @return false, as we don't have a body to be evaluated.
	 * @see org.apache.struts2.components.Component#start(java.io.Writer)
	 */
	@Override
	public boolean start(Writer writer) {
		String emailTagHtml = getMailToTag();
		if (this.writeWithJavaScript) {
			emailTagHtml = scriptWrapper(emailTagHtml);
		}

		try {
			writer.write(emailTagHtml);
		} catch (IOException e) {
			if (LOG.isInfoEnabled()) {
				LOG.info("Could not print out value '" + value + "'", e);
			}
		}
		return false;
	}

	private String getMailToTag() {
		String actualValue = null;

		if (value == null) {
			value = "top";
		} else {
			value = stripExpressionIfAltSyntax(value);
		}

		// exception: don't call findString(), since we don't want the
		// expression parsed in this one case. it really
		// doesn't make sense, in fact.
		actualValue = (String) getStack().findValue(value, String.class, throwExceptionOnELFailure);
		if (actualValue == null) {
			actualValue = this.defaultAddress;
		}

		String emailTagHtml = "<a" + getIdAttribute() + getClassAttribute() + " href=\"mailto:" + actualValue + "\""
				+ getTitleAttribute() + getStyleAttribute() + ">" + actualValue + "</a>";
		return emailTagHtml;
	}

	private String getAsAttribute(String value, String name) {
		if (value != null && value.length() > 0) {
			return " " + name + "=\"" + value + "\"";
		}
		return "";
	}

	private String getIdAttribute() {
		return getAsAttribute(this.id, "id");
	}

	private String getClassAttribute() {
		return getAsAttribute(this.clath, "class");
	}

	private String getTitleAttribute() {
		return getAsAttribute(this.title, "title");
	}

	private String getStyleAttribute() {
		return getAsAttribute(this.style, "style");
	}

	private static String getAsUnicodeChars(final String str) {
		StringBuffer result = new StringBuffer();
		for (char c : str.toCharArray()) {
			result.append("\\u"); // flag Unicode character to JavaScript interpreter.
			String hex = Integer.toHexString(c & 0xFFFF); // The hex value of the char.
			// Left pad result with zeros as Unicode is 4 digits long
			for (int i = 0; i < 4 - hex.length(); i++)
				result.append("0");
			result.append(hex.toLowerCase()); // add Unicode value
		}
		return result.toString();
	}

	private String scriptWrapper(final String emmitedHtml) {
		return "<script type=\"text/javascript\">document.write('" + getAsUnicodeChars(emmitedHtml) + "')</script>";
	}

	/**
	 * @return false as we don't want the body to be evaluated again.
	 * @see org.apache.struts2.components.Component#end(java.io.Writer, java.lang.String)
	 */
	@Override
	public boolean end(Writer writer, String body) {
		return false;
	}

}
