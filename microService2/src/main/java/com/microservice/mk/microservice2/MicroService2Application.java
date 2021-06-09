package com.microservice.mk.microservice2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroService2Application {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(MicroService2Application.class, args);
    }

    private String getMessage() {
        final String uri = "http://localhost:8081/testMessage";
        return restTemplate.getForObject(uri, String.class);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RestController
    class MicroService2 {

        @ResponseBody
        @GetMapping("testMessage")
        String populateService() {
            return getMessage() + "From Two";
        }
    }
}
