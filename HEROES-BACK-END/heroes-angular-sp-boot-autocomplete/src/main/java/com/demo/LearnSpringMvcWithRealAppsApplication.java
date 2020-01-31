package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class LearnSpringMvcWithRealAppsApplication { // implements CommandLineRunner {
	
	

	public static void main(String[] args) {
		
		//System.setProperty("es.set.netty.runtime.available.processors", "false");
		SpringApplication.run(LearnSpringMvcWithRealAppsApplication.class, args);
	}

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.demo"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                           
    }

	private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Library Spring Boot REST API Documentation")
            .description("REST APIs For Managing Products ")
            .contact(new Contact("Achille Van houtte", "https://stackoverflow.com/users/1816151/georges-van", "vanhoutteachille@gmail.com"))
            .version("1.0")
            .build();

    }

}
