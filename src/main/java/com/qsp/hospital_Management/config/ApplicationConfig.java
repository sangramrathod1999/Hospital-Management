package com.qsp.hospital_Management.config;
//url of swagger : http://localhost:8080/swagger-ui.html#
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("sangram", "http://qspider.com", "qspider@gmail.com");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("Hospital Management System",
				"This application will maintain & manage Information of patient and hospital", "version1.0",
				"1 year of free service", contact, "qsp001", "http://qsp001.com", extensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.qsp.hospital_Management")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}
