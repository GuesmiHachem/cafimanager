package com.cafimanager.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	/*
	 * @Bean public LocaleResolver localeResolver() { SessionLocaleResolver
	 * localeResolver = new SessionLocaleResolver();
	 * localeResolver.setDefaultLocale(Locale.US); return localeResolver; }
	 * 
	 * @Bean public LocaleChangeInterceptor localeChangeInterceptor() {
	 * LocaleChangeInterceptor localeChangeInterceptor = new
	 * LocaleChangeInterceptor(); localeChangeInterceptor.setParamName("lang");
	 * return localeChangeInterceptor; }
	 * 
	 * @Override public void addInterceptors(InterceptorRegistry registry) {
	 * registry.addInterceptor(localeChangeInterceptor()); }
	 */

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		//localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/*
	 * @Bean(name = "localeResolver") public LocaleResolver getLocaleResolver() {
	 * CookieLocaleResolver resolver= new CookieLocaleResolver();
	 * resolver.setCookieDomain("myAppLocaleCookie"); // 60 minutes
	 * resolver.setCookieMaxAge(60*60); return resolver; }
	 */

	@Bean(name = "messageSource")
	public MessageSource getMessageResource() {
		ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();

		// Read i18n/messages_xxx.properties file.
		// For example: i18n/messages_en.properties
		messageResource.setBasename("classpath:messages/messages");
		messageResource.setDefaultEncoding("UTF-8");

		return messageResource;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
		localeInterceptor.setParamName("lang");
		registry.addInterceptor(localeInterceptor).addPathPatterns("/**");
	}

}