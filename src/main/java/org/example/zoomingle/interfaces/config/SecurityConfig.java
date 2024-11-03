package org.example.zoomingle.interfaces.config;//package org.example.zoomingle.interfaces.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable() // CSRF 보호 비활성화
////                .authorizeHttpRequests((requests) ->
////                        requests.requestMatchers("/public/**").permitAll()
////                                .requestMatchers("/swagger-ui/**").permitAll()
////                                .requestMatchers("/api/docs").permitAll()
////                                .anyRequest().authenticated())
////                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
////                .httpBasic(Customizer.withDefaults());
//
//        http
//                .csrf().disable() // CSRF 보호 비활성화
//                .authorizeHttpRequests((requests) ->
////                        requests.requestMatchers("/public/**").permitAll()
//
//                                requests.requestMatchers("/swagger-ui/**").permitAll()
////                                .requestMatchers("/api/docs").permitAll()
//                                .anyRequest().authenticated())
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
//
//
//}


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{


//    @Bean
//    pulbic BCyrptPasswordEncoder bCyrptPasswordEncodr(){
//        return new bCryptPasswordEncoder();
//    }

        private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{

        http
                .formLogin().disable()
                .httpBasic().disable()
                .csrf().disable();

        http
                .authorizeHttpRequests(
                    (auth)->auth
                            .requestMatchers("/api/docs","/api/swagger-ui/**","/api/openapi/**","" +
                                    "/public/**").permitAll()
//                            .requestMatchers("/admin").hasAnyRole("ADMIN")
                            .anyRequest().authenticated()
		)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .sessionManagement((session)->session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));


        return http.build();

    }
}