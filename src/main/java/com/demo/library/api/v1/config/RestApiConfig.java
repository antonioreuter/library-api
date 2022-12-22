package com.demo.library.api.v1.config;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter;
import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor;
import com.atlassian.oai.validator.springmvc.SpringMVCLevelResolverFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;


@Configuration
public class RestApiConfig implements WebMvcConfigurer{
	@Bean
	public Filter validationFilter() {
		var filter = new OpenApiValidationFilter(true, false);

		return filter;
	}

	@Bean
	public WebMvcConfigurer getOpenApiValidationInterceptor(@Value("schemas/api-v1.yaml") final String apiSpecUrl) {
		final OpenApiInteractionValidator validator = OpenApiInteractionValidator
				.createFor(apiSpecUrl)
				.withLevelResolver(SpringMVCLevelResolverFactory.create())
				.build();
		final OpenApiValidationInterceptor openApiValidationInterceptor = new OpenApiValidationInterceptor(validator);

		return new WebMvcConfigurer() {
			@Override
			public void addInterceptors(final InterceptorRegistry registry) {
				registry.addInterceptor(openApiValidationInterceptor);
			}
		};
	}
}
