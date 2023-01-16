package ru.kalenikov.euclient2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EuClient2 {

    public static void main(String[] args) {
        SpringApplication.run(EuClient2.class, args);
    }

}
