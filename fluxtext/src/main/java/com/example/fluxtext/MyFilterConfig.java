package com.example.fluxtext;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

	@Autowired
	private EventNotify evnetNotify;

	@Bean
	public FilterRegistrationBean<Filter> addFilter() {
		System.out.println("필터 등록됨");
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter(evnetNotify));
		bean.addUrlPatterns("/sse");
		return bean;
	}

	@Bean
	public FilterRegistrationBean<Filter> addFilter2() {
		System.out.println("필터2 등록됨");
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new MyFilter2(evnetNotify));
		bean.addUrlPatterns("/add");
		return bean;
	}

}
