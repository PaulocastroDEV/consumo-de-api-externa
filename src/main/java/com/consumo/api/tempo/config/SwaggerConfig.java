package com.consumo.api.tempo.config;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	private Contact contact() {
		return new Contact("Paulo Gustavo", "https://github.com/PaulocastroDEV", "paulogustavo.dev@gmail.com");
	}

	private ApiInfoBuilder infoApi() {

		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

		apiInfoBuilder.title("Consumo de uma api de tempo");
		apiInfoBuilder.description(
				"Nessa api é possivel checar temperatura, longitude,nivel em relação ao oceano,o clima, a humidade tudo isso através do nome de uma cidade ");
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
		apiInfoBuilder.license("Licença -Livre ");
		apiInfoBuilder.licenseUrl("https://github.com/PaulocastroDEV");
		apiInfoBuilder.contact(this.contact());

		return apiInfoBuilder;
	}

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.consumo.api.tempo")).paths(PathSelectors.any()).build()
				.apiInfo(this.infoApi().build()).consumes(new HashSet<String>(Arrays.asList("application/json")))
				.produces(new HashSet<String>(Arrays.asList("application/json")));

	}

}