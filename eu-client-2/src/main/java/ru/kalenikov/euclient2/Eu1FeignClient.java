package ru.kalenikov.euclient2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eu1", fallback = Eu1ClientFallback.class)
public interface Eu1FeignClient {
    @GetMapping("/")
    String index();
}


