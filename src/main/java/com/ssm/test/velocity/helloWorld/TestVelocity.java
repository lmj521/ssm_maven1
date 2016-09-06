package com.ssm.test.velocity.helloWorld;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TestVelocity {

	public static void main(String[] args) throws Exception {
		VelocityEngine engine = new VelocityEngine();
		engine.init();
		Template template = engine.getTemplate("hellosite.vm");
		VelocityContext context = new VelocityContext();
		 context.put("name", "Eiffel Qiu");  
         context.put("site", "http://www.eiffelqiu.com");  
         StringWriter stringWriter = new StringWriter();
         template.merge(context, stringWriter);
         System.out.println(stringWriter.toString());
	
}
}