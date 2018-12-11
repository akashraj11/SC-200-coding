package com.stackroute.zuulgateway;

import filters.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableZuulProxy
@CrossOrigin("*")
public class ZuulgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulgatewayApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.addUrlPatterns("/secure/**");
		registrationBean.addUrlPatterns("/challenge/**");
		registrationBean.addUrlPatterns("/profile/**");
		registrationBean.addUrlPatterns("/vote/**");
		registrationBean.addUrlPatterns("/score/**");
		registrationBean.addUrlPatterns("/complie/**");
		registrationBean.addUrlPatterns("/file/**");
		registrationBean.setFilter(new JwtFilter());

		return registrationBean;
	}
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
