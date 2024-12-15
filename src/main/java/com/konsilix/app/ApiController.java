package com.konsilix.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping(path = "/hostname", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getHostname() {
        String hostname = Utils.getMyHostname();
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "hostname", hostname));
    }
}
