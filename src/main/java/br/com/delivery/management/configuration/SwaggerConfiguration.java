package br.com.delivery.management.configuration;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

import java.lang.reflect.WildcardType;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan
public class SwaggerConfiguration {
	
	@Autowired
	private TypeResolver typeResolver;
	
	@Bean
	public Docket docket(){
		String title = "";
		String description = "";
		String version = "";
		String termsOfServiceUrl = null;
		String contact = null;
		String license = null;
		String licenseUrl = null;

		ApiInfo apiInfo = new ApiInfo(title, description, version,
				termsOfServiceUrl, contact, license, licenseUrl);
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.delivery.management"))
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.directModelSubstitute(LocalDate.class, String.class)
				.genericModelSubstitutes(ResponseEntity.class)
				.alternateTypeRules(
						newRule(typeResolver.resolve(DeferredResult.class,
								typeResolver.resolve(ResponseEntity.class,
										WildcardType.class)), typeResolver
								.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getDefaultResponseMessage())
				.globalResponseMessage(RequestMethod.POST,
						getDefaultResponseMessage())
				.globalResponseMessage(RequestMethod.PUT,
						getDefaultResponseMessage())
				.globalResponseMessage(RequestMethod.DELETE,
						getDefaultResponseMessage())
				.enableUrlTemplating(true);
				
	}
	

	private List<ResponseMessage> getDefaultResponseMessage() {
		return newArrayList(
				new ResponseMessageBuilder().code(500)
						.message("Internal Server Error")
						.responseModel(new ModelRef("Error")).build(),
				new ResponseMessageBuilder().code(400).message("Bad Request")
						.responseModel(new ModelRef("Error")).build());
	}

}
