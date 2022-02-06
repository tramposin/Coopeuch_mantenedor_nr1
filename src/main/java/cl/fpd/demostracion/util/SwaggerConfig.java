package cl.fpd.demostracion.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
				.paths(PathSelectors.any()).build().apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfoBuilder().title("Prueba Back End Coopeuch")
				.description("Desafío técnico Mantenedor n°1")
				.version("v1.0")
				.contact(new springfox.documentation.service.Contact("Francisco Devaud", null, "francisco.devaud@gmail.com"))
				.build();
			
				
//				("Prueba Back End Coopeuch", "Desafío técnico Mantenedor n°1", "1.0", "Free to use",
//						new springfox.documentation.service.Contact("Francisco Devaud", null, "francisco.devaud@gmail.com"),
//						"API Licencia", "Licencia", Collections.emptyList());

	}

}
