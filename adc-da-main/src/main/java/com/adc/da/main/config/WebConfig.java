package com.adc.da.main.config;

import com.adc.da.util.filter.CorsFilter;
import com.adc.da.util.filter.CsrfFilter;
import com.adc.da.util.filter.FakeJSessionIdFilter;
import com.adc.da.util.filter.HttpCacheFilter;
import com.adc.da.util.filter.RequestInfoFilter;
import com.adc.da.util.xss.XssFilter;
import com.adc.da.util.xssshield.XssShieldFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Web配置，用于注入过滤器，拦截器等
 */
@Configuration
public class WebConfig {

	/**
	 * xss过滤器（高标准）
	 */
	@Bean
	public FilterRegistrationBean xssFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new XssFilter());
		registration.addUrlPatterns("/*");
		registration.setName("xssFilter");
		registration.setOrder(10);
		return registration;
	}

	/**
	 * xss过滤器（低标准）
	 */
//	@Bean
//	public FilterRegistrationBean xssShieldFilter() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new XssShieldFilter());
//		registration.addUrlPatterns("/*");
//		registration.setName("xssShieldFilter");
//		registration.setOrder(10);
//		return registration;
//	}

	@Bean
	public FilterRegistrationBean csrfFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CsrfFilter());
		registration.addUrlPatterns("/*");
		registration.setName("csrfFilter");
		registration.setOrder(9);
		return registration;
	}

	@Bean
	public FilterRegistrationBean requestInfoFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new RequestInfoFilter());
		registration.addUrlPatterns("/*");
		registration.setName("RequestInfoFilter");
		registration.setOrder(8);
		return registration;
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CorsFilter());
		registration.addUrlPatterns("/*");
		registration.setName("corsFilter");
		registration.setOrder(7);
		return registration;
	}

	@Bean
	public FilterRegistrationBean httpCacheFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new HttpCacheFilter());
		registration.addUrlPatterns("/*");
		registration.setName("httpCacheFilter");
		registration.addInitParameter("maxAge", String.valueOf(60 * 60 * 24 * 7));
		registration.setOrder(6);
		return registration;
	}

	/**
	 * 防伪造jsessionid
	 */
	@Bean
	public FilterRegistrationBean fakeJSessionIdFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new FakeJSessionIdFilter());
		registration.addUrlPatterns("/*");
		registration.setName("fakeJSessionIdFilter");
		registration.setOrder(5);
		return registration;
	}
}