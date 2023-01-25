package ru.kalenikov.euclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EuClient {

    @Value("${eureka.instance.instance-id}")
    private String id;

    @Value("${instance.title}")
    private String title;

    public static void main(String[] args) {
        SpringApplication.run(EuClient.class, args);
    }

    @GetMapping("/")
    public String index() {
        return Map.of("instance.title", title,
                "eureka.instance.instance-id", id).toString();
    }

}
