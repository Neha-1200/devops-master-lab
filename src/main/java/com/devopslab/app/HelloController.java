package com.devopslab.app;

import java.time.Instant;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final String version;

    public HelloController(@Value("${APP_VERSION:1.0.0}") String version) {
        this.version = version;
    }

    @GetMapping("/api/hello")
    public Map<String, Object> hello() {
        return Map.of(
            "message", "Hello from the DevOps Java Lab",
            "version", version,
            "timestamp", Instant.now().toString()
        );
    }
}
