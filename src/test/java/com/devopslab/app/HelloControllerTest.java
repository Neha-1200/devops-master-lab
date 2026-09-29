package com.devopslab.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTest {
    @LocalServerPort int port;
    @Autowired TestRestTemplate restTemplate;

    @Test
    void helloEndpointWorks() {
        String body = restTemplate.getForObject("http://localhost:" + port + "/api/hello", String.class);
        assertThat(body).contains("Hello from the DevOps Java Lab");
    }
}
