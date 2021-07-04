package br.com.gabriel.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableOpenApi
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
