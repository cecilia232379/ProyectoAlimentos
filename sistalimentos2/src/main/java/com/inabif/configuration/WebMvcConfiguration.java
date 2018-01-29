package com.inabif.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.inabif.component.RequestTimeInterceptor;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Autowired
	@Qualifier("requestTimeInterceptor")
	private RequestTimeInterceptor requestimeinterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestimeinterceptor);
	}
	
	@Bean
	@Description("Thymeleaf template engine with Spring integration")
	public TemplateEngine templateEngine(ITemplateResolver templateResolver) {
	    SpringTemplateEngine engine = new SpringTemplateEngine();
	    engine.addDialect(new Java8TimeDialect());
	    engine.setTemplateResolver(templateResolver);
	    return engine;
	}
}
