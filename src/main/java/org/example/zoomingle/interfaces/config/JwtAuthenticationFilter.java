package org.example.zoomingle.interfaces.config;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.UnavailableException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.coyote.BadRequestException;
import org.example.zoomingle.domain.JwtTestService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;


//@Component
//@Slf4j
//@RequiredArgsConstructor
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    private final JwtTestService jwtTestService;
//
////    private
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        String BEARER_PREFIX = "Bearer";
//        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
//        SecurityContext securityContext = SecurityContextHolder.getContext();
//
//        if (authorization == null || !authorization.startsWith(BEARER_PREFIX)) {
//            log.error("Missing or invalid Authorization header");
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
//            return;
//        }
//
//        if (authorization != null && authorization.startsWith(BEARER_PREFIX)
//                && securityContext.getAuthentication() == null) {
//            String accessToken = authorization.substring(BEARER_PREFIX.length()).trim(); // trim() 은 앞뒤 공백 제거
//            String subject = jwtTestService.getSubjectFromToken(accessToken);
//            log.info("subject: {}", subject);
//
//
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(subject, null, null);
//
//
//            securityContext.setAuthentication((Authentication) new WebAuthenticationDetailsSource().buildDetails(request));
//
//            securityContext.setAuthentication(authentication);
//        }
//        // TODO: Implement JWT authentication filter
//
//        filterChain.doFilter(request, response);
//
//
//
//
//    }
//}
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTestService jwtTestService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String BEARER_PREFIX = "Bearer ";
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        SecurityContext securityContext = SecurityContextHolder.getContext();

        // Authorization 헤더가 없거나 올바르지 않은 경우
//        if (authorization == null || !authorization.startsWith(BEARER_PREFIX)) {
//            log.error("Missing or invalid Authorization header");
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
//            return;
//        }

        // 유효한 Authorization 헤더가 존재하고 SecurityContext에 인증 정보가 없는 경우
        if (authorization != null && authorization.startsWith(BEARER_PREFIX) && securityContext.getAuthentication() == null) {
            String accessToken = authorization.substring(BEARER_PREFIX.length()).trim();
            String subject = jwtTestService.getSubjectFromToken(accessToken);

            // 사용자의 권한 정보 조회 (예시로 USER 권한 부여)
            List<GrantedAuthority> authorities = jwtTestService.getAuthoritiesFromToken(accessToken);

            log.info("subject: {}", subject);

            // 인증 객체 생성
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(subject, null, authorities);

            // WebAuthenticationDetailsSource를 사용하여 요청 세부정보 추가
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            // SecurityContext에 인증 정보 설정
            securityContext.setAuthentication(authentication);
        }

        // 필터 체인으로 요청 전달
        filterChain.doFilter(request, response);
    }
}