package ru.kalenikov.euserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EuServer {
    public static void main(String[] args) {
        SpringApplication.run(EuServer.class, args);
    }
}
