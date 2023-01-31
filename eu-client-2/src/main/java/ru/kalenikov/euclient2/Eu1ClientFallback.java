package ru.kalenikov.euclient2;

import org.springframework.stereotype.Component;

@Component
public class Eu1ClientFallback implements Eu1FeignClient {
    @Override
    public String index() {
        return "eu1 unavailable";
    }
}