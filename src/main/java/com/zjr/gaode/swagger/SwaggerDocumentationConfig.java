package com.zjr.gaode.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: ZhangJiaRen
 * @Date: Created in 15:38 2018/1/8
 * @Description:
 */
@Configuration
public class SwaggerDocumentationConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("高德web服务API文档").description("").license("").licenseUrl("")
				.termsOfServiceUrl("").version("1.0.0").contact(new Contact("", "", "")).build();
	}

	@Bean
	public Docket customImplementation() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.zjr.gaode"))
				.apis(RequestHandlerSelectors.basePackage("com.zjr.gaode.controller")).build()
				.apiInfo(apiInfo());
	}

}
