package com.lib.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
@ComponentScan("com.lib")
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	/*
	 * @Bean public InternalResourceViewResolver viewResolver() {
	 * InternalResourceViewResolver vr=new InternalResourceViewResolver();
	 * vr.setPrefix("/webapp/"); vr.setSuffix(".jsp"); return vr;
	 * 
	 * }
	 * 
	 */}
