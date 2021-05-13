package com.example.blog.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

@Configuration
public class Swagger {
    @Bean
    public Docket initDocket() {
        // 暴露接口文档配置
        return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .select()
            // 加了注解的类才生成文档
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
            // 包下的类才生成文档
            // .apis(RequestHandlerSelectors.basePackage("com.example.blog.modules"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("博客接口文档")
            .description("文档持续更新中")
            .version("1.0")
            .build();
    }

    // 配置swaggerUI
    @Bean
    public UiConfiguration initUi() {
        return UiConfigurationBuilder.builder()
            .defaultModelsExpandDepth(-1)
            .build();
    }
}
