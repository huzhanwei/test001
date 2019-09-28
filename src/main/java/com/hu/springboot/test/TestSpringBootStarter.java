package com.hu.springboot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCaching   //自动配置Redis缓存的CacheManager
@EnableSwagger2 // 启动swagger注解
@SpringBootApplication
public class TestSpringBootStarter {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hu.springboot.test"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("springboot学习API")
                .description("springboot 学习")
                .termsOfServiceUrl("http://www.huzhanwei")
                .version("1.0")
                .build();
    }

    public static void main(String[] args){
        SpringApplication.run(TestSpringBootStarter.class, args);
    }
}

