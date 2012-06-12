package au.edu.versi.tags;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.TagLibrary;

import com.opensymphony.xwork2.util.ValueStack;

public class VersiTagLibrary implements TagLibrary {
	
	@Override
	public Object getFreemarkerModels(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new VersiModels(stack, req, res);
	}

	@Override
	public List<Class> getVelocityDirectiveClasses() {
	       Class[] directives = new Class[] {
	    		   EmailAnchorDirective.class,
	       };
	       return Arrays.asList(directives);
	}

}
