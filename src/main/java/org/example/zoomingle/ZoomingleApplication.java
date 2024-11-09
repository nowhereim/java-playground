package org.example.zoomingle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ZoomingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoomingleApplication.class, args);
    }
}

//ㅋㅋ