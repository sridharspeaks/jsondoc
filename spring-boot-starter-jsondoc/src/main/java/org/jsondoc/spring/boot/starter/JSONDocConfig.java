package org.jsondoc.spring.boot.starter;

import org.jsondoc.springmvc.controller.JSONDocController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JSONDocProperties.class)
@ConditionalOnClass(JSONDocController.class)
public class JSONDocConfig {
	
	public final static String JSONDOC_PROPERTIES_PREFIX = "jsondoc";
	
	@Autowired
	private JSONDocProperties properties;

	@Bean
	public JSONDocController jController() {
		return new JSONDocController(this.properties.getVersion(), this.properties.getBasePath(), this.properties.getPackages());
	}

}
