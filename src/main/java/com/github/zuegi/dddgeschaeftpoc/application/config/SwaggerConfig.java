package com.github.zuegi.dddgeschaeftpoc.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.ant;
import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

@Configuration
@EnableSwagger2
public class SwaggerConfig {



    private ApiInfo apiInfo() {
        return new ApiInfo("Geschaeft Service",
                "Geschaeft Service",
                "1.0",
                null,
                new Contact("Peter Paul and Mary", null, null),
                "License of API", "Peter und Paul www", new ArrayList<>());
    }

    private List<Parameter> globalOperationParameters() {
        return newArrayList(
            new ParameterBuilder()
                .name("Accept-Language")
                .description("preferred language")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .defaultValue("de-CH")
                .build()
        );
    }

    @Bean
    public Docket swaggerPublicApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("www")
                .select()
                .apis(withClassAnnotation(RestController.class))
                .paths(ant("/api/public/**"))
                .build()
                .globalOperationParameters(globalOperationParameters())
                .apiInfo(apiInfo())
                .enable(true);
    }
}
