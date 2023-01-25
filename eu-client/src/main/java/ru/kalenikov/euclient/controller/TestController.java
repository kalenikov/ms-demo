package ru.kalenikov.euclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eu1")
public class TestController {

    @Value("${eureka.instance.instance-id}")
    private String id;

    @GetMapping("/id")
    public String test() {
        return String.format("%s -- %s", "id", id);
    }

    @GetMapping
    public String index() {
        return String.format("%s -- %s", "index", id);
    }

    @GetMapping("/value")
    public String value(@Value("${kalenikov.some.value}") String value) {
        return String.format("%s -- %s", "value", value);
    }
}
