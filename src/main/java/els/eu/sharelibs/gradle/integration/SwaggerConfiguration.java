package els.eu.sharelibs.gradle.integration;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket swaggerSpringfoxDocket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(apiEndPointsInfo()).pathMapping("/")
				.forCodeGeneration(true).genericModelSubstitutes(ResponseEntity.class)
				.ignoredParameterTypes(java.sql.Date.class)
				.directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
				.directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
				.directModelSubstitute(java.time.LocalDateTime.class, Date.class)
				.useDefaultResponseMessages(false);
		docket = docket.select().apis( RequestHandlerSelectors.basePackage( "els.eu.sharelibs.gradle.integration")).paths(PathSelectors.any()).build();
		return docket;
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Gradle Spring boot REST API for Jenkins Sharelibs")
				.description("This gradle spring boot application is for an integration test for the jenkins sharelibs")
				.contact(new Contact("CICD Team", "integration-continue@lefebvre-sarrut.eu", "integration-continue@lefebvre-sarrut.eu")).build();
	}

}
