package com.innovez.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.innovez.web", includeFilters={@Filter(type=FilterType.ANNOTATION, value=Controller.class)})
@EnableSpringDataWebSupport
public class WebAppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/WEB-INF/assets/");
		registry.addResourceHandler("/app/**").addResourceLocations("/app/");
		registry.addResourceHandler("/libs/**").addResourceLocations("/libs/");
	}
	
	/**
	 * Resolve Internet Explorer issues (as always?) on caching fetched resources.
	 * 
	 * @return
	 */
	@Bean
	public WebContentInterceptor webContentInterceptor() {
		WebContentInterceptor contentInterceptor = new WebContentInterceptor();
		contentInterceptor.setCacheSeconds(0);
		contentInterceptor.setUseExpiresHeader(true);
		contentInterceptor.setUseCacheControlHeader(true);
		contentInterceptor.setUseCacheControlNoStore(true);
		return contentInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(webContentInterceptor());
	}
}
