package com.milton.book.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	@Autowired
	private MessageSource messageSource;
	 
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	 registry.addViewController("/").setViewName("index");
	 registry.addViewController("/login").setViewName("/login");
	 registry.addViewController("/admin/home").setViewName("adminhome");
	// registry.addViewController("/admin/addBook").setViewName("admin/addBook");
	// registry.addViewController("/admin/searchBook").setViewName("admin/searchBook");
	}
	
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setValidationMessageSource(messageSource);
		return factoryBean;
	}
	
	@Bean
	public SpringSecurityDialect springSecurityDialect() {
		return new SpringSecurityDialect();
	}

}
