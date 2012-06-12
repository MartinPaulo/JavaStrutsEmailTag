package au.edu.versi.tags;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.velocity.components.AbstractDirective;

import com.opensymphony.xwork2.util.ValueStack;

public class EmailAnchorDirective extends AbstractDirective {
  
	public String getBeanName() {
        return "emailAnchor";
    }

    protected Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new EmailAnchor(stack);
    }
}