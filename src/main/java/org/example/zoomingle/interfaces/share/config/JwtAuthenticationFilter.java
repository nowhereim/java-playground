package org.example.zoomingle.interfaces.share.config;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.zoomingle.domain.user.service.JwtService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String BEARER_PREFIX = "Bearer ";
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        SecurityContext securityContext = SecurityContextHolder.getContext();

        // 유효한 Authorization 헤더가 존재하고 SecurityContext에 인증 정보가 없는 경우
        if (authorization != null && authorization.startsWith(BEARER_PREFIX) && securityContext.getAuthentication() == null) {
            String accessToken = authorization.substring(BEARER_PREFIX.length()).trim();
            String subject = jwtService.getSubjectFromToken(accessToken);

            // 사용자의 권한 정보 조회 (예시로 USER 권한 부여)
            List<GrantedAuthority> authorities = jwtService.getAuthoritiesFromToken(accessToken);

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