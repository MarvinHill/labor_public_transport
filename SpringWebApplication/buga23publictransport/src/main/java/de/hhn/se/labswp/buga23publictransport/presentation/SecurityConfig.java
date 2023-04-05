package de.hhn.se.labswp.buga23publictransport.presentation;

import de.hhn.se.labswp.buga23publictransport.business.CustomUserDetailsManager;
import de.hhn.se.labswp.buga23publictransport.persistence.enity.User;
import de.hhn.se.labswp.buga23publictransport.persistence.enity.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider authenticationProvider) throws Exception{
    http.authorizeHttpRequests()
          //.requestMatchers(HttpMethod.GET,"/").permitAll()
          //.requestMatchers(HttpMethod.GET,"/ptl").permitAll()
          //.requestMatchers(HttpMethod.GET,"/ptl/**").permitAll()
        .requestMatchers(HttpMethod.GET).permitAll()
            // todo - add login-check path endpoint
            // todo - add register path endpoint
//        .requestMatchers(HttpMethod.POST).hasRole(UserRole.ADMIN.name())
//        .requestMatchers("/login-page**").permitAll()
        .anyRequest().authenticated()
        .and().httpBasic();
    http.authenticationProvider(authenticationProvider);
    return http.build();
  }
  @Bean
  public AuthenticationManager authManager(HttpSecurity http, AuthenticationConfiguration configuration) throws Exception {
  return configuration.getAuthenticationManager();
  }

  @Bean
  public AuthenticationProvider provider(CustomUserDetailsManager userDetailsService,PasswordEncoder passwordEncoder){
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    return  daoAuthenticationProvider;
  }
  @Bean
  PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }
  @Bean
  UserDetailsManager users(CustomUserDetailsManager manager, PasswordEncoder encoder){
    User admin = new User();
    admin.setRole(UserRole.ADMIN);
    admin.setEmail("admin");
    admin.setPassword(encoder.encode("123"));
    manager.createUser(admin);
    return manager;
  }
}
