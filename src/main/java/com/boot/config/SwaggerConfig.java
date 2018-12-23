package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/");
//                .apiInfo(apiInfo());
    }
}


//@EnableSwagger2
//@Component
//class SwaggerConfig {
//    @Bean
//    fun api(): Docket {
//        return Docket(DocumentationType.SWAGGER_2).select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api::class.java))
//                .paths(PathSelectors.any())
//                .build()
//                .pathMapping("/").apiInfo(apiInfo())
//    }
//
//    @Bean
//    fun apiInfo(): ApiInfo {
//        val builder = ApiInfoBuilder()
//        val contact = Contact("admin@beyondsoft.com", "", "Admin")
//        builder.title("SteyService Api").version("1.0").license("(C) Copyright Stey")
//                .description("Stey Digital Restful APIs").contact(contact)
//
//        return builder.build()
//    }
//}
