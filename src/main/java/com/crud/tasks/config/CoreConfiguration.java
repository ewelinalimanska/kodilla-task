package com.crud.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
@Configuration
public class CoreConfiguration implements WebMvcConfigurer {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType//udostępnienie metod pozwalających na konfigurację Swaggera
                .SWAGGER_2)//typ dokumentacji
                .select()//rozpoczęcie budowania konfiguracji
                .apis(RequestHandlerSelectors.basePackage("com.crud.tasks.controller"))//wybranie pakietów, które chcemy, aby zostały przeszukane w celu znalezienia controllerów.
                .paths(PathSelectors.any())// pozwala na bardziej dogłębne skanowanie
                .build(); //tworzenie obiektu Docket
    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        //dodajemy do Springa miejsca, które mogą być skanowane i udostępniane publicznie.
        // Required by Swagger UI configuration
        registry.addResourceHandler("/lib/**").addResourceLocations("/lib/").setCachePeriod(0);
        registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(0);
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(0);
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
