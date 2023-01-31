package ru.kalenikov.euclient2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RestController
public class EuClient2App {

    @Value("${eureka.instance.instance-id}")
    private String id;

    @Value("${instance.title}")
    private String title;

    @Autowired
    Eu1FeignClient eu1FeignClient;

    @Autowired
    Source outputBinding;

    @Autowired
    MessageProducer messageProducer;

    public static void main(String[] args) {
        SpringApplication.run(EuClient2App.class, args);
    }

    @GetMapping("/")
    public String index() {
        return Map.of("instance.title", title,
                "eureka.instance.instance-id", id).toString();
    }

    @GetMapping("/eu1")
    public String eu1() {
        return "eu2 + eu1 = " + eu1FeignClient.index();
    }

    @GetMapping("/rabbit")
    public void rabbit() {
        while (true) {
            String payload = String.valueOf(new Random().nextInt());
            Message<String> msg = MessageBuilder.withPayload(payload).build();
            try {
                Thread.sleep(1000);
                outputBinding.output().send(msg);
                System.out.println(payload);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
