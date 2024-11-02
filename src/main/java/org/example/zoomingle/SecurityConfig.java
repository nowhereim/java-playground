//package org.example.zoomingle;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/static/**", "/public/**", "/resources/**").permitAll()  // 정적 자원 접근 허용
//                        .anyRequest().authenticated()  // 나머지 요청은 인증 필요
//                )
//                .formLogin(formLogin -> formLogin
//                        .loginPage("/login")  // 로그인 페이지 경로
//                        .permitAll()  // 로그인 페이지 접근 허용
//                );
//
//        return http.build();
//    }
//}