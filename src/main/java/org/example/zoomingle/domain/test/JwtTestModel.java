//package org.example.zoomingle.domain.test;
//
//import lombok.Builder;
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.time.ZonedDateTime;
//import java.util.Collection;
//import java.util.List;
//
//@Data
//@Builder
//public class JwtTestModel implements UserDetails {
//
//    private Long id;
//
//
//    private String username;
//
//    private String password;
//
//    private String profile;
//
//    private String description;
//
//    private List<GrantedAuthority> roles;
//
//    private ZonedDateTime createdAt;
//
//    private ZonedDateTime updatedAt;
//
//    private ZonedDateTime deletedAt;
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return UserDetails.super.isAccountNonExpired();
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return UserDetails.super.isAccountNonLocked();
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return UserDetails.super.isCredentialsNonExpired();
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return UserDetails.super.isEnabled();
//    }
//}
