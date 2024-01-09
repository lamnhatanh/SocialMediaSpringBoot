package com.brian.socialmedia.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.thymeleaf.TemplateEngine;

public class EmailConstructor {

	@Autowired
	private Environment env;
	
	private TemplateEngine templateEngine;
	
	
	// Use javax mail and thymeleaf
	// Create context for setting variable and add them to the thymeleaf template
}
