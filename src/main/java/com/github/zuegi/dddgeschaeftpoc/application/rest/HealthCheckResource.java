package com.github.zuegi.dddgeschaeftpoc.application.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/health")
@Slf4j
public class HealthCheckResource {

    @GetMapping("/check")
    public String healthCheck() {
        log.info("/api/health/check called");
        return "Alles super! " + LocalDateTime.now();
    }
}
