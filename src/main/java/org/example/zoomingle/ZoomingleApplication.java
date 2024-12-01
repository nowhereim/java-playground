package org.example.zoomingle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ZoomingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZoomingleApplication.class, args);
        System.out.println("주밍글 빨리 만들어야한다고!!! = " + args);
    }
}

//소셜로그인, 핸드폰번호 로그인
//        둘 다 본인 확인 필수 ( 본인인증 )