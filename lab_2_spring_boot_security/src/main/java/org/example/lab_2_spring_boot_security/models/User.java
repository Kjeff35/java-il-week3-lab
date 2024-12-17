package org.example.lab_2_spring_boot_security.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.lab_2_spring_boot_security.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    private String username;
    private String email;
    private String password;
    private String pictureUrl;
    private boolean isEnabled;
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return List.of(new SimpleGrantedAuthority(role.toString()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public static User fromOAuth2GithubUser(OAuth2User user) {
        return User.builder()
                .email(user.getAttribute("email"))
                .fullName(user.getAttribute("name"))
                .username(user.getAttribute("login"))
                .pictureUrl(user.getAttribute("avatar_url"))
                .role(Role.CUSTOMER)
                .isEnabled(true)
                .build();
    }

    public static User fromOauth2GoogleUser(OAuth2User user) {
        return User.builder()
                .email(user.getAttributes().get("email").toString())
                .fullName(user.getAttributes().get("name").toString())
                .username(user.getAttributes().get("given_name").toString())
                .pictureUrl(user.getAttributes().get("picture").toString())
                .role(Role.CUSTOMER)
                .isEnabled(true)
                .build();
    }
}
