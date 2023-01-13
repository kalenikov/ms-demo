package ru.kalenikov.euclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EuClient {
    public static void main(String[] args) {
        SpringApplication.run(EuClient.class, args);
    }
}
