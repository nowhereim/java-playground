//package org.example.zoomingle.domain.test;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.*;
//import javax.crypto.SecretKey;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//@Service
//@Slf4j
//public class JwtTestService {
//
//    private static final SecretKey key = Jwts.SIG.HS256.key().build();
//
//
//    public String generateAccessToken() {
//        JwtTestModel userDetails = new JwtTestModel(
//                1L,
//                "test",
//                "test",
//                "test",
//                "test",
//                List.of(new SimpleGrantedAuthority("user")),
//                null,
//                null,
//                null
//        );
//        return createToken(userDetails.getUsername());
//    }
//
//    public String getSubjectFromToken(String token) {
//        return getSubject(token);
//    }
//
//    public List<GrantedAuthority>getAuthoritiesFromToken(String token) {
//        Jws<Claims> claimsJws = Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
//
//        // "roles" 클레임에서 역할 정보를 가져옵니다. (List<Object>로 가져온 후 변환)
////        String subject = claims.getSubject();
//        String role = claimsJws.getPayload().get("roles", String.class);
//        // 역할 정보를 GrantedAuthority 리스트로 변환하여 반환합니다.
//        return Collections.singletonList(new SimpleGrantedAuthority(role));
//    }
//
//    private List<GrantedAuthority> getAuthorities(String token) {
//        // 여기서 authorities를 추출하는 로직이 필요합니다. 예시로 비워두었습니다.
//        return List.of(); // 빈 리스트 반환 (여기에 실제 권한 로직을 추가하면 됩니다)
//    }
//
//
//    private String createToken(String subject) {
//
//        Date now = new Date();
//        Date exp = new Date(now.getTime() + 1000 * 60 * 60 * 3);
//
//        return Jwts.builder()
//                .subject(subject)
//                .claim("roles", "user") //이렇게하면 페이로드에 roles라는 키로 user라는 값을 넣을 수 있다. 여러개를 넣으려면
//                .signWith(key)
//                .issuedAt(now)
//                .expiration(exp)
//                .compact();
//    }
//
//
//    private String getSubject(String token) {
//        try {
//
//            return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
//
//            //OK, we can trust this JWT
//        } catch (JwtException e) {
//            log.error("JWT parsing error: {}", e.getMessage());
//
//            throw e;
//            //don't trust the JWT!
//        }
//    }
//
//
//
//
//}
